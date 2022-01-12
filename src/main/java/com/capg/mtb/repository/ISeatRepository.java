package com.capg.mtb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.mtb.model.Seat;

public interface ISeatRepository extends JpaRepository<Seat, Integer>{

}
