package com.green.smartGrade.utils;

public class GradeUtils {
    public int totalScore;
    public double rating;
    private String result = "";


    public GradeUtils(int totalScore) {
        this.totalScore = totalScore;
    }

    public GradeUtils() {

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

    public double totalScore2(int score) {
        if (score >= 90) {
            this.rating = 4.0;
            if (score > 94) {
                this.rating = 4.5;
            }
        } else if (score >= 80) {
            this.rating = 3.0;
            if (score > 84) {
                this.rating = 3.5;
            }
        } else if (score >= 70) {
            this.rating = 2.0;
            if (score > 74) {
                this.rating = 2.5;
            }
        } else if (score >= 60) {
            this.rating = 1.0;
            if (score >= 64) {
                this.rating = 1.5;
            }
        } else {
            this.rating = 0;
        }
        return this.rating;
    }

}
//class GradeUtils2{
//    private  double pp;
//    private  String grade;
//
//    public double getPp() {
//        return pp;
//    }
//
//    public String getGrade() {
//        return grade;
//    }
//
//
//    public void getGread(int totalScore){
//        int temp= totalScore/10;
//        int temp2=totalScore%10;
//        double result=0;
//        String gread="F";
//        if (temp>=9){
//            result=4.0;
//            gread="A";
//        }else if (temp>=8){
//            result= 3.0;
//            gread="B";
//        }else if (temp>=7){
//            result=2.0;
//            gread="C";
//        } else if (temp >= 6) {
//            result=1.0;
//            gread="D";
//
//        }
//
//        if (temp2>4 || totalScore== 100){
//            result+=0.5;
//            gread+="+";
//        }
//        this.pp=result;
//        this.grade=gread;
//    }
//
//
//}