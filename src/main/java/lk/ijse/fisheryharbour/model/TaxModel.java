package lk.ijse.fisheryharbour.model;

import lk.ijse.fisheryharbour.dto.OwnerDTO;
import lk.ijse.fisheryharbour.dto.TaxDTO;
import lk.ijse.fisheryharbour.utill.SQLUtill;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TaxModel {
    public ArrayList<String> getAllTaxId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtill.execute("SELECT tax_Id FROM tax ORDER BY LENGTH(tax_Id),tax_Id");
        ArrayList<String> list = new ArrayList<>();

        while (resultSet.next()) {
            list.add(resultSet.getString(1));
        }
        return list;
    }

    public boolean save(TaxDTO taxDTO) throws SQLException, ClassNotFoundException {
        return SQLUtill.execute("insert into owner VALUES (?,?,?,?,?,?)",
                taxDTO.getTax_Id(),
                taxDTO.getDate(),
                taxDTO.getFee(),
                taxDTO.getTax_Type(),
                taxDTO.getTime(),
                taxDTO.getBoat_Id());

    }

    public TaxDTO getData(String id) throws SQLException, ClassNotFoundException {
        ResultSet set = SQLUtill.execute("SELECT * FROM tax where tax_Id=?", id);

        TaxDTO taxDTO = new TaxDTO();

        if (set.next()) {
            taxDTO.setTax_Id(set.getString(1));
            taxDTO.setDate(set.getString(2));
            taxDTO.setFee(set.getString(3));
            taxDTO.setTax_Type(set.getString(4));
            taxDTO.setTime(set.getString(5));
            taxDTO.setBoat_Id(set.getString(6));
        }
        return taxDTO;
    }
}
