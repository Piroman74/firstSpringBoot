package com.dmitrijpol.firstboot.firstspringboot.controllers;

import com.dmitrijpol.firstboot.firstspringboot.models.User;
import com.dmitrijpol.firstboot.firstspringboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users", userService.index());
        return "index";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("newUser", new User());
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/user-remove/{id}")
    public String remove(@PathVariable("id") long id) {
        userService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        User user = userService.show(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @PatchMapping("/user-update")
    public String updateUser(@ModelAttribute() User user) {
        userService.update(user);
        return "redirect:/";
    }
}
