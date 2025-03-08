package com.study_nest.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "Department")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false, name = "name")
    private String name;
}
