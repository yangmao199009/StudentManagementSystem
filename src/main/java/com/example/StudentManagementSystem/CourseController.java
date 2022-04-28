package com.example.StudentManagementSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Course")
public class CourseController {
   @Autowired
   CourseRepository repo;
    @GetMapping("/")
    public String viewHomePage(Model model){
        List<Course> listCourse = new ArrayList<Course>();
        listCourse = repo.findAll();

        model.addAttribute("listcourse", listCourse);
        return "Course";
    }

    @GetMapping("/addcourse")
    public String add(Model model) {
        //List<Course> listcourse = new ArrayList<Course>();
       // model.addAttribute("listcourse", listcourse);
        model.addAttribute("course", new Course());
        return "addCourse";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCourse(@ModelAttribute("course") Course course) {
        //System.out.println(course.getCoursename());
       // service.save(course);
        repo.save(course);
        return "redirect:/Course/";
    }

    @RequestMapping(value = "/edit/{id}" )
    public ModelAndView updateCourse(@PathVariable(name = "id") Long id){
        ModelAndView md = new ModelAndView("addCourse");
        Course c = repo.getById(id);
        md.addObject("course",c);
        return md;
    }
    @RequestMapping("/delete/{id}")
    public String deleteCoursePage(@PathVariable(name = "id") Long id) {
        repo.deleteById(id);
        return "redirect:/Course/";
    }

}
