package com.study_nest.model;


import jakarta.persistence.*;
import lombok.*;

@Table(name = "courses")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "code")
    private String code;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
