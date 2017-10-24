package web.sakila.dao.business;

import web.sakila.jpa.entities.*;

import java.util.List;

public interface IBusiness {
	
	public List<Actor> getAllActors();
	
	public Actor getByID(int actorId);
	
	public List<Customer> getAllCustomers();
	
	public Customer getByCustomerID(int customerId);
	
	public List<Address> getAllAddresses();
	
	public Address getByAddressID(int addressId);
	
	public List<City> getAllCities();
	
	public City getByCityID(int cityId);
	
	public List<Film> getAllFilms();
	
	public Film getByFilmID(int filmId);
	
	public List<Staff> getAllStaffs();
	
	public Staff getByStaffID(int staffId);
}
