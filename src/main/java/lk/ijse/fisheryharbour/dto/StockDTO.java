package lk.ijse.fisheryharbour.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class StockDTO {
    private String item_Code;
    private String description;
    private String qty;
    private String unit_Price;
}
