import java.io.*;

public class P1Parlmpar {
    ;

    public static void main(String[] args) {
        try (
                BufferedInputStream is = new BufferedInputStream(new FileInputStream("entrada.txt"));
                OutputStream os = new FileOutputStream("salida.txt")
        ) {

            int n = 0;
            while (true) {
                int dato = is.read();
                System.out.println(dato);
                if (dato == -1) break;
                if (dato != 32){
                    n = n + Character.charCount(dato);
                }


            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}