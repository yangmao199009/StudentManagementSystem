package com.example.StudentManagementSystem;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Course")
public class CourseController {
    @GetMapping("/")
    public String viewHomePage(Model model){
        List<Course> listCourse = new ArrayList<Course>();

        Course a = new Course();
        a.setCoursename("Spring");
        a.setId(1L);
        a.setDuration(2);

        Course b = new Course();
        b.setCoursename("Spring");
        b.setId(2L);
        b.setDuration(2);
        Course c = new Course();
        c.setCoursename("Spring");
        c.setId(3L);
        c.setDuration(2);

        listCourse.add(a);
        listCourse.add(b);
        listCourse.add(c);

        model.addAttribute("listcourse", listCourse);
        return "Course";
    }
}
