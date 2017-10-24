package web.sakila.dao.repositories;

import org.springframework.data.repository.CrudRepository;

import web.sakila.jpa.entities.Film;

public interface FilmRepository extends CrudRepository<Film, Integer> {

}
