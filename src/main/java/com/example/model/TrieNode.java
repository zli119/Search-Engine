package com.example.model;

import java.util.HashMap;
import java.util.List;

public class TrieNode{
	public String val;
	public boolean isWord;
	public List<Doc_Info> doc_list;
	public HashMap<Character, TrieNode> children;
	public TrieNode(){
		isWord = false;
		val = "";
		children = new HashMap<Character, TrieNode>();
	}
}
