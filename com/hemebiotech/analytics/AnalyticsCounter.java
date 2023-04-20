package com.hemebiotech.analytics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnalyticsCounter {
  static Integer var = 1;
  
  public static void main(String args[]) throws IOException {
   
    HashMap<String, Integer> map = new HashMap<>();
      try (Scanner a = new Scanner(new File("symptoms.txt"))) {
          while (a.hasNextLine()) { // there are lines that have not been read   
              String ligne = a.nextLine().trim(); // read the file line by line
              if (!ligne.isEmpty()) Ajouter(map, ligne); // add the line that is not empty in the HashMap 
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
  
  static void Ajouter(Map<String, Integer> map, String phrase) {
    Object k = map.get(phrase);
    if (k == null) map.put(phrase, var); // a new symptom is added
    else {
       // symptom already present, its value is incremented by 1
      int nb = ((Integer) k) + 1;
      map.put(phrase, nb);
    }
  }
}
