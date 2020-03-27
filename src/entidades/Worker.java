package entidades;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import entities.Enum.WorkerLevel;

public class Worker {
	
	private String name;
	private WorkerLevel level;
	private Double baseSalary;

	private Department department;
	private List<HourContarct> contracts = new ArrayList<>();
	
	public Worker() {
	}
	
//NAO INCLUI LISTAS NO CONSTRUTOR
	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContarct> getContracts() {
		return contracts;
	}
	
	
			//NAO TROCAR A LISTA POR OUTRA
	//public void setContracts(List<HourContarct> contracts) {
		//this.contracts = contracts;
	//}
	
	
	
	//FAZER E DESFAZER A ASSOCIAÇÃO ENTRE WORKER E CONTARCT
//PEGA A LISTA DE CONTRATOS E ADICIONA O NOVO CONTARTO NA LISTA
	public void addContarct(HourContarct contract) {
		
		contracts.add(contract);
	}
//PEGA A LISTA DE CONTRATOS E REMOVE O NOVO CONTARTO NA LISTA
	public void removeContarct(HourContarct contract) {
		
		contracts.remove(contract);
	}
	
	public double income(int year, int month) {
		
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		for(HourContarct c : contracts) {
			
		//PEGA A DATA DO CONTRATO E DEFINE COMO A DATA DO CALENDARIO
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1  + cal.get(Calendar.MONTH);
			
			if(year == c_year && month == c_month) {
				
				sum += c.totalValue();
			}
		}
		
	}
	
	
	
}
