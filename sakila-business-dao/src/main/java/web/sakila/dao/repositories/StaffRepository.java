package web.sakila.dao.repositories;

import org.springframework.data.repository.CrudRepository;

import web.sakila.jpa.entities.Staff;

public interface StaffRepository extends CrudRepository<Staff, Integer> {

}
