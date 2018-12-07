package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    @RequestMapping("/")
    public String index(Model model){
        Student student = new Student();
        student.setName("Chaz Westbrooks");

        Course course = new Course();
        course.setName("JAVA");
        course.setTeacher("Henley");
        course.setDescription("About Java...");

        Set<Course> courses = new HashSet<Course>();
        courses.add(course);

        student.setCourses(courses);

        studentRepository.save(student);

        model.addAttribute("students", studentRepository.findAll());
        return "index";
    }
}
