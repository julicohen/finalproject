package com.finalproject;

public class cell {
	cell(int row, int col){
		
	}
	int value;
	boolean Flag=false;
	boolean Uncovered;
	boolean Mine;
	int getvalue(){
		return this.value;
	}
	void setvalue(int v){
		this.value=v;
	}
	void setFlag(boolean f){
		Flag=f;
	}
	boolean getFlag(){
		return Flag;
	}
	boolean getMine(){
		return Mine;
	}
	void setMine(boolean m){
		this.Mine=m;
	}
	void setState(boolean hu){
		Uncovered=hu;
	}
	boolean getState(){
		return Uncovered;
	}
	


}
