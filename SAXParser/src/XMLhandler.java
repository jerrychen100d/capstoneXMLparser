import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLhandler extends DefaultHandler {
	private List<GroupCommandEvents> eventList = new ArrayList<>();
	private SingleCommandEvent event = new SingleCommandEvent(null, null, null);
	private GroupCommandEvents gevent = new GroupCommandEvents(null);
	
	public List<GroupCommandEvents> getEventList() {
		return eventList;
	}
	
	boolean events = false;
	boolean commandEvents = false;
	boolean commandEvent = false;
	
	String cId = null;
	String count = null;
	String command = null;
	String date = null;
	
	Integer numOfEvents = 0;
	
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("Start Element: " + qName);
		if(qName.equalsIgnoreCase("EVENTS")){
			/*
			event = new SingleCommandEvent(null,null,null);
			if(eventList == null){*/
				numOfEvents++;
			/*}*/
		}
		else if(qName.equalsIgnoreCase("COMMANDEVENTS")){
			commandEvents = true;
			date = attributes.getValue("date");
			gevent.setDate(date);
			
			System.out.println("Date: " + date);
		}
		else if(qName.equalsIgnoreCase("COMMANDEVENT")){
			commandEvent = true;
			cId = attributes.getValue("commandId");
			count = attributes.getValue("count");
			System.out.println("CommandEvent: " + cId + " Count: " + count);
			event.setAll(cId, command, count);
		}		
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("End element: " + qName);
		if(qName.equalsIgnoreCase("COMMANDEVENTS")){
			eventList.add(gevent);
		}
		else if(qName.equalsIgnoreCase("COMMANDEVENT")){
			gevent.add(event);
		}	
	}
	
	public void characters(char ch[], int start, int length) throws SAXException {
		
		if(events){
			//System.out.println("Events: " + new String(ch, start, length));
			events = false;
		}
		else if(commandEvents){
			//System.out.println("Command Events: " + new String(ch, start, length));
			commandEvents = false;
			
		}
		else if(commandEvent){
			//System.out.println("Command Event: " + new String(ch, start, length));
			commandEvent = false;
			//event.setAll(cId, null, count);
			
		}
	} 
	
	
}
