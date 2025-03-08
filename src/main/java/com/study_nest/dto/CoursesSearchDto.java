package com.study_nest.dto;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CoursesSearchDto {

    @Builder.Default
    @Min(value = 1, message = "Course page number must be at least 1")
    private int pageNumber = 1;

    @Builder.Default
    private int pageSize = 20;

    private String name;
}
