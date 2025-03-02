package org.example.granjadao.REPOSITORY;

import org.example.granjadao.MODEL.Animal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends MongoRepository<Animal, Integer> {
}
