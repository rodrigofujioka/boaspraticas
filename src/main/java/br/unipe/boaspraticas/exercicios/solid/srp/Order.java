package br.unipe.boaspraticas.exercicios.solid.srp;

import br.unipe.boaspraticas.exercicios.solid.model.Item;

import java.util.List;



public class Order {
    private int orderId;
    private String customerName;
    private List<Item> items;

    public Order(int orderId, String customerName, List<Item> items) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.items = items;
    }

    public void calculateTotalPrice() {
        double total = 0;
        for (Item item : items) {
            total += item.getP();
        }
        System.out.println("Total Price: " + total);
    }

    public void saveOrderToDatabase() {
        // Código para salvar o pedido no banco de dados
        System.out.println("Order saved to database.");
    }

    public void sendConfirmationEmail() {
        // Código para enviar e-mail de confirmação para o cliente
        System.out.println("Confirmation email sent to customer.");
    }
}
