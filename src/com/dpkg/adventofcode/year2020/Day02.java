package com.dpkg.adventofcode.year2020;

import com.dpkg.adventofcode.DayBase;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day02 extends DayBase {

    @Override
    public String getPuzzleOneAnswer() {
        return String.valueOf(calculatePart1());
    }

    @Override
    public String getPuzzleTwoAnswer() {
        return String.valueOf(calculatePart2());
    }

    public long calculatePart2() {
        return getInput().stream()
                .filter(lineItem -> {
                    int position1 = Integer.parseInt(lineItem[0]);
                    int position2 = Integer.parseInt(lineItem[1]);
                    char char_ = lineItem[2].charAt(0);
                    String password = lineItem[3];

                    boolean matchesPosition1 = password.charAt(position1 - 1) == char_;
                    boolean matchesPosition2 = password.charAt(position2 - 1) == char_;

                    return matchesPosition1 ^ matchesPosition2;
                })
                .count();
    }

    public long calculatePart1() {
        return getInput().stream()
                .filter(lineItem -> {
                    int min = Integer.parseInt(lineItem[0]);
                    int max = Integer.parseInt(lineItem[1]);
                    char char_ = lineItem[2].charAt(0);
                    String password = lineItem[3];
//                    System.out.println(String.format("%d-%d %s: %s", min, max, char_, password));
                    int count = getCharCountInString(char_, password);
                    return min <= count && count <= max;
                }).count();
    }

    private static int getCharCountInString(char char_, String inputString) {
        int count = 0;
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            if (char_ == c) {
                count++;
            }
        }
        return count;
    }

    private List<String[]> getInput() {
        String inputString = getHttpInput();
        return Arrays.stream(inputString.split(NEW_LINE))
                .map(v -> {
                    String[] firstSplit = v.trim().split(":");
                    String[] secondSplit = firstSplit[0].split(" ");
                    String[] thirdSplit = secondSplit[0].split("-");
                    return new String[] { thirdSplit[0], thirdSplit[1], secondSplit[1], firstSplit[1].trim() };
                })
                .collect(Collectors.toUnmodifiableList());
    }
}
