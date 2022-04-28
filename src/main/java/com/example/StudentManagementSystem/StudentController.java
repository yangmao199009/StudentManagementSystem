package com.example.StudentManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Student")
public class StudentController {
    @Autowired
    StudentRepository repo;
    @RequestMapping("/")
    public String viewStudentHomePage(Model model){
        List<Student> studentList = new ArrayList<Student>();
        studentList=repo.findAll();

        model.addAttribute("liststudent", studentList);
        return "Student";
    }

    @GetMapping("/addstudent")
    public String add(Model model) {
        //List<Course> listcourse = new ArrayList<Course>();
       // model.addAttribute("listcourse", listcourse);
        model.addAttribute("student", new Student());
        return "addStudent";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCourse(@ModelAttribute("student") Student student) {
        //System.out.println(course.getCoursename());
        // service.save(course);
        repo.save(student);
        return "redirect:/Student/";
    }
}
