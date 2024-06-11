package actividades.tres;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MainTres {
    public static void main(String[] args) {

        ArrayList<String> lecturaFichero1 = new ArrayList<>();
        ArrayList<String> lecturaFichero2 = new ArrayList<>();

        leerFichero("src/actividades/uno/ficheros/fichero.txt", lecturaFichero1);
        leerFichero("src/actividades/dos/ficheros/nuevoFichero.txt", lecturaFichero2);
        escribirFichero("src/actividades/tres/ficheros/texto.txt", lecturaFichero1, lecturaFichero2);
    }

    public static void escribirFichero(String ruta, ArrayList<String> arrayList1, ArrayList<String> arrayList2) {
        try {
            FileWriter flujoSalida = new FileWriter(ruta);
            BufferedWriter flujoBufado = new BufferedWriter(flujoSalida);
            flujoBufado.write("- Contenido del Fichero Uno: ");
            for (String linea : arrayList1) {
                flujoBufado.write(linea);
                flujoBufado.write("\n");
            }
            flujoBufado.write("\n- Contenido del Fichero Dos: ");
            for (String linea : arrayList2) {
                flujoBufado.write(linea);
                flujoBufado.write("\n");
            }
            flujoBufado.close();

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Fichero no encontrado.");
        } catch (IOException e) {
            System.out.println("ERROR: Problema de I/O.");
        }
    }

    public static void leerFichero(String rutaFichero, ArrayList<String> arrayList) {
        try {
            FileReader flujoEntrada = new FileReader(rutaFichero);
            BufferedReader flujoBufado = new BufferedReader(flujoEntrada);
            while (true) {
                String lineaActual = flujoBufado.readLine();
                if (lineaActual == null) {
                    break;
                }
                arrayList.add(lineaActual);
            }
            flujoBufado.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: La ruta al fichero no es correcta.");
        } catch (IOException e) {
            System.out.println("ERROR: Problema de I/O.");
        }
    }
}
