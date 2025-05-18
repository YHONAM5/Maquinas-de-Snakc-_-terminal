import java.util.ArrayList;
import java.util.List;

public class Snacks {
    private static final List<Snack> snaks;

    //Bloque static inicializado
    static{
        snaks = new ArrayList<>();
        snaks.add(new Snack("Coca Cola", 2.5));
        snaks.add(new Snack("Pepsi", 3.5));
        snaks.add(new Snack("Fanta", 4.5));
    }

    public static  void agregarSnack(Snack o){
        snaks.add(o);
    }

    public static void mostrarSnacks(){
        String inventario = "";
        for (Snack snack : snaks) {
            inventario += snack.toString() + "\n";
        }
        System.out.println("============INVENTARIO===========");
        System.out.println(inventario);
    }

    public static List<Snack> getSnaks() {
        return snaks;
    }
}
