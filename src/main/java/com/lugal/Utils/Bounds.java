package com.lugal.Utils;


public record Bounds<T extends Number, V>(T min, T max, V value) {

    public boolean contains(T number) {
        return number.doubleValue() >= min.doubleValue()
             && number.doubleValue() <= max.doubleValue();
    }
}
