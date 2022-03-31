package fr.limayrac.banque.repository;

import fr.limayrac.banque.model.Compte;
import org.springframework.data.repository.CrudRepository;

public interface CompteRepository extends CrudRepository<Compte, Integer> {
}
