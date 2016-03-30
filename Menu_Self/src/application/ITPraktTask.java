package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;

import javafx.concurrent.Task;

public class ITPraktTask extends Task {
	String url;
	int port;
	String request;
	URL uri;
	public ITPraktTask(String url, int port){
		this.url = url;
		this.port = port;
	}
	@Override
	protected Object call() throws Exception {
		try {
			uri = new URL(url);
			Socket sock = new Socket(uri.getHost(),port);
			PrintWriter pw = new PrintWriter(sock.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			
			//send request
			request = "GET " + uri.getFile() + " HTTP/1.1 \r\n" + 
					  "Host: "+uri.getHost()+"\r\n"+
					  "\r\n";	
			System.out.println("REQUEST: "+request);
			pw.write(request);
			pw.flush();
			//get result
			
			String hallo;
			String conten="";
			double i=0;
			conten += "HTTP ANTWORT\n\n";
			while( !(hallo = br.readLine()).equals("")){
				
				//if(hallo.equals("\n"))conten +="HTTP CONTENT\n";
				conten += hallo + "\n";
				i += hallo.length();
				updateMessage(conten);	
				updateProgress(i,46925);
			}
			conten += "\nHTTP DATEN\n\n";
			
			while( (hallo = br.readLine()) != null){
				
				//if(hallo.equals("\n"))conten +="HTTP CONTENT\n";
				conten += hallo + "\n";
				i += hallo.length();
				updateMessage(conten);	
				updateProgress(i,46925);
			}
			System.out.println(conten.length());
			updateProgress(i,9999999);
			
			
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	

	
}
