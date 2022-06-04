package gov.iti.jets.sax.demo2;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class StudentsHandler extends DefaultHandler {

    private ArrayList<Student> students;
    private Student student;
    private String currentElement = "";
    private StringBuilder currentText;

    public ArrayList<Student> getStudents() {
        return students;
    }

    @Override
    public void startDocument() throws SAXException {
        students = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;

        switch (currentElement) {
            case "students":
                break;
            case "student":
                student = new Student();
                break;
            default:
                currentText = new StringBuilder();
                break;
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("students")) {
            return;
        }

        if (qName.equals("student")) {
            if (student.getName().contains("amin"))
                students.add(student);
            return;
        }

        String content = currentText.toString();

        switch (currentElement) {
            case "name":
                student.setName(content);
                break;
            case "age":
                student.setAge(Integer.parseInt(content));
                break;
            case "email":
                student.setEmail(content);
                break;
            case "phone":
                student.setPhone(content);
                break;
            case "track":
                student.setTrack(content);
                break;
            case "about":
                student.setAbout(content);
                break;
        }

        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        if (currentText != null) {
            currentText.append(ch, start, length);
        }

    }

}
