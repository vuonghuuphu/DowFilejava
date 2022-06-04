import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class FileHandler  extends DefaultHandler {
    private List<FileDow> fileList = new ArrayList();
    private FileDow currentStudent = new FileDow();
    private boolean isgroupId = false;
    private boolean isartifactId = false;
    private boolean isverion = false;

    public List<FileDow> getlist(){
        return fileList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("dependency")){
            currentStudent = new FileDow();
        }
        else if (qName.equals("groupId")){
            isgroupId = true;
        }
        else if (qName.equals("artifactId")){
            isartifactId = true;
        }
        else if (qName.equals("verion")){
            isverion = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("dependency")){
            fileList.add(currentStudent);
        }
        else if (qName.equals("groupId")){
            isgroupId = false;
        }
        else if (qName.equals("artifactId")){
            isartifactId = false;
        }
        else if (qName.equals("verion")){
            isverion = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch,start,length);
        if (isgroupId){
            currentStudent.setGroupId(content);
        }
        else if (isartifactId){
            currentStudent.setArtifactId(content);
        }
        else if (isverion){
            currentStudent.setVerion(content);
        }
    }
}
