package com.example.kerneljavaspring.sisproject.domain.score.service;

import com.example.kerneljavaspring.sisproject.domain.score.model.ScoreInfoDto;
import com.example.kerneljavaspring.sisproject.domain.score.db.ScoreRepository;
import com.example.kerneljavaspring.sisproject.domain.score.model.ScoreDto;
import com.example.kerneljavaspring.sisproject.domain.student.db.StudentEntity;
import com.example.kerneljavaspring.sisproject.domain.student.db.StudentRepository;
import com.example.kerneljavaspring.sisproject.global.policy.FailurePolicy;
import com.example.kerneljavaspring.sisproject.global.policy.GeneralPolicy;
import com.example.kerneljavaspring.sisproject.global.policy.RequiredPolicy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScoreService {
    private final ScoreRepository scoreRepository;
    private final StudentRepository studentRepository;

    public List<ScoreInfoDto> getScoreInfoList(String selectedSubject) {

        List<ScoreDto> scoreDtoList = scoreRepository.findAll().stream().map(ScoreDto::from).toList();

        List<ScoreInfoDto> scoreInfoDtoList = new ArrayList<>();

        for (ScoreDto scoreDto : scoreDtoList) {
            if (scoreDto.getSubject().equals(selectedSubject)) {
                StudentEntity studentEntity = studentRepository.findByStudentId(scoreDto.getStudentId());

                ScoreInfoDto scoreInfoDto = ScoreInfoDto.from(studentEntity, scoreDto);
                String scoreAndGrade = getScoreAndGrade(selectedSubject, scoreInfoDto);  // 점수와 등급을 계산
                scoreInfoDto.setScoreAndGrade(scoreAndGrade);  // ScoreInfoDto에 점수와 등급을 저장

                scoreInfoDtoList.add(scoreInfoDto);
            }
        }

        return scoreInfoDtoList;
    }

    public String getScoreAndGrade(String selectedSubject, ScoreInfoDto scoreInfoDto) {

        List<String> requiredSubjectsList = new ArrayList<>(Arrays.asList("국어","수학"));

        if (scoreInfoDto.getScore() == null) {

            return "없음";

        } else if (selectedSubject.equals(scoreInfoDto.getRequiredSubject())) {
            String grade = new RequiredPolicy().getGrade(scoreInfoDto.getScore());

            return scoreInfoDto.getScore()+":"+grade;

        } else if (requiredSubjectsList.contains(selectedSubject)) {
            String grade = new GeneralPolicy().getGrade(scoreInfoDto.getScore());

            return scoreInfoDto.getScore()+":"+grade;

        } else {
            String grade = new FailurePolicy().getGrade(scoreInfoDto.getScore());

            return scoreInfoDto.getScore()+":"+grade;
        }

    }

}
