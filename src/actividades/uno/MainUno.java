package actividades.uno;

import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class MainUno {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce una palabra de al menos 30 caracteres: ");
        String palabrita = scanner.nextLine();

        while (palabrita.length() < 30) {
            System.out.println("Faltan: " + (30 - palabrita.length())
                    + " caracteres, introduce una palabra de 30 caracteres");
            palabrita = scanner.nextLine();
        }

        palabrita = palabrita.replace(" ", "_").toUpperCase();
        escribirFicherito("src/actividades/uno/ficheros/ficherito.txt", palabrita);
        scanner.close();
    }

    public static void escribirFicherito(String rutaFichero, String texto) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(rutaFichero))) {
            bufferedWriter.write(texto);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR! No se ha encontrado el fichero...");
        } catch (IOException e) {
            System.out.println("ERROR! Hay un problema de I/O");
        }
    }
}
