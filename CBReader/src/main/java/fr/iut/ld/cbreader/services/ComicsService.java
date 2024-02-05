package fr.iut.ld.cbreader.services;

import fr.iut.ld.cbreader.logic.*;
import fr.iut.ld.cbreader.repositories.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ComicsService {
    private ComicsRepository comics;
    private FilesRepository files;

    public ComicsService(ComicsRepository comics, @Value("${books_location}") String booksLocation) {
        this.comics = comics;
        this.files = new FilesRepository(booksLocation);
    }

    public ComicBook AddNewBook(ComicBook book, MultipartFile file) throws IOException {
        this.files.uploadFile(file, book.getFileName());
        return this.comics.insert(new StoredComicBook(book));
    }
}
