package fr.iut.ld.cbreader.logic;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Une implémentation de ComicBook qui peut être stockée en BDD.
 */
@Document
public class StoredComicBook implements ComicBook, StoredObject {
    private final ComicBook underlyingBook;
    private final int id;

    /**
     * Crée un livre qui peut être enregistré à partir d'un livre existant.
     * @param book Des informations sur un livre.
     */
    public StoredComicBook(ComicBook book) {
        this.id = -1;
        this.underlyingBook = book;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getTitle() {
        return this.underlyingBook.getTitle();
    }

    @Override
    public String getFileName() {
        return this.underlyingBook.getFileName();
    }

    @Override
    public SeriesInformation getSeriesInformation() {
        return this.underlyingBook.getSeriesInformation();
    }
}
