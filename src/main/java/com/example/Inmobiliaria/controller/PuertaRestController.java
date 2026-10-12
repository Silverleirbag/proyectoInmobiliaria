/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Inmobiliaria.controller;

import com.example.Inmobiliaria.entity.Puerta;
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

@RestController
@RequestMapping("api/puerta")
public class PuertaRestController {

    List<Puerta> puertaList;

    @PostConstruct
    public void loadData() {

        puertaList = new ArrayList<>();

        puertaList.add(new Puerta(1, 1));
        puertaList.add(new Puerta(2, 2));
        puertaList.add(new Puerta(3, 3));
        puertaList.add(new Puerta(4, 4));
        puertaList.add(new Puerta(5, 5));
    }

    @PostMapping("/puertas")
    public Puerta addPuerta(@RequestBody Puerta thePuerta) {

        puertaList.add(thePuerta);

        return thePuerta;
    }

    @GetMapping("/puertas")
    public List<Puerta> listPuertas() {

        return puertaList;
    }

    @GetMapping("/puertas/{puertaId}")
    public Puerta getPuerta(@PathVariable int puertaId) {

        for (Puerta puerta : this.puertaList) {

            if (puerta.getId() == puertaId) {
                return puerta;
            }
        }

        return null;
    }

    @PutMapping("/puertas")
    public Puerta updatePuerta(@RequestBody Puerta thePuerta) {

        for (Puerta puerta : puertaList) {

            if (puerta.getId() == thePuerta.getId()) {

                puerta.setNumeroPuerta(thePuerta.getNumeroPuerta());
            }
        }

        return thePuerta;
    }

    @DeleteMapping("/puertas/{puertaId}")
    public String deletePuerta(@PathVariable int puertaId) {

        this.puertaList.removeIf(p -> p.getId() == puertaId);

        return "Borrada la puerta: " + puertaId;
    }
}
