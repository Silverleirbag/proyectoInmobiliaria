package com.example.Inmobiliaria.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Inmobiliaria.entity.Direccion;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("api")
public class DireccionRestController {
List<Direccion> list;
//crea direccion
@PostMapping("/createDireccion")
public Direccion addDireccion(@RequestBody Direccion theDireccion) {
	list.add(theDireccion);
	return theDireccion;
}

//lee los datos y los cargar en memoria
@PostConstruct
public void loadData() {
	list= new ArrayList<Direccion>();
	list.add(new Direccion(1, "calle Pepe", 5, "05821", "Barcelona"));
}
//mostrar todas las direcciones
@GetMapping("/direcciones")
public List<Direccion> getDirecciones() {
	return this.list;
}

//mostrar dirección {id}
@GetMapping("/direcciones/{id}")
public Direccion getDireccion(@PathVariable int id) {
	for(Direccion direccion: this.list) {
		if(direccion.getId() == id) {
			return direccion;
		}
	}
	return null;
	}
	// actualizar campos
	@PutMapping("/updateDireccion")
	public Direccion updateDireccion(@RequestBody Direccion theDireccion) {
		for(Direccion direccion: list) {
			if(direccion.getId() == theDireccion.getId()) {
				direccion.setCalle(theDireccion.getCalle());
				direccion.setNumero(theDireccion.getNumero());
				direccion.setCp(theDireccion.getCp());
				direccion.setProvincia(theDireccion.getProvincia());
				return direccion;
				
			}
			
		}
		return null;
	}
//eliminardirección {id}
	@DeleteMapping("/deleteDireccion/{id}")
public boolean deleteDireccion(@PathVariable int id) {
	for (Direccion direccion : list) {
		if(direccion.getId() == id) {
			list.remove(direccion);
			return true;
		}
	}
	return false;
}
}