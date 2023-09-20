package lk.ijse.fisheryharbour.model;

import lk.ijse.fisheryharbour.dto.BoatDTO;
import lk.ijse.fisheryharbour.dto.SupplierDTO;
import lk.ijse.fisheryharbour.utill.SQLUtill;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoatModel {
    public ArrayList<String> getAllBoatId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtill.execute("SELECT boat_Id FROM boat ORDER BY LENGTH(boat_Id),boat_Id");
        ArrayList<String> list = new ArrayList<>();

        while (resultSet.next()) {
            list.add(resultSet.getString(1));
        }
        return list;
    }

    public boolean save(BoatDTO boatDTO) throws SQLException, ClassNotFoundException {
        return SQLUtill.execute("insert into boat VALUES (?,?,?,?)",
                boatDTO.getBoat_Id(),
                boatDTO.getBoat_name(),
                boatDTO.getBoat_Type(),
                boatDTO.getOwner_Id());
    }

    public BoatDTO getData(String id) throws SQLException, ClassNotFoundException {
        ResultSet set = SQLUtill.execute("SELECT * FROM boat where boat_Id=?", id);

        BoatDTO boatDTO = new BoatDTO();

        if (set.next()) {
            boatDTO.setBoat_Id(set.getString(1));
            boatDTO.setBoat_name(set.getString(2));
            boatDTO.setOwner_Id(set.getString(4));
            boatDTO.setBoat_Type(set.getString(3));
        }
        return boatDTO;
    }
}
