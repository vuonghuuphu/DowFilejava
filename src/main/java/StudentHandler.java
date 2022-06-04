import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class StudentHandler  extends DefaultHandler {
    private List<Student> studentList = new ArrayList();
    private Student currentStudent = new Student();
    private boolean isFName = false;
    private boolean isLName = false;
    private boolean isNickName = false;
    private boolean isMarks = false;

    public List<Student> getlistStudent(){
        return studentList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//        Rollno = attributes.getValue("rollno");
        if (qName.equals("student")){
            currentStudent = new Student();
        }
        else if (qName.equals("firstname")){
            isFName = true;
        }
        else if (qName.equals("lastname")){
            isLName = true;
        }
        else if (qName.equals("nickname")){
            isNickName = true;
        }
        else if (qName.equals("marks")){
            isMarks = true;
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("student")){
            studentList.add(currentStudent);
        }
        else if (qName.equals("firstname")){
            isFName = false;
        }
        else if (qName.equals("lastname")){
            isLName = false;
        }
        else if (qName.equals("nickname")){
            isNickName = false;
        }
        else if (qName.equals("marks")){
            isMarks = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch,start,length);
        if (isFName){
            currentStudent.setfName(content);
        }
        else if (isLName){
            currentStudent.setlName(content);
        }
        else if (isNickName){
            currentStudent.setNickName(content);
        }
        else if (isMarks){
            currentStudent.setMarks(Integer.parseInt(content));
        }

    }
}
