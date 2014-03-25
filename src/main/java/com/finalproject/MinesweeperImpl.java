package com.finalproject;

import com.despegar.highflight.utils.Matrix2DCellPosition;
import com.despegar.highflight.utils.MatrixUtils;

public class MinesweeperImpl implements Minesweeper {

	static CellsMat cm;
	boolean gameover;
	static  Minesweeper m; 
	public void uncover(int row, int col) {
		// TODO Auto-generated method stub
		if(cm.thereIsMine(row, col)){
			gameover=true;
		}else{
			if(cm.getNumber(row, col)==0){
				MatrixUtils mat=new MatrixUtils();
				int[][]matrix = new int[3][4];
				for (int i=0; i<3; i++) { 
			            for (int j=0; j<4; j++){ 
			            	 matrix[i][j]= cm.getNumber(i, j) ; 
			            } 
			       } 
				Matrix2DCellPosition mat2d;
				mat2d=mat.cascade(matrix, row, col);
			}else{
				
			}
		}
	}
	public void flagAsMine(int row, int col) {
		// TODO Auto-generated method stub
		cm.setFlag(row, col);
	}

	public void clearFlag(int row, int col) {
		// TODO Auto-generated method stub
		cm.ClearFlag(row, col);
	}

	public boolean isGameOver() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isWinningGame() {
		// TODO Auto-generated method stub
		return false;
	}

	public void display() {
		// TODO Auto-generated method stub
		for (int i=0; i<3; i++) { 
            for (int j=0; j<4; j++){ 
                System.out.print(cm.thereIsUncovered(i,j)); 
            } 
            System.out.println(); 
        }

	}

	public void displayInternal() {
		// TODO Auto-generated method stub
		  for (int i=0; i<3; i++) { 
	            for (int j=0; j<4; j++){ 
	                System.out.print(cm.getNumber(i,j)); 
	            } 
	            System.out.println(); 
	        } 
	}

	public void displayRaw() {
		// TODO Auto-generated method stub
		System.out.println(cm.getNumber(2, 3));
		
	}
	
	public void setMat(CellsMat cellmat) {
		// TODO Auto-generated method stub
		cm=cellmat;
		cm.init();
	}
	  public static void main(String[] args) {
		  CellsMat c=new CellsMatImpl();
		  m=new MinesweeperImpl();
		  m.setMat(c);
		  m.display();
		  
	  }

}
