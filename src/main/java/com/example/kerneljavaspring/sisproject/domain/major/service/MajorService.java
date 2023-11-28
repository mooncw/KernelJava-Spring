package com.example.kerneljavaspring.sisproject.domain.major.service;

import com.example.kerneljavaspring.sisproject.domain.major.db.MajorRepository;
import com.example.kerneljavaspring.sisproject.domain.major.model.MajorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MajorService {
    public final MajorRepository majorRepository;

    public List<MajorDto> getMajorList() {

        return majorRepository.findAll().stream().map(MajorDto::from).toList();
    }
}
