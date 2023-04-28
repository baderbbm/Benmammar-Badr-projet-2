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
  public List<String> getSymptoms() throws IOException {  
    ArrayList<String> result = new ArrayList<String>();

    if (filepath != null) {
      BufferedReader reader = null;
      try {
        reader = new BufferedReader(new FileReader(filepath));
        String line = reader.readLine();
        while (line != null) {
          result.add(line);
          line = reader.readLine();
        }
      } catch (IOException e) {
        throw new IOException("Erreur lors de la lecture du fichier : " + filepath, e);
      } finally {
        if (reader != null) {
          reader.close();
        }
      }
    } else {
      throw new FileNotFoundException("Le chemin d'accès au fichier n'a pas été spécifié.");
    }
    return result;
  }
}