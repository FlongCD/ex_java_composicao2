package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		Date moment = new Date();
		System.out.println("Enter order data");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		Order order = new Order(moment, status, new Client(name, email, birthDate));  
		System.out.print("How many to this order? ");
		int n = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < n; i++) {
			System.out.println("Enter #" + (i + 1) + " item data:");
			System.out.print("Product name: ");
			String nameProduct = sc.nextLine();
			System.out.print("Product price: ");
			Double priceProduct = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantityProduct = sc.nextInt();
			sc.nextLine();
			OrderItem orderItem = new OrderItem(quantityProduct, priceProduct, new Product(nameProduct, priceProduct));
			order.addItem(orderItem);
		}
		//System.out.println("ORDER SUMMARY");
		//System.out.println("Order moment: " + sdf.format(order.getMoment()));
		//System.out.println("Order status: " + order.getStatus());
		//System.out.println("Client: " + order.getClient().getName() + " (" + order.getClient().getBirthDate() + ") - " + order.getClient().getEmail());
		//System.out.println("Order items:");
		//for(OrderItem c: order.getItems()) {
			//System.out.println(c.getProduct().getName() + ", $" + String.format("%.2f", c.getPrice()) + ", Quantity: " + c.getQuantity() + ", Subtotal: $" + c.subTotal());
		//}
		//System.out.println("Total price: " + order.total());
		System.out.println(order);
		
		sc.close();
	}
}
