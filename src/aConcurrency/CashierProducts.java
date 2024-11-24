package aConcurrency;

import Entitys.Client;
import Entitys.Product;

import java.util.List;

/**
 * Clase que representa a una cajera en el supermercado.
 * La cajera procesa a los clientes producto a producto.
 */
public class CashierProducts {
    private String name; // Nombre de la cajera
    private int processingTimePerProduct; // Tiempo en milisegundos para procesar cada producto

    /**
     * Constructor de la clase Cashier.
     *
     * @param name                     Nombre de la cajera.
     * @param processingTimePerProduct Tiempo que toma procesar cada producto (en milisegundos).
     */
    public CashierProducts(String name, int processingTimePerProduct) {
        this.name = name;
        this.processingTimePerProduct = processingTimePerProduct;
    }

    /**
     * Procesa la compra de un cliente.
     *
     * @param client    Cliente que será procesado.
     * @param timeStamp Marca de tiempo inicial para calcular la duración del proceso.
     */
    public void processClient(Client client, long timeStamp) {
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Cajera -> " + this.name + " Comienza a procesar al cliente -> " + client.getName());

        List<Product> products = client.getProducts();
        int productCount = 1;

        for (Product product : products) {
            processProduct(product, productCount); // Procesar cada producto
            productCount++;
        }

        long totalTime = (System.currentTimeMillis() - timeStamp) / 1000;
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
            // Simula el tiempo de procesamiento
            Thread.sleep(this.processingTimePerProduct);
            System.out.println("Producto " + productCount + ": " + product.getName() +
                    " | Cantidad: " + product.getQuantity() +
                    " | Precio Total: " + product.getTotalCost());
        } catch (InterruptedException e) {
            System.out.println("Error en el procesamiento del producto: " + product.getName());
        }
    }

    /**
     * Obtiene el nombre de la cajera.
     *
     * @return Nombre de la cajera.
     */
    public String getName() {
        return name;
    }
}
