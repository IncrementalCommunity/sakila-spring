package web.sakila.webapi.service;

import web.sakila.jpa.config.PersistenceConfig;
import web.sakila.webapi.model.ActorWO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@SpringBootTest(classes = PersistenceConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ActorServiceTest {

	@Autowired
	private ActorService service;
	
	@Test
	public void testFindById() {
		Assert.assertEquals("GUINESS", service.findById(1).getLastName());
	}

	@Test
	public void testSaveActor() {
		ActorWO testWO = new ActorWO();
		testWO.setActorId(201);
		testWO.setFirstName("zpeng");
		testWO.setLastName("zpeng");
		service.saveActor(testWO);
		Assert.assertEquals("zpeng", service.findById(201).getLastName());
	}

	@Test
	public void testUpdateActor() {
		ActorWO updateWO = service.findById(201);
		updateWO.setLastName("test");
		service.updateActor(updateWO);
		Assert.assertEquals("test", service.findById(201).getLastName());
	}

	@Test
	public void testDeleteActorById() {
		service.deleteActorById(201);
		Assert.assertEquals(200, service.findAllActors().size());
	}

	@Test
	public void testFindAllActors() {
		Assert.assertEquals(200, service.findAllActors().size());
	}

}
