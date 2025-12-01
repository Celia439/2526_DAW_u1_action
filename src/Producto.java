
/**
 * Representa un producto dentro de un inventario, incluyendo sus datos básicos
 * como nombre, unidades disponibles, descripción y precio. Permite realizar
 * operaciones comunes como aplicar descuentos, calcular el costo total de una compra
 * y gestionar el stock.
 */
public class Producto {

    public String nombre;
    public Integer unidades;
    public String descripcion;
    public Double precio;

    /**
     * Crea un nuevo producto con los datos proporcionados.
     *
     * @param nombre nombre del producto
     * @param unidades cantidad inicial disponible
     * @param descripcion breve descripción del producto
     * @param precio precio unitario del producto
     * @throws IllegalArgumentException si nombre es vacío, unidades o precio
     * son negativos
     */
    public Producto(String nombre, Integer unidades, String descripcion, Double precio) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío.");
        }
        if (unidades < 0) {
            throw new IllegalArgumentException("Las unidades no pueden ser negativas.");
        }
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        this.nombre = nombre;
        this.unidades = unidades;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    /**
     * Muestra la información completa del producto en consola.
     */
    public void mostrarProducto() {
        System.out.println("Producto: " + this.nombre);
        System.out.println("Descripción: " + this.descripcion);
        System.out.println("Precio: $" + this.precio);
        System.out.println("Unidades disponibles: " + this.unidades);
    }

    /**
     * Calcula el precio total al comprar una cantidad específica de unidades.
     *
     * @param unidades cantidad de unidades que se desea comprar
     * @return el valor total de la compra
     * @throws IllegalArgumentException si la cantidad de unidades es negativa o
     * cero
     */
    public Double comprarProducto(Integer unidades) {
        if (unidades <= 0) {
            throw new IllegalArgumentException("La cantidad a comprar debe ser mayor que cero.");
        }
        return this.precio * unidades;
    }

    /**
     * Aplica un descuento porcentual al precio actual del producto.
     *
     * @param descuento porcentaje de descuento a aplicar (0 a 100)
     * @throws IllegalArgumentException si el descuento es negativo o mayor a
     * 100
     */
    public void aplicarDescuento(Integer descuento) {
        if (descuento < 0 || descuento > 100) {
            throw new IllegalArgumentException("El descuento debe estar entre 0 y 100.");
        }
        this.precio = this.precio - (this.precio * descuento / 100);
    }

    /**
     * Aumenta el stock del producto sumando las unidades indicadas.
     *
     * @param unidades cantidad de unidades a agregar
     * @throws IllegalArgumentException si la cantidad es negativa o cero
     */
    public void agregarStock(Integer unidades) {
        if (unidades <= 0) {
            throw new IllegalArgumentException("La cantidad a agregar debe ser mayor que cero.");
        }
        this.unidades += unidades;
        System.out.println(unidades + " unidades agregadas. Nuevo stock: " + this.unidades);
    }

    /**
     * Resta unidades del stock al vender el producto.
     *
     * @param unidades cantidad de unidades a vender
     * @throws IllegalArgumentException si la cantidad es negativa o cero
     * @throws IllegalStateException si la cantidad a vender excede el stock
     * disponible
     */
    public void venderProducto(Integer unidades) {
        if (unidades <= 0) {
            throw new IllegalArgumentException("La cantidad a vender debe ser mayor que cero.");
        }
        if (unidades > this.unidades) {
            throw new IllegalStateException("Stock insuficiente. Solo hay " + this.unidades + " unidades disponibles.");
        }
        this.unidades -= unidades;
        System.out.println("Venta realizada. Quedan " + this.unidades + " unidades en stock.");
    }

    /**
     * Actualiza la descripción del producto.
     *
     * @param nuevaDescripcion nuevo texto descriptivo para el producto
     * @throws IllegalArgumentException si la nueva descripción es vacía o nula
     */
    public void actualizarDescripcion(String nuevaDescripcion) {
        if (nuevaDescripcion == null || nuevaDescripcion.isBlank()) {
            throw new IllegalArgumentException("La descripción no puede estar vacía.");
        }
        this.descripcion = nuevaDescripcion;
        System.out.println("Descripción actualizada: " + this.descripcion);
    }
}
