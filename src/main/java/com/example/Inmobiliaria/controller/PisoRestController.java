/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Inmobiliaria.controller;

import com.example.Inmobiliaria.entity.Piso;
import jakarta.annotation.PostConstruct;
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




/**
 *
 * @author gbrlt
 */

@RestController
@RequestMapping("/api/piso")
public class PisoRestController {
    
   List<Piso> pisoList;

    @PostConstruct
    public void loadData() {

        pisoList = new ArrayList<>();

        pisoList.add(new Piso(0, "Sótano", 1));
        pisoList.add(new Piso(1, "Planta Baja", 2));
        pisoList.add(new Piso(2, "1ª Planta", 3));
        pisoList.add(new Piso(3, "2ª Planta", 4));
        pisoList.add(new Piso(4, "3ª Planta", 5));
    }

    @PostMapping("/pisos")
    public Piso addPiso(@RequestBody Piso thePiso) {

        pisoList.add(thePiso);

        return thePiso;
    }

    @GetMapping("/pisos")
    public List<Piso> listPisos() {

        return pisoList;
    }

    @GetMapping("/pisos/{pisoId}")
    public Piso getPiso(@PathVariable int pisoId) {

        for (Piso piso : this.pisoList) {

            if (piso.getId() == pisoId) {
                return piso;
            }
        }

        return null;
    }

    @PutMapping("/pisos")
    public Piso updatePiso(@RequestBody Piso thePiso) {

        for (Piso piso : pisoList) {

            if (piso.getId() == thePiso.getId()) {

                piso.setNumeroPiso(thePiso.getNumeroPiso());
                piso.setNombre(thePiso.getNombre());
            }
        }

        return thePiso;
    }

    @DeleteMapping("/pisos/{pisoId}")
    public String deletePiso(@PathVariable int pisoId) {

        this.pisoList.removeIf(p -> p.getId() == pisoId);

        return "Borrado el piso: " + pisoId;
    }
}
