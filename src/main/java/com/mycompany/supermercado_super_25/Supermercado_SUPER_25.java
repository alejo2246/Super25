/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.supermercado_super_25;

import java.util.Calendar;
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
        String UserName = "";
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
            UserName = ScannerObject.nextLine();
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
                    /// Comunicacion por consola
                    while (MenuCuponesOpcion != 2) {
                        int codigoExiste = 0;
                        System.out.println(
                                "\nPor favor, seleccione una opcion:\n1) Agregar un cupon\n2) Volver al menu principal");
                        /// Lectura de consola y conversion de String a entero
                        MenuCuponesOpcion = Integer.parseInt(ScannerObject.nextLine());

                        if (MenuCuponesOpcion == 1) {
                            System.out.print("Codigo del cupon: ");
                            String nombreCupon = ScannerObject.nextLine();
                            System.out.print("Valor del cupon (0 - 100): ");
                            float descuentoCupon = Float.parseFloat(ScannerObject.nextLine());
                            /// Prevencion de pre-existencia del cupon
                            for (int i = 0; i < sumaCupones; i++) {
                                if (cupones[i].nombreCodigo.equals(nombreCupon))
                                    codigoExiste = 1;
                            }
                            /// Validacion de errores
                            if (codigoExiste == 1) {
                                System.out.println("El cupon ya existe, intentelo de nuevo");
                            } else if (nombreCupon.length() != 4) {
                                System.out.println("El cupon debe tener exactamente 4 digitos");
                            } else if (descuentoCupon < 0 || descuentoCupon > 100) {
                                System.out.println(
                                        "El cupon posee un descuento invalido, este debe ser un valor entre 0 y 100");
                            } else {
                                /// Agregar el cupon a la lista de descuentos existentes
                                cupones[sumaCupones] = new codigoDescuento(nombreCupon, descuentoCupon);
                                sumaCupones++;/// sumador para garantizar que siempre se guarden en la ultima posicion
                                              /// de la lista
                                System.out.println("El Cupon ha sido registrado exitosamente");
                            }
                        }
                    }
                    break;
                }
                case "3": {
                    System.out.println(
                            "\t\tBienvenido al menu de venta");

                    /// Lectura y comunicacion por consola
                    System.out.println("Por favor, registre los siguientes datos del cliente\nNombre: ");
                    String nombreCliente = ScannerObject.nextLine();
                    System.out.println("NIT (opcional): ");
                    String nitCliente = ScannerObject.nextLine();

                    /// El NIT se valida como diferente de vacio, en caso de que se provea. De lo
                    /// contrario se clasifica al cliente como C/F
                    if (nitCliente.equals("")) {
                        System.out.println("Cliente registrado con documento C/F");
                        nitCliente = "C/F";
                    }
                    System.out.println("Ha registrado a " + nombreCliente + " con documento " + nitCliente);


                    /// Seleccion de productos para vender hasta que se ingrese `Terminar`
                    int sumaVendidos =0;
                    int completado = 0;
                    float total = 0;
                    int[] vendidos = new int[20];
                    while (completado != 1) {
                        System.out.println(
                                "Seleccione que productos desea con su indice respectivo, al finalizar indique `Terminar`\nProductos Registrados:");

                        /// Visualizacion de productos registrados
                        for (int i = 0; i < SumaProductos; i++) {
                            System.out.println(
                                    "" + (i + 1) + ") " + producto[i].nombreProducto + " Precio: $" + producto[i].precio);/// Se evita mostrar un indice 0 mediante i+1
                        }                        
                        /// Comunicacion por consola
                        String productoSeleccionado = ScannerObject.nextLine();

                        /// Logica negada para evaluar si es distinto a `terminar` incluyendo el caso de
                        /// mayusculas
                        if (!(productoSeleccionado.equals("terminar")) && !(productoSeleccionado.equals("Terminar"))) {
                            System.out.println("Cantidad: ");
                            int cantidadProducto = Integer.parseInt(ScannerObject.nextLine());
                            int prodSeleccionado = Integer.parseInt(productoSeleccionado);

                            /// Eliminando el impacto de i+1 se actualiza la cantidad vendida del producto y
                            /// la cantidad vendida para la sesion (cliente) actual
                            producto[prodSeleccionado
                                    - 1].cantidadSesion = cantidadProducto;                            
                            producto[prodSeleccionado
                                    - 1].cantidadVendida = producto[prodSeleccionado - 1].cantidadVendida
                                            + cantidadProducto;

                            /// Se calcula el subtotal a medida que se itera
                            total += producto[prodSeleccionado - 1].precio * cantidadProducto;

                            /// Se registran los indices de los productos vendidos en caso que el usuario
                            /// decida registrar nuevamente un mismo producto
                            /// De esta forma se podra visualizar apropiadamente en la factura
                            vendidos[sumaVendidos] = prodSeleccionado-1;
                            sumaVendidos++;
                        } else
                            completado = 1;
                    }

                    /// Comunicacion por consola para validar el posible descuento
                    System.out.println("Codigo de descuento (opcional): ");
                    String CodDescuento = ScannerObject.nextLine();
                    float descuentoAplicado = 0;

                    /// Si el descuento es diferente a un enter se entrara a buscar el nombre
                    /// ingresado del cupon mediante la iteracion de la lista que contiene los
                    /// cupones registrados
                    if (!CodDescuento.equals("")) {
                        for (int i = 0; i < sumaCupones; i++) {
                            if (CodDescuento.equals(cupones[i].nombreCodigo)) {
                                /// Se prepara la multiplicacion del descuento al total
                                descuentoAplicado = cupones[i].descuento;
                            }
                        }
                    }

                    /// Facturacion
                    /// Se utiliza la libreria Calendar para obtener la fecha
                    Calendar calendar = Calendar.getInstance();

                    /// Se hace un bosquejo de la factura con respuestas de consola dinamicas
                    System.out.println("\t\t\tSUPER-25");
                    System.out.println("\t\t" + calendar.getTime());
                    System.out.println(
                            "---------------------------------------------------------------------------------------");
                    System.out.println("\tCajero:\t\t" + UserName);
                    System.out.println("\tCliente:\t\t" + nombreCliente);
                    System.out.println("\tNIT:\t\t" + nitCliente);
                    System.out.println(
                            "---------------------------------------------------------------------------------------");
                    System.out.println("\tProducto  _ _ _ Precio/u _ _ _ Cantidad _ _ _ Total");
                    for (int i = 0; i < sumaVendidos; i++) {
                        System.out.println("\t" + producto[vendidos[i]].nombreProducto + " _ _ _ "
                                + producto[vendidos[i]].precio + " " + producto[vendidos[i]].cantidadSesion + " "
                                + producto[vendidos[i]].cantidadSesion * producto[vendidos[i]].precio);
                    }
                    System.out.println(
                            "---------------------------------------------------------------------------------------");
                    System.out.println("\tSubtotal: \t\t" + total);
                    System.out.println("\tDescuento: \t\t" + descuentoAplicado * 100 + "%");
                    System.out.println(
                            "---------------------------------------------------------------------------------------");
                    System.out.println("\tTotal: \t\t" + total * (1-descuentoAplicado));

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
