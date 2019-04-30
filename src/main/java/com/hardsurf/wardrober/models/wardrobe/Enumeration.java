package com.hardsurf.wardrober.models.wardrobe;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Enumeration<T> {
    private List<T> values;

    public Enumeration(T... args) {
        this.values = Collections.unmodifiableList(
                Stream.of(args).collect(Collectors.toList())
        );
    }

    public List<T> values() {
        return values;
    }

    public Optional<T> findElem(Predicate<T> where) {
        return values.stream()
                .filter(where)
                .findFirst();
    }

    public T getElem(Predicate<T> where) {
        return findElem(where).orElseThrow(NoSuchElementException::new);
    }
}
