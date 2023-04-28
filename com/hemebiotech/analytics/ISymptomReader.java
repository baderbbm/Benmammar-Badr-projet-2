package com.hemebiotech.analytics;

import java.io.IOException; 
import java.util.List;

/**
* If no data is available, return an empty List.
* @return a raw listing of all Symptoms obtained from a data source duplicates are possible/probable
*/

public interface ISymptomReader {
  List<String> getSymptoms() throws IOException;  
}