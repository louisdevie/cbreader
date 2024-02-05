package fr.iut.ld.cbreader.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.iut.ld.cbreader.logic.*;
import fr.iut.ld.cbreader.services.ComicsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ComicsController {
    private final ComicsService service;

    public ComicsController(ComicsService service) {
        this.service = service;
    }

    @PostMapping("book")
    @CrossOrigin
    public ResponseEntity<ComicBook> AddNewBook(
            @RequestParam(value = "book") String str,
            @RequestParam(value = "file") MultipartFile file
    ) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ComicBook book = mapper.readValue(str, ComicBook.class);
        return ResponseEntity.ok(service.AddNewBook(book, file));
    }
}
