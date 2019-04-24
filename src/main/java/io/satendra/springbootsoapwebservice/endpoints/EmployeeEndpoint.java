package io.satendra.springbootsoapwebservice.endpoints;

import io.satendra.springbootsoapwebservice.dao.EmployeeDao;
import io.satendra.springbootsoapwebservice.entity.EmployeeEntity;
import localhost._8080.ns.employee.Employee;
import localhost._8080.ns.employee.EmployeeDetailsRequest;
import localhost._8080.ns.employee.EmployeeDetailsResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;
import java.util.Optional;


@Endpoint
public class EmployeeEndpoint {

    private static final String NAMESPACE_URI = "http://localhost:8080/ns/employee";

    @Autowired
    private EmployeeDao employeeDao;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "employeeDetailsRequest")
    @ResponsePayload
    public EmployeeDetailsResponse getStudent(@RequestPayload EmployeeDetailsRequest request) {


        EmployeeDetailsResponse employeeDetailsResponse = new EmployeeDetailsResponse();

        if (request.getId() == 0) {
            List<EmployeeEntity> employeeEntityList = employeeDao.findAll();

            employeeEntityList.forEach(f -> {
                Employee employee = new Employee();
                BeanUtils.copyProperties(f, employee);
                employeeDetailsResponse.getEmployee().add(employee);
            });

        } else {
            Optional<EmployeeEntity> employeeEntity = employeeDao.findById(request.getId());

            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeEntity.get(), employee);

            employeeDetailsResponse.getEmployee().add(employee);
        }


        return employeeDetailsResponse;

    }


}
