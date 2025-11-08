/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package mx.edu.itses.electricidad.iz.javafundamental_seccion6_poo2;

import java.util.Scanner;

/**
 *
 * @author zunig
 */
public class JavaFundamental_seccion6_Poo2 {

    public static void main(String[] args) {
        System.out.println("1. Declare una calificación de nombre de array"
                + " de una dimensión del tipo int que pueda contener 9 valores. ");
        int[] calificacion = new int[9];
        System.out.println("2. Declare un precio con nombre de array de 2 dimensiones "
                + "de tipo float que tenga 10 filas y 3 columnas. ");
        float[][] precio = new float[10][3];
        System.out.println("3. Declare e inicialice un array de 2 dimensiones denominado "
                + "arreglo de un tipo largo que tenga 4 filas y 3 columnas para que \n" +
"todos los valores estén configurados en 5. ");
        int[][] arreglo = new int[4][3];
        for (int fila = 0; fila < 4; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                arreglo[fila][columna]=5;
            }
            
        }
        System.out.println("4.");
        byte[]valores= new byte[10];
        for (int i = 0; i < valores.length; i++) {
            valores[i]=1;
            
        }
        System.out.println("5: 76546");
         

        System.out.println("6: 333,765");
        System.out.println("7.");
        Scanner sc = new Scanner(System.in);
        int[] resultadoprueba =new int[5];
        int sumaTotal =0;
        for (int i = 0; i < resultadoprueba.length; i++) {
            System.out.println("Ingrese el resultado del examen: " + (i+1));
            resultadoprueba[i]= sc.nextInt();
            
            double promedio = (double)sumaTotal/resultadoprueba.length;
            for (int J = 0; J < resultadoprueba.length; J++) {
                System.out.println(resultadoprueba[i] + (i < resultadoprueba.length - 1 ? ", " : ""));
                
            }
            System.out.println(sumaTotal);
            System.out.println(promedio);
        }
    }
}
