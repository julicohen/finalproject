package com.finalproject;


public interface CellsMat {
	void init();
	boolean thereIsMine(int row, int col);
	boolean thereIsUncovered(int row, int col);
	int getNumber(int row, int col);
	void ClearFlag(int row, int col);
	void setFlag(int row, int col);	
}
