package fr.iut.ld.cbreader.logic;

/**
 * Les informations sur la série à laquelle appartient un livre.
 */
public interface SeriesInformation {
    /**
     * Le nom de la série.
     */
    String name();

    /**
     * Le numéro du livre dans la série.
     */
    int number();
}
