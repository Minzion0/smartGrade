package com.green.smart_grade.utils;

public class GradeUtils {
    public int totalScore;
    public double rating;
    private final String symbol = "+";
    private String result = "";

    public GradeUtils(int totalScore) {
        this.totalScore = totalScore;
    }
    public String totalRating(double rating) {
        String symbol = "";
        if (rating == 4.5) {
            symbol = "A+";
        } else if (rating == 4.0) {
            symbol = "A";
        } else if (rating == 3.5) {
            symbol = "B+";
        } else if (rating == 3.0) {
            symbol = "B";
        } else if (rating == 2.5) {
            symbol = "C+";
        } else if (rating == 2.0) {
            symbol = "C";
        } else if (rating == 1.5) {
            symbol = "D+";
        } else if (rating == 1.0) {
            symbol = "D";
        } else {
            symbol = "F";
        }
        return symbol;
    }

    public double totalScore() {
        if (totalScore >= 90) {
            rating = 4.0;
            if (totalScore > 94) {
                rating = 4.5;
            }
        } else if (totalScore >= 80) {
            rating = 3.0;
            if (totalScore > 84) {
                rating = 3.5;
            }
        } else if (totalScore >= 70) {
            rating = 2.0;
            if (totalScore > 74) {
                rating = 2.5;
            }
        } else if (totalScore >= 60) {
            rating = 1.0;
            if (totalScore >= 64) {
                rating = 1.5;
            }
        } else {
            rating = 0;
        }

        return rating;
    }


}
