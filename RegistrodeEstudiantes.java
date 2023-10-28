package com.mycompany.registrodeestudiantes;

import javax.swing.JOptionPane;

public class RegistrodeEstudiantes {

    public static void main(String[] args) {
        Estudiante2023 estudiantes = new Estudiante2023();
        estudiantes.listarEstudiantes();

        String opcion = "";
        while (!"10".equals(opcion)) {
            opcion = JOptionPane.showInputDialog("""
                                                 
                                                  CLIENTE: 
                                                 1-NUEVO ESTUDIANTE 
                                                 2-BUSCAR ESTUDIANTE
                                                 3-ELIMINAR ESTUDIANTE 
                                                 4-MODIFICAR ESTUDIANTE
                                                 5-MODIFICAR APELLIDOS EN MIN\u00daSCULAS
                                                 6-VER TODOS LOS ESTUDIANTES
                                                 7-VER TODOS LOS ESTUDIANTES POR APELLIDOS
                                                 8-VER TODOS LOS ESTUDIANTES POR PENSI\u00d3N
                                                 9-TOTAL DE PENSIONES
                                                 10-SALIR""");
            switch (opcion) {
                case "1" -> {
                    int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código del estudiante:"));
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante:");
                    int ciclo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ciclo del estudiante:"));
                    double pension = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la pensión del estudiante:"));

                    Estudiante nuevoEstudiante = new Estudiante(codigo, nombre, ciclo, pension);
                    estudiantes.adicionar(nuevoEstudiante);
                }
                case "2" -> {
                    int codigoBuscar = Integer
                            .parseInt(JOptionPane.showInputDialog("Ingrese el código del estudiante a buscar:"));
                    Estudiante estudianteEncontrado = estudiantes.buscar(codigoBuscar);
                    if (estudianteEncontrado != null) {
                        JOptionPane.showMessageDialog(null,
                                "Estudiante encontrado:\n" + estudianteEncontrado.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Estudiante no encontrado.");
                    }
                }
                case "3" -> {
                    int codigoEliminar = Integer
                            .parseInt(JOptionPane.showInputDialog("Ingrese el código del estudiante a eliminar:"));
                    Estudiante estudianteEliminar = estudiantes.buscar(codigoEliminar);
                    if (estudianteEliminar != null) {
                        estudiantes.eliminar(estudianteEliminar);
                        JOptionPane.showMessageDialog(null,
                                "Estudiante eliminado:\n" + estudianteEliminar.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Estudiante no encontrado.");
                    }
                }
                case "4" -> {
                    int codigoModificar = Integer
                            .parseInt(JOptionPane.showInputDialog("Ingrese el código del estudiante a modificar:"));
                    Estudiante estudianteModificar = estudiantes.buscar(codigoModificar);
                    if (estudianteModificar != null) {
                        String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del estudiante:");
                        int nuevoCiclo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo ciclo del estudiante:"));
                        double nuevaPension = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nueva pensión del estudiante:"));

                        estudianteModificar.setNombre(nuevoNombre);
                        estudianteModificar.setCiclo(nuevoCiclo);
                        estudianteModificar.setPension(nuevaPension);

                        JOptionPane.showMessageDialog(null, "Estudiante modificado:\n" + estudianteModificar.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Estudiante no encontrado.");
                    }
                }
                case "5" -> {
                    estudiantes.modificarApellidosAMinusculas();
                    JOptionPane.showMessageDialog(null, "Apellidos modificados a minúsculas correctamente.");
                }
                case "6" -> estudiantes.mostrarDatos();
                case "7" -> {
                    estudiantes.ordenarPorApellidos();
                    estudiantes.listarEstudiantes();
                }
                case "8" -> {
                    estudiantes.ordenarPorPension();
                    estudiantes.listarEstudiantes();
                }
                case "9" -> {
                    double totalPensiones = estudiantes.calcularTotalPensiones();
                    JOptionPane.showMessageDialog(null, "Total de pensiones: " + totalPensiones);
                }
                case "10" -> {
                }
                default -> JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        }
    }
    
}
