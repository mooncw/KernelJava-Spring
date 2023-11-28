package com.example.kerneljavaspring.sisproject.domain.student.service;

import com.example.kerneljavaspring.sisproject.domain.student.model.StudentInfoDto;
import com.example.kerneljavaspring.sisproject.domain.student.model.StudentInfoRequest;
import com.example.kerneljavaspring.sisproject.domain.major.db.MajorEntity;
import com.example.kerneljavaspring.sisproject.domain.student.db.StudentEntity;
import com.example.kerneljavaspring.sisproject.domain.student.db.StudentRepository;
import com.example.kerneljavaspring.sisproject.domain.major.db.MajorRepository;
import com.example.kerneljavaspring.sisproject.domain.subject.db.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentInfoService {

    public final StudentRepository studentRepository;
    public final MajorRepository majorRepository;
    public final SubjectRepository subjectRepository;

    public List<StudentInfoDto> getStudentInfoList() {
        List<StudentEntity> students = studentRepository.findAll();
        List<StudentInfoDto> studentInfoDtoList = new ArrayList<>();

        for (StudentEntity student : students) {
            studentInfoDtoList.add(StudentInfoDto.from(student));
        }

        return studentInfoDtoList;
    }
    public StudentInfoDto createStudentInfo(
        StudentInfoRequest studentInfoRequest
    ) {
        MajorEntity majorEntity = majorRepository.findByTitle(studentInfoRequest.getMajor());

        StudentEntity studentEntity = StudentEntity.builder()
            .name(studentInfoRequest.getName())
            .studentId(studentInfoRequest.getStudentId())
//            .major(commonRequest.getMajor())
            .majorEntity(majorEntity)
            .build();

        StudentEntity saveStudentEntity = studentRepository.save(studentEntity);

        return StudentInfoDto.from(saveStudentEntity);
    }

    public void registCourse() {

    }
}
