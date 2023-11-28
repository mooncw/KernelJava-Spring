package com.example.kerneljavaspring.sisproject.domain.student.model;

import com.example.kerneljavaspring.sisproject.domain.student.db.StudentEntity;
import com.example.kerneljavaspring.sisproject.domain.student.db.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class StudentDtoTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    @Transactional
    public void should_convert_to_gradeDto() {
        StudentEntity student = StudentEntity.builder()
            .name("김영롱")
            .studentId(211213L)
            .build();

        StudentEntity saveStudent = studentRepository.save(student);

        StudentDto studentDto = StudentDto.from(saveStudent);

        assertThat(studentDto).hasFieldOrPropertyWithValue("name", "김영롱");
        assertThat(studentDto).hasFieldOrPropertyWithValue("studentId", 211213L);

        System.out.println("should_convert_to_gradeDto 테스트 통과");
    }
}