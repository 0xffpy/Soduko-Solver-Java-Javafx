package application;

import java.util.Random;

public class Soduko {
	 private int[][] board = new int[9][9];
	 private String mode;
	 private Random random = new Random();
	 private int[][] solvedBoard;
	 Soduko(int[][] board,String mode) {
		 this.board = board;
		 this.mode = mode;
		 generateSoducode(this.mode);
	 }
	 Soduko(int[][] boaard){
		 board = java.util.Arrays.copyOf(boaard,boaard.length);
	 }
	 public void generateSoducode(String mode){
		 int diffuclty ; // check the diff to remove some elemnts
		 int randomPosX;
		 int randomPosY;
		 int randomValue;
		 int[][] newBoard;
		 if(mode.equals("E")) {
			 diffuclty = 50;
		 }
		 else if(mode.equals("M"))
			 diffuclty = 65;
		 else
			 diffuclty = 80;
		 // take random numbers to generate a soduko code 
		 while(true) {
			 for(int i =0;i<20;i++) {
				 randomPosX = random.nextInt(9);
				 randomPosY = random.nextInt(9);
				 randomValue = random.nextInt(9)+1;
				 if(issSafe(randomPosY,randomPosX,randomValue) == true) {
					 board[randomPosY][randomPosX] = randomValue;
					 
				 }else {  continue;}
				 
			}
			 if(sodukoSolver() == true) {
				 for(int i = 0 ; i< diffuclty;i++) {
					 int randy = random.nextInt(9);
					 int randx = random.nextInt(9);
					 if(board[randy][randx] != 0) {
						 board[randy][randx] = 0;
					 }
					 else {
						 while(true) {
							 randy = random.nextInt(9);
							 randx = random.nextInt(9); 
							 if(board[randy][randx] == 0) {
								 board[randy][randx] = 0;
								 continue;
							 }else break;
						 }
					 }
				 }			 
				 
				 newBoard = copyArray();
				 if(sodukoSolver() == true) {
					 solvedBoard = copyArray();
					 break;
				 }
					 
			 	}else continue;
			 }
	
		 
		 setBoard(newBoard);
	 }
	 private boolean issSafe(int y,int x,int value){
		for(int i =0 ;i<board[y].length; i++ ) {
			if(board[y][i] == value)
				return false;
		}
		for(int i =0;i<board.length ; i++) {
			if(board[i][x] == value)
				return false;
		}
		int sqrt = (int)Math.sqrt(board.length);
       int boxRowStart = y - y % sqrt;
       int boxColStart = x - x % sqrt;

       for (int r = boxRowStart;
            r < boxRowStart + sqrt; r++)
       {
           for (int d = boxColStart;
                d < boxColStart + sqrt; d++)
           {
               if (board[r][d] == value)
               {
                   return false;
               }
           }
       }
       return true;
	}
	 public boolean isSafe(int y, int x , int value) {
		 if(solvedBoard[y][x] == value)
			 return true;
		return false;
	 }
	
	public boolean sodukoSolver(int value) {
		int x=-1;
		int y=-1;
		boolean empty = false;
		for(int i = 0 ;i<9;i++) {
			for(int j =0;j<9;j++) {
				if(board[i][j] == 0) {
					y = i;
					x = j;
					empty = true;
					break;
				}
				
			}
			if(empty)
				break;
		}
		if(!empty)
			return true;
		
		for(int i = 9 ; i > 0;i--) {
			if(issSafe(y,x,i) == true) {
				board[y][x] = i;
				if(sodukoSolver(i) == true) {
					return true;
				}
				else {
					board[y][x] = 0;
				}
			}
		}
		return false;
	}
	public boolean sodukoSolver() {
		int x=-1;
		int y=-1;
		boolean empty = false;
		for(int i = 0 ;i<9;i++) {
			for(int j =0;j<9;j++) {
				if(board[i][j] == 0) {
					y = i;
					x = j;
					empty = true;
					break;
				}
				
			}
			if(empty)
				break;
		}
		if(!empty)
			return true;
		
		for(int i = 9 ; i>0;i--) {
			if(issSafe(y,x,i) == true) {
				board[y][x] = i;
				if(sodukoSolver(i) == true) {
					return true;
				}
				else {
					board[y][x] = 0;
				}
			}
		}
		return false;
	}
	
	public void printArray() {
		for(int i = 0;i<9;i++) {
			for(int j = 0 ;j<9;j++) {
				System.out.print(board[i][j]+" ");
				
			}				
			System.out.print("\n");

			
		}
	}
	public void printArray(int[][] board) {
		for(int i = 0;i<9;i++) {
			for(int j = 0 ;j<9;j++) {
				System.out.print(board[i][j]+" ");
				
			}				
			System.out.print("\n");
		}
	}
	public void setBoard(int[][] board) {
		this.board = board;
	}
	public int[][] getBoard(){
		return this.board;
	}
	public int[][] copyArray(){
		int temp;
		int[][] array = new int[9][9];
		for(int i = 0; i<9;i++ ) {
			for(int j =0;j<9;j++) {
				temp = board[i][j];
				array[i][j] = temp;
			}
		}
		return array;
	}
	public boolean setBoard(int y , int x, int value ) {
		if(isSafe(y,x,value)) {
			board[y][x] = value;
			//}
			return true;
		}
		else {
			return false;
		}
	}
	public int returnValue(int y,int x) {
		return board[y][x];
	}
}