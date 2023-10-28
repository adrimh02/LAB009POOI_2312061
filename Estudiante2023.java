/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrodeestudiantes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class Estudiante2023 {
   
    private static ArrayList<Estudiante> estudiantes;

    public Estudiante2023() {
        estudiantes = new ArrayList<>();
        cargarArchivo();
    }

    public void adicionar(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public void eliminar(Estudiante estudiante) {
        estudiantes.remove(estudiante);
    }

    public Estudiante obtener(int pos) {
	if (pos >= 0 && pos < estudiantes.size()) {
            return estudiantes.get(pos);
        }
        return null;
    }

    public Estudiante buscar(int codigo) {
	for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCodigo() == codigo) {
                return estudiante;
            }
        }       
	  return null;
    }

    public int tamano() {        
	  return  estudiantes.size();
    }

    public void listarEstudiantes(){
        System.out.println("LISTA DE ESTUDIANTES:");
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante.toString());
        }        
    }
    public void ordenarPorApellidos() {
        Collections.sort(estudiantes, Comparator.comparing(Estudiante::getApellido));
    }
    public void ordenarPorPension() {
    Collections.sort(estudiantes, Comparator.comparingDouble(Estudiante::getPension));

    System.out.println("Pensiones de los estudiantes:");
    for (Estudiante estudiante : estudiantes) {
        System.out.println(estudiante.getPension());
    }
}

    public double calcularTotalPensiones() {
        double total = 0;
        for (Estudiante estudiante : estudiantes) {
            total += estudiante.getPension();
        }
        return total;
    }
 
