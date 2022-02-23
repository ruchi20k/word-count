package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
public class WordCountTest {

    @Autowired
    public WordCount wordCount;

    @ParameterizedTest
    @CsvSource({
	"flower, true",
	", false",
	"12345, false",
	"ruchi, true"
    })
    public void testAddWords(String word, boolean expectedValue) {
	assertThat(wordCount.addWord(word)).isEqualTo(expectedValue);
    }
    
    
    @ParameterizedTest
    @CsvSource({
	"flower, 1",
	", 0",
	"12345, 0",
	"ruchi, 1",
	"ruchi, 2"
    })
    public void testGetCount(String word, int expectedValue) {
	wordCount.addWord(word);
	assertThat(wordCount.getCount(word)).isEqualTo(expectedValue);
    }
}
