package com.example.kerneljavaspring.sisproject.domain.score.model;

import com.example.kerneljavaspring.sisproject.domain.student.db.StudentEntity;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ScoreInfoDto {

    private String name;

    private Long studentId;

    private String requiredSubject;

    private Long score;

    private String scoreAndGrade;

    public static ScoreInfoDto from(StudentEntity studentEntity, ScoreDto scoreDto) {
        return ScoreInfoDto.builder()
            .name(studentEntity.getName())
            .studentId(scoreDto.getStudentId())
            .requiredSubject(studentEntity.getMajorEntity().getRequiredSubject())
            .score(scoreDto.getScore())
            .build();
    }
}
