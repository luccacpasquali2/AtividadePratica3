import java.util.Scanner;

public class Console {

    private static Scanner scan = new Scanner(System.in);

    public static int lerInt() {
        int valor = scan.nextInt();
        scan.nextLine(); 
        return valor;
    }

    public static float lerFloat() {
        float valor = scan.nextFloat();
        scan.nextLine();
        return valor;
    }

    public static String lerString() {
        return scan.nextLine();
    }
}