package com.example.model;

public class ResponseJSON {
	private String url;
	
	private String title;
	
	private Double ranking;
	
	public ResponseJSON(String url, String title, Double ranking){
		this.url = url;
		this.title = title;
		this.ranking = ranking;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getRanking() {
		return ranking;
	}

	public void setRanking(Double ranking) {
		this.ranking = ranking;
	}
	
	
}
