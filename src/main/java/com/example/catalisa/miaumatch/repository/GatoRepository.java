package com.example.catalisa.miaumatch.repository;

import com.example.catalisa.miaumatch.model.GatoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GatoRepository extends JpaRepository<GatoModel,Long> {
    @Query("SELECT nome FROM GatoModel nome WHERE LOWER (nome.nome) = LOWER(:nome)")
    Optional<List<GatoModel>> findByName(String nome);

}
