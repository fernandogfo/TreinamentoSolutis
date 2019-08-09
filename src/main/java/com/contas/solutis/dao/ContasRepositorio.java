package com.contas.solutis.dao;

import com.contas.solutis.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ContasRepositorio extends JpaRepository<Conta, Long> {
    Conta findById(long id);
    List<Conta> findByNome(String nome);



    @Query(value = "SELECT * FROM contas WHERE extract(month from data_venc) = :dataVenc", nativeQuery = true)
    List<Conta> findByData(@Param("dataVenc") int dataVenc);

    @Query(value = "SELECT * FROM contas WHERE extract(month from data_venc) = :dataVenc " +
            "AND permanente = true", nativeQuery = true)
    List<Conta> findByPermanente(@Param("dataVenc") int dataVenc);

}
