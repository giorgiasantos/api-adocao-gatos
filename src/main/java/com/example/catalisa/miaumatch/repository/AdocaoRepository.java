package com.example.catalisa.miaumatch.repository;

import com.example.catalisa.miaumatch.model.AdocaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdocaoRepository extends JpaRepository<AdocaoModel,Long> {
}
