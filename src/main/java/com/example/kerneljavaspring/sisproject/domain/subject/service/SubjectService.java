package com.example.kerneljavaspring.sisproject.domain.subject.service;

import com.example.kerneljavaspring.sisproject.domain.subject.model.SubjectRequest;
import com.example.kerneljavaspring.sisproject.domain.score.db.ScoreEntity;
import com.example.kerneljavaspring.sisproject.domain.score.db.ScoreRepository;
import com.example.kerneljavaspring.sisproject.domain.subject.db.SubjectEntity;
import com.example.kerneljavaspring.sisproject.domain.subject.db.SubjectRepository;
import com.example.kerneljavaspring.sisproject.domain.subject.model.SubjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final ScoreRepository scoreRepository;
    
    public List<SubjectDto> getSubjectList() {

        return subjectRepository.findAll().stream().map(SubjectDto::from).toList();
    }

    public SubjectDto createSubject(
        SubjectRequest subjectRequest
    ) {
        SubjectEntity subjectEntity = SubjectEntity.builder()
            .name(subjectRequest.getName())
            .build();

        SubjectEntity saveSubjectEntity = subjectRepository.save(subjectEntity);

        return SubjectDto.from(saveSubjectEntity);
    }

    public void registSubject(Long studentId, String subject) {

        ScoreEntity scoreEntity = ScoreEntity.builder()
            .studentId(studentId)
            .subject(subject)
            .build();

        scoreRepository.save(scoreEntity);
    }
}
