package com.hemebiotech.analytics;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;


// WRITE YOUR CODE HERE

public class WriteSymptomDataToFile implements ISymptomWriter {

	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) { 
            
             try ( 
              PrintWriter pw = new PrintWriter(new FileWriter("result.out"))) {
          // browse through the table and record the results in the file
          
 // sortie of type Map.Entry<String, Integer>          
          for (Map.Entry<String, Integer> sortie : symptoms.entrySet()) { // entrySet() to obtain a set 
            
              pw.println(sortie.getKey() + " : " + sortie.getValue());
          } 
      }     catch (IOException ex) {
              
            }
    
    System.out.println("Résultat sauvegardé dans le fichier 'result.out'.");
	
	}
}