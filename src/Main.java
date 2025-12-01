
public class Main {

    public static void main(String[] args) {

        try {
            // Crear un nuevo producto
            Producto manteca = new Producto("Manteca", 15, "Mantequita 100% natural", 15.99);

            System.out.println("=== Datos iniciales del producto ===");
            manteca.mostrarProducto();

            System.out.println("\n=== Aplicando descuento del 10% ===");
            manteca.aplicarDescuento(10);
            manteca.mostrarProducto();

            System.out.println("\n=== Agregando 5 unidades al stock ===");
            manteca.agregarStock(5);
            manteca.mostrarProducto();

            System.out.println("\n=== Vendiendo 8 unidades ===");
            manteca.venderProducto(8);
            manteca.mostrarProducto();

            System.out.println("\n=== Calculando el precio total por 3 unidades ===");
            Double totalCompra = manteca.comprarProducto(3);
            System.out.println("El total a pagar por 3 unidades es: $" + totalCompra);

            System.out.println("\n=== Actualizando la descripción del producto ===");
            manteca.actualizarDescripcion("Manteca premium sin sal, ideal para repostería");
            manteca.mostrarProducto();

            System.out.println("\n=== Fin del programa ===");

        } catch (IllegalArgumentException e) {
            System.out.println("Error en los datos proporcionados: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("Error de operación: " + e.getMessage());
        }
    }
}
