package ru.samozanet.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.samozanet.entity.UserEntity;
import ru.samozanet.services.UserService;

@Controller
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService userService;

    @GetMapping("/registration/client")
    public String registrationClient() {
        return "registration";
    }

    @GetMapping("/registration/master")
    public String registrationMaster() {
        return "registration";
    }

    @GetMapping("/registration/admin")
    public String registrationAdmin() {
        return "registration";
    }

    @PostMapping("/registration/admin")
    public String createAdmin(@RequestParam("phonenumber")Long phonenumber, @RequestParam("lastname")String lastname,
                              @RequestParam("firstname")String firstname, UserEntity userEntity, Model model) {
        if (!userService.createAdmin(phonenumber, lastname, firstname, userEntity)) {
            model.addAttribute("errorMessage", "Пользователь с таким email или номером телефона уже существует");
            return "registration";
        }
        return "redirect:/login";
    }

    @PostMapping("/registration/client")
    public String createClient(@RequestParam("phonenumber")Long phonenumber, @RequestParam("lastname")String lastname,
                               @RequestParam("firstname")String firstname, UserEntity userEntity, Model model) {
        if (!userService.createClient(phonenumber, lastname, firstname, userEntity)) {
            model.addAttribute("errorMessage", "Пользователь с таким email или номером телефона уже существует");
            return "registration";
        }
        return "redirect:/login";
    }

    @PostMapping("/registration/master")
    public String createMaster(@RequestParam("phonenumber")Long phonenumber, @RequestParam("lastname")String lastname,
                               @RequestParam("firstname")String firstname, UserEntity userEntity, Model model) {
        if (!userService.createMaster(phonenumber, lastname, firstname, userEntity)) {
            model.addAttribute("errorMessage", "Пользователь с таким email или номером телефона уже существует");
            return "registration";
        }
        return "redirect:/login";
    }
}
