package web.sakila.webapi.service;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.sakila.dao.repositories.FilmRepository;
import web.sakila.dao.repositories.InventoryRepository;
import web.sakila.dao.repositories.StoreRepository;
import web.sakila.jpa.entities.Film;
import web.sakila.jpa.entities.Inventory;
import web.sakila.jpa.entities.Store;
import web.sakila.webapi.model.InventoryWO;

@Service("inventoryService")
@Transactional
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;

	@Autowired
	private FilmRepository filmRepository;

	@Autowired
	private StoreRepository storeRepository;

	// log
	private static final Log log = LogFactory.getLog(InventoryServiceImpl.class);

	// find all inventories
	@Override
	public List<InventoryWO> findAllInventories() {
		List<InventoryWO> inventories = new LinkedList<InventoryWO>();
		for (Inventory inventory : inventoryRepository.findAll()) {
			inventories.add(new InventoryWO(inventory));
			log.debug("Add inventory with id : " + inventory.getInventoryId());
		}
		return inventories;
	}

	// find by id
	@Override
	public InventoryWO findById(int id) {
		log.debug("Find inventory with id : " + id);
		Inventory inventory = inventoryRepository.findOne(id);

		if (inventory != null) {
			return new InventoryWO(inventory);
		}
		return null;
	}

	// save inventory
	@Override
	public void saveInventory(InventoryWO inventoryWO) {
		Inventory inventory = new Inventory();
		Film film = filmRepository.findOne(inventoryWO.getFilm());
		Store store = storeRepository.findOne((byte) inventoryWO.getStore());

		inventory.setFilm(film);
		inventory.setStore(store);
		inventory.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		inventoryRepository.save(inventory);
	}

	// update inventory
	@Override
	public void updateInventory(InventoryWO inventoryWO) {
		Inventory inventory = inventoryRepository.findOne(inventoryWO.getInventoryId());
		Film film = filmRepository.findOne(inventoryWO.getFilm());
		Store store = storeRepository.findOne((byte) inventoryWO.getStore());

		inventory.setFilm(film);
		inventory.setStore(store);
		inventory.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		inventoryRepository.save(inventory);
	}

	// delete inventory
	@Override
	public void deleteInventoryById(int id) {
		inventoryRepository.delete(id);
	}

	// find by store id
	@Override
	public List<InventoryWO> findInventoriesByStore(int storeId) {
		List<InventoryWO> inventories = new LinkedList<InventoryWO>();
		for (Inventory inventory : inventoryRepository.findAll()) {
			if (inventory.getStore().getStoreId() == storeId) {
				inventories.add(new InventoryWO(inventory));
				log.debug("Add inventory with id : " + inventory.getInventoryId());
			}
		}
		return inventories;
	}

	// find by film id
	@Override
	public List<InventoryWO> findInventoriesByFilm(int filmId) {
		List<InventoryWO> inventories = new LinkedList<InventoryWO>();
		for (Inventory inventory : inventoryRepository.findAllInventoriesByFilm(filmRepository.findOne(filmId))) {
			inventories.add(new InventoryWO(inventory));
		}
		return inventories;
	}

}
