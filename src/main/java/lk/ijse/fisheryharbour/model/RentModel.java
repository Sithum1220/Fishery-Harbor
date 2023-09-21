package lk.ijse.fisheryharbour.model;

import lk.ijse.fisheryharbour.dto.RentDTO;
import lk.ijse.fisheryharbour.dto.SupplierDTO;
import lk.ijse.fisheryharbour.utill.SQLUtill;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RentModel {
    public ArrayList<String> getAllRentId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtill.execute("SELECT rent_Id FROM rent ORDER BY LENGTH(rent_Id),rent_Id");
        ArrayList<String> list = new ArrayList<>();

        while (resultSet.next()) {
            list.add(resultSet.getString(1));
        }
        return list;
    }

    public boolean save(RentDTO rentDTO) throws SQLException, ClassNotFoundException {
        return SQLUtill.execute("insert into rent VALUES (?,?,?,?,?,?)",
                rentDTO.getRent_Id(),
                rentDTO.getRent_Type(),
                rentDTO.getFee(),
                rentDTO.getDate(),
                rentDTO.getTime(),
                rentDTO.getOwner_Id());
    }

    public RentDTO getData(String id) throws SQLException, ClassNotFoundException {
        ResultSet set = SQLUtill.execute("SELECT * FROM rent where rent_Id=?", id);

        RentDTO rentDTO = new RentDTO();

        if (set.next()) {
            rentDTO.setRent_Id(set.getString(1));
            rentDTO.setRent_Type(set.getString(2));
            rentDTO.setFee(set.getString(3));
            rentDTO.setDate(set.getString(4));
            rentDTO.setTime(set.getString(5));
            rentDTO.setOwner_Id(set.getString(6));
        }
        return rentDTO;
    }
}
