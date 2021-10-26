package fr.solutec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	public Optional<User> findByLoginAndMdp(String login, String mdp);
	
	public List<User> findByAdresseVille(String ville);
	
}
