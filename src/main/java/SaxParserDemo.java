import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SaxParserDemo {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = null;
        try {
            saxParser = factory.newSAXParser();
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
        StudentHandler studentHandler = new StudentHandler();
        try {
            saxParser.parse(inputFile,studentHandler);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
        List<Student> studentslist = studentHandler.getlistStudent();
        for (Student student : studentslist) {
            System.out.println(student.toString());
        }
    }
}
