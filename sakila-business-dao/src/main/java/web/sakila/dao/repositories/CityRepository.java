package web.sakila.dao.repositories;

import org.springframework.data.repository.CrudRepository;

import web.sakila.jpa.entities.City;

public interface CityRepository extends CrudRepository<City, Integer> {

}
