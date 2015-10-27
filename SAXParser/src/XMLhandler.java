import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLhandler extends DefaultHandler {
	private List<GroupCommandEvents> eventList = new ArrayList<>();
	private SingleCommandEvent event; //= new SingleCommandEvent(null, null, null);
	private GroupCommandEvents gevent; //= new GroupCommandEvents(null);
	
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
		//System.out.println("1. Start Element: " + qName);
		if(qName.equalsIgnoreCase("EVENTS")){
			
		}
		else if(qName.equalsIgnoreCase("COMMANDEVENTS")){
			commandEvents = true;
			date = attributes.getValue("date");
			gevent = new GroupCommandEvents(date);
			
			//System.out.println("Date: " + date);
		}
		else if(qName.equalsIgnoreCase("COMMANDEVENT")){
			commandEvent = true;
			cId = attributes.getValue("commandId");
			count = attributes.getValue("count");
			
			String[] part = cId.split("\\.");
			command = part[part.length-1];
			
			event = new SingleCommandEvent(cId, command, count);
			
			//System.out.println("CommandEvent: " + cId + " Count: " + count);
		}		
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException {
		//System.out.println("3. End element: " + qName);
		if(qName.equalsIgnoreCase("COMMANDEVENTS")){
			eventList.add(gevent);
		}
		else if(qName.equalsIgnoreCase("COMMANDEVENT")){
			gevent.add(event);
		}	
	}
	
	public void characters(char ch[], int start, int length) throws SAXException {
		//System.out.println("2. Characters function");
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
		}
	} 
}
