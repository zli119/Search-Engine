package com.example.Service;

import java.util.List;

import com.example.model.Doc_Info;

public interface Trie {
	
	public void insert(String str, List<Doc_Info> info_list);
	public List<Doc_Info> query(String word);
	public void setTotalDocs(int total_docs);

}
