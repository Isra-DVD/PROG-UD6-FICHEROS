package actividades.cuatro;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import actividades.cuatro.mobiliario.Mesa;
import actividades.cuatro.utilidades.Utilidades;

public class MainCuatro {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner escaner = new Scanner(System.in);
        boolean seguirPreguntando = true;
        ArrayList<Mesa> coleccionMesas = new ArrayList<>();

        do {
            System.out.println("1.-Nueva mesa: \n2.-Mostrar todas las mesas almacenadas \n 3.-Salir del programa");
            int entradaUsuario = escaner.nextInt();
            escaner.nextLine();
            switch (entradaUsuario) {
                case 1:
                    System.out.println("Introduce el color que tendrá la mesa");
                    String colorMesa = escaner.nextLine();
                    System.out.println("Introduce el número de patas que tendrá la mesa");
                    int numeroPatas = escaner.nextInt();
                    escaner.nextLine();

                    Mesa nuevaMesa = new Mesa(colorMesa, numeroPatas);
                    coleccionMesas.add(nuevaMesa);
                    Utilidades.guardarMesas(coleccionMesas);
                    break;

                case 2:
                    Utilidades.mostrarMesas();
                    break;

                case 3:
                    System.out.println("Adiós <3");
                    seguirPreguntando = false;

                default:
                    System.out.println("Ha introducido un valor inválido");
                    break;
            }
        } while (seguirPreguntando);
        escaner.close();
    }
}
