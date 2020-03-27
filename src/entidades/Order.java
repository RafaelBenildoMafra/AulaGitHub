package entidades;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import entities.Enum.OrderStatus;

public class Order {
	
	OrderStatus status;
	Client client;
	
	
	private List<OrderItem> orderItem = new ArrayList<>();

	public Order(OrderStatus status) {
		
		this.status = status;
		
	}
	
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public void addItem(OrderItem item) {
		
		orderItem.add(item);
	}
	public void removeItem(OrderItem item) {
		
		orderItem.remove(item);
		
	}
	
	public void subTotal() {
		
		for(OrderItem orderItem : orderItem) {
			System.out.println();
			double subtotal = orderItem.getQuantity() * orderItem.getProduct().getPrice();
			
			System.out.printf(orderItem.getProduct().getName() + ", D$"  + orderItem.getProduct().getPrice() + "," 
			+ "Quantity: " + orderItem.getQuantity() + "," + "Subtotal: D$" + subtotal);
		}
		
	}
	public double total() {
		
		double sum = 0;
		
		for(OrderItem orderItem : orderItem) {
	
			sum += (double) orderItem.getQuantity() * orderItem.getProduct().getPrice();
		}
		
		
		return sum;
		
	}
}
	




	


