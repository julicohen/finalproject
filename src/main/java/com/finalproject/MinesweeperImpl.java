package com.finalproject;

import java.util.Scanner;
import java.util.Set;

import com.despegar.highflight.utils.Matrix2DCellPosition;
import com.despegar.highflight.utils.MatrixUtils;

public class MinesweeperImpl implements Minesweeper {
	int rowmat;
	int colmat;
	CellsMat cellmat;
	boolean gameover;
	MinesweeperImpl(int row, int col){
		 gameover=false;
		 cellmat=new CellsMatImpl();  
		 cellmat.init(row, col);
		 this.rowmat=row;
		 this.colmat=col;
	}
	public void uncover(int row, int col) {
		// TODO Auto-generated method stub
		if(! cellmat.thereIsUncovered(row, col)){
			if(cellmat.thereIsMine(row, col)){
				gameover=true;
			}else{
				if(cellmat.getNumber(row, col)==0){
					int[][]binmatrix = new int[rowmat][colmat];
					for (int i=0; i<rowmat; i++) { 
				            for (int j=0; j<colmat; j++){ 
				            	if(cellmat.thereIsMine(i, j)){
				            		binmatrix[i][j]=1;
				            	}else{
				            		binmatrix[i][j]=0;
				            	}
				            } 
				       } 
					
					Set<Matrix2DCellPosition> c;
					c=MatrixUtils.cascade(binmatrix, row, col);
					for (Matrix2DCellPosition matrix2dCellPosition : c) {
						cellmat.uncoverCell(matrix2dCellPosition.getRow(), matrix2dCellPosition.getColumn());
					}
				}else{
					cellmat.uncoverCell(row, col);					
				}
			}
		}
	}
	public void flagAsMine(int row, int col) {
		// TODO Auto-generated method stub
		if(!cellmat.thereIsFlag(row, col)){
			cellmat.setFlag(row, col);			
		}
	}

	public void clearFlag(int row, int col) {
		// TODO Auto-generated method stub
		if(cellmat.thereIsFlag(row, col)){
			cellmat.ClearFlag(row, col);
		}
	}

	public boolean isGameOver() {
		// TODO Auto-generated method stub
		return gameover;
	}

	public boolean isWinningGame() {
		// TODO Auto-generated method stub
		int ContUncovered=0;
		boolean GameOver=false;
		for (int i=0; i<rowmat; i++) { 
            for (int j=0; j<colmat; j++){ 
            	if(cellmat.thereIsUncovered(i, j)||cellmat.thereIsFlag(i, j)){
            		ContUncovered ++;
            	}
            } 
        } 
		if(ContUncovered==cellmat.getNumberOfMines()){
			GameOver=true;
			gameover=true;
		}
		return GameOver;
	}

	public void display() {		
		// TODO Auto-generated method stub	
		for (int i=0; i<rowmat; i++) { 
            for (int j=0; j<colmat; j++){ 
            	if(cellmat.thereIsUncovered(i, j)){
            		if(cellmat.thereIsFlag(i, j)){
            			System.out.println("F");
            		}else{
                		System.out.println(cellmat.getNumber(i, j));
            		}
           	}else{
            		System.out.print("X");
            	}
            } 
            System.out.println(); 
        }

	}

	public void displayInternal() {
		// TODO Auto-generated method stub
		  for (int i=0; i<rowmat; i++) { 
	            for (int j=0; j<colmat; j++){ 
	            	if(cellmat.thereIsMine(i, j)){
	            		System.out.print("M"); 
	            	}else{
		                System.out.print(cellmat.getNumber(i,j)); 
	            	}
	            } 
	            System.out.println(); 
	        } 
	}

	public void displayRaw() {
		// TODO Auto-generated method stub
		for (int i=0; i<rowmat; i++) { 
            for (int j=0; j<colmat; j++){ 
            	if(cellmat.thereIsMine(i, j)){
            		System.out.print("1"); 
            	}else{
            		System.out.print("0"); 
            	}
            } 
            System.out.println(); 
       } 
	}
	
	
	  public static void main(String[] args) {
		  Minesweeper game;
		  game=new MinesweeperImpl(4,4);
		  game.display();
		  game.displayInternal();
		 // game.displayRaw();
		  
		while(!game.isGameOver() && !game.isWinningGame()){
			  Scanner keyboard=new Scanner(System.in);
			  System.out.print("Ingrese fila:");
			  int row=keyboard.nextInt();
			  System.out.print("Ingrese columna:");
			  int col=keyboard.nextInt();
			  
			  System.out.print("Ingrese accion:");
	          String action=keyboard.next();
	   
	          if(action.equals("U")){
					game.uncover(row, col);
					game.display();
				//	game.displayInternal();
	          }else if(action.equals("F")){
					game.flagAsMine(row, col);
					game.display();
				//	game.displayInternal();
	          }else if(action.equals("C")){
					game.clearFlag(row, col);
					game.display();
				//	game.displayInternal();
	          }else{
				  System.out.print("Solo puede ingresar U, F o C");
	          }
	        
		}
		  
		 if (game.isWinningGame()){
			  System.out.print("¡Ganaste!");
		  }else{
			  game.displayInternal();
			  System.out.print("¡Perdiste!");
		  }
		  
	  }

}
