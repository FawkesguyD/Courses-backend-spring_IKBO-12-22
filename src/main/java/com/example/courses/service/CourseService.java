package com.example.courses.service;

import com.example.courses.dto.CourseDTO;
import com.example.courses.model.Course;
import com.example.courses.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<CourseDTO> getCourseById(Long id) {
        return courseRepository.findById(id)
                .map(this::convertToDTO);
    }

    @Transactional
    public CourseDTO createCourse(CourseDTO courseDTO) {
        Course course = convertToEntity(courseDTO);
        Course savedCourse = courseRepository.save(course);
        return convertToDTO(savedCourse);
    }

    @Transactional
    public Optional<CourseDTO> updateCourse(Long id, CourseDTO courseDTO) {
        return courseRepository.findById(id)
                .map(existingCourse -> {
                    Course course = convertToEntity(courseDTO);
                    course.setId(id);
                    return convertToDTO(courseRepository.save(course));
                });
    }

    @Transactional
    public boolean deleteCourse(Long id) {
        return courseRepository.findById(id)
                .map(course -> {
                    courseRepository.delete(course);
                    return true;
                })
                .orElse(false);
    }

    private CourseDTO convertToDTO(Course course) {
        CourseDTO dto = new CourseDTO();
        dto.setId(course.getId());
        dto.setTitle(course.getTitle());
        dto.setDescription(course.getDescription());
        dto.setInstructor(course.getInstructor());
        dto.setDurationHours(course.getDurationHours());
        dto.setPrice(course.getPrice());
        return dto;
    }

    private Course convertToEntity(CourseDTO dto) {
        Course course = new Course();
        course.setId(dto.getId());
        course.setTitle(dto.getTitle());
        course.setDescription(dto.getDescription());
        course.setInstructor(dto.getInstructor());
        course.setDurationHours(dto.getDurationHours());
        course.setPrice(dto.getPrice());
        return course;
    }
} 