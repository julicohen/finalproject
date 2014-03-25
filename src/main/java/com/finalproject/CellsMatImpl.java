package com.finalproject;

import java.util.Random;

public class CellsMatImpl implements CellsMat{
	 static cell[][]mat=new cell[3][4]; 
	 static cell cel;
	public void init() {
		// TODO Auto-generated method stub
	     for (int i=0; i<3; i++) { 
	            for (int j=0; j<4; j++){ 
	            	cel=new cell(i, j);
	                cel.setvalue(0); 
	                mat[i][j]=cel;
	            } 
	        } 
		  for (int j=0; j<5; j++){
	        	Random rand = new Random();
	        	int n = rand.nextInt(3); 
	        	int m= rand.nextInt(4); 
	        	if(thereIsMine(n, m)){
	        		j--;
	        	}else{
	                cel.setvalue(99); 
	                mat[n][m]=cel;
	        	}
	        }
		  
	}
	/*
	 public static void main (String args[]) { 
		 CellsMat c=new CellsMatImpl();
		 c.init();
	        for (int i=0; i<3; i++) { 
	            for (int j=0; j<4; j++){ 
	                System.out.print(mat[i][j].getvalue()); 
	            } 
	            System.out.println(); 
	        } 
	    }
*/
	public boolean thereIsMine(int row, int col) {
		// TODO Auto-generated method stub
		boolean mine;
		if(mat[row][col].getvalue()==99){
			mine=true;
		}else{
			mine=false;
		}
		return mine;
	}

	public int getNumber(int row, int col) {
		// TODO Auto-generated method stub
		return mat[row][col].getvalue();
	}
	public void ClearFlag(int row, int col) {
		// TODO Auto-generated method stub
		mat[row][col].setFlag(false);
	}
	public void setFlag(int row, int col) {
		// TODO Auto-generated method stub
		mat[row][col].setFlag(true);
	}
	public boolean thereIsUncovered(int row, int col) {
		// TODO Auto-generated method stub
		boolean Estate;
		if(mat[row][col].getEstate()){
			Estate=true;
		}else{
			Estate=false;
		}
		return Estate;
	}
}
