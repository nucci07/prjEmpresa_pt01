package com.prjempresa.empresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.prjempresa.empresa.entities.Funcionario;
import com.prjempresa.empresa.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
	private FuncionarioRepository Funcionariorepository;

public FuncionarioService(FuncionarioRepository funcionariorepository) {
	this.Funcionariorepository = funcionariorepository;
}

public Funcionario savefuncionario(Funcionario funcionario) {
	return Funcionariorepository.save(funcionario);
}

public Funcionario getfuncionarioById(Long Funcodigo) {
	return Funcionariorepository.findById(Funcodigo).orElse(null);
}

public List<Funcionario> getAllFuncionario() {
	return Funcionariorepository.findAll();
}

public void deletefuncionario(Long Funcodigo) {
	Funcionariorepository.deleteById(Funcodigo);
}

public Funcionario saveFuncionario(Funcionario funcionario) {
	return Funcionariorepository.save(funcionario);
}

public Funcionario updatefuncionario(Long Funcodigo, Funcionario novofuncionario) {
	Optional<Funcionario> funcionarioOptional = Funcionariorepository.findById(Funcodigo);

	if (funcionarioOptional.isPresent()) {
		Funcionario funcionarioExistente = funcionarioOptional.get();
		funcionarioExistente.setFunnome(novofuncionario.getFunnome());
		funcionarioExistente.setFunnascimento(novofuncionario.getFunnascimento());
		funcionarioExistente.setFunsalario(novofuncionario.getFunsalario());
		return Funcionariorepository.save(funcionarioExistente);
	} else {
		return null;
	}
}
}
