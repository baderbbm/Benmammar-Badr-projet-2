package com.hemebiotech.analytics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AnalyticsCounter {
 
    private ISymptomReader reader;
    private ISymptomWriter writer;
    
public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) { 
    this.reader=reader;
   this.writer=writer;
}
        
public List<String> getSymptoms() {  
    return reader.getSymptoms();
}

public Map<String, Integer> countSymptoms(List<String> symptoms) {
    HashMap<String, Integer> map = new HashMap<>();
    symptoms.forEach(symptom -> {
        map.compute(symptom, (key, value) -> (value == null) ? 1 : value + 1);
        });
return map;
}

public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) { 
 return new TreeMap<>(symptoms);
}

public void writeSymptoms(Map<String, Integer> symptoms) { 
writer.writeSymptoms(symptoms);
}
  
  public static void main(String args[]) throws IOException {
   
    HashMap<String, Integer> map = new HashMap<>();
      try (Scanner a = new Scanner(new File("symptoms.txt"))) {
          while (a.hasNextLine()) { // there are lines that have not been read   
              String ligne = a.nextLine().trim(); // read the file line by line
              if (!ligne.isEmpty()) ajouter(map, ligne); // add the line that is not empty in the HashMap 
          } }
   
      try ( 
              PrintWriter pw = new PrintWriter(new FileWriter("result.out"))) {
          // browse through the table and record the results in the file
          
 // sortie of type Map.Entry<String, Integer>          
          for (Map.Entry<String, Integer> sortie : map.entrySet()) { // entrySet() to obtain a set 
            
              pw.println(sortie.getKey() + " : " + sortie.getValue());
          } 
      }
    
    System.out.println("Résultat sauvegardé dans le fichier 'result.out'.");
  }
  
  static void ajouter(Map<String, Integer> map, String phrase) {
map.compute(phrase, (key, value) -> (value == null) ? 1 : value + 1);
}
  
}
