package com.example.demo.repositorios;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Usuario;

@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, Long>{
	
	 public abstract ArrayList<Usuario> findByPrioridad(Integer prioridad);
	
}
