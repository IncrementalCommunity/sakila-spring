package web.sakila.webapi.service;

import web.sakila.jpa.config.PersistenceConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = PersistenceConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CityServiceTest {

	@Autowired
	private CityService service;
	
	@Test
	public void testFindAllCities() {
		Assert.assertEquals(600, service.findAllCities().size());
	}

	@Test
	public void testFindById() {
		Assert.assertEquals("Abha", service.findById(2).getCity());
	}

}
