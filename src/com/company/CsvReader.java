package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by am92200 on 2017-11-16.
 */
public class CsvReader {

    public CsvReader() {

    }

    public ArrayList<String[]> readFile(String fileName) {
        ArrayList<String[]> content = new ArrayList<String[]>();
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();

            while (line != null) {
                content.add(line.split(","));
                line = br.readLine();
            }
        }
        catch(FileNotFoundException ex) {
            System.err.println("File not found: " + fileName);
            ex.printStackTrace();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return content;
    }
}
