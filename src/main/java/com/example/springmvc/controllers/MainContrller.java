package com.example.springmvc.controllers;


import com.example.springmvc.dao.UserDAO;
import com.example.springmvc.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class MainContrller {

    private UserDAO userDAO;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("xxx", "hi");
        return "homeTemplate";
    }

    @PostMapping("/saveUser")
    public String saveUser(User user, Model model) {
        userDAO.save(user);
        model.addAttribute("someUser", user);
        model.addAttribute("users", userDAO.findAll());
        System.out.println(user);
        System.out.println(userDAO.findAll());

        return "next";
    }

    @PostMapping("/editUser")
    public String editUser(User user, Model model){
        System.out.println(user);
        userDAO.save(user);
        model.addAttribute("someUser", user);
        model.addAttribute("users", userDAO.findAll());
        return "next";
    }
}
