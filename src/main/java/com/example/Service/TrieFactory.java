package com.example.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Component;

import com.example.model.Doc_Info;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;


public class TrieFactory{
	private static Trie trie;
	private static final int total_docs = 50;
	public static Trie init_Trie(){
		if(trie != null) return trie;
		trie = new TrieImpl();
		MongoClient mongoClient = null;
		MongoDatabase mongoDatabase = null;
		try{
			mongoClient = new MongoClient( "localhost" , 27017 );
		       
	         // Register for Database
	        mongoDatabase = mongoClient.getDatabase("Search");  
	       System.out.println("Connect to database successfully");
	        
	      }catch(Exception e){
	        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        System.exit(0);
	     }
		
		MongoCollection<Document> collection = mongoDatabase.getCollection("search");
//		FindIterable<Document> iter = collection.find(new BasicDBObject("term","events"));
		
		
		FindIterable<Document> iter = collection.find();
		MongoCursor<Document> cursor = iter.iterator();
		HashSet<String> distinct_urls = new HashSet<String>();
		DocInfoComparator doc_info_comparator = new DocInfoComparator();
		while(cursor.hasNext()){
			Document temp = cursor.next();
			String term = (String) temp.get("term");
			
			//convert document into a list of Doc_Info and sort this list according to url. When query the search engine, 
			List<Doc_Info> info_list = converter((List<Document>) temp.get("docs"));
			for(Doc_Info info : info_list){
				distinct_urls.add(info.url);
			}
			Collections.sort(info_list, doc_info_comparator);
			trie.insert(term, info_list);
		}
		mongoClient.close();
		trie.setTotalDocs(distinct_urls.size());
		return trie;
	}
	
	private static List<Doc_Info> converter(List<Document> docs){
		ArrayList<Doc_Info> res = new ArrayList<Doc_Info>();
		for(Document doc : docs){
			Doc_Info info = new Doc_Info();
			info.url = doc.getString("url");
			info.title = doc.getString("title");
			info.tfidf = doc.getDouble("tfidf").doubleValue();
			res.add(info);
		}
		return res;
	}	
}

class DocInfoComparator implements Comparator<Doc_Info>{
	public int compare(Doc_Info info1, Doc_Info info2){
		return info1.url.compareTo(info2.url);
	}
}
