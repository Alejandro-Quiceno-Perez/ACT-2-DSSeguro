package withConcurrency;

import Entitys.Client;
import Entitys.Product;

/**
 * Clase que representa a una cajera que procesa clientes en un hilo.
 */
public class CashierProducts implements Runnable {
       private String name; // Nombre de la cajera
       private Client client; // Cliente asignado a la cajera
       private long startTime; // Marca de tiempo inicial para calcular duración

       /**
        * Constructor de la clase CashierThread.
        *
        * @param name      Nombre de la cajera.
        * @param client    Cliente a procesar.
        * @param startTime Marca de tiempo inicial.
        */
       public CashierProducts(String name, Client client, long startTime) {
              this.name = name;
              this.client = client;
              this.startTime = startTime;
       }

       /**
        * Método que ejecuta el procesamiento del cliente.
        */
       @Override
       public void run() {
              System.out.println("---------------------------------------------------------------------------------");
              System.out.println("Cajera -> " + this.name + " Comienza a procesar al cliente -> " + client.getName());

              int productCount = 1;
              for (Product product : client.getProducts()) {
                     processProduct(product, productCount); // Procesar cada producto
                     productCount++;
              }

              long totalTime = (System.currentTimeMillis() - startTime) / 1000;
              System.out.println("Cajera -> " + this.name + " Ha terminado de procesar al cliente -> "
                      + client.getName() + " En el tiempo: " + totalTime + "seg");
              System.out.println("---------------------------------------------------------------------------------");
       }

       /**
        * Simula el procesamiento de un producto.
        *
        * @param product      Producto que será procesado.
        * @param productCount Número del producto actual en la lista.
        */
       private void processProduct(Product product, int productCount) {
              try {
                     Thread.sleep(1000); // Simula tiempo de procesamiento por producto
                     System.out.println("Producto " + productCount + ": " + product.getName() +
                             " | Cantidad: " + product.getQuantity() +
                             " | Precio Total: " + product.getTotalCost());
              } catch (InterruptedException e) {
                     System.out.println("Error en el procesamiento del producto: " + product.getName());
                     Thread.currentThread().interrupt(); // Restaurar el estado de interrupción
              }
       }
}
