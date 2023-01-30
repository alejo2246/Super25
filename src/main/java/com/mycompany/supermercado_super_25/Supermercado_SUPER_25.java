/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.supermercado_super_25; /// prueba push

/**
 *
 * @author USUARIO
 */
import java.util.Scanner;

public class Supermercado_SUPER_25 {

    public static void main(String[] args) {
        /// Creacion de Variables para uso general
        String MainMenuOption = "";
        int Acceso = 0;
        Productos producto[] = new Productos[20]; /// Creacion de array de objetos con 20(MAX) posiciones a modo de
                                                  /// limitacion en arrays dinamicos en Java
        int SumaProductos = 0;
        codigoDescuento cupones[] = new codigoDescuento[10];
        int sumaCupones = 0;
        /// Creacion de crdenciales
        String[] users = { "cajero_1", "cajero_2", "cajero_3" };
        String[] passwords = { "ipc_1", "ipc_2", "ipc_3" };
        /// Creacion del objeto Scanner para su uso en lectura por consola
        Scanner ScannerObject = new Scanner(System.in);
        /// Comunicacion con el usuario para ingreso de credenciales
        while (Acceso == 0) {
            System.out.print("\n\t\tSUPER-25 LOGIN\nUsuario: ");

            /// Lectura de consola
            String UserName = ScannerObject.nextLine();
            System.out.print("Contrasena: ");
            String UserPassword = ScannerObject.nextLine();

            /// Recorrido de los arreglos para identificar los usuarios y contraseñas segun
            /// los definidos previamente
            for (int i = 0; i < 3; i++) {
                if (users[i].equals(UserName) && passwords[i].equals(UserPassword)) {
                    System.out.println("Acceso Correcto...");
                    Acceso = 1;

                }
            }

            /// Validacion de errores
            if (Acceso != 1) {
                System.out.println("\nEl usuario o la contraseña no son validos, por favor intente de nuevo");
            }
        }
        while (!MainMenuOption.equals("5")) {
            /// Comunicacion con el usuario para el menu principal
            System.out.println(
                    "\nBienvenido al sistema Cashier de SUPER-25\n\n\t\tMenu Principal\nPor favor seleccione una de las siguientes opciones:");
            System.out.println(
                    "1) Agregar un producto\n2) Agregar un Cupon de descuento\n3) Realizar una venta\n4) Realizar reporte\n5) Finalizar Sesion");
            /// Conversion a entero de Opcion elegida e identificacion del caso al que
            /// aplica
            MainMenuOption = ScannerObject.nextLine();
            switch (MainMenuOption) {
                case "1": {
                    System.out.println("\t\tBienvenido al registro de productos");
                    int masProductos = 0;
                    while (masProductos != 2) {
                        /// Lectura de consola para menu de registro
                        System.out.println(
                                "\nPor favor elija una opcion:\n1) Anadir un producto\n2) Volver al menu principal");
                        int MenuProductoOpcion = Integer.parseInt(ScannerObject.nextLine());
                        if (MenuProductoOpcion == 1) {
                            int productoExistente = 0;
                            /// Entrada de Parametros y creacion de objetos con dichos parametros como
                            /// argumentos
                            System.out.println("Nombre del producto: ");
                            String nombreProducto = ScannerObject.nextLine();
                            System.out.println("Precio del producto: ");
                            float precioProducto = Float.parseFloat(ScannerObject.nextLine());
                            /// Prevencion de pre-existencia del producto recorriendo los productos ya
                            /// creados previamente
                            for (int i = 0; i < SumaProductos; i++) {
                                if (producto[i].nombreProducto.equals(nombreProducto))
                                    productoExistente = 1;
                            }
                            /// Indexado del nuevo producto a la lista de productos
                            if (productoExistente != 1) {
                                producto[SumaProductos] = new Productos(nombreProducto, precioProducto);
                                System.out.println("¡Producto guardado exitosamente!");
                                SumaProductos++;
                            } else {
                                System.out.println("El producto ya existe, intentelo de nuevo");
                            }

                        } else {
                            System.out.println("Volviendo al menu...");
                            masProductos = 2;
                        }
                    }
                    break;
                }
                case "2": {
                    int MenuCuponesOpcion = 0;
                    System.out.println("\t\tBienvenido al registro de cupones");
                    while (MenuCuponesOpcion != 2) {
                        int codigoExiste = 0;
                        System.out.println(
                                "\nPor favor, seleccione una opcion:\n1) Agregar un cupon\n2) Volver al menu principal");
                        MenuCuponesOpcion = Integer.parseInt(ScannerObject.nextLine());
                        if (MenuCuponesOpcion == 1) {
                            System.out.println("Codigo del cupon: ");
                            String nombreCupon = ScannerObject.nextLine();
                            System.out.println("Valor del cupon (0 - 100): ");
                            float descuentoCupon = Float.parseFloat(ScannerObject.nextLine());
                            for (int i = 0; i < sumaCupones; i++) {
                                if (cupones[i].nombreCodigo.equals(nombreCupon))
                                    codigoExiste = 1;
                            }
                            if (codigoExiste != 1) {
                                cupones[sumaCupones] = new codigoDescuento(nombreCupon, descuentoCupon);
                                sumaCupones++;
                                System.out.println("El Cupon ha sido registrado exitosamente");
                            } else {
                                System.out.println("El cupon ya existe, intentelo de nuevo");
                            }

                        }
                    }
                    break;
                }
                case "3": {
                    break;

                }
                case "4": {
                    break;
                }
                case "5": {
                    MainMenuOption = "5";
                    break;
                }
                default: {
                    System.out.println("Ingrese una opción valida");
                    break;
                }
            }
        }

    }
}
