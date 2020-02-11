package com.example.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.model.Doc_Info;
import com.example.model.ResponseJSON;

public class QueryService{
	Trie trie;
	
	@Autowired
	public void setTrie(Trie trie){
		this.trie = trie;
	}
	
	public List<ResponseJSON> Query(String query){
		String[] terms = query.toLowerCase().split(" ");
		ArrayList<List<Doc_Info>> outerList = new ArrayList<List<Doc_Info>>();
		for(String term : terms){
			List<Doc_Info> term_list = new ArrayList<Doc_Info>(trie.query(term));
			
			
			if(!term_list.isEmpty())
				outerList.add(term_list);
		}
		
		//Map key is url. Double value is document relevance
		HashMap<String, ResponseJSON> map = new HashMap<String, ResponseJSON>();
		for(List<Doc_Info> innerList : outerList){
			for(Doc_Info info : innerList){
				if(!map.containsKey(info.url))
					map.put(info.url, new ResponseJSON(info.url, info.title, 0.0));
				map.get(info.url).setRanking(map.get(info.url).getRanking() + info.tfidf);
			}
		}
		
		//TODO: Remove this return statement. And add logic to process multi-list.
		ArrayList<ResponseJSON> res = new ArrayList<ResponseJSON>();
		for(Map.Entry<String, ResponseJSON> entry : map.entrySet()){
			res.add(entry.getValue());
		}
		
		return res;

	}
}