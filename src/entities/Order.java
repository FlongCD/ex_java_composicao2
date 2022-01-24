package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderStatus status;
	
	private List<OrderItem> items = new ArrayList<>();
	private Client client;
	
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public void addItem(OrderItem item) {
		items.add(item);
	}
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public double total() {
		double total = 0;
		for(OrderItem c: items) {
			total += c.subTotal();
		}
		return total;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY: " + "\n");
		sb.append("Order moment: " + sdf.format(getMoment()) + "\n");
		sb.append("Order status: " + getStatus() + "\n");
		sb.append("Client: " + getClient().getName() + " (" + getClient().getBirthDate() + ")" + " - " + getClient().getEmail() +  "\n");
		sb.append("Order items:" + "\n");
		for(OrderItem c: items) {
			sb.append(c.getProduct().getName() + ", $" + String.format("%.2f", c.getPrice()) + ", Quantity: " + c.getQuantity() + ", Subtotal: $" + String.format("%.2f", c.subTotal()) + "\n");
		}
		sb.append("Total price: $" + String.format("%.2f", total()));
		
		return sb.toString();
	}
	
	
}
