package aConcurrency;

import Entitys.Client;
import Entitys.Product;

public class CashierProducts {
       private String name;

       public CashierProducts(String name) {
              this.name = name;
       }

       public void processClient(Client client, long timeStamp) {
              System.out.println("---------------------------------------------------------------------------------");
              System.out.println("Cajera -> " + this.name + " Comienza a procesar al cliente -> " + client.getName());

              int productCount = 1;
              for (Product product : client.getProducts()) {
                     processProduct(product, productCount);
                     productCount++;
              }
              System.out.println("Cajera -> " + this.name + " Ha terminado de procesar al cliente -> "
                            + client.getName() + " En el tiempo: "
                            + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
              System.out.println("---------------------------------------------------------------------------------");
       }

       private void processProduct(Product product, int productCount) {
              try {
                     Thread.sleep(1000); // Simula el tiempo de procesamiento por producto
                     System.out.println("Producto " + productCount + ": " + product.getName() +
                                   " | Cantidad: " + product.getQuantity() +
                                   " | Precio Total: " + product.getTotalCost());
              } catch (InterruptedException e) {
                     System.out.println("Error en el procesamiento del producto: " + product.getName());
              }
       }
}
