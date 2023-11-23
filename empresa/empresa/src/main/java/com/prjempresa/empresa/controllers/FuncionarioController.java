package com.prjempresa.empresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prjempresa.empresa.entities.Funcionario;
import com.prjempresa.empresa.services.FuncionarioService;

@RestController
@RequestMapping("/Funcionario")
public class FuncionarioController {
	
	private final FuncionarioService Funcionarioservice;

	@GetMapping("/home")
	public String paginaInicial() {
		return "index";
	}

	@Autowired
	public FuncionarioController(FuncionarioService Funcionarioservice) {
		this.Funcionarioservice = Funcionarioservice;
	}

	@PostMapping
	public Funcionario createFuncionarios(@RequestBody Funcionario Funcionario) {
		return Funcionarioservice.saveFuncionario(Funcionario);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> getFuncionario(@PathVariable Long Funcodigo) {
		Funcionario Funcionario = Funcionarioservice.getfuncionarioById(Funcodigo);
		if (Funcionario != null) {
			return ResponseEntity.ok(Funcionario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public void deleteFuncionario(@PathVariable Long Funcodigo) {
		Funcionarioservice.deletefuncionario(Funcodigo);
	}

	@GetMapping
	public ResponseEntity<List<Funcionario>> getAllFuncionario(RequestEntity<Void> requestEntity) {
		String method = requestEntity.getMethod().name();
		String contentType = requestEntity.getHeaders().getContentType().toString();
		List<Funcionario> Funcionario = Funcionarioservice.getAllFuncionario();
		return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
				.body(Funcionario);
	}

	@PutMapping("/{id}")
	public Funcionario updateFuncionario(@PathVariable Long Funcodigo, @RequestBody Funcionario departamento) {
		return Funcionarioservice.updatefuncionario(Funcodigo, departamento);
	}

}
