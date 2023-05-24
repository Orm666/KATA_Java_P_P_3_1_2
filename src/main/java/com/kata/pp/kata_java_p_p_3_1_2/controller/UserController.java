package com.kata.pp.kata_java_p_p_3_1_2.controller;

import com.kata.pp.kata_java_p_p_3_1_2.model.User;
import com.kata.pp.kata_java_p_p_3_1_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/users", method = RequestMethod.POST)
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String displayAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "viewAllUsers";
    }

    @GetMapping("/add")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("add", true);
        return "viewUser";
    }

    @GetMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String updateUser(@PathVariable Long id ,Model model) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("add", false);
        return "viewUser";
    }

    @GetMapping("/updateUser")
    public String updateNewUser(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/removeUser")
    public String removeUser(@PathVariable Long id) {
        userService.remove(id);
        return "redirect:/users";
    }
}
