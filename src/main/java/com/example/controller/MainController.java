package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.example.Service.QueryService;
import com.example.Service.Trie;
import com.example.model.Doc_Info;
import com.example.model.ResponseJSON;

@Controller
public class MainController {
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	@ResponseBody
	public List<Doc_Info> index(){
		List<Doc_Info> list = trie.query("machine");
		return list;
		
	}
	
	private Trie trie;
	
	
	@Autowired
	public void setTrie(Trie trie){
		this.trie = trie;
	}
	
	private QueryService queryService;
	
	@Autowired
	public void setQueryService(QueryService qs){
		this.queryService = qs;
	}
	
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	@ResponseBody
	public List<ResponseJSON> engine(@RequestParam(value = "terms") String terms){
		System.out.println(terms);
		return queryService.Query(terms);
		
	}
	
	
	
}


@Configuration  
class MvcConfigurer extends WebMvcConfigurerAdapter {  
  
    @Override  
    public void addViewControllers(ViewControllerRegistry registry) {  
        registry.addViewController("/index").setViewName("index.html");  
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);  
    }  
  
    @Override  
    public void configurePathMatch(PathMatchConfigurer configurer) {  
        super.configurePathMatch(configurer);  
        configurer.setUseSuffixPatternMatch(false);  
    }  
  
  
}  
