package com.example.kerneljavaspring.sisproject.domain.student.controller;

import com.example.kerneljavaspring.sisproject.domain.student.model.StudentInfoDto;
import com.example.kerneljavaspring.sisproject.domain.student.model.StudentInfoRequest;
import com.example.kerneljavaspring.sisproject.domain.major.service.MajorService;
import com.example.kerneljavaspring.sisproject.domain.student.service.StudentInfoService;
import com.example.kerneljavaspring.sisproject.domain.major.model.MajorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentInfoService studentInfoService;
    private final MajorService majorService;

    @GetMapping("")
    public String getStudentInfoList(Model model) {

        List<StudentInfoDto> studentInfoDtoList = studentInfoService.getStudentInfoList();

        model.addAttribute("students", studentInfoDtoList);

        return "studentInfo";
    }

    @GetMapping("/create")
    public String createStudentInfoPage(Model model) {

        List<MajorDto> majorDtoList = majorService.getMajorList();

        model.addAttribute("majors", majorDtoList);
        model.addAttribute("studentInfoRequest", new StudentInfoRequest());

        return "studentInfoCreate";
    }

    @PostMapping("/create")
    public String createStudentInfo(
        @RequestBody
        @ModelAttribute
        StudentInfoRequest studentInfoRequest
    ) {
        studentInfoService.createStudentInfo(studentInfoRequest);

        return "redirect:/student";
    }

//    @GetMapping("/login")
}
