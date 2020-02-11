package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.Service.QueryService;
import com.example.Service.Trie;
import com.example.Service.TrieFactory;

@Configuration
public class Config {
	
	@Bean
	public Trie Trie(){
		return TrieFactory.init_Trie();
	}
	
	@Bean 
	public QueryService setQueryService(Trie trie){
		return new QueryService();
	}

}
