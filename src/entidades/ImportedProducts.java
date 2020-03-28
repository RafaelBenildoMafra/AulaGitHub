package entidades;


public class ImportedProducts extends Product{
	
	private Double customsFee;

	public ImportedProducts(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}
	
	public String priceTag() {
		
		return name + price + "(CustomsFee: $D" + customsFee + ")";
		
	}

	

}
