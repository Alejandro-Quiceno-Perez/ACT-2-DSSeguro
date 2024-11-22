package withConcurrency;

import Entitys.Client;
import Entitys.Product;

public class CashierProducts implements Runnable {
       private String name;
       private Client client;
       private long startTime;

       public CashierProducts(String name, Client client, long startTime) {
              this.name = name;
              this.client = client;
              this.startTime = startTime;
       }

       public void run() {
              System.out.println("---------------------------------------------------------------------------------");
              System.out.println("Cajera -> " + this.name + " Comienza a procesar al cliente -> " + client.getName());

              int productCount = 1;
              for (Product product : client.getProducts()) {
                     processProduct(product, productCount);
                     productCount++;
              }
              System.out.println("Cajera -> " + this.name + " Ha terminado de procesar al cliente -> "
                            + client.getName() + " En el tiempo: "
                            + (System.currentTimeMillis() - startTime) / 1000 + "seg");
              System.out.println("---------------------------------------------------------------------------------");
       }

       private void processProduct(Product product, int productCount) {
              try {
                     Thread.sleep(1000);
                     System.out.println("Producto " + productCount + ": " + product.getName() +
                                   " | Cantidad: " + product.getQuantity() +
                                   " | Precio Total: " + product.getTotalCost());
              } catch (Exception e) {
                     Thread.currentThread().interrupt();
              }

       }

}
