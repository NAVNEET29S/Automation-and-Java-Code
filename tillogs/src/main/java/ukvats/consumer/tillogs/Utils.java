package ukvats.consumer.tillogs;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

public class Utils {
	
	public static SOAPMessage readSoapMessage(String soap) throws SOAPException, FileNotFoundException {
		InputStream is = new ByteArrayInputStream(soap.getBytes());
		SOAPMessage message = null;
		try {
			message = MessageFactory.newInstance().createMessage(null, is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return message;
	}
	
	public static boolean isRequest(String soap) throws SOAPException {
		SOAPMessage message = null;
        try {
        	message= readSoapMessage(soap);
        	if(message.getSOAPBody().getChildNodes().item(0).getNodeName().contains("Request")) {
        		return true;
        	}
		} catch (FileNotFoundException e2) {
			//e2.printStackTrace();
		}
		return false;
	}
	
	public static boolean isResponse(String soap) throws SOAPException {
		SOAPMessage message = null;
        try {
        	message= readSoapMessage(soap);
        	if(message.getSOAPBody().getChildNodes().item(0).getNodeName().contains("Response")) {
        		return true;
        	}
		} catch (FileNotFoundException e2) {
			//e2.printStackTrace();
		} 
		return false;
	}
	
	public static HashMap<String, TiLLogs> readDataFile(BufferedReader reader) throws IOException {
		
		HashMap<String, TiLLogs> logUnit = null;
		if(reader!=null) {
			String logs = null;
			
			while(reader.ready()) {
				String line = reader.readLine();
				
				if(logs!=null) {
					logs = logs+"\n"+line;
				} else {
					logs = line;
				}
				
				if(line.contains("Body:")) {
					String soap = reader.readLine();
					logs = logs+"\n"+soap;
					try {
						if(isRequest(soap)) {
							logUnit = new HashMap<String, TiLLogs>();
							logUnit.put("request", getLogUnitObject(logs));
							break;
							
						} else if (isResponse(soap)) {
							logUnit = new HashMap<String, TiLLogs>();
							logUnit.put("response", getLogUnitObject(logs));
							break;
						}
					} catch(SOAPException ex) {
						//ex.printStackTrace();
					}
					
				}
				
			}
		}
		return logUnit;
	}
	
	public static TiLLogs getLogUnitObject(String lines) {
		String[] line = lines.split("\n");
		TiLLogs tiLLogs = new TiLLogs();
		for (int i = 0; i < line.length; i++) {
			if(line[i].toString().contains("SystemTimestamp")) {
				tiLLogs.setSystemTimestamp(line[i]);
			}
			else if(line[i].toString().contains("JMSCorrelationID")) {
				tiLLogs.setJmsCorrelationID(line[i]);
			}
			else if(line[i].toString().contains("SoapAction")) {
				tiLLogs.setSoapAction(line[i]);
			}		
			else if(line[i].toString().contains("Body")) {
				i++;
				tiLLogs.setBody(line[i]);
				try {
					tiLLogs.setMSISDN(Long.parseLong(getMSISDN(line[i])));
				} catch(NumberFormatException e) {
					System.out.println("Not Getting Log in MSISDN");
				}
			}
			
		}
		System.out.println("TilLogs "+tiLLogs );
		return tiLLogs;
	}
	
	public static String getMSISDN(String body) {
		try {
			if(!isRequest(body)) {
				return null;
			}
		} catch(SOAPException ex) {
			//ex.printStackTrace();
		}
		
        SOAPMessage message = null;
        String MSISDN  = null;
        try {
        	message= readSoapMessage(body);
        	MSISDN  = message.getSOAPBody().getChildNodes().item(0).getChildNodes().item(0).getChildNodes().item(0).getChildNodes().item(3).getChildNodes().item(0).getChildNodes().item(0).getTextContent();
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		} catch (SOAPException e2) {
			e2.printStackTrace();
		}
        return MSISDN;
	}

}
