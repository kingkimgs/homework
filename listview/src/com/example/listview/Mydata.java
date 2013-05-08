package com.example.listview;

public class Mydata {
	
	int image;
	String name;
	String tel;
	String email;
	
	public Mydata(int image,String name, String tel, String email){
		this.image = image;
		this.name = name;
		this.tel = tel;
		this.email = email;
	}
	
	public int getImage(){
		return image;
	}
	
	public String getName(){
		return name;
	}
	
	public String getTel(){
		return tel;
	}
	
	public String getEmail(){
		return email;
	}

}
