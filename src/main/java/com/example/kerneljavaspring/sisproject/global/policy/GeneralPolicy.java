package com.example.kerneljavaspring.sisproject.global.policy;

public class GeneralPolicy implements GradePolicy {

    @Override
    public String getGrade(Long score) {
        if (score >= 90) return "A";
        if (score >= 80) return "B";
        if (score >= 70) return "C";
        if (score >= 55) return "D";
        return "F";
    }

}
