package com.dpkg;

import com.dpkg.adventofcode.DailyChallenge;
import com.dpkg.adventofcode.year2020.Day01;
import com.dpkg.adventofcode.year2020.Day02;
import com.dpkg.adventofcode.year2020.Day03;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        DailyChallenge[] days = new DailyChallenge[] {
                new Day01(),
                new Day02(),
                new Day03()
        };
        Arrays.stream(days)
                .sorted((a,b) -> -a.getClass().getSimpleName().compareToIgnoreCase(b.getClass().getSimpleName()))
                .forEach(System.out::println);
    }
}
