package aConcurrency;

import java.util.Arrays;
import Entitys.Client;
import Entitys.Product;

/**
 * Clase principal para simular el funcionamiento del supermercado.
 * Gestiona clientes, productos y el procesamiento de compras por parte de las cajeras.
 */
public class SuperMarket {
       public static void main(String[] args) {
              // Crear productos
              Product product1 = new Product("Pan", 1.500, 3);
              Product product2 = new Product("Leche", 3.500, 5);
              Product product3 = new Product("Manzana", 1.100, 10);

              // Crear clientes
              Client client1 = new Client("Paco", Arrays.asList(product1, product2, product3));
              Client client2 = new Client("Ana Maria", Arrays.asList(product2, product3));

              // Crear cajeras con tiempo de procesamiento por producto
              CashierProducts cashier1 = new CashierProducts("Cajera 1", 1000); // 1000 ms = 1 segundo por producto
              CashierProducts cashier2 = new CashierProducts("Cajera 2", 1500); // 1500 ms = 1.5 segundos por producto

              // Marca de tiempo inicial
              long startTime = System.currentTimeMillis();

              // Procesar los clientes con las cajeras
              cashier1.processClient(client1, startTime);
              cashier2.processClient(client2, startTime);

              // Mostrar tiempo total de la simulación
              System.out.println("Simulación completa. Tiempo total: " +
                      (System.currentTimeMillis() - startTime) / 1000 + " segundos.");
       }
}
