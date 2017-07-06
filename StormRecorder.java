package a3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class StormRecorder {

	public static void main(String[] args) throws IOException, FileNotFoundException {
		BufferedReader kbd = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the name of a city");
		String input = kbd.readLine();
		while (!input.equals("exit")) { // != compares memory addresses.
			
			Scanner scanner = new Scanner(new FileInputStream("src/a3/StormList.txt"));
			ArrayList<String> list = new ArrayList<String>();
			ArrayList<City> listCity = new ArrayList<City>();
			while (scanner.hasNextLine()) {
				String[] record;
				String[] info;
	    		Storm storm;
			      record = scanner.nextLine().split("\\s\\|\\s");
			      info = record[0].split("\\s");
			      
			      storm = new Storm(info[0], Integer.parseInt(info[1]));
			      for (int i = 1; i < record.length; i++){
							if (list.contains(record[i])){
								for (int j = 0; j < listCity.size(); j++){
									if (listCity.get(j).getName().equals(record[i])){
										storm.addCity(listCity.get(j));
									}
								}
							}
							else{
								City c = new City(record[i]);
						    	  storm.addCity(c);
						    	  listCity.add(c);
						    	  list.add(record[i]);
							}
			      }
			}
			scanner.close();
			if (list.contains(input)){
				for (int j = 0; j < listCity.size(); j++){
					if (listCity.get(j).getName().equals(input)){
						System.out.println(listCity.get(j).toString());
					}
				}
				
			}
			else{
				System.out.println("This is not a valid city.");
			}
			
			input = kbd.readLine();
		}   
  }
}

