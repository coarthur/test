package fr.solutec;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.solutec.entities.Address;
import fr.solutec.entities.User;
import fr.solutec.repository.AddressRepository;
import fr.solutec.repository.UserRepository;

@SpringBootApplication
public class PrimoSpringDev52021Application implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepos;
	@Autowired
	private AddressRepository addressRepos;
	
	public static void main(String[] args) {
		SpringApplication.run(PrimoSpringDev52021Application.class, args);
		System.out.println("lancement terminé");
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		Address a1 = new Address(null, "Saint-Denis", "10 rue Ampère", "8", "93200");
		Address a2 = new Address(null, "Paris", "Avenue George V", "8", "75008");
		Address a3 = new Address(null, "Paris", "Rue Saint-Martin", "40", "75010");
		Address a4 = new Address(null, "Boulogne", "Rue du bonheur", "2", "92012");
		
		Stream.of(a1, a2, a3, a4).forEach(a -> {
			addressRepos.save(a);
		});
			
		User u1 = new User (null, "CORNET", "Arthur", 23, "azerty", "rose", a1);
		User u2 = new User (null, "MSAIDIE", "Zaher", 23, "exploit", "rose", a2);
		User u3 = new User (null, "EUSTACHE", "Juliette", 23, "juliettee", "rose", a3);
		User u4 = new User (null, "GALLON", "Rose-Marie", 23, "rosemarieg", "rose", a4);
		userRepos.save(u1);
		userRepos.save(u2);
		userRepos.save(u3);
		userRepos.save(u4);
		
				
		/*		
		userRepos.findAll().forEach(u -> {
			System.out.println(u.toString());
		});
		
		Optional<User> uP = userRepos.findByLoginAndMdp("azerty","rose");
		if(uP.isPresent()) {
			System.out.println("connexion ok");
			System.out.println(uP.get().toString());
		}
		else {
			System.out.println("user not found");
		}
		*/
	}

}
