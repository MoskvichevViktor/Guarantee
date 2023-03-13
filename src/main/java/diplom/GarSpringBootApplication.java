package diplom;

import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@SpringBootApplication
public class GarSpringBootApplication {

    public static void main(String[] args) {

        SpringApplication.run(GarSpringBootApplication.class, args);

    }

}
