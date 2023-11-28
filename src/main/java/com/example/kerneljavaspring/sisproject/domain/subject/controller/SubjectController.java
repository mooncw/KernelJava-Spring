package com.example.kerneljavaspring.sisproject.domain.subject.controller;

import com.example.kerneljavaspring.sisproject.domain.subject.model.SubjectRequest;
import com.example.kerneljavaspring.sisproject.domain.subject.service.SubjectService;
import com.example.kerneljavaspring.sisproject.domain.subject.model.SubjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/subject")
public class SubjectController {
    
    private final SubjectService subjectService;
    
    @GetMapping("")
    public String getSubjectList(Model model) {

        List<SubjectDto> subjectInfoDtoList = subjectService.getSubjectList();

        model.addAttribute("subjects", subjectInfoDtoList);

        return "subjectInfo";
    }
    
    @GetMapping("/create")
    public String createSubjectPage(Model model) {

        List<SubjectDto> subjectDtoList = subjectService.getSubjectList();

        model.addAttribute("subjects", subjectDtoList);
//        model.addAttribute("studentInfoRequest", new StudentInfoRequest());

        return "subjectInfoCreate";
    }

    @PostMapping("/create")
    public String createSubject(
        @RequestBody
        @ModelAttribute
        SubjectRequest subjectRequest
    ) {
        subjectService.createSubject(subjectRequest);

        return "redirect:/subject";
    }

    @GetMapping("/regist")
    public String showRegistrationForm(Model model) {
        List<SubjectDto> subjects = subjectService.getSubjectList();  // 모든 과목 이름을 가져옵니다.
        model.addAttribute("subjects", subjects);
        return "registration";
    }

    @PostMapping("/regist")
    public String register(@RequestParam Long studentId, @RequestParam String subject, Model model) {

        List<SubjectDto> subjects = subjectService.getSubjectList();
        subjectService.registSubject(studentId, subject);  // 수강신청을 처리합니다.

        model.addAttribute("subjects", subjects);
        model.addAttribute("message", "수강신청이 완료되었습니다.");
        return "registration";
    }
}
