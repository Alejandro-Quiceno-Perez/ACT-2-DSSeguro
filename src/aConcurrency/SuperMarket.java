package aConcurrency;

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
              Client client1 = new Client("Paco", Arrays.asList(product1, product2, product3));
              Client client2 = new Client("Ana Maria", Arrays.asList(product2, product3));

              // crear cajeras
              CashierProducts cashier1 = new CashierProducts("Cajera 1");
              CashierProducts cashier2 = new CashierProducts("Cajera 2");

              long startTime = System.currentTimeMillis();
              cashier1.processClient(client1, startTime);
              cashier2.processClient(client2, startTime);

              System.out.println("Simulación completa. Tiempo total: " +
                            (System.currentTimeMillis() - startTime) / 1000 + " segundos.");
       }
}
