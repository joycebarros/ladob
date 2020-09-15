package com.br.recode.restaurante.ladob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.recode.restaurante.ladob.model.Tables;

@Repository
public interface TablesRepository extends JpaRepository<Tables, Integer> {

}
