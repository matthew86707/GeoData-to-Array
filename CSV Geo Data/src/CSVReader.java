import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
	
	public static void startReading(){

		CSVSettings.COL_LAT = Integer.parseInt(MainWindow.latIn.getText());
		CSVSettings.COL_LON = Integer.parseInt(MainWindow.lonIn.getText());
		System.out.println("Reading from Columns -> Lat:" + CSVSettings.COL_LAT + " Lon:" + CSVSettings.COL_LON);
		
		String csvFile = CSVSettings.FILE;
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

			        // use comma as separator
				String[] country = line.split(cvsSplitBy);

				System.out.println("Coords [Lat= " + country[CSVSettings.COL_LAT] 
	                                 + " , Lon=" + country[CSVSettings.COL_LON] + "]");
				float latVal = 0f;
				float lonVal = 0f;
				try{
				latVal = Float.valueOf(country[CSVSettings.COL_LAT]) - 31.98f ;
				lonVal = Float.valueOf(country[CSVSettings.COL_LON]) + 118f;
				}catch(Exception e){
					
				}
				try{
				Data.grid[(int) (latVal * 1000) - 500][(int) (lonVal * 1000) - 500]++;
				}catch(Exception e){
					
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("Done");
	  }

		
	}


