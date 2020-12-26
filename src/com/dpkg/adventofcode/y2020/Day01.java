package com.dpkg.adventofcode.y2020;

import com.dpkg.adventofcode.DayBase;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day01 extends DayBase {

    @Override
    public String getPuzzleOneAnswer() {
        return String.valueOf(calculatePart1());
    }

    @Override
    public String getPuzzleTwoAnswer() {
        return String.valueOf(calculatePart2());
    }

    public int calculatePart2() {
        List<Integer> input = getIntegers();
        for (int num1 : input) {
            for (int num2 : input) {
                for (int num3 : input) {
                    if (isSum2020(num1, num2, num3)) {
//                        System.out.println(num1 + " & " + num2 + " & " + num3);
                        return num1 * num2 * num3;
                    }
                }
            }
        }
        throw new RuntimeException("bad input");
    }



    public int calculatePart1() {
        List<Integer> input = getIntegers();
        for (int num1 : input) {
            for (int num2 : input) {
                if (isSum2020(num1, num2)) {
//                    System.out.println(num1 + " & " + num2);
                    return num1 * num2;
                }
            }
        }
        throw new RuntimeException("bad input");
    }

    private static boolean isSum2020(int... numbers) {
        return 2020 == Arrays.stream(numbers).sum();
    }

    private List<Integer> getIntegers() {
        String inputString = getHttpInput();
        return Arrays.stream(inputString.split(NEW_LINE))
                .map(v -> Integer.parseInt(v.trim()))
                .collect(Collectors.toUnmodifiableList());
    }
}