package lk.ijse.fisheryharbour.model;

import lk.ijse.fisheryharbour.dto.EmployeeDTO;
import lk.ijse.fisheryharbour.dto.OwnerDTO;
import lk.ijse.fisheryharbour.dto.SupplierDTO;
import lk.ijse.fisheryharbour.utill.SQLUtill;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OwnerModel {
    public ArrayList<String> getAllOwnerId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtill.execute("SELECT owner_Id FROM owner ORDER BY LENGTH(owner_Id),owner_Id");
        ArrayList<String> list = new ArrayList<>();

        while (resultSet.next()) {
            list.add(resultSet.getString(1));
        }
        return list;
    }

    public boolean save(OwnerDTO ownerDTO) throws SQLException, ClassNotFoundException {
        return SQLUtill.execute("insert into owner VALUES (?,?,?,?,?,?,?,?,?,?,?,?)",
                ownerDTO.getOwner_Id(),
                ownerDTO.getEmail(),
                ownerDTO.getFirst_Name(),
                ownerDTO.getLast_Name(),
                ownerDTO.getOwner_Role(),
                ownerDTO.getContact_No(),
                ownerDTO.getNic(),
                ownerDTO.getHouse_No(),
                ownerDTO.getStreet(),
                ownerDTO.getCity(),
                ownerDTO.getTime(),
                ownerDTO.getDate());

    }
    public OwnerDTO getData(String id) throws SQLException, ClassNotFoundException {
        ResultSet set = SQLUtill.execute("SELECT * FROM owner where owner_Id=?", id);

        OwnerDTO ownerDTO = new OwnerDTO();

        if (set.next()) {
            ownerDTO.setOwner_Id(set.getString(1));
            ownerDTO.setEmail(set.getString(2));
            ownerDTO.setFirst_Name(set.getString(3));
            ownerDTO.setLast_Name(set.getString(4));
            ownerDTO.setOwner_Role(set.getString(5));
            ownerDTO.setContact_No(set.getString(6));
            ownerDTO.setNic(set.getString(9));
            ownerDTO.setHouse_No(set.getString(10));
            ownerDTO.setStreet(set.getString(11));
            ownerDTO.setCity(set.getString(12));
            ownerDTO.setTime(set.getString(12));
            ownerDTO.setDate(set.getString(12));
        }
        return ownerDTO;
    }
}
