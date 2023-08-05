package ru.samozanet.controllers.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.samozanet.services.PriceService;

@Controller
@RequiredArgsConstructor
public class AdminPriceController {

    @GetMapping("/admin/price") // Страница редактирования услуг
    public String adminPriceGet() {
        return "admin-price";
    }

    @Autowired
    private PriceService priceService;

    @PostMapping("/admin/price/create") // Запрос на обновление списка услуг из файла xlsx
    public String addPrice(@RequestParam("file") MultipartFile file) {
        priceService.savePrice(file);
        return "redirect:/admin/price";
    }
}
