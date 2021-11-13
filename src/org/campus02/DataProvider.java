package org.campus02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataProvider {

    public static ArrayList<Incidence> getData() {

        ArrayList<Incidence> recordedValues = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("coviddata.csv"))){

            String line = "";
            while ((line = br.readLine()) != null) {
                String[] col = line.split(";");
                if (col[1].equals("oesterreich"))
                    continue;
                Incidence incidence = new Incidence(col[1], col[0], Integer.parseInt(col[2]));
                recordedValues.add(incidence);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return recordedValues;

    }
}
