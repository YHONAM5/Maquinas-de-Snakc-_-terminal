import java.util.Scanner;

public class Start {
    public void menu(){
        Scanner consola = new Scanner(System.in);
        boolean maquinaActiva = true;
        while (maquinaActiva){
            try {
                System.out.print("""
                ============TIENDA DE SNACKS=============
                    MENU PRINCIPAL
                    1. Ver snacks de la tienda
                    2. Agregar snacks ala tienda
                    3. Realizar nueva venta
                    4. Ver ventas realizadas
                    5. Salir
                Eliga una opcion: \s
               \s""");
                int opcion = Integer.parseInt(consola.nextLine());
                switch (opcion){
                    case 1 -> Snacks.verSnacks();
                    case 2 -> Snacks.agregarSnack();
                    case 3 -> {
                        Venta venta = new Venta();
                        Venta.ventas.add(venta);
                        venta.realizarVenta();
                    }
                    case 4 -> Venta.mostrarVentas();
                    case 5 -> maquinaActiva = false;
                    default -> System.out.println("Opcion no valaida...");
                }
            } catch (Exception e) {
                System.out.println("Ocurio un problema: "+e.getMessage()+"===>"+e.getLocalizedMessage());
            }
        }
    }

    public static void main(String[] args) {
        Start inicio = new Start();

        Snack s1 = new Snack("papas picantes",3.99);
        Snack s2 = new Snack("papas hilos",2.00);
        Snack s3 = new Snack("taquiz",5.6);
        Snack s4 = new Snack("doritos", 10.5);
        Snacks.listaSnacks.add(s3);
        Snacks.listaSnacks.add(s4);
        Snacks.listaSnacks.add(s1);
        Snacks.listaSnacks.add(s2);
        inicio.menu();
    }
}
