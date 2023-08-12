package ru.samozanet.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//import ru.samozanet.services.ObjectService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller("/")
@RequiredArgsConstructor
public class IndexController {

//    private final ObjectService objectService;

    @GetMapping("/") // Главная
    public String indexGet() {
        return "index";
    }


//    @GetMapping("/objects") // Объекты
//    public String objectsGet(Model model) {
//        model.addAttribute("objects", objectService.objectEntityList());
//        return "objects";
//    }

    @GetMapping("/contacts") // Контакты
    public String contactsGet() {
        return "contacts";
    }

    @GetMapping("/login") // Аутентификация пользователя
    public String loginGet() {
        return "login";
    }

    @GetMapping("/logout") // Выход текущего пользователя из системы
    public String logout(HttpServletRequest request, HttpServletResponse response) { // получить доступ к текущему пользователю
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) { // Если текущая аутентификация не равна null
            new SecurityContextLogoutHandler().logout(request, response, authentication); // выполнение выхода пользователя из системы
        }
        return "redirect:/login?logout";
    }
}