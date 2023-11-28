package com.example.kerneljavaspring.sisproject.domain.major.db;

import com.example.kerneljavaspring.sisproject.domain.student.db.StudentEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "major")
public class MajorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String requiredSubject;
}
