package web.sakila.dao.repositories;

import org.springframework.data.repository.CrudRepository;

import web.sakila.jpa.entities.Address;

public interface AddressRepository extends CrudRepository<Address, Integer> {

}
