package com.study_nest.controller;

import com.study_nest.dto.CourseDto;
import com.study_nest.dto.CoursesSearchDto;
import com.study_nest.service.CourseService;
import com.study_nest.service.pagination.CustomPage;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( "/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private  final CourseService courseService;

    @GetMapping
    public ResponseEntity<CustomPage<CourseDto>> getCourses(CoursesSearchDto coursesSearchDto){
        return ResponseEntity.ok().body(courseService.getCourses(coursesSearchDto));
    }

    @GetMapping("/recommendation")
    public ResponseEntity<List<CourseDto>> getCourseRecommendation(){
        return ResponseEntity.ok().body(courseService.getCourseRecommendation());
    }

    @GetMapping("/download/{courseId}")
    public ResponseEntity<Resource> getCourseRecommendation(@PathVariable Integer courseId) throws BadRequestException {
        return courseService.download(courseId);
    }
}
