package actividades.dos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainDos {
    public static void main(String[] args) {
        leerFicherito("src/actividades/dos/ficheros/LoremIpsum.txt");
    }

    public static void leerFicherito(String fileRoute) {
        try {
            BufferedReader bufferReader = new BufferedReader(new FileReader(fileRoute));
            int caracteres = bufferReader.read();
            while (caracteres != -1) {
                System.out.print(Character.toString(caracteres) + "_" + caracteres);
                caracteres = bufferReader.read();
                if (caracteres != -1) {
                    System.out.print(", ");
                } else {
                    System.out.println(".");
                }
            }
            bufferReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR! La ruta es incorrecta.");
        } catch (IOException e) {
            System.out.println("ERROR! Hay un problema de I/O.");
        }
    }
}
