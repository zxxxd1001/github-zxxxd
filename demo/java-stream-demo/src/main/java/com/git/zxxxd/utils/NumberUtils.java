package com.git.zxxxd.utils;


import com.google.common.base.Function;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberUtils {
    public static List<Integer> create() {
        return Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList());
    }

    public static List<Integer> create(Integer start, Integer limit) {
        return Stream.iterate(start, item -> item + 1).limit(limit).collect(Collectors.toList());
    }

    public static List<Integer> create(Integer limit) {
//        return Stream.generate(Math::random).limit(limit).collect(Collectors.toList());
        Random random = new Random();
        return Stream.generate(() -> {
            int i = random.nextInt(100);
            return i;
        }).limit(limit).collect(Collectors.toList());
    }
}
