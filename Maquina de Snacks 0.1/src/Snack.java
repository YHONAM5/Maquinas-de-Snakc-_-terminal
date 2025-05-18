import java.io.Serializable;
import java.util.Objects;

public class Snack implements Serializable {
    private static int contadorsnacks;

    private final int idSnack;
    private String nombre;
    private double precio;

    //Constructores
    public Snack(){
        this.idSnack = ++Snack.contadorsnacks;
    }
    public Snack(String nombre, double precio){
        this();
        this.nombre = nombre;
        this.precio = precio;
    }

    public static int getContadorsnacks() {
        return contadorsnacks;
    }


    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdSnack() {
        return idSnack;
    }

    @Override
    public String toString() {
        return "Snack{" +
                "ID Snack=" + idSnack +
                ", Nombre='" + nombre + '\'' +
                ", Precio=" + precio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Snack snack = (Snack) o;
        return idSnack == snack.idSnack && Double.compare(precio, snack.precio) == 0 && Objects.equals(nombre, snack.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSnack, nombre, precio);
    }
}
