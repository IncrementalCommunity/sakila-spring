package web.sakila.dao.repositories;

import org.springframework.data.repository.CrudRepository;

import web.sakila.jpa.entities.Actor;

public interface ActorRepository extends CrudRepository<Actor, Integer>{

}
