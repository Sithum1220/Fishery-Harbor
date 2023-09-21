package lk.ijse.fisheryharbour.model;

import lk.ijse.fisheryharbour.dto.BoatDTO;
import lk.ijse.fisheryharbour.utill.DateTimeUtil;
import lk.ijse.fisheryharbour.utill.SQLUtill;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryModel {
    public BoatDTO getBoatData(String id) throws SQLException, ClassNotFoundException {
        ResultSet set = SQLUtill.execute("SELECT * FROM boat b INNER JOIN  owner o on o.first_Name, o.last_Name,o.email WHERE o.owner_Id=?", id);

        BoatDTO boatDTO = new BoatDTO();

        if (set.next()) {
            boatDTO.setBoat_Id(set.getString(1));
            boatDTO.setBoat_name(set.getString(2));
            boatDTO.setOwner_Id(set.getString(4));
            boatDTO.setBoat_Type(set.getString(3));
            boatDTO.setOwner_Name(set.getString(5) + " " + set.getString(6));
            boatDTO.setOwner_Email(set.getString(7));
        }
        return boatDTO;
    }

    public void updatePassword() {

    }

    public boolean checkTaxPay(String id) throws SQLException, ClassNotFoundException {

        String date = DateTimeUtil.dateNow();
        String[] arDate = date.split("-");
        ResultSet set = SQLUtill.execute("SELECT tax_Id FROM tax WHERE boat_Id = ? LIKE ?",id, arDate[0] + "-" + arDate[1] + "%");
        while (set.next()) {
            return true;
        }
        return false;
    }
}
