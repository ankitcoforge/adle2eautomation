package utils;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XmlDataReader {
	String fileName;
	public XmlDataReader(String fileName){
		this.fileName=fileName;
	}

	


	public String getXMLData(String datafor)
      {
          String nodevalue = null;
          try{
        	  String fileLocation = System.getProperty("user.dir") + "/Resources/"+fileName+".xml";
//        	  String fileLocation = "C:/ADL Automation Git/adle2eautomation/Resources/"+fileName+".xml";
              String sourceXML = fileLocation;
              File file = new File(sourceXML);
              DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
              DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
              org.w3c.dom.Document document = documentBuilder.parse(file);
              nodevalue =  document.getElementsByTagName(datafor).item(0).getTextContent();
          }
      
          catch(Exception e)
          {
              nodevalue = null;
          }
          System.out.println(datafor+"--"+nodevalue);
          return nodevalue;
      }
	  
}


