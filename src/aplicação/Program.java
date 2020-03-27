package aplicação;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import entidades.Client;
import entidades.Order;
import entidades.OrderItem;
import entidades.Product;
import entities.Enum.OrderStatus;

public class Program {
	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
		System.out.println("------Enter Client Data------");
		
		System.out.print("Name: ");
		String name = sc.next();
		
		System.out.print("Email: ");
		String email = sc.next();
		
		System.out.print("\nBirth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
	
		System.out.println("\n------Enter Order Data------\n");
		
		System.out.println("Status: ");
		String status = sc.next();
		
		Client client = new Client(name, email, birthDate);
		
		
		System.out.println("How many items to this order? ");
		int item = sc.nextInt();
		
		Order order = new Order(OrderStatus.valueOf(status));
		
		for(int i = 0; i < item; i ++) {
			System.out.println("Enter " + "#" + i + " data: ");
			
			System.out.print("Product name: ");
			String product = sc.next();
			
			System.out.print("Product price: ");
			Double price = sc.nextDouble();
			
			System.out.print("Quantity: ");
			Integer quantity = sc.nextInt();
			
			OrderItem orderItem = new OrderItem(quantity ,new Product(product, price));
		
			order.addItem(orderItem);
		}
		
		System.out.println("ORDER SUMMARY: ");
		System.out.println("Order status: " + OrderStatus.valueOf(status));
		System.out.println("Client: " + client.getName() + client.getBirthDate()  + " - " + client.getEmail());
		System.out.println("Order items: ");
		
		order.subTotal();
		System.out.printf("\n Total price: D$" + order.total());
		
	}

}
