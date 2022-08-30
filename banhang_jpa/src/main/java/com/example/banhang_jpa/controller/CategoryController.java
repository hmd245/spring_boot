package com.example.banhang_jpa.controller;

import com.example.banhang_jpa.catepository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("categories")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping(value = {"newOrEdit"})
    public String newOrEdit(ModelMap model) {
        return "categories/newOrEdit";
    }
}
