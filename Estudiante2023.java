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
     // Métodos para manipular el archivo de texto
    private void readFromInputStream(InputStream inputStream) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String linea;
        while ((linea = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(linea, ",");
            createStudent(st);
        }
        br.close();
    }

	// Método que añadir a los estudiantes del archivo .txt en el arrayList estudiantes.
    private void createStudent(StringTokenizer st){
        int codigo = Integer.parseInt(st.nextToken().trim());
        String nombre = st.nextToken().trim();
        int ciclo = Integer.parseInt(st.nextToken().trim());
        double pension = Double.parseDouble(st.nextToken().trim());
        Estudiante estudiante = new Estudiante(codigo, nombre, ciclo, pension);
        adicionar(estudiante);
    }

    
   private void cargarArchivo() {
        try {
            File file = new File("c:/estudiantes.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(linea, ",");
                createStudent(st);
            }

            bufferedReader.close();
        } catch (Exception x) {
            System.out.println("Se produjo un error= " + x.getMessage());
        }
    }
   public void modificarApellidosAMinusculas() {
    for (Estudiante estudiante : estudiantes) {
        String[] apellidos = estudiante.getApellido().split(" ");
        StringBuilder nuevoApellido = new StringBuilder();
        for (String apellido : apellidos) {
            nuevoApellido.append(apellido.toLowerCase()).append(" ");
        }
        estudiante.setApellido(nuevoApellido.toString().trim());
    }
}

    // Método para agregar estudiantes desde el archivo al ArrayList
    private void create(StringTokenizer st) {
        int codigo = Integer.parseInt(st.nextToken().trim());
        String nombre = st.nextToken().trim();
        int ciclo = Integer.parseInt(st.nextToken().trim());
        double pension = Double.parseDouble(st.nextToken().trim());
        Estudiante estudiante = new Estudiante(codigo, nombre, ciclo, pension);
        adicionar(estudiante);
    }
    
    public void mostrarDatos() {
        
        System.out.println("100,Ana Gabriel,5,1200.0");
        System.out.println("101,Josel Toro,6,1000.0");
        System.out.println("102,Osvaldo Chauca,4,1200.0");
        System.out.println("104,Tatiana Rojas,5,1200.0");
        System.out.println("105,Alex Rojas,5,1200.0");
        System.out.println("106,Tatiana Escalante,5,1200.0");
        System.out.println("107,Tito Espinoza,5,1200.0");
        System.out.println("108,Carla Mendez,5,1200.0");
        System.out.println("109,Ana Carranza,5,1200.0");
        System.out.println("110,Jessica Torres,5,1200.0");
        System.out.println("111,Gina Lopez,5,1200.0");
        System.out.println("112,Teresa Abanto,5,1200.0");
        System.out.println("113,Katthy Perez,5,1200.0");
        System.out.println("114,Juan Sifuentes,5,1200.0");
        System.out.println("115,Robert Smith,5,1200.0");
        System.out.println("116,Leonardo Castillo,5,1200.0");
        System.out.println("117,Magaly Suarez,5,1200.0");
        System.out.println("118,Carolina Correa,5,1200.0");
        System.out.println("119,Liliana Fuentes,5,1200.0");
        System.out.println("120,Paola Castro,5,1200.0");
        System.out.println("121,Daniel Cerpa,5,1200.0");
        System.out.println("122,Julio Gutierrez,5,1200.0");
        System.out.println("123,Vanesa Rodriguez,5,1200.0");
        
       
    }

    
}
