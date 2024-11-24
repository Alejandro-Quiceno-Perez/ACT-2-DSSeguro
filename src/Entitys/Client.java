package Entitys;

import java.util.List;

/**
 * Clase que representa un cliente en el supermercado.
 * Cada cliente tiene un nombre y una lista de productos que desea comprar.
 */
public class Client {
       private String name; // Nombre del cliente
       private List<Product> products; // Lista de productos del cliente

       /**
        * Constructor de la clase Client.
        *
        * @param name     Nombre del cliente.
        * @param products Lista de productos que el cliente desea comprar.
        */
       public Client(String name, List<Product> products) {
              this.name = name;
              this.products = products;
       }

       /**
        * Obtiene el nombre del cliente.
        *
        * @return Nombre del cliente.
        */
       public String getName() {
              return name;
       }

       /**
        * Obtiene la lista de productos del cliente.
        *
        * @return Lista de productos.
        */
       public List<Product> getProducts() {
              return products;
       }
}
