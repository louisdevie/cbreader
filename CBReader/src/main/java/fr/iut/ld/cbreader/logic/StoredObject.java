package fr.iut.ld.cbreader.logic;

import org.springframework.data.annotation.Id;;

/**
 * Une interface commune à tous les objets stockés en BDD.
 */
public interface StoredObject {
    @Id
    int getId();
}
