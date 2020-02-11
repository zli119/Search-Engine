package com.example.Service;

import com.example.model.TrieNode;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Doc_Info;

public class TrieImpl implements Trie{
	TrieNode root;
	private int total_docs = 0;
	
	public TrieImpl(){
		root = new TrieNode();
	}
	
	public void insert(String word, List<Doc_Info> info_list){
		char[] arr = word.toLowerCase().toCharArray();
		TrieNode curr = root;
		for(int i = 0; i < word.length(); i++){
			if(!curr.children.containsKey(arr[i])){
				curr.children.put(arr[i], new TrieNode());
			}
			
			curr = curr.children.get(arr[i]);
			
			if(i == word.length() - 1){
				curr.isWord = true;
				curr.val = word;
				curr.doc_list = info_list;
			}
		}
	}
	
	
	public List<Doc_Info> query(String word){
		char[] arr = word.toCharArray();
		TrieNode curr = root;
		for(int i = 0; i < word.length(); i++){
			if(!curr.children.containsKey(arr[i]))
				return new ArrayList<Doc_Info>();
			curr = curr.children.get(arr[i]);
		}
		
		if(curr.isWord)
			return curr.doc_list;
		else 
			return new ArrayList<Doc_Info>();
	}
	
	public void setTotalDocs(int total_docs){
		this.total_docs = total_docs;
	}




}
