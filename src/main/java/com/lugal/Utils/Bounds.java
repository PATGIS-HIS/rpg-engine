package com.lugal.Utils;

import java.util.List;

public record Bounds<T extends Number, V>(T min, T max, V value) {

    public boolean contains(T number) {
        return number.doubleValue() >= min.doubleValue()
             && number.doubleValue() <= max.doubleValue();
    }

    public static <T extends Number, V> V getValue(T number, List<Bounds<T, V>> boundsList) {
        for (Bounds<T, V> bound : boundsList) {
            if (bound.contains(number)) {
                return bound.value();
            }
        }
        return null;
    }
}
