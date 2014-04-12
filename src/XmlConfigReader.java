import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class XmlConfigReader{

    public static SystemParameters ReadConfig (String fileName){

    	SystemParameters params = new SystemParameters();
    	
    	try {
    		
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse (new File(fileName));

            doc.getDocumentElement().normalize ();
            
            // Log path
            NodeList logFilePath = doc.getElementsByTagName("logFilePath");
            if (logFilePath.getLength() == 0)
            	throw new ApplicationException("Config error: logFilePath value not set");
            
            params.setLogPath(logFilePath.item(0).getFirstChild().getNodeValue());
            Logger.logMessage("LogPath: " + params.getLogPath());
            
            
            // Database path
            NodeList databasePath = doc.getElementsByTagName("databasePath");
            if (databasePath.getLength() == 0)
            	throw new ApplicationException("Config error: databasePath value not set");
            
            params.setDatabase(databasePath.item(0).getFirstChild().getNodeValue());
            Logger.logMessage("Database Path: " + params.getDatabase());
            
            
            // Object Index List
            NodeList objectIndexList = doc.getElementsByTagName("objectIndexList");
            if (objectIndexList.getLength() == 0)
            	throw new ApplicationException("Config error: objectIndexList value not set");
            
            params.setObjectIndexList(objectIndexList.item(0).getFirstChild().getNodeValue());
            Logger.logMessage("Object Index List: " + params.getObjectIndexList());
            
            // Attribute Index List
            NodeList attributeIndexList = doc.getElementsByTagName("attributeIndexList");
            if (attributeIndexList.getLength() == 0)
            	throw new ApplicationException("Config error: attributeIndexList value not set");
            
            params.setAttributeIndexList(attributeIndexList.item(0).getFirstChild().getNodeValue());
            Logger.logMessage("Attribute Index List: " + params.getAttributeIndexList());
            
            
            return params;
            
        }catch (SAXParseException err) {
        	System.out.println ("** Parsing error" + ", line " + err.getLineNumber () + ", uri " + err.getSystemId ());
        	System.out.println(" " + err.getMessage ());
        	return null;
        }catch (SAXException e) {
        	Exception x = e.getException ();
        	((x == null) ? e : x).printStackTrace ();
        	return null;
        }catch (Throwable t) {
        	t.printStackTrace ();
        	return null;
        }

        
    }
}

	
