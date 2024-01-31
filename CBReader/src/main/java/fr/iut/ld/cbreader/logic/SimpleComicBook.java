package fr.iut.ld.cbreader.logic;

import java.util.Objects;

/**
 * Une implémentation de ComicBook qui stocke juste les informations nécessaires.
 */
public class SimpleComicBook implements ComicBook {
    private final String title;
    private final String fileName;
    private final SimpleSeriesInformation seriesInformation;

    private record SimpleSeriesInformation(String name, int number) implements SeriesInformation { }

    /**
     * Crée un livre avec les informations sur la série.
     * @param title Le titre du livre.
     * @param fileName Le nom du fichier téléversé.
     * @param seriesName Le nom de la série.
     * @param seriesNumber Le numéro du livre dans la série.
     */
    public SimpleComicBook(String title, String fileName, String seriesName, int seriesNumber) {
        this.title = title;
        this.fileName = fileName;
        this.seriesInformation = new SimpleSeriesInformation(seriesName, seriesNumber);
    }

    /**
     * Crée un livre sans série (one-shot).
     * @param title Le titre du livre.
     * @param fileName Le nom du fichier téléversé.
     */
    public SimpleComicBook(String title, String fileName) {
        this(title, fileName, null, -1);
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getFileName() {
        return this.fileName;
    }

    @Override
    public SeriesInformation getSeriesInformation() {
        return this.seriesInformation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleComicBook that = (SimpleComicBook) o;
        return Objects.equals(title, that.title) && Objects.equals(fileName, that.fileName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, fileName);
    }
}
