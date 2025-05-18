import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Snacks {

    //Lista de snack que se estar añadienso
    public static List<Snack> listaSnacks = new ArrayList<>();

    public static void agregarSnack(){
        Scanner consola = new Scanner(System.in);
        System.out.print("Nombre del Snack: ");
        String nombre = consola.nextLine();
        System.out.print("Precion del Snack: ");
        double precio = Double.parseDouble(consola.nextLine());
        Snack snack = new Snack(nombre,precio);
        Snacks.listaSnacks.add(snack);
    }

    public static void verSnacks(){
        for (Snack val: Snacks.listaSnacks){
            System.out.println(val);
        }
    }
}
