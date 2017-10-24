package web.sakila.dao.business;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.sakila.dao.repositories.*;
import web.sakila.jpa.entities.*;

import java.util.List;


@Service("business")
public class Business implements IBusiness {

	@Autowired
	private ActorRepository actorRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private FilmRepository filmRepository;
	
	@Autowired
	private StaffRepository staffRepository;
	
	@Override
	public List<Actor> getAllActors() {
		// TODO Auto-generated method stub
		return Lists.newArrayList(actorRepository.findAll());
	}

	@Override
	public Actor getByID(int actorId) {
		// TODO Auto-generated method stub
		return actorRepository.findOne(actorId);
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return Lists.newArrayList(customerRepository.findAll());
	}

	@Override
	public Customer getByCustomerID(int customerId) {
		// TODO Auto-generated method stub
		return customerRepository.findOne(customerId);
	}

	@Override
	public List<Address> getAllAddresses() {
		// TODO Auto-generated method stub
		return Lists.newArrayList(addressRepository.findAll());
	}

	@Override
	public Address getByAddressID(int addressId) {
		// TODO Auto-generated method stub
		return addressRepository.findOne(addressId);
	}

	@Override
	public List<City> getAllCities() {
		// TODO Auto-generated method stub
		return Lists.newArrayList(cityRepository.findAll());
	}

	@Override
	public City getByCityID(int cityId) {
		// TODO Auto-generated method stub
		return cityRepository.findOne(cityId);
	}

	@Override
	public List<Film> getAllFilms() {
		// TODO Auto-generated method stub
		return Lists.newArrayList(filmRepository.findAll());
	}

	@Override
	public Film getByFilmID(int filmId) {
		// TODO Auto-generated method stub
		return filmRepository.findOne(filmId);
	}

	@Override
	public List<Staff> getAllStaffs() {
		// TODO Auto-generated method stub
		return Lists.newArrayList(staffRepository.findAll());
	}

	@Override
	public Staff getByStaffID(int staffId) {
		// TODO Auto-generated method stub
		return staffRepository.findOne(staffId);
	}

}
