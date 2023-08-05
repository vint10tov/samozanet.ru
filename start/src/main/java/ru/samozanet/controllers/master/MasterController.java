package ru.samozanet.controllers.master;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MasterController {

    @GetMapping("/master")
    public String master() {
        return "master";
    }
}
