package com.example.kerneljavaspring.sisproject.domain.student.db;

import com.example.kerneljavaspring.sisproject.domain.score.db.ScoreEntity;
import com.example.kerneljavaspring.sisproject.domain.major.db.MajorEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long studentId;

//    private String major;

    @ManyToOne()
    @JoinColumn(name = "major_id")
    private MajorEntity majorEntity;

    @OneToMany(mappedBy = "studentId")
    private List<ScoreEntity> scores;

}
