package com.example.demo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

@Component
public class Translator {
    public static Map<String, String> wordTransalate = new ConcurrentHashMap<String, String>();
    
    static
    {
	wordTransalate.put("flower", "flower");
	wordTransalate.put("flor", "flower");
	wordTransalate.put("blume", "flower");
	wordTransalate.put("fiore", "flower");
	wordTransalate.put("ruchi", "ruchi");
	
    }
 
    public static String translate(String word){
       if(wordTransalate.containsKey(word)) {
	   return wordTransalate.get(word);
       }
       return null;
    }

}