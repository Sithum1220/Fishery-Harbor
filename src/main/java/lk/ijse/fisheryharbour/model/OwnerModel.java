package lk.ijse.fisheryharbour.model;

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
        return SQLUtill.execute("insert into owner VALUES (?,?,?,?,?,?,?,?,?,?)",
                ownerDTO.getOwner_Id(),
                ownerDTO.getEmail(),
                ownerDTO.getFirst_Name(),
                ownerDTO.getLast_Name(),
                ownerDTO.getOwner_Role(),
                ownerDTO.getContact_No(),
                ownerDTO.getNic(),
                ownerDTO.getHouse_No(),
                ownerDTO.getStreet(),
                ownerDTO.getCity());
    }
}
