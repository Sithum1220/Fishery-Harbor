package lk.ijse.fisheryharbour.dto;

public class EmployeeDTO {
    private String employee_Id;
    private String email;
    private String first_Name;
    private String last_Name;
    private String contact_No;
    private String nic;
    private String password;
    private String user_Name;
    private String role;
    private String house_No;
    private String street;
    private String city;

    public EmployeeDTO() {
    }

    public EmployeeDTO(String employee_Id, String email, String first_Name, String last_Name, String contact_No, String nic,
                       String password, String user_Name, String role, String house_No, String street, String city) {
        this.employee_Id = employee_Id;
        this.email = email;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.contact_No = contact_No;
        this.nic = nic;
        this.password = password;
        this.user_Name = user_Name;
        this.role = role;
        this.house_No = house_No;
        this.street = street;
        this.city = city;
    }

    public String getEmployee_Id() {
        return employee_Id;
    }

    public void setEmployee_Id(String employee_Id) {
        this.employee_Id = employee_Id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public String getContact_No() {
        return contact_No;
    }

    public void setContact_No(String contact_No) {
        this.contact_No = contact_No;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getHouse_No() {
        return house_No;
    }

    public void setHouse_No(String house_No) {
        this.house_No = house_No;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "employee_Id='" + employee_Id + '\'' +
                ", email='" + email + '\'' +
                ", first_Name='" + first_Name + '\'' +
                ", last_Name='" + last_Name + '\'' +
                ", contact_No='" + contact_No + '\'' +
                ", nic='" + nic + '\'' +
                ", password='" + password + '\'' +
                ", user_Name='" + user_Name + '\'' +
                ", role='" + role + '\'' +
                ", house_No='" + house_No + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }


}
