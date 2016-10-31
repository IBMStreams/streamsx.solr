package com.ibm.streamsx.solrJavaTests;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

import com.ibm.streamsx.solr.LuceneStemmerEngine;

public class StemmerTest {
	static LuceneStemmerEngine solrStemmerEngine;
	private static String luceneMatchVersion = "LUCENE_51";
	private static String language = "English";
	private static String synonymFile = "synonyms.txt";
	private static String stopWordFile = "stopwords.txt";
	private static Boolean ignoreCase = true;
	private static Boolean expand = false; 
	private static String stemmerType = "snowball";
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		ClassLoader cl = ClassLoader.getSystemClassLoader();

        URL[] urls = ((URLClassLoader)cl).getURLs();

        for(URL url: urls){  
        	System.out.println(url.getFile());
        }
		System.out.println("Working Directory = " +
	              System.getProperty("user.dir"));
		solrStemmerEngine = new LuceneStemmerEngine(stemmerType, luceneMatchVersion, language, synonymFile, stopWordFile, ignoreCase, expand, true);
		String fullWords = "apples, bananas, hearing coding loving killing making be walked talked sorted love glove" ;  
		String stemmedTokens = solrStemmerEngine.getStems(fullWords);
		System.out.println(stemmedTokens);
	}

}
