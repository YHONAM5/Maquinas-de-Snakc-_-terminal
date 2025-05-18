import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Venta {
    private final int idVenta;
    private static int contadorVenta;
    private final List<Snack> listaSnacksVenta;

    //Lista de Ventas Realizadas
    public static List<Venta> ventas = new ArrayList<>();

    public Venta(){
     this.idVenta = ++contadorVenta;
     listaSnacksVenta = new ArrayList<>();
    }

    private boolean tieneSnack(){
        boolean verficar = true;
        if (Snacks.listaSnacks.isEmpty()) {
            System.out.println("La tienda no tiene Snacks");
            verficar = false;
        }
        return verficar;
    }
    private int selecionSnackPorID(){
        Scanner consola = new Scanner(System.in);
        System.out.print("Escoje tus Snacks por ID (0 para terminar): ");
        int id = Integer.parseInt(consola.nextLine());
        for (Snack busc: Snacks.listaSnacks){
            if (busc.getIdSnack() == id){
                this.listaSnacksVenta.add(busc);
                break;
            }
        }
        return id;
    }
    public void realizarVenta(){
        if (tieneSnack()){
            Snacks.verSnacks();
        }
        boolean para = true;
        while (para){
            int id = selecionSnackPorID();
            if (id == 0)
                para = false;
        }
        System.out.println("Venta Realizad con EXITO: $"+totalVenta());
    }
    public double totalVenta(){
        double total = 0.0;
        for (Snack valor : this.listaSnacksVenta){
            total += valor.getPrecio();
        }
        return total;
    }

    public static void  mostrarVentas(){
        for(Venta venta: Venta.ventas){
            System.out.println("===================================");
            System.out.println("        ID TICKET -> "+ venta.getIdVenta());
            System.out.println("===================================");
            System.out.println("SNACKS:");
            System.out.println(venta.verTodoSnackDeVentaRealizada());
            System.out.println("\tTotal a pagar $: "+ venta.totalVenta());
        }
    }
    public String verTodoSnackDeVentaRealizada(){
        String snacks = "";
        for (Snack i : this.listaSnacksVenta){
            System.out.println(i);
        }
        return snacks;
    }


    public int getIdVenta() {
        return idVenta;
    }
}