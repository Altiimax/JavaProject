package view;

import java.util.InputMismatchException;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import controller.LeJeuController;
import modele.LeJeu;

public class LeJeuVueConsole extends LeJeuVue implements Observer {

	protected Scanner sc;
	
	public LeJeuVueConsole (LeJeu modele, LeJeuController controller) {
		super(modele, controller);
		update(null,null);
		sc = new Scanner(System.in);
		new Thread (new ReadInput()).start();
	}
	
	public void update(Observable o, Object arg) {
		System.out.println(modele);
		printHelp();
	}
	
	private void printHelp() {
		affiche("Pour lancer le dé: lance");
	}
	
	private class ReadInput implements Runnable {
		public void run() {
			while(true) {
				try {
					String c = sc.next();
					if(c.length()!=1){
						affiche("Format d'input incorrect");
						printHelp();
					}
						
					int i = sc.nextInt();
					if(i<0 || i> 9){
						affiche("Numéro du livre incorrect");
						printHelp(); 
					}
					switch(c){
						case "lance" :
							controller.lanceDe(i);
							break;
						default : 
							affiche("Opération incorrecte");
							printHelp();
					}
				}
				catch(InputMismatchException e){
					affiche("Format d'input incorrect");
					printHelp();
				}
				}
			}
		}
	}
	
	@Override
	public void affiche(String string) {
		System.out.println(string);
		
	}
}
