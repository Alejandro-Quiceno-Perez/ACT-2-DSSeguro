package withConcurrency;

import java.util.Arrays;
import Entitys.Client;
import Entitys.Product;

public class SuperMarket {
       public static void main(String[] args) {
              // Crear productos
              Product product1 = new Product("Pan", 1.500, 3); // Producto: Pan, precio: 1.500, cantidad: 3
              Product product2 = new Product("Leche", 3.500, 5); // Producto: Leche, precio: 3.500, cantidad: 5
              Product product3 = new Product("Manzana", 1.100, 10); // Producto: Manzana, precio: 1.100, cantidad: 10

              // Crear clientes
              Client client1 = new Client("Ana", Arrays.asList(product1, product2, product3)); // Cliente "Ana" con su
                                                                                               // lista de productos
              Client client2 = new Client("Robbert", Arrays.asList(product2, product3)); // Cliente "Robbert" con su
                                                                                         // lista de productos

              // Crear marca de tiempo inicial para medir duración total
              long startTime = System.currentTimeMillis();

              // Crear hilos para procesar cada cliente con su respectiva cajera
              Thread cashier1 = new Thread(new CashierProducts("Cajera 1", client1, startTime));
              Thread cashier2 = new Thread(new CashierProducts("Cajera 2", client2, startTime));

              // Iniciar los hilos, cada uno procesará su cliente en paralelo
              cashier1.start();
              cashier2.start();

              // Esperar a que ambos hilos terminen (join asegura que el programa principal
              // espere)
              try {
                     cashier1.join();
                     cashier2.join();
              } catch (InterruptedException e) {
                     // En caso de interrupción, restaurar el estado del hilo principal
                     Thread.currentThread().interrupt();
              }

              // Mostrar el tiempo total de la simulación
              System.out.println("Simulación completa. Tiempo total: " +
                            (System.currentTimeMillis() - startTime) / 1000 + " segundos.");
       }
}
