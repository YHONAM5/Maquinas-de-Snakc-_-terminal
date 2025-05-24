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
        double precio = 0;
        boolean parar = false;
        while (!parar){
            System.out.print("Precio del Snack: ");
            if (!consola.hasNextDouble()){
                System.out.println("El precio debe ser de tipo Numerico..");
                consola.next();
            }
            else {
                precio = consola.nextDouble();
                parar = true;
            }
            consola.nextLine();
        }
        Snack snack = new Snack(nombre,precio);
        Snacks.listaSnacks.add(snack);
        System.out.println("Snack agregado con ¡exito!: "+nombre);
    }

    public static void verSnacks(){
        System.out.println("_________________Snacks Disponibles_______________");
        if (!listaSnacks.isEmpty()){
            for (Snack val: Snacks.listaSnacks){
                System.out.println(val);
            }
        }else {
            System.out.println("La Tienda esta vacia...");
        }

    }
}
