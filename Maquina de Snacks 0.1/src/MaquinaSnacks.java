import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaquinaSnacks {
    public static void main(String[] args) {
        maquinaSnacks();
    }

    private static void maquinaSnacks() {
        boolean salir = false;
        Scanner consola = new Scanner(System.in);
        List<Snack> productos = new ArrayList<>();
        Snacks.mostrarSnacks();
        while (!salir){
            try {
                int opcion = mostrarMenu(consola);
                salir = ejecutarOpcion(opcion, consola , productos);
            }catch (Exception e){
                System.out.println("Ocurrio un error"+e.getMessage());
            }finally {
                System.out.println();//imprimendo salto de linea
            }
        }
    }

    private static boolean ejecutarOpcion(int opcion, Scanner consola, List<Snack> productos) {
        boolean salir = false;
        switch (opcion){
            case 1 -> comprarSnack(consola,productos);
            case 2 -> mostrarTicket(productos);
            case 3 -> agreagarSnack(consola);
            case 4 -> {
                System.out.println("Gracias por usar nuestro programa");
                salir = true;
            }
            default -> System.out.println("Opcion no valida" + opcion);
        }
        return salir;
    }

    private static void agreagarSnack(Scanner consola) {
        System.out.print("Nombre del snack: ");
        String nombre = consola.nextLine();
        System.out.print("Precio del snack: ");
        double precio = Double.parseDouble(consola.nextLine());
        Snacks.agregarSnack(new Snack(nombre,precio));
        System.out.println("Tu snack ha sido agregado");
        System.out.println("Snack agregado exitosamente");
        Snacks.mostrarSnacks();
    }

    private static void mostrarTicket(List<Snack> productos) {
        String ticket = "***********Ticket***********";
        double total = 0.0;
        for (Snack producto : productos) {
            ticket += "\n\t" + producto.getNombre() + " $" + producto.getPrecio();
            total += producto.getPrecio();
        }
        ticket += "\n\tTotal: $" + total;
        System.out.println(ticket);
    }

    private static void comprarSnack(Scanner consola, List<Snack> productos) {
        System.out.print("Que esnack desea comprar (id): ");
        int idSnack = Integer.parseInt(consola.nextLine());
        //Validar que el snack esista en la lista de snacks
        boolean snackEncontrado = false;
        for (Snack snack : Snacks.getSnaks()) {
            if (idSnack == snack.getIdSnack()){
                //Agreagar el snack a la lista de productos
                productos.add(snack);
                System.out.println("Snack comprado exitosamente"+snack);
                snackEncontrado = true;
                break;
            }
        }
        if (!snackEncontrado){
            System.out.println("Snack no encontrado: " + idSnack);
        }
    }

    private static int mostrarMenu(Scanner consola) {
        System.out.print("""
                Menu:
                    1. Comprar Snack
                    2. Mostrar Ticket
                    3. Agregar nueco Snack
                    4. salir
                Eliga una opcion:
                """);
        return Integer.parseInt(consola.nextLine());
    }
}
