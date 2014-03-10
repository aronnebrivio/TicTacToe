import java.util.*;
import java.lang.*;

public class Main {

	public static String nome1, nome2;
	public static boolean single = true;

	public static void main(String[] args) {
		Scanner in = null;
		boolean continua = true;
		boolean fatto;
		int selettore = 0;
			
		while(continua) {
			fatto = false;
			while(!fatto) {
				System.out.println("Choose what kind of game you want to play (3 to exit): ");
				System.out.println("(1) Singleplayer ");
				System.out.println("(2) Multiplayer ");
				try {
					in = new Scanner(System.in);
					selettore = in.nextInt();
					fatto = true;
					break;
				}
				catch(InputMismatchException e) {
					System.out.println("Input is not in the correct format. Please try again");
					fatto = false;
				}
				System.out.println();
			}

			switch(selettore) {
				case 1:
					single = true;
					System.out.println("Enter player's name ");
					nome1 = in.next();
					System.out.println();
					GiocoSingle gs = new GiocoSingle();
					System.out.println(gs.getBoard().toStringInit());
					System.out.println();
					gs.play();
					break;
				case 2:
					single = false;
					System.out.println("Enter first player's name (X) ");
					nome1 = in.next();
					System.out.println();
					System.out.println("Enter second player's name (Y) ");
					nome2 = in.next();
					System.out.println();
					GiocoMulti gm = new GiocoMulti();
					System.out.println(gm.getBoard().toStringInit());
					System.out.println();
					gm.play();
					break;
				default:
					System.exit(0);
					break;
			}
			System.out.println();
			System.out.println("Want to play again? (y/n) ");
			if(in.next().toUpperCase().equals("Y"))
				continua = true;
			else
				continua = false;
			System.out.println();
		}
	}
}