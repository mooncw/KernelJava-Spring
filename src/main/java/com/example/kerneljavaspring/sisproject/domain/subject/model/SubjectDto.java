package com.example.kerneljavaspring.sisproject.domain.subject.model;

import com.example.kerneljavaspring.sisproject.domain.student.db.StudentEntity;
import com.example.kerneljavaspring.sisproject.domain.student.model.StudentDto;
import com.example.kerneljavaspring.sisproject.domain.subject.db.SubjectEntity;
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
public class SubjectDto {

    private Long id;

    private String name;

//    private String policy;

    public static SubjectDto from(SubjectEntity subjectEntity) {
        return SubjectDto.builder()
            .id(subjectEntity.getId())
            .name(subjectEntity.getName())
//            .policy(subjectEntity.getPolicy())
            .build();
    }
}
