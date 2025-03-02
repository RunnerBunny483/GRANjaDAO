package org.example.granjadao.REPOSITORY;

import org.example.granjadao.MODEL.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajadorRepository extends JpaRepository<Trabajador, String> {
}
