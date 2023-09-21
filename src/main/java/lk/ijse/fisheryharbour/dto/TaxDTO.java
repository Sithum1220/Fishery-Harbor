package lk.ijse.fisheryharbour.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class TaxDTO {
    private String tax_Id;
    private String date;
    private String fee;
    private String tax_Type;
    private String time;
    private String boat_Id;
}
