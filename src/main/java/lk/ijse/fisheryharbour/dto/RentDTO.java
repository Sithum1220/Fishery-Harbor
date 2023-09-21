package lk.ijse.fisheryharbour.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class RentDTO {
    private String rent_Id;
    private String rent_Type;
    private String fee;
    private String date;
    private String time;
    private String owner_Id;
}
