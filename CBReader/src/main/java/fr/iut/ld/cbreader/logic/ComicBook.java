package fr.iut.ld.cbreader.logic;

/**
 * Un livre dans la bibliothèque de l'utilisateur.
 */
public interface ComicBook {
    /**
     * Le titre du livre.
     */
    String getTitle();

    /**
     * Le nom du fichier téléversé.
     */
    String getFileName();

    /**
     * Les informations sur la série, qui peut être null si c'est un one-shot.
     */
    SeriesInformation getSeriesInformation();
}
