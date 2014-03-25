package com.finalproject;

public class cell {
	cell(int row, int col){
		
	}
	int value;
	boolean Flag;
	boolean Uncovered;
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
	void setEstate(boolean hu){
		Uncovered=hu;
	}
	boolean getEstate(){
		return Uncovered;
	}
	


}
