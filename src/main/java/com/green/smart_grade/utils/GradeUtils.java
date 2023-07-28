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
        if (rating == 4.5) {
            this.result = "A+";
        } else if (rating == 4.0) {
            this.result = "A";
        } else if (rating == 3.5) {
            this.result = "B+";
        } else if (rating == 3.0) {
            this.result = "B";
        } else if (rating == 2.5) {
            this.result = "C+";
        } else if (rating == 2.0) {
            this.result = "C";
        } else if (rating == 1.5) {
            this.result = "D+";
        } else if (rating == 1.0) {
            this.result = "D";
        } else {
            this.result = "F";
        }
        return this.result;
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
