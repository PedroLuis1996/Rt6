package ejercicio2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class P2ListarReservas {

    public static void main(String[] args) {
        File fichero = new File("reservas.dat");

        try (RandomAccessFile raf = new RandomAccessFile(fichero, "r")) {

            raf.seek(0);
            int dia;
            int reservas;
            int contador = 0;
            for (int i = 0; i < 31; i++) {
                reservas = raf.readInt();
                if (reservas != 0){
                    contador++;
                    dia = i+1;
                    System.out.println("Dia " + dia + ": " + reservas);
                }
            }
            System.out.println("Hay " + contador + " aperturas este mes");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
