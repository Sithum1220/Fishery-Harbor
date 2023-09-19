package lk.ijse.fisheryharbour.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class OwnerDTO {
    private String owner_Id;
    private String email;
    private String first_Name;
    private String last_Name;
    private String owner_Role;
    private String contact_No;
    private String nic;
    private String House_No;
    private String street;
    private String city;
    private String date;
    private String time;
}
