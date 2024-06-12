package ejercicio2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class P2RegistrarReservas {

    public static void main(String[] args) {

       try (RandomAccessFile raf = new RandomAccessFile("reservas.dat", "r")) {
           System.out.println("Abriendo reservas");

        } catch (FileNotFoundException e) {
            System.out.println("Inicializando reservas");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

       try (RandomAccessFile raf2 = new RandomAccessFile("reservas.dat", "rw")) {

           for (int i = 0; i < 31; i++) {
               raf2.writeInt(0);
           }
           Scanner scanner = new Scanner(System.in);
           while (true){
               int dia;
               System.out.println("dia");
               dia = scanner.nextInt();
               if (dia == 0) break;
               if (dia >0 && dia <=31){
                   raf2.seek(0);
                   int dias = Integer.BYTES * (dia - 1);
                   raf2.seek(dias);
                   int reserva = raf2.readInt();
                   if (reserva != 0){
                       System.out.println("tiene " + reserva + " reservas");
                   }
                       reservar(reserva, scanner, raf2, dias);








               } else {
                   System.out.println("Dia incorrecto");
               }
           }



       } catch (FileNotFoundException e) {
           throw new RuntimeException(e);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }

    }
    static void reservar(int reserva, Scanner scanner, RandomAccessFile raf2, int dias) throws IOException {
        while (true){
            System.out.println("invitados que quiere añadir?");
            int invitados = scanner.nextInt();
            if (invitados > 0){
                raf2.seek(dias);
                invitados = invitados + reserva;
                raf2.writeInt(invitados);
                System.out.println("añadida reserva");
                break;
            } else {
                System.out.println("debe ser mayor que 0");
            }
        }
    }
}