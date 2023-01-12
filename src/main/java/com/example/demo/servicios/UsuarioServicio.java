package com.example.demo.servicios;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Usuario;
import com.example.demo.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServicio {

	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	
	public ArrayList<Usuario> obtenerUsuarios() {
		return (ArrayList<Usuario>) usuarioRepositorio.findAll();
	}
	
	public Usuario guardarUsuario(Usuario usuario){
        return usuarioRepositorio.save(usuario);
    }
	
	public Optional<Usuario> obtenerPorId(Long id){
        return usuarioRepositorio.findById(id);
    }
	
	public ArrayList<Usuario>  obtenerPorPrioridad(Integer prioridad) {
        return usuarioRepositorio.findByPrioridad(prioridad);
    }
	
	public boolean eliminarUsuario(Long id) {
        try{
        	usuarioRepositorio.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
	
}
