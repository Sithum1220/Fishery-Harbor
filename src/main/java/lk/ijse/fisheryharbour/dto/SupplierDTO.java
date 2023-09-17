package lk.ijse.fisheryharbour.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class SupplierDTO {
    private String supplier_id;
    private String company_name;
    private String company_location;
    private String company_no;
    private String company_email;
}
