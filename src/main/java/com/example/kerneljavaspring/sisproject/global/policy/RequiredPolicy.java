package com.example.kerneljavaspring.sisproject.global.policy;

public class RequiredPolicy implements GradePolicy {

    @Override
    public String getGrade(Long score) {
        if (score >= 95) return "S";
        if (score >= 90) return "A";
        if (score >= 80) return "B";
        if (score >= 70) return "C";
        if (score >= 60) return "D";
        return "F";
    }

}
