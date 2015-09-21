package com.accolite.connect;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
public class CityList {
    InputStream inputStream;
    public CityList(InputStream inputStream) {
        this.inputStream = inputStream;// TODO Auto-generated constructor stub
    }
    public String[] read(){
        List resultList = new ArrayList();
        String[] cityName=new String[100];
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            String csvLine;
            reader.readLine();
            int i=0;
            while ((csvLine = reader.readLine()) != null) {
                String[] row = csvLine.split(",");
                if(i<100)
                {


                    cityName[i]=row[1].toString();
                    Log.d(toString()," this " +cityName[i]+"Ckeck");
                    i++;
                }

              //  Log.d(toString(), row[1] +"VIKAS");
                resultList.add(row);
            }


        }
        catch (IOException ex) {
            throw new RuntimeException("Error in reading CSV file: "+ex);
        }
        finally {
            try {
                inputStream.close();
            }
            catch (IOException e) {
                throw new RuntimeException("Error while closing input stream: "+e);
            }
        }
       // Log.d(toString(), cityName +"VIKS");
       // Log.d(toString(), cityName[6] +"VIKAS");


        return cityName;
    }

}
