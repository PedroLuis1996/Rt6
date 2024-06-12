package ejercicio3;

import java.io.*;
import java.util.Scanner;
import java.util.TreeMap;

public class PeTransporte {
    public static void main(String[] args)  {


        TreeMap<String, Camion> lista = new TreeMap<>();

        File archivo = new File("flota.dat");


        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));
             ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo)))
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("MENU PRINCIPAL");
            while (true){
                menu();
                int opcion = scanner.nextInt();
                switch (opcion){
                    case 1:
                        while (true){
                            System.out.println("Introduzca la matricula (FIN = salir)");
                            String matricula = scanner.next();
                            if (matricula.equalsIgnoreCase("fin")){
                                break;
                            }
                            System.out.println("Nombre de la empresa");
                            String nombre = scanner.next();
                            System.out.println("Capacidad:");
                            int capacidad = scanner.nextInt();
                            Camion c = new Camion(nombre, capacidad);
                            lista.put(matricula, c);

                        }


                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;

                }
            }



        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    static void menu(){
        System.out.println("1. Gestionar matricula");
        System.out.println("2. Listar Matricula");
        System.out.println("3. Eliminar Todas los camiones");
        System.out.println("4. salir");

    }



}
