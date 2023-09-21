package lk.ijse.fisheryharbour.model;

import lk.ijse.fisheryharbour.dto.StockDTO;
import lk.ijse.fisheryharbour.dto.SupplierDTO;
import lk.ijse.fisheryharbour.utill.SQLUtill;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StockModel {
    public ArrayList<String> getAllStockId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtill.execute("SELECT item_Code FROM item_stock ORDER BY LENGTH(item_Code),item_Code");
        ArrayList<String> list = new ArrayList<>();

        while (resultSet.next()) {
            list.add(resultSet.getString(1));
        }
        return list;
    }

    public boolean save(StockDTO stockDTO) throws SQLException, ClassNotFoundException {
        return SQLUtill.execute("insert into item_stock VALUES (?,?,?,?)",
                stockDTO.getItem_Code(),
                stockDTO.getDescription(),
                stockDTO.getQty(),
                stockDTO.getUnit_Price());
    }

    public StockDTO getData(String id) throws SQLException, ClassNotFoundException {
        ResultSet set = SQLUtill.execute("SELECT * FROM item_stock where item_code=?", id);

        StockDTO stockDTO = new StockDTO();

        if (set.next()) {
            stockDTO.setItem_Code(set.getString(1));
            stockDTO.setDescription(set.getString(2));
            stockDTO.setQty(set.getString(3));
            stockDTO.setUnit_Price(set.getString(4));
        }
        return stockDTO;
    }
}
