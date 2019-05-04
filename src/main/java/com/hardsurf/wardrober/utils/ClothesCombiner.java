package com.hardsurf.wardrober.utils;

import com.hardsurf.wardrober.models.wardrobe.BodyPart;
import com.hardsurf.wardrober.models.wardrobe.WardrobeItem;
import com.hardsurf.wardrober.models.wardrobe.WardrobeItemType;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClothesCombiner {

    private static Random rand = new Random();
    private static boolean isBetween(Double elem, Double from, Double to) {
        return elem >= from && elem <= to;
    }

    private static Stream<WardrobeItem> forBodyPart(Collection<WardrobeItem> filteredByPart) {
        List<List<WardrobeItem>> withoutDeps = filteredByPart.stream()
                .filter(item -> item.getType().getDependsOn().isEmpty())
                .map(Collections::singletonList)
                .collect(Collectors.toList());

        Map<WardrobeItemType, List<WardrobeItem>> lookup = filteredByPart.stream().collect(Collectors.toMap(
                WardrobeItem::getType,
                Collections::singletonList,
                (left, right) -> {
                    List<WardrobeItem> copy = new LinkedList<>();
                    copy.addAll(left);
                    copy.addAll(right);
                    return left;
                }
        ));

        List<List<WardrobeItem>> withSatisfiedDependencies = filteredByPart.stream()
                .filter(item -> {
                    WardrobeItemType type = item.getType();
                    return !type.getDependsOn().isEmpty() && !type.getMayDependOn().isEmpty();
                })
                .map(item -> {
                    List<WardrobeItem> satisfiedDeps = item.getType()
                            .getDependsOn()
                            .stream()
                            .map(WardrobeItemType::byName)
                            .filter(lookup::containsKey)
                            .flatMap(key -> lookup.get(key).stream())
                            .collect(Collectors.toList());

                    if (satisfiedDeps.isEmpty()) {
                        return new LinkedList<WardrobeItem>();
                    } else {
                        satisfiedDeps.add(item);
                        return satisfiedDeps;
                    }
                })
                .collect(Collectors.toList());
        withoutDeps.addAll(withSatisfiedDependencies);
        return withoutDeps.size() > 0 ? withoutDeps.get(
                rand.nextInt(withoutDeps.size())
        ).stream() : Stream.empty();
    }

    public static List<WardrobeItem> combine(ClothesCombinerArgs args) {
        List<WardrobeItem> forThisSeason = args.getWardrobeItems()
                .stream()
                .filter(item -> {
                    Double from = item.getSeason().getMinTemp();
                    Double to = item.getSeason().getMaxTemp();

                    return isBetween(args.getTemperature(), from, to);
                })
                .collect(Collectors.toList());

        return BodyPart.BodyParts
                .enumeration.values()
                .stream()
                .flatMap(bodyPart -> forBodyPart(forThisSeason.stream().filter(
                        wardrobeItem -> wardrobeItem.getType().getBodyPart().equals(bodyPart)
                ).collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

}
