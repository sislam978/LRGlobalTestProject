package lrglobal.project.test.LRGlobalTestProject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


import lrglobal.project.test.Model.MacroData;

public class ReadSelectedMacro {
	
	public ArrayList<MacroData> getAllData(String fileNameDefined) throws ParseException {

		//declaring a list to store all the records from csv file
		ArrayList<MacroData> result = new ArrayList<MacroData>();
		String thisLine = null;
		try {
			//open a reader to read the csv file  
			Reader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileNameDefined), "utf-8"));
			// Files.newBufferedReader(Paths.get(fileNameDefined));
			//csv parser take all the records by parsing from the reader
			CSVParser csvParser = new CSVParser(br, CSVFormat.DEFAULT);
			//Now data is seprated as a set of records 
			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			int i = 0;
			//reading data AS records
			for (CSVRecord csvRecord : csvRecords) {
				if (i == 0) {
					//first row is the tickers thats why we skip it
					i++;
					continue;
				}
				//create an object to store records as a table row value
				MacroData macroData = new MacroData();
				String dateToformat=csvRecord.get(0).toString();
				App app=new App();
				String formatedDate=app.dateFormation(dateToformat);
				macroData.setDate(formatedDate);
				
				if(csvRecord.get(1).toString().equals(null)){
					macroData.setMacro_value(null);
				}
				else{
					macroData.setMacro_value(Double.parseDouble(csvRecord.get(1).toString()));
				}
				
				macroData.setMacro_name(csvRecord.get(2).toString());
				
				// add one macro data row into the arraylist.
				result.add(macroData);
			}
			// after loop, close scanner
			br.close();

		} catch (IOException e) {

			System.out.println("exception at reading: " + e);
		}
		//return the result
		return result;

	}


}
