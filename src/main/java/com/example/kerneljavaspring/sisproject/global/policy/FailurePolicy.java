package com.example.kerneljavaspring.sisproject.global.policy;

public class FailurePolicy implements GradePolicy {

    @Override
    public String getGrade(Long score) {
        if (score >= 70) return "P";
        return "F";
    }

}
