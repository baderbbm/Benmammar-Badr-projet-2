package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of ISymptomReader interface to read symptom data from a file.
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

  private String filepath;

  /**
  * Constructor for ReadSymptomDataFromFile class.
  *
  * @param filepath A full or partial path to file with symptom strings in it, one per line.
  */
  public ReadSymptomDataFromFile(String filepath) {
    this.filepath = filepath;
  }

  /**
  * Reads symptom data from a file and returns it as a list of strings.
  *
  * @return a list of strings containing the symptom data.
*/
  @Override
  public List<String> getSymptoms() {
    ArrayList<String> result = new ArrayList<String>();

    if (filepath != null) {
      try {
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String line = reader.readLine();
        while (line != null) {
          result.add(line);
          line = reader.readLine();
        }
        reader.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return result;
  }
}