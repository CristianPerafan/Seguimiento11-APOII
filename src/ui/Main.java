package ui;

import java.util.Scanner;
import model.GameController;

/**
 * 
 * @author Cristian
 *
 */

public class Main {
	
	private static Scanner sc;
	private  GameController controller;
	
	private boolean win;
	
	//Constructo method
	public Main() {
		sc = new Scanner(System.in);
		controller = new GameController();
		win = false;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String [] args) {
		
		Main pc = new Main();
		
		System.out.println("Enter the number of rows: ");
		int numRows = sc.nextInt();
		
		System.out.println("Enter the number of columns: ");
		int numColumns = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter your player name: ");
		String playerName = sc.nextLine();
		
		pc.toSetUpGame(numRows,numColumns,playerName);
		
		int option = 0;
		do {
			option = pc.showGameOptions();
			pc.executeOperation(option);
		}while(option != 3);
	
	}
	/**
	 * This method is created to initialize the values ​​of the game
	 * @param numRows
	 * @param numColumns
	 * @param playerName
	 */
	public void toSetUpGame(int numRows, int numColumns, String playerName) {
		controller.toCreateGameBoard(numRows, numColumns,playerName);
	}
	
	/**
	 * 
	 * @return option,
	 */
	public int showGameOptions() {
		int option = 3;
		if(win == false) {
			System.out.println("*** GAME MENU ***\n"
					+ "1. Roll dice\n"
					+ "2. See game board\n"
					+ "3. Exit");
			option = sc.nextInt();
			sc.nextLine();
		}

		return option;
	}
	
	/**
	 * 
	 * @param option
	 */
	public void executeOperation(int option) {
		switch(option) {
		case 1:
			roollDice();
			break;
		case 2:
			seeGameBoard();
			break;
		case 3:
			System.out.println("Bye see you soon...");
			break;
		default:
			System.out.println("No valid option !!! =(");
			break;
		}
	}
	
	public void roollDice() {
		int movement = (int)((Math.random()*6)+1);
		System.out.println("");
		System.out.println("Result of the roll of the die: "+movement);
		
		if(controller.validateMovement(movement)) {

			controller.movePlayer(); 
			
			System.out.println("The player "+controller.getPlayerName()+" has moved to "+
					controller.getPosPlayer()+" block.");
			
			System.out.println("");
			
			if(controller.validatePlayerWon()) {
				System.out.println("");
				System.out.println("Congratulations "+controller.getPlayerName()+" you have won you are a crack !!! ");
				
				System.out.println("┌─┐　─┐☆\r\n"
						+ "│▒│ /▒/\r\n"
						+ "│▒│/▒/\r\n"
						+ "│▒ /▒/─┬─┐\r\n"
						+ "│▒│▒|▒│▒│\r\n"
						+ "┌┴─┴─┐-┘─┘\r\n"
						+ "│▒┌──┘▒▒▒│\r\n"
						+ "└┐▒▒▒▒▒▒┌┘\r\n"
						+ "└┐▒▒▒▒┌");
				win = true;
			}
			
		}
		else {
			System.out.println("You can not move, you must roll a number less than or equal to: "+
					controller.toCalculateMissingBoxers());
		}
	}
	
	public void seeGameBoard() {
		System.out.println(controller.toShowGameBoard());
	}
	
	
	
	
}
