package com.lugal.Utils;

public class RNG {
    public static int rand(int lowerBound, int upperBound) {
        return (int) (Math.random() * (upperBound - lowerBound + 1) + lowerBound);
    }
}
