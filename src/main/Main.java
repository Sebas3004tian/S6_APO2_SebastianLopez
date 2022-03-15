package main;

import java.io.IOException;
import java.util.Scanner;

import model.VallaData;


public class Main {

	private Scanner sc;
	private VallaData data=new VallaData();
	public Main() throws IOException {
		sc= new Scanner(System.in);
		int num=0;
		data.loadData(num);
		
	}
	public static void main(String[] args) throws IOException{
		
		Main menu = new Main();
		
		int answerInitialMenu= 0;
		do {
		    answerInitialMenu =menu.initialMenu();
		    menu.initialMenuOption(answerInitialMenu);
		}while (answerInitialMenu !=0);
		
	}
	public int initialMenu() {
		
		System.out.println("Selecciona que quieres hacer");
		System.out.println("");
		System.out.println("---------------------------------------------------------");
		System.out.println("(1). Importar datos CSV");
		System.out.println("(2). Agregar valla publicitaria");
		System.out.println("(3). Mostrar vallas publicitarias");
		System.out.println("(4). Exportar reporte de peligrosidad");
		System.out.println("(0). Salir de la aplicacion");
		int answer=sc.nextInt();
		

		return answer;
	}
	public void initialMenuOption(int answerInitialMenu) throws IOException {
		if(answerInitialMenu!=0 && answerInitialMenu!=1 && answerInitialMenu!=2 && answerInitialMenu!=3 && answerInitialMenu!=4){
			System.out.println("///////REMEMBER TO SELECT a number from the menu/////////");
		}
		
		switch(answerInitialMenu) {
		case 0: 
			System.out.println("The application is closed, thanks ...");
			break;
		case 1:
			int answerMenuImportar=0;
			
			answerMenuImportar=importarMenu();
			optionImportarMenu(answerMenuImportar);
			break;
		case 2:
			agregarValla();
			break;
		case 3: 
			mostrarTodasVallas();
			break;
		case 4: 
			reportePeligrosidad();
			break;
		}
		
	}
	public int importarMenu(){
		System.out.println("");
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		System.out.println("");
		System.out.println("(1). Importar Datos 1");
		System.out.println("(2). Importar Datos 2");
		System.out.println("(0).Return to main menu");
		System.out.println("");
		int answer=sc.nextInt();
		
		

		return answer;
	}
	public void optionImportarMenu(int answerImportarMenu) throws IOException {
		if(answerImportarMenu!=0&&answerImportarMenu!=1&&answerImportarMenu!=2){
			System.out.println("///////REMEMBER TO SELECT a number from the menu/////////");
		}
		int num=0;
		switch(answerImportarMenu) {
		case 0: 
			System.out.println("Return to the initial menu ...");
			break;
		case 1:
			num=1;
			data.loadData(num);
			break;
		case 2:
			num=2;
			data.loadData(num);
			break;
		}
		
	}
	public void agregarValla() throws IOException {
		System.out.println("Agrege la valla publicitaria en una sola linea con cada dato separado por ++");
		sc.nextLine();
		String line=sc.nextLine();
		String[] datosSeparados=line.split("\\++");
		int num=3;
		data.agregarValla(datosSeparados,num);
	}
	public void mostrarTodasVallas() {
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		System.out.println("\n"+data.mostrarTodasVallas()+"\n");
		System.out.println("-------------------------------------------------------------------------------------------------------------");
	}
	public void reportePeligrosidad() throws IOException {
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		System.out.println("\n"+data.mostrarReportePeligrosidad()+"\n");
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		
	}

}
