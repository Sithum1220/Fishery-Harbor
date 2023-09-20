package lk.ijse.fisheryharbour.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class BoatDTO {
    private String boat_Id;
    private String boat_name;
    private String boat_Type;
    private String owner_Id;
}
