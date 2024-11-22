package withConcurrency;

import java.util.Arrays;

import Entitys.Client;
import Entitys.Product;

public class SuperMarket {
       public static void main(String[] args) {
              // Crear productos
              Product product1 = new Product("Pan", 1.500, 3);
              Product product2 = new Product("Leche", 3.500, 5);
              Product product3 = new Product("Manzana", 1.100, 10);

              // Crear clientes
              Client client1 = new Client("Ana", Arrays.asList(product1, product2, product3));
              Client client2 = new Client("Robbert", Arrays.asList(product2, product3));

              // Crear cajeras
              long startTime = System.currentTimeMillis();
              Thread cashier1 = new Thread(new CashierProducts("Cajera 1", client1, startTime));
              Thread cashier2 = new Thread(new CashierProducts("Cajera 2", client2, startTime));

              cashier1.start();
              cashier2.start();

              try {
                     cashier1.join();
                     cashier2.join();
              } catch (InterruptedException e) {
                     Thread.currentThread().interrupt();
              }

              System.out.println("Simulación completa. Tiempo total: " +
                            (System.currentTimeMillis() - startTime) / 1000 + " segundos.");

       }
}
