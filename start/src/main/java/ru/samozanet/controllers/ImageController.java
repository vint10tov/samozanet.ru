package ru.samozanet.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.samozanet.entity.ImagesObject;
import ru.samozanet.repository.ImagesObjectRepository;

import java.io.ByteArrayInputStream;

@RestController
@RequiredArgsConstructor
public class ImageController {
    private final ImagesObjectRepository imagesObjectRepository;

    @GetMapping("/objects/images/{id}") // Запрос на получение картинки по id
    private ResponseEntity<?> getImageById (@PathVariable Long id){
        ImagesObject image = imagesObjectRepository.findById(id).orElse(null);
        assert image != null;
        return ResponseEntity.ok()
                .header("fileName", image.getOriginalFileName()) // оригинальное название картинки
                .contentType(MediaType.valueOf(image.getContentType())) // тип файла
                .contentLength(image.getSize()) // размер файла
                .body(new InputStreamResource(new ByteArrayInputStream(image.getBytes()))); // картинка в байтах
    }
}
