package com.capg.mtb.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.capg.mtb.model.Theatre;

public interface ITheatreRepository extends JpaRepository<Theatre,Integer> {

}
