import  org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class DownloadHandle {
    public static void main(String[] args) {
            File inputFile = new File("dependency.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = null;
            try {
                saxParser = factory.newSAXParser();
            } catch (ParserConfigurationException | SAXException e) {
                e.printStackTrace();
            }
            FileHandler fileHandler = new FileHandler();
            try {
                saxParser.parse(inputFile,fileHandler);
            } catch (SAXException | IOException e) {
                e.printStackTrace();
            }
            List<FileDow> list = fileHandler.getlist();
            for (FileDow fileDow : list) {
                String fileName = fileDow.getArtifactId()+"-"+fileDow.getVerion()+".jar";
        String fileLink = "https://repo1.maven.org/maven2/org/springframework/boot/"
                +fileDow.getArtifactId()+
                "/"+fileDow.getVerion()+
                "/"+fileName;
        dowload(fileName,fileLink);
                System.out.println(fileName);
            }
    }
    public static void dowload(String filename,String filelink){
        try {
            Connection.Response response = Jsoup.connect(filelink).ignoreContentType(true).execute();
            FileOutputStream out = (new FileOutputStream(filename));
            out.write(response.bodyAsBytes());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
