import java.util.Scanner;

public class Main {
	
	private static String[][] board = new String[3][3];
	private static boolean gameWon;
	private static String winner;

	public static void main(String[] args) {
		System.out.println("Starting");
		
		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board[row].length; col++) {
				board[row][col] = "-";
			}
		}
		
		int i = 1;
		
		outer:
		while(i < 9) {
			
			updateBoard(getPlayerOneInput());
			
			if(gameWon) {
				break outer;
			}
		
			updateBoard(getPlayerTwoInput());

			++i;
			if(gameWon) {
				break outer;
			}
			
		}
		
		System.out.println(winner);
		
	}
	

	private static void updateBoard(int[] cell) {
		if(cell[2] == 1) {
			board[cell[0]][cell[1]] = "X";
		}
		else if(cell[2] == 2) {
			board[cell[0]][cell[1]] = "O";
		}
		
		printBoard(board);
	}
	

	private static void printBoard(String[][] board2) {
		System.out.println(" -------------");
		for(int row = 0; row < board.length; row++) {
				int i = 1;
				while(i <= 3) {
					for(int col = 0; col < board[row].length; col++) {
						System.out.print(" | ");
						System.out.print(board[row][col]);
						i++;
					}
					System.out.print(" |");
				}
				System.out.println();
				System.out.print(" -------------");
				System.out.println();
			}
		
		checkForWin(board);
		
	}

	private static int[] getPlayerOneInput() {
		
		System.out.println("Player one choose a space");
		
		Scanner in = new Scanner(System.in);
		
		int success = 0;
		
		int[] input = new int[3];
		
		while(success == 0) {
			
			int intOne = Integer.parseInt(in.nextLine());
			int intTwo = Integer.parseInt(in.nextLine());
			
			if (board[intOne - 1][intTwo - 1] == "-") {
				input[0] = (intOne - 1);
				input[1] = (intTwo - 1);
				input[2] = 1;
				++success;
			} else {
				System.out.println("Space is already claimed! Choose another space");
			}
		}

		return input;
	}
	
	private static int[] getPlayerTwoInput() {
		
		System.out.println("Player two choose a space");
		
		Scanner in = new Scanner(System.in);
		
		int success = 0;
		
		int[] input = new int[3];
		
		while(success == 0) {
			
			int intOne = Integer.parseInt(in.nextLine());
			int intTwo = Integer.parseInt(in.nextLine());
			
			if (board[intOne - 1][intTwo - 1] == "-") {
				input[0] = intOne - 1;
				input[1] = intTwo - 1;
				input[2] = 2;
				++success;
			} else {
				System.out.println("Space is already claimed! Choose another space");
			}
		}

		return input;
	}
	
	// This can be improved? 
	private static boolean checkForWin(String[][] game) {
		
		if(game[0][0].equals(game[0][1]) && game[0][1].equals(game[0][2]) && game[0][0] != "-") {
			
			gameWon = true;
			
			if(game[0][0].equals("X")) {
				
				winner = "X Wins!";
				
			}
			else if(game[0][0].equals("O")) {
				
				winner = "O Wins!";
				
			}
		}
		else if(game[1][0].equals(game[1][1]) && game[1][1].equals(game[1][2]) && game[1][0] != "-") {
			
			gameWon = true;
			
			if(game[1][0].equals("X")) {
				
				winner = "X Wins!";
				
			}
			else if(game[1][0].equals("O")) {
				
				winner = "O Wins!";
				
			}
		}
		else if(game[2][0].equals(game[2][1]) && game[2][1].equals(game[2][2]) && game[2][0] != "-") {
			
			gameWon = true;
			
			if(game[2][0].equals("X")) {
				
				winner = "X Wins!";
				
			}
			else if(game[2][0].equals("O")) {
				
				winner = "O Wins!";
				
			}	
		}
		else if(game[0][0].equals(game[1][0]) && game[1][0].equals(game[2][0]) && game[0][0] != "-") {
			
			gameWon = true;
			
			if(game[0][0].equals("X")) {
				
				winner = "X Wins!";
				
			}
			else if(game[0][0].equals("O")) {
				
				winner = "O Wins!";
				
			}
		}
		else if(game[0][1].equals(game[1][1]) && game[1][1].equals(game[2][1]) && game[0][1] != "-") {
			
			gameWon = true;
			
			if(game[0][1].equals("X")) {
				
				winner = "X Wins!";
				
			}
			else if(game[0][1].equals("O")) {
				
				winner = "O Wins!";
				
			}
			
		}
		else if(game[0][2].equals(game[1][2]) && game[1][2].equals(game[2][2]) && game[0][2] != "-") {
			
			gameWon = true;
			
			if(game[0][2].equals("X")) {
				
				winner = "X Wins!";
				
			}
			else if(game[0][2].equals("O")) {
				
				winner = "O Wins!";
				
			}
			
		}
		else if(game[0][0].equals(game[1][1]) && game[1][1].equals(game[2][2]) && game[0][0] != "-") {
			
			gameWon = true;
			
			if(game[0][0].equals("X")) {
				
				winner = "X Wins!";
				
			}
			else if(game[0][0].equals("O")) {
				
				winner = "O Wins!";
				
			}
			
		}
		else if(game[2][0].equals(game[1][1]) && game[1][1].equals(game[0][2]) && game[2][0] != "-") {
			
			gameWon = true;
			
			if(game[2][0].equals("X")) {
				
				winner = "X Wins!";
				
			}
			else if(game[2][0].equals("O")) {
				
				winner = "O Wins!";
				
			}
			
		}
		else {
			
			return false;
			
		}
		
		return gameWon;
	}

}
