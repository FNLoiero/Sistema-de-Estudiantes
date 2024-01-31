package com.gm;

import java.util.Scanner;

import com.gm.datos.EstudianteDAO;
import com.gm.dominio.Estudiante;

public class Main {
    public static void main(String[] args) {
        var estudiantedao = new EstudianteDAO();
        Scanner consola = new Scanner(System.in);
        opciones(consola, estudiantedao);
    }

    public static void opciones(Scanner consola, EstudianteDAO estudiantedao) {
        boolean continuar = true;
        while (continuar) {
            menu();
            int numeroEntero = Integer.parseInt(consola.nextLine());
            switch (numeroEntero) {
                case 1 -> {
                    var estudiantes = estudiantedao.listarEstudiantes();
                    System.out.println("Listado de Estudiantes");
                    estudiantes.forEach(System.out::println);
                }
                case 2 -> {
                    System.out.print("ID del estudiante a modificar: ");
                    int id_estudiante = Integer.parseInt(consola.nextLine());
                    Estudiante estudianteMod;
                    estudianteMod = datos(consola);
                    estudianteMod.setIdEstudiante(id_estudiante);
                    boolean resultado = estudiantedao.modificarEstudiante(estudianteMod);
                    if (resultado)
                        System.out.println("Se modifico el alumno con exito");
                    else
                        System.out.println("Ocurrio un problema, no se pudo modificar el alumno");
                }
                case 3 -> {
                    Estudiante estudianteMod;
                    estudianteMod = datos(consola);
                    boolean resultado = estudiantedao.agregarEstudiante(estudianteMod);
                    if (resultado)
                        System.out.println("Se agrego el alumno con exito");
                    else
                        System.out.println("Ocurrio un problema, no se pudo agregar el alumno");
                }
                case 4 -> {
                    System.out.print("ID del estudiante a eliminar: ");
                    int id_estudiante = Integer.parseInt(consola.nextLine());
                    var estudianteMod = new Estudiante(id_estudiante);
                    boolean resultado = estudiantedao.eliminarEstudiante(estudianteMod);
                    if (resultado)
                        System.out.println("Se elimino el alumno con exito");
                    else
                        System.out.println("Ocurrio un problema, no se pudo eliminar el alumno");
                }
                case 5 -> {
                    System.out.print("ID del estudiante a buscar: ");
                    int id_estudiante = Integer.parseInt(consola.nextLine());
                    var estudianteMod = new Estudiante(id_estudiante);
                    var encontrado = estudiantedao.buscarEstudiantePorId(estudianteMod);
                    if (encontrado)
                        System.out.println("estudiante encontrado");
                    else
                        System.out.println("estudiante no encontrado");
                }
                case 6 -> {
                    System.out.println("hasta pronto");
                    continuar = false;
                }
            }
        }
    }

    public static Estudiante datos(Scanner consola) {
        System.out.print("Nombre: ");
        var nombre = consola.nextLine();
        System.out.print("Apellido: ");
        var apellido = consola.nextLine();
        System.out.print("Telefono: ");
        var telefono = consola.nextLine();
        System.out.print("Email: ");
        var email = consola.nextLine();
        var estudiante = new Estudiante(nombre, apellido, telefono, email);
        return estudiante;
    }

    public static void menu() {
        System.out.println("""
                ***Sistema de Estudiante***
                1 - listar
                2 - modificar
                3 - agregar
                4 - eliminar
                5 - buscar
                6 - salir
                """);
        System.out.print("ingrese una opcion");
    }

}
