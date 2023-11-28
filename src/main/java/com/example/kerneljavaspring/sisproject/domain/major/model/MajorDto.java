package com.example.kerneljavaspring.sisproject.domain.major.model;

import com.example.kerneljavaspring.sisproject.domain.major.db.MajorEntity;
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
public class MajorDto {

    private Long id;

    private String title;

    private String requiredSubject;

    public static MajorDto from(MajorEntity majorEntity) {
        return MajorDto.builder()
//            .id(majorEntity.getId())
            .title(majorEntity.getTitle())
            .requiredSubject(majorEntity.getRequiredSubject())
            .build();
    }
}
