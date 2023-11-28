package com.example.kerneljavaspring.sisproject.domain.score.model;

import com.example.kerneljavaspring.sisproject.domain.score.db.ScoreEntity;
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
public class ScoreDto {

    private Long id;

    private Long studentId;

    private String subject;

    private Long score;

    public static ScoreDto from(ScoreEntity scoreEntity) {
        return ScoreDto.builder()
            .studentId(scoreEntity.getStudentId())
            .subject(scoreEntity.getSubject())
            .score(scoreEntity.getScore())
            .build();
    }
}
