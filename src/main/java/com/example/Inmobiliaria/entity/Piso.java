/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Inmobiliaria.entity;

/**
 *
 * @author gbrlt
 */

public class Piso {
    private int numeroPiso;
    private String nombre;
    private int id;

    public Piso() {
    }

    public Piso(int numeroPiso, String nombre, int id) {
        this.numeroPiso = numeroPiso;
        this.nombre = nombre;
        this.id = id;
    }

    public int getNumeroPiso() {
        return numeroPiso;
    }

    public void setNumeroPiso(int numeroPiso) {
        this.numeroPiso = numeroPiso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
