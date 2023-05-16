package com.example.demo.repository;

import com.example.demo.entity.Mechanics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface MechanicsRepository extends JpaRepository<Mechanics, Long>{

}
