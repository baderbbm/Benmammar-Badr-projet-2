package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

  /**
  * Writes the symptom data to a file named "result.out".
  * 
  * @param symptoms the Map containing the symptom data to be written to the file
  */
  @Override
  public void writeSymptoms(Map<String, Integer> symptoms) {
    try (PrintWriter pw = new PrintWriter(new FileWriter("result.out"))) {
      for (Map.Entry<String, Integer> sortie : symptoms.entrySet()) {
        pw.println(sortie.getKey() + " : " + sortie.getValue());
      }
    } catch (IOException ex) {
      System.err.println("Erreur lors de l'écriture des symptômes dans le fichier " + filepath);
    }
    System.out.println("Résultat sauvegardé dans le fichier 'result.out'.");
  }
}