package com.example.lab2.controller;

import com.example.lab2.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("students")
public class StudentController {
    @GetMapping("new")
    public String newForm() {
        return "students/new";
    }

    @PostMapping("saveOrUpdate")
    public String saveOrUpdate(
            @RequestParam("studentId") String studentId,
            @RequestParam("name") String name,
            Model model) {
        System.out.println("student Id: " + studentId);
        System.out.println("student Id: " + name);

        model.addAttribute("studentId", studentId);
        model.addAttribute("name", name);
        return "students/viewDetail";
//        return "students/edit";
    }

    @PostMapping("update")
    public String update(Student student, Model model) {
        System.out.println("Update method");

        model.addAttribute("studentId", student.getStudentId());
        model.addAttribute("name", student.getName());

        return "students/viewDetail";
    }

    @GetMapping("edit/{studentId}")
    public String edit(@PathVariable("studentId") String studentId, Model model) {
        System.out.println("Edit Student Id: " + studentId);

        Student student = new Student();
        student.setStudentId(studentId);
        student.setName("Minh");

        model.addAttribute("student", student);

        return "students/edit";
    }

    @RequestMapping("list")
    public String list() {
        return "students/list";
    }

    @RequestMapping("search")
    public String search() {
        return "students/search";
    }
}
