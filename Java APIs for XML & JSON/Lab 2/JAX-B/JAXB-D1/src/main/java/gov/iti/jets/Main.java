package gov.iti.jets;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import gov.iti.jets.dto.Address;
import gov.iti.jets.dto.Student;
import gov.iti.jets.dto.Students;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
         //marshalling();
         //unmarshalling();
         marshalling2();
         unmarshalling();

    }

    private static void marshalling() throws Exception {

        Address address = new Address("egypt", "giza", "28 street");
        List<Address> addresses = new ArrayList<>();
        addresses.add(address);
        List<String> hobbies = new ArrayList<>(){{add("Swimming"); add("Running");}};
        Student student = new Student(123, "Hashem", "hashemalhariry@iti.gov.eg", 24, addresses, hobbies);

        List<Student> studentsList = new ArrayList<>();
        studentsList.add(student);
        studentsList.add(student);
        Students students = new Students();
        students.setStudents(studentsList);

        JAXBContext jaxbContext = JAXBContext.newInstance(Students.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(students, new FileWriter("hamadas.xml"));

    }

    private static void unmarshalling() throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Student student = (Student)unmarshaller.unmarshal(new FileReader("hashem.xml"));
        System.out.println(student);
    }

    private static void marshalling2() throws Exception {

        Address address  =  new Address("Egypt", "giza", "28 street");
        Address address1 = new Address("Egypt", "Cairo", "NEW Cairo");
        Address address2 = new Address("Egypt", "Cairo", "NEW Cairo");
        Address address3 = new Address("Egypt", "Cairo", "NEW Cairo");
        Address address4 = new Address("Egypt", "Cairo", "NEW Cairo");
        List<Address> addresses = new ArrayList<>();
        addresses.add(address);
        addresses.add(address1);
        addresses.add(address2);
        addresses.add(address3);
        addresses.add(address4);
        List<String> hobbies = new ArrayList<>(){{add("Swimming"); add("Running"); add("Playing football");}};

        Student student = new Student(123, "HASHEM", "hashem@gmail.com", 24, addresses, hobbies);

        JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(student, new FileWriter("hashem.xml"));


    }

}
