package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;

// WRITE YOUR CODE HERE

public class Main {
    public static void main(String args[]) throws IOException {
        
       ISymptomReader r= new ReadSymptomDataFromFile ("symptoms.txt");
      ISymptomWriter w= new WriteSymptomDataToFile ();
      AnalyticsCounter a = new AnalyticsCounter (r, w);
      List<String> liste = a.getSymptoms();
     Map<String, Integer> map=a.countSymptoms(liste);
     map =a.sortSymptoms (map);
     a.writeSymptoms(map);     
    }   
}
