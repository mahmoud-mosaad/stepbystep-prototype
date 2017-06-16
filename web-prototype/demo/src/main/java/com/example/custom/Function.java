package com.example.custom;

public class Function {
	
	public boolean contains(String arr [], String s){
		for(int i=0;i<arr.length;i++)
			if (arr[i].equals(s))
				return true;
		return false;
	}
	
}
