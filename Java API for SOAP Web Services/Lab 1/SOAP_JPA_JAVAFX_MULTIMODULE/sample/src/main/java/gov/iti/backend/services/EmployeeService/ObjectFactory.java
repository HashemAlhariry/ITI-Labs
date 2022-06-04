
package gov.iti.backend.services.EmployeeService;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the gov.iti.backend.services.EmployeeService package. 
 * &lt;p&gt;An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DeleteEmployee_QNAME = new QName("http://services.backend.iti.gov/", "deleteEmployee");
    private final static QName _DeleteEmployeeResponse_QNAME = new QName("http://services.backend.iti.gov/", "deleteEmployeeResponse");
    private final static QName _EmployeeDto_QNAME = new QName("http://services.backend.iti.gov/", "employeeDto");
    private final static QName _GetAllEmployees_QNAME = new QName("http://services.backend.iti.gov/", "getAllEmployees");
    private final static QName _GetAllEmployeesResponse_QNAME = new QName("http://services.backend.iti.gov/", "getAllEmployeesResponse");
    private final static QName _Testing_QNAME = new QName("http://services.backend.iti.gov/", "testing");
    private final static QName _TestingResponse_QNAME = new QName("http://services.backend.iti.gov/", "testingResponse");
    private final static QName _UpdateEmployee_QNAME = new QName("http://services.backend.iti.gov/", "updateEmployee");
    private final static QName _UpdateEmployeeResponse_QNAME = new QName("http://services.backend.iti.gov/", "updateEmployeeResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: gov.iti.backend.services.EmployeeService
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeleteEmployee }
     * 
     */
    public DeleteEmployee createDeleteEmployee() {
        return new DeleteEmployee();
    }

    /**
     * Create an instance of {@link DeleteEmployeeResponse }
     * 
     */
    public DeleteEmployeeResponse createDeleteEmployeeResponse() {
        return new DeleteEmployeeResponse();
    }

    /**
     * Create an instance of {@link EmployeeDto }
     * 
     */
    public EmployeeDto createEmployeeDto() {
        return new EmployeeDto();
    }

    /**
     * Create an instance of {@link GetAllEmployees }
     * 
     */
    public GetAllEmployees createGetAllEmployees() {
        return new GetAllEmployees();
    }

    /**
     * Create an instance of {@link GetAllEmployeesResponse }
     * 
     */
    public GetAllEmployeesResponse createGetAllEmployeesResponse() {
        return new GetAllEmployeesResponse();
    }

    /**
     * Create an instance of {@link Testing }
     * 
     */
    public Testing createTesting() {
        return new Testing();
    }

    /**
     * Create an instance of {@link TestingResponse }
     * 
     */
    public TestingResponse createTestingResponse() {
        return new TestingResponse();
    }

    /**
     * Create an instance of {@link UpdateEmployee }
     * 
     */
    public UpdateEmployee createUpdateEmployee() {
        return new UpdateEmployee();
    }

    /**
     * Create an instance of {@link UpdateEmployeeResponse }
     * 
     */
    public UpdateEmployeeResponse createUpdateEmployeeResponse() {
        return new UpdateEmployeeResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteEmployee }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteEmployee }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.backend.iti.gov/", name = "deleteEmployee")
    public JAXBElement<DeleteEmployee> createDeleteEmployee(DeleteEmployee value) {
        return new JAXBElement<DeleteEmployee>(_DeleteEmployee_QNAME, DeleteEmployee.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteEmployeeResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteEmployeeResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.backend.iti.gov/", name = "deleteEmployeeResponse")
    public JAXBElement<DeleteEmployeeResponse> createDeleteEmployeeResponse(DeleteEmployeeResponse value) {
        return new JAXBElement<DeleteEmployeeResponse>(_DeleteEmployeeResponse_QNAME, DeleteEmployeeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmployeeDto }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EmployeeDto }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.backend.iti.gov/", name = "employeeDto")
    public JAXBElement<EmployeeDto> createEmployeeDto(EmployeeDto value) {
        return new JAXBElement<EmployeeDto>(_EmployeeDto_QNAME, EmployeeDto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllEmployees }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllEmployees }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.backend.iti.gov/", name = "getAllEmployees")
    public JAXBElement<GetAllEmployees> createGetAllEmployees(GetAllEmployees value) {
        return new JAXBElement<GetAllEmployees>(_GetAllEmployees_QNAME, GetAllEmployees.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllEmployeesResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllEmployeesResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.backend.iti.gov/", name = "getAllEmployeesResponse")
    public JAXBElement<GetAllEmployeesResponse> createGetAllEmployeesResponse(GetAllEmployeesResponse value) {
        return new JAXBElement<GetAllEmployeesResponse>(_GetAllEmployeesResponse_QNAME, GetAllEmployeesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Testing }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Testing }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.backend.iti.gov/", name = "testing")
    public JAXBElement<Testing> createTesting(Testing value) {
        return new JAXBElement<Testing>(_Testing_QNAME, Testing.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TestingResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TestingResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.backend.iti.gov/", name = "testingResponse")
    public JAXBElement<TestingResponse> createTestingResponse(TestingResponse value) {
        return new JAXBElement<TestingResponse>(_TestingResponse_QNAME, TestingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateEmployee }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateEmployee }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.backend.iti.gov/", name = "updateEmployee")
    public JAXBElement<UpdateEmployee> createUpdateEmployee(UpdateEmployee value) {
        return new JAXBElement<UpdateEmployee>(_UpdateEmployee_QNAME, UpdateEmployee.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateEmployeeResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateEmployeeResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.backend.iti.gov/", name = "updateEmployeeResponse")
    public JAXBElement<UpdateEmployeeResponse> createUpdateEmployeeResponse(UpdateEmployeeResponse value) {
        return new JAXBElement<UpdateEmployeeResponse>(_UpdateEmployeeResponse_QNAME, UpdateEmployeeResponse.class, null, value);
    }

}
