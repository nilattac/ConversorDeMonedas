import API.Conexion;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);

        while (true) {                  //menu
            System.out.println("""
                    ***********************************************************
                    Sea bienvenido/a a el Conversor de Moneda

                    Elija una opción válida:
                    1) Dólar Estadounidense  >>>  Peso Argentino 
                    2) Peso Argentino        >>>  Dólar Estadounidense
                    3) Dólar Estadounidense  >>>  Real Brasilero
                    4) Real Brasilero        >>>  Dólar Estadounidense
                    5) Dólar Estadounidense  >>>  Peso Colombiano
                    6) Peso Colombiano       >>>  Dólar Estadounidense
                    7) Salir

                    ***********************************************************
                    """);

            String inputUsuario = lectura.nextLine();

            if (inputUsuario.equals("7")) {         //salida
                System.out.println("""
                        ***********************************************************
                        Gracias por usar el Conversor de Monedas.
                        ***********************************************************
                        """);
                break;
            }

            String monto;
            double resultado;
            Conexion conexion;

            switch (inputUsuario) {                 //opciones
                case "1":
                    monto = String.valueOf(ingresarMonto(lectura));                                 //loop de monto a convetir
                    conexion = new Conexion("USD", "ARS", monto);
                    resultado = conexion.convertir();                                                                       //conversor
                    System.out.println("***********************************************************");
                    System.out.println(monto + " Dólares Estadounidenses son: "+ resultado + " Pesos Argentinos." );        //resultados
                    break;
                case "2":
                    monto = String.valueOf(ingresarMonto(lectura));                                 //loop de monto a convetir
                    conexion = new Conexion("ARS", "USD", monto);
                    resultado = conexion.convertir();                                                                       //conversor
                    System.out.println("***********************************************************");
                    System.out.println(monto + " Pesos Argentinos son: "+ resultado + " Dólares Estadounidenses." );        //resultados
                    break;
                case "3":
                    monto = String.valueOf(ingresarMonto(lectura));                                 //loop de monto a convetir
                    conexion = new Conexion("USD", "BRL", monto);
                    resultado = conexion.convertir();                                                                       //conversor
                    System.out.println("***********************************************************");
                    System.out.println(monto + " Dólares Estadounidenses son: "+ resultado + " Reales Brasileros." );        //resultados
                    break;
                case "4":
                    monto = String.valueOf(ingresarMonto(lectura));                                 //loop de monto a convetir
                    conexion = new Conexion("BRL", "USD", monto);
                    resultado = conexion.convertir();                                                                       //conversor
                    System.out.println("***********************************************************");
                    System.out.println(monto + " Reales Brasileros son: "+ resultado + " Dólares Estadounidenses." );        //resultados
                    break;
                case "5":
                    monto = String.valueOf(ingresarMonto(lectura));                                 //loop de monto a convetir
                    conexion = new Conexion("USD", "COP", monto);
                    resultado = conexion.convertir();                                                                       //conversor
                    System.out.println("***********************************************************");
                    System.out.println(monto + " Dólares Estadounidenses son: "+ resultado + " Pesos Colombianos." );        //resultados
                    break;
                case "6":
                    monto = String.valueOf(ingresarMonto(lectura));                                 //loop de monto a convetir
                    conexion = new Conexion("COP", "USD", monto);
                    resultado = conexion.convertir();                                                                       //conversor
                    System.out.println("***********************************************************");
                    System.out.println(monto + " Pesos Colombianos son: "+ resultado + " Dólares Estadounidenses." );        //resultados
                    break;
                default:
                    System.out.println("***********************************************************");
                    System.out.println("Opción inválida");
            }
        }
    }

    public static double ingresarMonto(Scanner lectura) {               //loop de monto a convetir
        double montoUsuario;
        while (true) {
            System.out.print("Ingrese el monto a convertir: ");

            if (lectura.hasNextDouble()) {                  //verificacion que sea numero
                montoUsuario = lectura.nextDouble();
                lectura.nextLine();
                return montoUsuario;
            } else {
                System.out.println("Debe ingresar un número válido.");
                lectura.next();
            }
        }
    }
}

