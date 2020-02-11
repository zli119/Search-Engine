package com.example.model;

public class Doc_Info{
	public String title;
	public String url;
	public Double tfidf;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "title: "+ title+"\n" + "url: "+ url +"\n" +"tfidf: "+ Double.toString(tfidf) +"\n\n";
	}
}