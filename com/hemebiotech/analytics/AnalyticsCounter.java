package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
 
    private final ISymptomReader reader;
    private final ISymptomWriter writer;
    
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
       ajouter (map,symptom);
        });
return map;
}

public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) { 
 return new TreeMap<>(symptoms);
}

public void writeSymptoms(Map<String, Integer> symptoms) { 
writer.writeSymptoms(symptoms);
}
    
  static void ajouter(Map<String, Integer> map, String symptom) {
map.compute(symptom, (key, value) -> (value == null) ? 1 : value + 1);
}
  
}
