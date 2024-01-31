package fr.iut.ld.cbreader.repositories;

import fr.iut.ld.cbreader.logic.*;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ComicsRepository extends MongoRepository<StoredComicBook, StoredObject> {

}
