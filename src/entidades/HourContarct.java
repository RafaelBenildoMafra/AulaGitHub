package entidades;
import java.util.Date;

public class HourContarct {
	
	private Date date;
	private double valuePerHour;
	private Integer hours;
	
	public HourContarct(Date date, Double valuePerHour, Integer hours) {
		
		this.date = date;
		this.valuePerHour = valuePerHour;
		this.hours = hours;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getValuePerHour() {
		return valuePerHour;
	}
	public void setValuePerHour(double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}
	public Integer getHours() {
		return hours;
	}
	public void setHours(Integer hours) {
		this.hours = hours;
	}
	
	public double totalValue() {
		
		return valuePerHour * hours;
		
	}
}
