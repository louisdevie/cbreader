package fr.iut.ld.cbreader.repositories;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;

public class FilesRepository {
    private final String booksLocation;

    public FilesRepository(String booksLocation) {
        this.booksLocation = booksLocation;
    }

    /**
     * store a file sent by form
     *
     * @param file     the file to store
     * @param fileName the name of the file (simple filename, no path)
     * @throws IOException if the file can not be written
     */
    public void uploadFile(MultipartFile file, String fileName) throws IOException {
        if (fileName == null || fileName == "") {
            fileName = file.getOriginalFilename();
        }
        Path destinationPath = Paths.get(this.booksLocation, fileName);
        destinationPath = destinationPath.normalize().toAbsolutePath();
        try (InputStream stream = file.getInputStream()) {
            Files.copy(stream, destinationPath, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
