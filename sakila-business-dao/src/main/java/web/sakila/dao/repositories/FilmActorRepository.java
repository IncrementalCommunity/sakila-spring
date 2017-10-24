package web.sakila.dao.repositories;

import org.springframework.data.repository.CrudRepository;

import web.sakila.jpa.entities.FilmActor;

public interface FilmActorRepository extends CrudRepository<FilmActor, Integer> {

}