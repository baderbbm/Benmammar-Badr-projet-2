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
          while (a.hasNextLine()) { // tant que il y a des lignes qui n'ont pas été lus  
              String ligne = a.nextLine().trim(); // lire le fichier ligne par ligne
              if (!ligne.isEmpty()) Ajouter(map, ligne); // ajouter la ligne qui n'est pas vide dans le HashMap 
          } }
   
      try ( 
              PrintWriter pw = new PrintWriter(new FileWriter("result.out"))) {
          // Parcourir le tableau pour écrire les résultats dans le fichier
          
 // sortie de trype Map.Entry<String, Integer>          
          for (Map.Entry<String, Integer> sortie : map.entrySet()) { // entrySet() pour obtenir un ensemble 
            
              pw.println(sortie.getKey() + " : " + sortie.getValue());
          } 
      }
    
    System.out.println("Résultat sauvegardé dans le fichier 'result.out'.");
  }
  
  static void Ajouter(Map<String, Integer> map, String phrase) {
    Object k = map.get(phrase);
    if (k == null) map.put(phrase, var); // une nouvelle phrase est ajoutée
    else {
       // phrase déjà présente, sa valeur est incrémentée de 1
      int nb = ((Integer) k) + 1;
      map.put(phrase, nb);
    }
  }
}
