package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Main class for the symptom analytics program.
 */
public class Main {

  /**
  * Main method to run the symptom analytics program.
  *
  * @param args the command-line arguments.
  * @throws IOException if an I/O error occurs.
  */
  public static void main(String [] args) throws IOException {
    ISymptomReader symptomReader = new ReadSymptomDataFromFile("symptoms.txt");
    ISymptomWriter resultWriter = new WriteSymptomDataToFile("result.out");
    AnalyticsCounter analyticsCounter = new AnalyticsCounter(symptomReader, resultWriter);
    List<String> liste = analyticsCounter.getSymptoms();
    Map<String, Integer> map = analyticsCounter.countSymptoms(liste);
    map = analyticsCounter.sortSymptoms(map);
    analyticsCounter.writeSymptoms(map);
  }
}