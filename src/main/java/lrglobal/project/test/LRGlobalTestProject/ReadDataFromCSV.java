package lrglobal.project.test.LRGlobalTestProject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
//import org.apache.log4j.Logger;

import lrglobal.project.test.Model.HedgeFund;

public class ReadDataFromCSV {

	// static Logger logger = Logger.getLogger(ReadDataFromCSV.class);

	public ArrayList<HedgeFund> getAllData(String fileNameDefined) {

		ArrayList<HedgeFund> result = new ArrayList<HedgeFund>();
		// -define .csv file in app
		// String fileNameDefined = "HedgeFund.csv";
		// -File class needed to turn stringName to actual file
		// File file = new File(fileNameDefined);
		String thisLine = null;
		try {
			// -read from filePooped with Scanner class
			// Scanner sc= new Scanner(System.in);
			// String line = "";
			// int lineNumber=sc.nextInt();
			Reader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileNameDefined), "utf-8"));
			// Files.newBufferedReader(Paths.get(fileNameDefined));
			CSVParser csvParser = new CSVParser(br, CSVFormat.DEFAULT);
			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			int i = 0;
			for (CSVRecord csvRecord : csvRecords) {
				if (i == 0) {
					i++;
					continue;
				}
				HedgeFund hedgeFund = new HedgeFund();

				hedgeFund.setStockName(csvRecord.get(0));
				hedgeFund.setSymbol(csvRecord.get(1));
				hedgeFund.setType(csvRecord.get(2));
				hedgeFund.setShareHeld(Double.parseDouble(csvRecord.get(3)));
				hedgeFund.setMarketValue(Double.parseDouble(csvRecord.get(4)));
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

				hedgeFund.setSource_date(csvRecord.get(15));
				hedgeFund.setNameOfFund(csvRecord.get(16));

				result.add(hedgeFund);
				// read single line, put in string
				// String data = csvRecord.get(1);
				// result.add(data);

			}
			// after loop, close scanner
			br.close();

		} catch (IOException e) {

			System.out.println("exception at reading: " + e);
		}
		return result;

	}

}
