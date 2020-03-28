package aplicação;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entidades.ImportedProducts;
import entidades.Product;
import entidades.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> list = new ArrayList<>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i = 1; i < n + 1; i ++) {
			
			System.out.printf("Product #" + i + "data: \n");
			System.out.print("Common, used or imported (c/u/i)? ");
			char c = sc.next().charAt(0);
			
			if(c == 'i') {
				
				System.out.println("Name: ");
				String name = sc.next();
				
				System.out.println("Price: ");
				double price = sc.nextDouble();	
				
				System.out.println("Customs fee: ");
				double customsFee = sc.nextDouble();	

				Product product = new ImportedProducts(name, price, customsFee);
				
				list.add(product);
				
				
			}

			if(c == 'c') {
				
				System.out.println("Name: ");
				String name = sc.next();
				
				System.out.println("Price: ");
				double price = sc.nextDouble();	

				Product product = new Product(name, price);
				
				list.add(product);
				
			}

			if(c == 'u') {
				
				System.out.println("Name: ");
				String name = sc.next();
				
				System.out.println("Price: ");
				double price = sc.nextDouble();
				
				System.out.println("Manufacture date: (DD/MM/YYYY)");
				Date manufactureDate = sdf.parse(sc.next());
				
			
				Product product = new UsedProduct(name, price, manufactureDate);
				
				list.add(product);
				
			}
			
		}
		System.out.println("PRICE TAGS: ");
		for(Product product: list) {
			
			System.out.printf(product.priceTag());
			
		}
	
		
		sc.close();
				
				
	}
	
	
}
