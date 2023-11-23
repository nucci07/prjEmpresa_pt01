package com.prjempresa.empresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prjempresa.empresa.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
