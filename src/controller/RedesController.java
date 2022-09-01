package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {

	private String os() {
		return System.getProperty("os.name");
	}
	
	
	
	public void ip() {
		String os = os();
		Process process;
		InputStream stream;
		InputStreamReader reader;
		BufferedReader bufferReader;
		String line;
		String adapter = "";
		String IPv4 = "";
		
		if(os.contains("Windows")) {
			try {
				process = Runtime.getRuntime().exec("ipconfig");
				stream = process.getInputStream();
				reader = new InputStreamReader(stream);
				bufferReader = new BufferedReader(reader);
				line = bufferReader.readLine();
				
				while(line != null) {
					
					if(line.contains("Adapt")) {
						 adapter = line;
					}
					
					if(line.contains("IPv4")) {
						IPv4 = line;
						System.out.println(adapter);
						System.out.println(IPv4);
					}
					
					line = bufferReader.readLine();	
					
					}
				
				bufferReader.close();
				stream.close();
				reader.close();
				}
			 catch (IOException e) {
				System.out.println(e);
			}
			
		}
		else {
			try {
				process = Runtime.getRuntime().exec("ifconfig");
				stream = process.getInputStream();
				reader = new InputStreamReader(stream);
				bufferReader = new BufferedReader(reader);
				line = bufferReader.readLine();
				
				while(line != null) {
					if(line.contains("Adap")) {
						adapter = line;
					}
					if(line.contains("IPv4")) {
						IPv4 = line;
						System.out.println(adapter);
						System.out.println(IPv4);
					}
					
					line = bufferReader.readLine();
				}
				bufferReader.close();
				stream.close();
				reader.close();
				
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
	}
	
	public void ping() {
		String os = os();
		Process process;
		InputStream stream;
		InputStreamReader reader;
		BufferedReader bufferReader;
		String line;
		String avg;
		String[] values = null;
		
		if(os.contains("Windows")) {
			try {
				process = Runtime.getRuntime().exec("ping -4 -n 10 www.google.com.br");
				stream = process.getInputStream();
				reader = new InputStreamReader(stream);
				bufferReader = new BufferedReader(reader);
				line = bufferReader.readLine();

				while(line != null) {
//					System.out.println(line);
					
					if(line.contains("dia")) {
						values = line.split(", ");
						values = values[2].split("=");
						avg = values[1].trim();
						System.out.println("Tempo medio: " + avg);
					}
					line = bufferReader.readLine();
					
				}
			} 
			catch (Exception e) {
				System.err.println("Error");
			}
		}
		
		else {
			
			try {
				process = Runtime.getRuntime().exec("ping -4 -c 10 www.google.com.br");
				stream = process.getInputStream();
				reader = new InputStreamReader(stream);
				bufferReader = new BufferedReader(reader);
				line = bufferReader.readLine();
				
				while(line != null) {
					if(line.contains("avg")) {
						values = line.split(" = ");
						values = values[1].split("/");
						avg = values[1].trim();
					}
				}
			}
			
			catch (Exception e) {
				System.err.println("Error");
			}
			
			
		}
	}
}
