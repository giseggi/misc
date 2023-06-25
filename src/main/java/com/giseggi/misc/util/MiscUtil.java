package com.giseggi.misc.util;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

@Component
public class MiscUtil {

    // Remove duplication of specific fields in an object
    public <T, R> List<T> deduplication(List<T> list, Function<T, R> key) {
        final Set<R> set = new HashSet<>();
        return list.stream().filter(t -> set.add(key.apply(t))).toList();
    }
}
