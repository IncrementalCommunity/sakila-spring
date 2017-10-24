package web.sakila.dao.repositories;

import org.springframework.data.repository.CrudRepository;

import web.sakila.jpa.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{

}
