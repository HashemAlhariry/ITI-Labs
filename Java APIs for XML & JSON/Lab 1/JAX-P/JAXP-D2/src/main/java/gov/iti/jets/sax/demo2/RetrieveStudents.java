package gov.iti.jets.sax.demo2;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class RetrieveStudents {

    public void readingWithSax() throws Exception {

        StudentsHandler studentsHandler = new StudentsHandler();
        File xmlFile = new File(getClass().getResource("/students.xml").toURI());

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        saxParser.parse(xmlFile, studentsHandler);

        List<Student> students = studentsHandler.getStudents();
        System.out.println("Number of Students: " + students.size());
        for (Student student : students) {
            System.out.println(student);
        }

    }

}
