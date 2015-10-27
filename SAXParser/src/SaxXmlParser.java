import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

public class SaxXmlParser {
	
	public static void main(String args[]){
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = factory.newSAXParser();
			XMLhandler handler = new XMLhandler();
			
			saxParser.parse(new File(args[0]), handler);
			
			List<GroupCommandEvents> eventList = handler.getEventList();
			
			for(GroupCommandEvents gce : eventList){
				System.out.println(gce.toString());
			}
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
}
