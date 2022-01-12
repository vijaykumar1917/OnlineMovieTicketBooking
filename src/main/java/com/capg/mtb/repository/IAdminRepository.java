package com.capg.mtb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.mtb.model.Admin;

public interface IAdminRepository extends JpaRepository<Admin, Integer> {

}
