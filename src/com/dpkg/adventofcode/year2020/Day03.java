package com.dpkg.adventofcode.year2020;

import com.dpkg.adventofcode.DayBase;

public class Day03 extends DayBase {

    @Override
    public String getPuzzleOneAnswer() {
        return String.valueOf(getNumberOfTrees(3, 1));
    }

    @Override
    public String getPuzzleTwoAnswer() {
        long result = getNumberOfTrees(1, 1) *
                getNumberOfTrees(3, 1) *
                getNumberOfTrees(5, 1) *
                getNumberOfTrees(7, 1) *
                getNumberOfTrees(1, 2);
        return String.valueOf(result);
    }

    private long getNumberOfTrees(int slopeX, int slopeY) {
        int totalLines = getInput().length;
        // set starting position at 0,0
        int x = 0;
        int y = 0;
        int numberOfTreesInPath = 0;
        for (int linesTraversed = 0; linesTraversed <= totalLines;) {
            x += slopeX;
            y += slopeY;
            if (getCharAtLinePosition(y, x) == '#') {
                numberOfTreesInPath++;
            }
            linesTraversed += slopeY;
        }
        return numberOfTreesInPath;
    }

    private char getCharAtLinePosition(int lineIndex, int position) {
        if (lineIndex >= getInput().length) {
            return 'X'; // can return any character but '#' which signifies a tree
        }
        char[] originalLine = getInput()[lineIndex];
        if (position < originalLine.length) {
            return originalLine[position];
        }
        char[] line = originalLine;
        while (position >= line.length) {
            line = (String.valueOf(line) + String.valueOf(originalLine)).toCharArray();
            if (position < line.length) {
                return line[position];
            }
        }
        throw new RuntimeException("bad input");
    }

    private char[][] _inputArray;

    private char[][] getInput() {
        if (null != _inputArray) {
            return _inputArray;
        }
        String inputString = getHttpInput();
        String[] lines = inputString.split(NEW_LINE);
        char[][] returnValue = new char[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            returnValue[i] = lines[i].toCharArray();
        }
        return _inputArray = returnValue;
    }
}
