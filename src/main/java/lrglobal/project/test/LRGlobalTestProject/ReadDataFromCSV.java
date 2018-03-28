package lrglobal.project.test.LRGlobalTestProject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
//import org.apache.log4j.Logger;

import lrglobal.project.test.Model.HedgeFund;

public class ReadDataFromCSV {


	public ArrayList<HedgeFund> getAllData(String fileNameDefined) {

		//declaring a list to store all the records from csv file
		ArrayList<HedgeFund> result = new ArrayList<HedgeFund>();
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
				HedgeFund hedgeFund = new HedgeFund();

				// assign all the values of the hedge fund entity table 
				hedgeFund.setStockName(csvRecord.get(0));
				hedgeFund.setSymbol(csvRecord.get(1));
				hedgeFund.setType(csvRecord.get(2));
				hedgeFund.setShareHeld(Double.parseDouble(csvRecord.get(3)));
				hedgeFund.setMarketValue(Double.parseDouble(csvRecord.get(4)));
				// null cheking for all the values which have null constraint in the database 
				// if we dont check it it will give null pointer exception if any of the data is null
				if (csvRecord.get(5).equals("")) {
					hedgeFund.setPer_Portfolio(null);
				} else {
					hedgeFund.setPer_Portfolio(Double.parseDouble(csvRecord.get(5)));
				}
				//String ss=csvRecord.get(6);
				if (csvRecord.get(6).equals("")) {
					hedgeFund.setPrev_perPortfolio(null);
				} else {
					hedgeFund.setPrev_perPortfolio(Double.parseDouble(csvRecord.get(6)));
				}
				if (csvRecord.get(7).equals("")) {
					hedgeFund.setRanking(null);
				} else {
					hedgeFund.setRanking(Integer.parseInt(csvRecord.get(7)));
				}
				String vv=csvRecord.get(8);
				
				if (csvRecord.get(8).equals("")) {
					hedgeFund.setChangInshare(null);
				} else {
					hedgeFund.setChangInshare(Double.parseDouble(csvRecord.get(8)));
				}

				if (csvRecord.get(9).equals("")) {
					hedgeFund.setPerChange(null);
				} else {
					hedgeFund.setPerChange(Double.parseDouble(csvRecord.get(9)));
				}

				if (csvRecord.get(10).equals("")) {
					hedgeFund.setChangeType(null);
				} else {
					hedgeFund.setChangeType(csvRecord.get(10));
				}

				if (csvRecord.get(11).equals("N/A") || csvRecord.get(11).equals("No Data")) {
					hedgeFund.setOwnerShip(null);
				} else {
					hedgeFund.setOwnerShip(Double.parseDouble(csvRecord.get(11)));
				}
				if (csvRecord.get(12).equals("")) {
					hedgeFund.setQtrFirstOwned(null);
				} else {
					hedgeFund.setQtrFirstOwned(csvRecord.get(12));
				}
				if (csvRecord.get(13).equals("")) {
					hedgeFund.setSector(null);
				} else {
					hedgeFund.setSector(csvRecord.get(13));
				}
				if (csvRecord.get(14).equals("")) {
					hedgeFund.setSource_type(null);
				} else {
					hedgeFund.setSource_type(csvRecord.get(14));
				}

				
				App app=new App();
				String formatedDate=app.dateFormation(csvRecord.get(15).toString());
				hedgeFund.setSource_date(formatedDate);
				
				hedgeFund.setNameOfFund(csvRecord.get(16));

				// add one hedge fund row into the arraylist.
				result.add(hedgeFund);
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
