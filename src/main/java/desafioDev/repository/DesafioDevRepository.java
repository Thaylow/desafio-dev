package desafioDev.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import desafioDev.entidade.DesafioDev;

public interface DesafioDevRepository extends JpaRepository<DesafioDev, Long>{
	
	
}
