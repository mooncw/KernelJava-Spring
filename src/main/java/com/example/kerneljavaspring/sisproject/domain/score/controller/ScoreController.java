package com.example.kerneljavaspring.sisproject.domain.score.controller;

import com.example.kerneljavaspring.sisproject.domain.score.model.ScoreInfoDto;
import com.example.kerneljavaspring.sisproject.domain.score.service.ScoreService;
import com.example.kerneljavaspring.sisproject.domain.subject.service.SubjectService;
import com.example.kerneljavaspring.sisproject.domain.subject.model.SubjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/score")
@RequiredArgsConstructor
public class ScoreController {

    private final ScoreService scoreService;
    private final SubjectService subjectService;

    @GetMapping("/scores")
    public String showScores(Model model) {
        List<SubjectDto> subjects = subjectService.getSubjectList();  // 모든 과목 이름을 가져옵니다.
        model.addAttribute("subjects", subjects);

        return "scoreInfo";
    }

    @PostMapping("/scores")
    public String showScoresBySubject(@RequestParam String subject, Model model) {
        List<SubjectDto> subjects = subjectService.getSubjectList();
        List<ScoreInfoDto> scores = scoreService.getScoreInfoList(subject);  // 선택한 과목의 점수를 가져옵니다.

//        for (ScoreInfoDto score : scores) {
//            System.out.println(score);
//        }

        model.addAttribute("scores", scores);
        model.addAttribute("subjects", subjects);
        model.addAttribute("selectedSubject", subject);

        return "scoreInfo";
    }
}
