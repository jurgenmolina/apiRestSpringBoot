package com.example.demo.controladores;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Usuario;
import com.example.demo.servicios.UsuarioServicio;

@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {
	
	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@GetMapping()
	public ArrayList<Usuario> obtenerUsuarios(){
		return usuarioServicio.obtenerUsuarios();
	}
	
	@PostMapping()
	public Usuario guardarUsuario(@RequestBody Usuario usuario) {
		return this.usuarioServicio.guardarUsuario(usuario);
	}
	
	@GetMapping( path = "/{id}")
    public Optional<Usuario> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.usuarioServicio.obtenerPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<Usuario> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.usuarioServicio.obtenerPorPrioridad(prioridad);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.usuarioServicio.eliminarUsuario(id);
        if (ok){
            return "Se eliminó el usuario con id " + id;
        }else{
            return "No pudo eliminar el usuario con id" + id;
        }
    }
	
}
