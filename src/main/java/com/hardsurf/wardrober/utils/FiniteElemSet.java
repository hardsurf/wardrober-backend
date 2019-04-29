package com.hardsurf.wardrober.utils;

import java.util.Collection;

public interface FiniteElemSet<T, ID> {
    public Collection<T> values();
    public T findById(ID id);
}
