/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itses.electricidad.iz.javafundamental_seccion6_poo2;

import java.util.Scanner;

/**
 *
 * @author zunig
 */
public class Arreglos_suma_resta_multi {
    
    // Dimensiones de las matrices (constantes)
    private static final int FILAS = 2;
    private static final int COLUMNAS = 3;
    
    // Scanner para leer la entrada del usuario
    private static Scanner sc = new Scanner(System.in);

    // ------------------------------------------------------------------
    // --- MÉTODO PRINCIPAL (Lógica del Menú) ---
    // ------------------------------------------------------------------
    public static void main(String[] args) {
        
        int[][] A = null;
        int[][] B = null;
        char opcion;
        boolean continuar = true;

        System.out.println("--- Calculadora Simple de Matrices 2x3 ---");
        
        while (continuar) {
            
            mostrarMenu();
            System.out.print("Elige una opción (a-f): ");
            opcion = sc.next().toLowerCase().charAt(0);

            switch (opcion) {
                case 'a':
                    A = ingresarArreglo("A");
                    System.out.println("✅ Arreglo A listo.");
                    break;
                case 'b':
                    B = ingresarArreglo("B");
                    System.out.println("✅ Arreglo B listo.");
                    break;
                case 'c':
                    if (A != null && B != null) {
                        mostrarResultado(sumar(A, B), "A + B");
                    } else {
                        System.out.println("🛑 Ingresa A y B primero.");
                    }
                    break;
                case 'd':
                    if (A != null && B != null) {
                        mostrarResultado(restar(A, B), "A - B");
                    } else {
                        System.out.println("🛑 Ingresa A y B primero.");
                    }
                    break;
                case 'e':
                    // Advertencia simple de multiplicación no válida
                    System.out.println("🛑 Multiplicación A*B: Las dimensiones (2x3 * 2x3) no permiten esta operación.");
                    break;
                case 'f':
                    System.out.println("👋 Programa finalizado.");
                    continuar = false;
                    break;
                default:
                    System.out.println("⚠️ Opción inválida.");
            }
        }
        sc.close();
    }
    
    // ------------------------------------------------------------------
    // --- MÓDULOS (Métodos) SIMPLIFICADOS ---
    // ------------------------------------------------------------------

    // Módulo 1: Mostrar el menú
    public static void mostrarMenu() {
        System.out.println("\n--- MENÚ ---");
        System.out.println("a. Ingresar Arreglo A");
        System.out.println("b. Ingresar Arreglo B");
        System.out.println("c. Mostrar A + B (Suma)");
        System.out.println("d. Mostrar A - B (Resta)");
        System.out.println("e. Mostrar A * B (Multiplicación)");
        System.out.println("f. Salir");
        System.out.println("------------");
    }
    
    // Módulo 2: Ingresar los valores de una matriz
    public static int[][] ingresarArreglo(String nombre) {
        int[][] arreglo = new int[FILAS][COLUMNAS];
        System.out.println("\nIngresando Arreglo " + nombre + " (" + FILAS + "x" + COLUMNAS + "):");
        
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print("Valor [" + i + "][" + j + "]: ");
                // Asumimos que el usuario ingresa un entero (simplificación)
                arreglo[i][j] = sc.nextInt();
            }
        }
        return arreglo;
    }
    
    // Módulo 3: Sumar dos matrices
    public static int[][] sumar(int[][] a, int[][] b) {
        int[][] resultado = new int[FILAS][COLUMNAS];
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                resultado[i][j] = a[i][j] + b[i][j];
            }
        }
        return resultado;
    }

    // Módulo 4: Restar dos matrices
    public static int[][] restar(int[][] a, int[][] b) {
        int[][] resultado = new int[FILAS][COLUMNAS];
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                resultado[i][j] = a[i][j] - b[i][j];
            }
        }
        return resultado;
    }

    // Módulo 5: Mostrar el resultado de la operación
    public static void mostrarResultado(int[][] resultado, String operacion) {
        System.out.println("\n--- Resultado de " + operacion + " ---");
        for (int i = 0; i < resultado.length; i++) {
            System.out.print("[");
            for (int j = 0; j < resultado[i].length; j++) {
                System.out.printf("%4d", resultado[i][j]); // Formato simple
            }
            System.out.println(" ]");
        }
    }

    
}

