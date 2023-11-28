package com.example.kerneljavaspring.sisproject.domain.student.model;

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
public class StudentDto {

    private Long id;

    private String name;

    private Long studentId;

//    private String major;

    public static StudentDto from(StudentEntity studentEntity) {
        return StudentDto.builder()
//            .id(studentEntity.getId())
            .name(studentEntity.getName())
            .studentId(studentEntity.getStudentId())
//            .major(studentEntity.getMajor())
            .build();
    }
}
