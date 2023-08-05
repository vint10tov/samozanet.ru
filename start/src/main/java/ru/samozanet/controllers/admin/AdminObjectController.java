package ru.samozanet.controllers.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.samozanet.entity.ObjectEntity;
import ru.samozanet.services.ObjectService;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class AdminObjectController {

    private final ObjectService objectService;

    @GetMapping("/admin/objects") // Страница редактирования объектов
    public String adminObjectsGet() {
        return "admin-objects";
    }

    @PostMapping("/admin/objects/create") // запрос на добавление нового объекта
    public String createObject(@RequestParam("file1") MultipartFile file1,
                               @RequestParam("file2") MultipartFile file2,
                               @RequestParam("file3") MultipartFile file3,
                               @RequestParam("file4") MultipartFile file4,
                               @RequestParam("file5") MultipartFile file5,
                               @RequestParam("file6") MultipartFile file6,
                               @RequestParam("file7") MultipartFile file7,
                               @RequestParam("file8") MultipartFile file8,
                               @RequestParam("file9") MultipartFile file9,
                               @RequestParam("file10") MultipartFile file10,
                               ObjectEntity objectEntity) throws IOException {
            objectService.saveObject(objectEntity, file1, file2, file3, file4, file5,
                    file6, file7, file8, file9, file10);
        return "redirect:/admin/objects";
    }
}
