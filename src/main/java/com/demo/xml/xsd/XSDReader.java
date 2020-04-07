/*package com.demo.xml.xsd;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.XMLConstants;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.sun.org.apache.xerces.internal.impl.dtd.DTDGrammar;
import com.sun.org.apache.xerces.internal.impl.dtd.XMLDTDLoader;
import com.sun.org.apache.xerces.internal.util.SAXInputSource;
import com.sun.org.apache.xerces.internal.xni.parser.XMLInputSource;
import com.sun.xml.internal.ws.developer.MemberSubmissionAddressing.Validation;

public class XSDReader {
    public static void main(String[] args) throws Exception {
        // minimal example DTD
    	
    	File file  = new File("C:/Users/sbharatha/Documents/WorkStation_Spring/DemoAPI/src/main/resources/suppa.dtd");
        StringWriter sw = new StringWriter();
        sw.write("<!DOCTYPE html [");
        sw.write("  <!ELEMENT html (head, body)>");
        sw.write("  <!ELEMENT head (title)> <!ELEMENT title (#PCDATA)>");
        sw.write("  <!ELEMENT body (p+)> <!ELEMENT p (#PCDATA)>");
        sw.write("]>");
        
        StringBuilder sbuild = new StringBuilder();
        try(BufferedReader br = Files.newBufferedReader(Paths.get("C:/Users/sbharatha/Documents/WorkStation_Spring/DemoAPI/src/main/resources/suppa.dtd"))){
        	String line;
        	while((line = br.readLine())!= null) {
        		sbuild.append(line).append("\n"); 
        	}
        }catch(IOException e) {
        	e.printStackTrace();
        	
        }

        // read DTD
        InputStream dtdStream = new ByteArrayInputStream(sw.toString().getBytes());
        //InputStream dtdStream = So26391485.class.getResourceAsStream("your.dtd");
        Scanner scanner = new Scanner(dtdStream);
        String dtdText = scanner.useDelimiter("\\z").next();
        scanner.close();

        // DIRTY: use Xerces internals to parse the DTD
        Pattern dtdPattern = Pattern.compile("^\\s*<!DOCTYPE\\s+(\\S+)\\s*\\[(.*)\\]>\\s*$", Pattern.DOTALL);
        Matcher m = dtdPattern.matcher(dtdText);
        if (m.matches()) {
            String docType = m.group(1);
            InputSource is = new InputSource(new StringReader(m.group(2)));
            XMLInputSource source = new SAXInputSource(is);
            XMLDTDLoader d = new XMLDTDLoader();
            DTDGrammar g = (DTDGrammar) d.loadGrammar(source);
            g.printElements();
        }
    }
    
    public static void validation(String xsdFile, InputStream xmlInput) throws SAXException, IOException
	{
		SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		URL xsdURL = Validation.class.getClassLoader().getResource(xsdFile);
		if(xsdURL != null)
		{
			Schema schema = factory.newSchema(xsdURL);
			Validator validator = schema.newValidator();
//			validator.setErrorHandler(new AutoErrorHandler());

			Source source = new StreamSource(xmlInput);
			
			try(OutputStream resultOut = new FileOutputStream(new File( xsdFile , "C:/Users/sbharatha/Documents/WorkStation_Spring/DemoAPI/src/main/resources/classification_xml")))
			{
				Result result = new StreamResult(resultOut);
				validator.validate(source, result);
			}
		}
		else
		{
			throw new FileNotFoundException(String.format("can not found xsd file [%s] from classpath.", xsdFile));
		}
	}
 
}
*/