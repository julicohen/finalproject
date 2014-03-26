package com.finalproject;

import java.util.Random;

public class CellsMatImpl implements CellsMat{
	  cell cel;
	  int rowmat;
	  int colmat;
	  cell[][]mat; 
	 int CantMines;
	public void init(int row, int col) {
		// TODO Auto-generated method stub
		this.rowmat=row;
		this.colmat=col;
		mat=new cell[rowmat][colmat];
	     for (int i=0; i<row; i++) { 
	            for (int j=0; j<col; j++){ 
	            	cel=new cell(i, j);
	            	cel.setFlag(false);
	                cel.setState(false);
	                cel.setMine(false);
	                mat[i][j]=cel;
	            } 
	      } 
	     
	      CantMines=(int) ((int)row*col*0.15);
		  for (int j=0; j<CantMines; j++){
	        	Random rand = new Random();
	        	int n = rand.nextInt(row); 
	        	int m= rand.nextInt(col); 
	        	if(thereIsMine(n, m)){
	        		j--;
	        	}else{
	        		mat[n][m].setMine(true); 
	        	}
	        }	     
		 setNumber(row, col);     
	}
	private void setNumber(int row, int col){
		 for (int i=0; i<row; i++) { 
	            for (int j=0; j<col; j++){
	            	if(thereIsMine(i, j)){      	
	            	}else{
		            	int CountMines=0;
	            		int border1=i+1;
	            		int border2=i-1;
	            		int border3=j+1;
	            		int border4=j-1;
	            		if(border1<row){
	            			if(thereIsMine(border1, j)){
		            			CountMines=CountMines+1;
		            		}
	            		}
	            		if(border2>=0){
	            			if(thereIsMine(border2, j)){
		            			CountMines=CountMines+1;
		            		}
	            		}
	            		if(border3<col){
	            			if(thereIsMine(i, border3)){
		            			CountMines=CountMines+1;
		            		}
	            		}
	            		if(border4>=0){
	            			if(thereIsMine(i, border4)){
		            			CountMines=CountMines+1;
		            		}
	            		}
	            		if(border1<row && border3<col){
	            			if(thereIsMine(border1, border3)){
		            			CountMines=CountMines+1;
		            		}
	            		}
	            		
	            		if(border1<row && border4>=0){
	            			if(thereIsMine(border1, border4)){
		            			CountMines=CountMines+1;
		            		}
	            		}
	            		if(border2>=0 && border3<col){
		            		if(thereIsMine(border2, border3)){
		            			CountMines=CountMines+1;
		            		}
	            		}

	            		if(border2>=0 && border4>=0){
		            		if(thereIsMine(border2, border4)){
		            			CountMines=CountMines+1;
		            		}
	            		}
	            		mat[i][j].setvalue(CountMines);
	            	}
	            } 
	       } 
	}
	public boolean thereIsMine(int row, int col) {
		// TODO Auto-generated method stub
		return mat[row][col].getMine();
	}

	public int getNumber(int row, int col) {
		// TODO Auto-generated method stub
		return mat[row][col].getvalue();
	}
	public void ClearFlag(int row, int col) {
		// TODO Auto-generated method stub
		mat[row][col].setFlag(false);
		mat[row][col].setState(false);
	}
	public void setFlag(int row, int col) {
		// TODO Auto-generated method stub
		mat[row][col].setFlag(true);
		mat[row][col].setState(true);
	}
	public boolean thereIsUncovered(int row, int col) {
		// TODO Auto-generated method stub
		boolean Estate;
		if(mat[row][col].getState()){
			Estate=true;
		}else{
			Estate=false;
		}
		return Estate;
	}
	public void uncoverCell(int row, int col) {
		// TODO Auto-generated method stub
		mat[row][col].setState(true);
	}
	public boolean thereIsFlag(int row, int col) {
		// TODO Auto-generated method stub
		return mat[row][col].getFlag();
	}
	public int getNumberOfMines() {
		// TODO Auto-generated method stub
		return CantMines;
	}
}
