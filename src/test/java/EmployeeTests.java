import models.Employee;
import models.LombokEmployeeData;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.is;

public class EmployeeTests{

    @Test
    public void createEmployeeTest(){

        Employee employee = new Employee();
        employee.setEmployeeName("Mario");
        employee.setEmployeeSalary("40000");
        employee.setEmployeeAge("34");

        given()
                .spec(BaseSpec.baseSpec)
                .body(employee)
                .when()
                .post(Endpoints.CREATE.getEndpoint())
                .then()
                .spec(BaseSpec.baseResponse);

    }

    @Test
    public void getEmployeeTest(){
        LombokEmployeeData employee = given()
                .spec(BaseSpec.baseSpec)
                .when()
                .get(Endpoints.EMPLOYEE_ID.getEndpoint() + "5")
                .then()
                .spec(BaseSpec.baseResponse)
                .log().body()
                .extract().as(LombokEmployeeData.class);
        assertThat(employee.getEmployee().getEmployeeName()
                .equalsIgnoreCase("Airi Satou"));
    }

    @Test
    public void employeeOfCertainAge(){
        given()
                .spec(BaseSpec.baseSpec)
                .when()
                .get(Endpoints.EMPLOYEES.getEndpoint())
                .then()
                .log().body()
                .spec(BaseSpec.baseResponse)
                .body("data.findAll{it.employee_age == 55}.employee_name", is("[Rhona Davidson]"));
    }
}
