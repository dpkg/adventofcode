package com.dpkg.adventofcode;

import com.dpkg.adventofcode.year2020.Day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public abstract class DayBase implements DailyChallenge {

    private static final String COOKIE_PROP_NAME = "Cookie";
    private static final String USER_SESSION_COOKIE_VALUE =
            "session=ITS_A_SECRET";
    private static final String INPUT_REQUEST_METHOD = "GET";
    protected static final String NEW_LINE = "\n";

    @Override
    public String toString() {
        String answer1 = getPuzzleOneAnswer();
        String answer2 = getPuzzleTwoAnswer();
        return String.format("%s\n=================\n> Puzzle 1 answer: %s\n> Puzzle 2 answer: %s\n-----------------\n",
                getDayName(), answer1, answer2);
    }

    protected String getDayName() {
        return this.getClass().getSimpleName();
    }

    protected int getDayNumber () {
        return Integer.parseInt(getDayName().split("Day")[1]); // assumes the naming format
    }

    private String getPuzzleInputUrl() {
        String urlFormat = "https://adventofcode.com/2020/day/%d/input";
        return String.format(urlFormat, getDayNumber());
    }

    private String _httpInput;

    protected String getHttpInput() {
        if (null != _httpInput) {
            return _httpInput;
        }
        try {
            URL url = new URL(getPuzzleInputUrl());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(INPUT_REQUEST_METHOD);
            connection.setRequestProperty(COOKIE_PROP_NAME, USER_SESSION_COOKIE_VALUE);

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder content = new StringBuilder();
            String inputLine;
            while ((inputLine = reader.readLine()) != null) {
                content.append(inputLine);
                content.append(NEW_LINE);
            }
            reader.close();
            connection.disconnect();
            _httpInput = content.toString();
        } catch (IOException ex) {
            throw new RuntimeException("cannot read input for " + Day01.class.getSimpleName());
        }
        return _httpInput;
    }

    @Override
    public String getPuzzleOneAnswer() {
        return "NOT SOLVED YET!!!";
    }

    @Override
    public String getPuzzleTwoAnswer() {
        return "NOT SOLVED YET!!!";
    }
}
