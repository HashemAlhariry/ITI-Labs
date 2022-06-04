package gov.iti.jets;

import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.math.BigInteger;

import gov.iti.jets.dto.*;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        marshalling();
        //unmarshalling();

    }

    private static void marshalling() throws Exception {

        ObjectFactory objectFactory = new ObjectFactory();
        AddressType addressType = objectFactory.createAddressType();
        addressType.setNumber(25);
        addressType.setStreet("Said Alhariry");


        PersonType personType = objectFactory.createPersonType();
        personType.setName("Hashem Alhariry");
        personType.setAddress(addressType);

        BookType bookType = objectFactory.createBookType();
        bookType.setTitle("OCP");
        bookType.setTitle("FOR JAVA DEVLEOPER");
        bookType.setDate("24/4/2022");
        bookType.setISBN(BigInteger.valueOf(1122334455));
        bookType.setPerson(personType);
        bookType.setAddress(addressType);

        BookStore bookStore = objectFactory.createBookStoreType();
        bookStore.setBook(bookType);

        JAXBElement<BookStore> personJaxbElement = objectFactory.createBookStore(bookStore);

        JAXBContext jaxbContext = JAXBContext.newInstance("gov.iti.jets.dto");
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(personJaxbElement, new FileWriter("bookstore.xml"));

    }

    private static void unmarshalling() throws Exception {
        
        JAXBContext jaxbContext = JAXBContext.newInstance("gov.iti.jets.dto");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        JAXBElement<PersonType> personJaxbElement = (JAXBElement<PersonType>)unmarshaller.unmarshal(new FileReader("person.xml"));

        PersonType personType = personJaxbElement.getValue();

        System.out.println("Name: " + personType.getName());
        System.out.println("Address Number: " + personType.getAddress().getNumber());
        System.out.println("Address Street: " + personType.getAddress().getStreet());
    }

}
