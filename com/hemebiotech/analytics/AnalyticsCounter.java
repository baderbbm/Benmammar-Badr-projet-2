package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * The AnalyticsCounter class represents a symptom analysis counter. This class uses an instance
 * of ISymptomReader to read the symptoms, and an instance of ISymptomWriter to write the analysis
 * results.
 */
public class AnalyticsCounter {
 
  private ISymptomReader reader;
  private ISymptomWriter writer;
    
  /**
  * Constructs an AnalyticsCounter object.
  * 
  * @param reader the instance of ISymptomReader to read the symptoms.
  * @param writer the instance of ISymptomWriter to write the analysis results.
  */
  public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) { 
    this.reader = reader;
    this.writer = writer;
  }
        
  /**
  * This method retrieves the list of symptoms from the ISymptomReader instance.
  * 
  * @return the list of symptoms.
  */
  public List<String> getSymptoms() throws IOException {  
    return reader.getSymptoms();
  }

  /**
  * This method counts the number of occurrences of each symptom.
  * 
  * @param symptoms the list of symptoms to analyze.
  * @return a map containing the number of occurrences of each symptom.
  */
  public Map<String, Integer> countSymptoms(List<String> symptoms) {
    HashMap<String, Integer> map = new HashMap<>();
    symptoms.forEach(symptom -> {
      addToMap(map, symptom);
    });
    return map;
  }

  /**
  * This method sorts the provided map in alphabetical order of the keys.
  * 
  * @param symptoms the map to sort.
  * @return the map sorted in alphabetical order of the keys.
  */
  public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) { 
    return new TreeMap<>(symptoms);
  }

  /**
  * This method writes the results of the symptom analysis using the ISymptomWriter instance.
  * 
  * @param symptoms the map containing the number of occurrences of each symptom.
  */
  public void writeSymptoms(Map<String, Integer> symptoms) { 
    writer.writeSymptoms(symptoms);
  }
    
  /**
  * This method adds the symptom to the map by incrementing the counter if it already exists.
  * 
  * @param map the map to update.
  * @param symptom the symptom to add.
  */
  static void addToMap(Map<String, Integer> map, String symptom) {
    map.compute(symptom, (key, value) -> (value == null) ? 1 : value + 1);
  }
}
