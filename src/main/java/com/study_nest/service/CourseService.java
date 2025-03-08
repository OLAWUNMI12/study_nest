package com.study_nest.service;

import com.study_nest.dto.CourseDto;
import com.study_nest.dto.CoursesSearchDto;
import com.study_nest.model.Course;
import com.study_nest.model.Department;
import com.study_nest.model.User;
import com.study_nest.repo.CourseRepository;
import com.study_nest.service.pagination.CustomPage;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final UserService userService;
    private final ResourceLoader resourceLoader;


    public CustomPage<CourseDto> getCourses(CoursesSearchDto coursesSearchDto){
        List<CourseDto> courseDtos = new ArrayList<>();
        User user = userService.getCurrentUser();
        Department department = user.getDepartment();
        Pageable pageable = PageRequest.of(coursesSearchDto.getPageNumber() - 1, coursesSearchDto.getPageSize());

        Page<Course> coursesPage  = courseRepository.searchCourses(StringUtils.hasText(coursesSearchDto.getName())? coursesSearchDto.getName(): "", department.getId(), pageable);
        List<Course> courses = coursesPage.getContent();
        if(!CollectionUtils.isEmpty(courses)){
            for(Course course: courses){
                courseDtos.add(CourseDto.builder()
                        .id(course.getId())
                        .name(course.getName())
                        .code(course.getCode())
                        .build());
            }
        }
        return  getCourseResponseCustomPage(courseDtos, coursesPage, coursesSearchDto);
    }

    private static CustomPage<CourseDto> getCourseResponseCustomPage(List<CourseDto> courseDtos, Page coursesPage, CoursesSearchDto request) {
        CustomPage<CourseDto> customPage = new CustomPage<>();
        customPage.setContent(courseDtos);
        customPage.setPageNumber(coursesPage.getNumber() + 1);
        customPage.setPageSize(coursesPage.getSize());
        customPage.setTotalElements(coursesPage.getTotalElements());
        customPage.setTotalPages(coursesPage.getTotalPages());
        customPage.setLast(coursesPage.isLast());
        customPage.setFirst(coursesPage.isFirst());
        customPage.setEmpty(coursesPage.isEmpty());
        return customPage;
    }

    public List<CourseDto> getCourseRecommendation(){
        List<CourseDto> courseDtos = new ArrayList<>();
        User user = userService.getCurrentUser();
        Department department = user.getDepartment();

        List<Course> courses = courseRepository.searchRandomCourses(department.getId());
        if(!CollectionUtils.isEmpty(courses)){
            for(Course course: courses){
                courseDtos.add(CourseDto.builder()
                        .id(course.getId())
                        .name(course.getName())
                        .code(course.getCode())
                        .build());
            }
        }
        return  courseDtos;
    }

    public ResponseEntity<Resource> download(Integer courseId) throws BadRequestException {
        Optional<Course> courseOptional = courseRepository.findById(courseId);
        if(courseOptional.isEmpty()){
            throw new BadRequestException("Course not found");
        }

        Course course = courseOptional.get();

        User user = userService.getCurrentUser();
        if(!Objects.equals(user.getDepartment().getId(), course.getDepartment().getId())){
            throw new BadRequestException("Unauthorized action: course does not apply to user");
        }


        Resource resource = resourceLoader.getResource("classpath:Courses/" + course.getName() + ".pdf");

        if (!resource.exists()) {
            throw new BadRequestException("File not found");
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" +  course.getName() + ".pdf" + "\"");

        return ResponseEntity.ok()
                .headers(headers)
                .body(resource);

    }
}
