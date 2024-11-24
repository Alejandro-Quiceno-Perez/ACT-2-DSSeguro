package Entitys;

/**
 * Clase que representa un producto en el supermercado.
 * Cada producto tiene un nombre, un precio unitario y una cantidad.
 */
public class Product {
       private String name; // Nombre del producto
       private double price; // Precio unitario del producto
       private int quantity; // Cantidad del producto

       /**
        * Constructor de la clase Product.
        *
        * @param name     Nombre del producto.
        * @param price    Precio unitario del producto.
        * @param quantity Cantidad del producto.
        */
       public Product(String name, double price, int quantity) {
              this.name = name;
              this.price = price;
              this.quantity = quantity;
       }

       /**
        * Obtiene el nombre del producto.
        *
        * @return Nombre del producto.
        */
       public String getName() {
              return name;
       }

       /**
        * Obtiene el precio unitario del producto.
        *
        * @return Precio del producto.
        */
       public double getPrice() {
              return price;
       }

       /**
        * Obtiene la cantidad del producto.
        *
        * @return Cantidad del producto.
        */
       public int getQuantity() {
              return quantity;
       }

       /**
        * Calcula el costo total del producto (precio * cantidad).
        *
        * @return Costo total del producto.
        */
       public double getTotalCost() {
              return price * quantity;
       }
}
