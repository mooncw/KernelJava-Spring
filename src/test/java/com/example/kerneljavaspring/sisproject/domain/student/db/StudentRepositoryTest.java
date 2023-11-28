package com.example.kerneljavaspring.sisproject.domain.student.db;

import com.example.kerneljavaspring.sisproject.domain.major.db.MajorEntity;
import com.example.kerneljavaspring.sisproject.domain.major.db.MajorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class StudentRepositoryTest {

//    @Autowired
//    private TestEntityManager entityManager;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private MajorRepository majorRepository;

    @Test
    public void should_find_no_student_if_repository_is_empty() {
        Iterable<StudentEntity> student = studentRepository.findAll();

        assertThat(student).isEmpty();

        System.out.println("should_find_no_student_if_repository_is_empty 테스트 통과");
    }

    @Test
    @Transactional
    public void should_store_a_student_info() {
        MajorEntity major = MajorEntity.builder()
            .title("국어국문학과")
            .requiredSubject("국어")
            .build();

        MajorEntity saveMajor = majorRepository.save(major);

        StudentEntity student = StudentEntity.builder()
            .name("김영롱")
            .studentId(211213L)
            .majorEntity(major)
            .build();

        StudentEntity saveStudent = studentRepository.save(student);

        assertThat(saveStudent).hasFieldOrPropertyWithValue("id", 1L);
        assertThat(saveStudent).hasFieldOrPropertyWithValue("name", "김영롱");
        assertThat(saveStudent).hasFieldOrPropertyWithValue("studentId", 211213L);
        assertThat(saveMajor).hasFieldOrPropertyWithValue("title", "국어국문학과");
        assertThat(saveMajor).hasFieldOrPropertyWithValue("requiredSubject", "국어");

        System.out.println("should_store_a_student_info 테스트 통과");
    }


}