package com.example.demo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;

@Component
public class WordCount{

    private Map<String, Integer> wordCountMap = new ConcurrentHashMap<String, Integer>();

    @Autowired
    public Translator translator;

    public boolean addWord(String word) {
	if(StringUtils.isEmpty(word) || !checkIfAlphaNumeric(word)){
	    return false;
	}
	word = Translator.translate(word.toLowerCase());

	if(word != null) {
	    if(wordCountMap.containsKey(word)){
		wordCountMap.put(word, wordCountMap.get(word)+1);
		return true;
	    }else{
		wordCountMap.put(word, 1);
		return true;
	    }
	} else {
	    return false;
	}
    }

    public Integer getCount(String word) {
	if(word == null || word.trim().equals(""))
	    return 0;
	else {
	    word = Translator.translate(word.toLowerCase());
	    if(word != null && wordCountMap.containsKey(word))
		return wordCountMap.get(word);
	    else
		return 0;

	}
    }

    private boolean checkIfAlphaNumeric(String word){

	Pattern pattern = Pattern.compile("^[a-zA-Z]*$");
	Matcher matcher = pattern.matcher(word);
	return matcher.matches();
    }

}
