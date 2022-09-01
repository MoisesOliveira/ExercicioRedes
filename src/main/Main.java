package main;

import controller.RedesController;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		int opc = escolhe();
		RedesController redes = new RedesController();
		
		switch(opc) {
		case 1:
			redes.ip();
			break;
		case 2:
			redes.ping();
			break;
		case 0:
			System.exit(0);
		}
	}
	
	public static int escolhe() {
		
		int opc = Integer.
				parseInt(JOptionPane.showInputDialog("Escolha uma opção: \n 1 - IP \n 2 - Ping"));
		
		return opc;
	}

}
