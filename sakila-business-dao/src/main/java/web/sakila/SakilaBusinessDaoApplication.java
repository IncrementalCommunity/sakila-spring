package web.sakila;

import web.sakila.dao.business.IBusiness;
import web.sakila.jpa.config.PersistenceConfig;
import web.sakila.jpa.entities.Actor;
import web.sakila.jpa.entities.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SakilaBusinessDaoApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SakilaBusinessDaoApplication.class, args);
		
		// we prepare the Spring Configuration
		SpringApplication app = new SpringApplication(PersistenceConfig.class);
		app.setLogStartupInfo(false);
		
		// we launch the Application Context
		ConfigurableApplicationContext context = app.run(args);
		
		// Business Layer
		IBusiness business = context.getBean(IBusiness.class);
		
		try{
			for (Customer customer : business.getAllCustomers()) {
				System.out.println(customer.toString());
			}
			Actor guiness = business.getByID(1);
			System.out.printf("Who is ID 1 ? %s %s %n", guiness.getLastName(), guiness.getFirstName());
		}catch(Exception e){
			System.out.println("Exception: " + e.getCause());
		}
		// Closing Spring Context
		context.close();
	}
}
