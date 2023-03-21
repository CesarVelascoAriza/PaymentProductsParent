package co.com.cava.example.costumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.cava.example.costumer.entities.Custumer;

public interface CustumerRepository extends JpaRepository<Custumer, Long>{

}
