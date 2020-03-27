package aplicação;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import entidades.Department;
import entidades.HourContarct;
import entidades.Worker;
import entities.Enum.WorkerLevel;


public class Programa {
	
	public static void main(String[] args) throws ParseException {
		
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department´s name: ");
		String department = sc.next();
		
		System.out.print("Enter worker data:\n ");
		
		System.out.print("Name: ");
		String name = sc.next();
		
		System.out.print("Level: ");
		String level = sc.next();
		
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();
		
		System.out.print("How many contracts to this worker? : ");
		int cont = sc.nextInt();
		
		//DEPARTAMENT ESTA ASSOCIADO A CLASSE WORKER - COMPOSIÇAÕ DE OBJETOS
		Worker worker = new Worker(name, WorkerLevel.valueOf(level), baseSalary, new Department(department)); 
		
		
		for (int i = 1; i < cont+1; i++) {
			
		System.out.printf("\nEnter contract" + " #" + i + " data\n");
		
	//PEGA A DATA INFORMADA
		System.out.print("Date (DD/MM/YYYY): ");
		Date date = sdf.parse(sc.next());
				
		System.out.print("Value per hour: ");
		double valuePerHour = sc.nextDouble();
		
		System.out.print("Duration (hours): ");
		int hours = sc.nextInt();
		
		HourContarct hourContract = new HourContarct(date, valuePerHour, hours);
	//CHAMA A FUNÇÃO QUE ADICIONA OS DADOS: DATE 
	//, VALUEPERHOUR E HOURS NA LISTA HOURCONTRACT
		worker.addContarct(hourContract);
		
		}
		
		System.out.println();
	//converte o mes em um inteiro e depois os anos
		System.out.println("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
	//recorta o string gerando uma substring com os 2 digitos(meses) e trasnformando em um inetiro
		int month = Integer.parseInt(monthAndYear.substring(0,2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for" + monthAndYear + ": " + String.format("%.2f",worker.income(year, month)));
		sc.close();
		
		
	}

}
