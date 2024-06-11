package actividades.cuatro.utilidades;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import actividades.cuatro.mobiliario.Mesa;

public class Utilidades {

    private static final String DIRECCION_FICHERO = "src/actividades/cuatro/ficheros/fichero";

    public static void guardarMesas(ArrayList<Mesa> coleccionMesas) throws IOException {

        try (ObjectOutput flujoObjetos = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(DIRECCION_FICHERO)))) {

            flujoObjetos.writeObject(coleccionMesas);

        } catch (FileNotFoundException e) {
            System.out.println("Error: Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("I/O Exception");
        }
    }

    public static void mostrarMesas() {
        try (ObjectInputStream flujoObjetos = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(DIRECCION_FICHERO)))) {

            @SuppressWarnings("unchecked")
            ArrayList<Mesa> arrayMesas = (ArrayList<Mesa>) flujoObjetos.readObject();

            for (Object mesa : arrayMesas) {
                mesa = (Mesa) mesa;
                System.out.println(mesa.toString());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: Fichero no encontrado");
        } catch (EOFException e) {
            System.out.println("No hay mesas guardadas");
        } catch (IOException e) {
            System.out.println("I/O Exception:");
        } catch (ClassNotFoundException e) {
            System.out.println("Ha ocurrido un error.");
        }
    }
}