package ru.gav.filter;

import java.util.Objects;

public interface Filter<T> {
    T apply(T t);
}
