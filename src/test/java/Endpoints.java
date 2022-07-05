public enum Endpoints {
    CREATE("/create"),
    UPDATE_ID("/update/"),
    DELETE_ID("/delete/"),
    EMPLOYEE_ID("/employee/"),
    EMPLOYEES("/employees");

    private String endpoint;

    Endpoints(String endpoint){this.endpoint = endpoint;}

    public String getEndpoint(){return endpoint;}
}
