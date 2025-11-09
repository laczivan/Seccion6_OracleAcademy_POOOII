/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package mx.edu.itses.electricidad.iz.producttester;

/**
 *
 * @author zunig
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductTester {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxSize = -1;
        boolean inputValid = false;

        // Bucle para pedir cuántos productos va a meter
        do {
            try {
                System.out.println("Ingrese la cantidda de prodictos a llevar");
                System.out.print("si no quieres añadir nada escribe: 0 ");
                
                maxSize = scanner.nextInt();
                scanner.nextLine(); 

                if (maxSize >= 0) {
                    inputValid = true;
                } else {
                    System.out.println("error, numeros negativos no validos");
                }

            } catch (InputMismatchException e) {
                System.out.println("solo se permite ingresar numeros enteros");
                scanner.nextLine(); 
            } catch (Exception e) {
                System.out.println("Algo inesperado pasó. Detalle: " + e.toString());
                scanner.nextLine();
            }
        } while (!inputValid);

        // Lógica principal: crear array o terminar
        if (maxSize == 0) {
            System.out.println("De acuerdo no añadiremos productos, que tengas un buen díaaa :)");
        } else {
            Product[] products = new Product[maxSize];
            System.out.printf("\n Registremos los nuevos productos :) \n", maxSize);

            // Bucle para meter los datos de cada producto
            for (int i = 0; i < maxSize; i++) {
                System.out.printf("\n Atencion Producto numero %d \n", i + 1);

                // 1. Nombre (String)
                System.out.print("¿Cómo se llama este producto?: ");
                String name = scanner.nextLine();
                
                // 2 & 3. Cantidad (int) y Precio (double) con validación
                int quantity = -1;
                double price = -1.0;
                
                // Bucle interno para asegurar que Cantidad y Precio sean correctos
                do {
                    inputValid = true;
                    try {
                        System.out.print("¿Cuantas unidades hay? : ");
                        quantity = scanner.nextInt();
                        
                        System.out.print("¿Cuanto cuesta cada uno?: ");
                        price = scanner.nextDouble();
                        
                        scanner.nextLine(); 

                        if (quantity < 0 || price < 0) {
                            System.out.println("La cantidad y el precio tienen que ser positivos.");
                            inputValid = false;
                        }

                    } catch (InputMismatchException e) {
                        System.out.println(" Aquí debes poner números. Escríbelos sin letras ni símbolos.");
                        scanner.nextLine(); 
                        inputValid = false;
                    } catch (Exception e) {
                        System.out.println("Un error inesperado al leer la cantidad/precio. Detalle: " + e.toString());
                        scanner.nextLine();
                        inputValid = false;
                    }
                } while (!inputValid);

                // Crear y guardar el objeto Product
                products[i] = new Product(name, quantity, price, i + 1);
            }

            // Mostrar el resumen
            System.out.println("\n Lista final de productos: ");
            for (Product product : products) {
                System.out.println(product);
            }
        }

        scanner.close(); 
    }
}