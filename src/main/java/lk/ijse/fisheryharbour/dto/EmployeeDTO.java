package lk.ijse.fisheryharbour.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
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

}
