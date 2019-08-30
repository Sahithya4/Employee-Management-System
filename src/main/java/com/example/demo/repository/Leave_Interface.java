package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.entity.Leaves;

public interface Leave_Interface extends JpaRepository<Leaves, Integer> {

	@Query("SELECT l FROM Leaves l where l.name =:name")
	public Leaves getleaves(@Param("name") String name);

}
