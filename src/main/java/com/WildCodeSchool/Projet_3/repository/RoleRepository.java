package com.WildCodeSchool.Projet_3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.WildCodeSchool.Projet_3.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
