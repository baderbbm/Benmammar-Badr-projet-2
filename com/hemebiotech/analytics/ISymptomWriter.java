package com.hemebiotech.analytics; 

import java.util.Map;

/**
 * Anything the will write symptom data on a valid data output format.
 *
 */
public interface ISymptomWriter {

  /**
  * This method writes the symptom data to a valid data output format.
  * 
  * @param symptoms the symptom data to write.
  */
  public void writeSymptoms(Map<String, Integer> symptoms);
}