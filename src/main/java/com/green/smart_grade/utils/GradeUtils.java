package com.green.smart_grade.utils;

public class GradeUtils {
    public int totalScore;
    private final String symbol = "+";
    private String result = "";

    public GradeUtils(int totalScore) {
        this.totalScore = totalScore;
    }


    public String TotalScore() {
        if (totalScore >= 90) {
            result = "A";
            if (totalScore > 94) {
                return result += symbol;
            }
        } else if (totalScore >= 80) {
            result = "B";
            if (totalScore > 84) {
                return result += symbol;
            }
        } else if (totalScore >= 70) {
            result = "C";
            if (totalScore > 74) {
                return result += symbol;
            }
        } else if (totalScore >= 60) {
            result = "D";
            if (totalScore >= 64) {
                return result += symbol;
            }
        } else {
            result = "F";
        }

        return result;
    }


}
