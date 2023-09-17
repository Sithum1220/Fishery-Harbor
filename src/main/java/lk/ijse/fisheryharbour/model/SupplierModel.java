package lk.ijse.fisheryharbour.model;

import lk.ijse.fisheryharbour.dto.EmployeeDTO;
import lk.ijse.fisheryharbour.dto.SupplierDTO;
import lk.ijse.fisheryharbour.utill.SQLUtill;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierModel {
    public ArrayList<String> getAllSupplierId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtill.execute("SELECT supplier_Id FROM supplier ORDER BY LENGTH(supplier_Id),supplier_Id");
        ArrayList<String> list = new ArrayList<>();

        while (resultSet.next()) {
            list.add(resultSet.getString(1));
        }
        return list;
    }

    public boolean save(SupplierDTO supplierDTO) throws SQLException, ClassNotFoundException {
        return SQLUtill.execute("insert into supplier VALUES (?,?,?,?,?)",
                supplierDTO.getSupplier_id(),
                supplierDTO.getCompany_name(),
                supplierDTO.getCompany_email(),
                supplierDTO.getCompany_no(),
                supplierDTO.getCompany_location());
    }

    public SupplierDTO getData(String id) throws SQLException, ClassNotFoundException {
        ResultSet set = SQLUtill.execute("SELECT * FROM supplier where supplier_Id=?", id);

        SupplierDTO supplierDTO = new SupplierDTO();

        if (set.next()) {
            supplierDTO.setSupplier_id(set.getString(1));
            supplierDTO.setCompany_name(set.getString(2));
            supplierDTO.setCompany_email(set.getString(3));
            supplierDTO.setCompany_no(set.getString(4));
            supplierDTO.setCompany_location(set.getString(5));
        }
        return supplierDTO;
    }


    public boolean update(SupplierDTO supplierDTO) throws SQLException, ClassNotFoundException {
        return SQLUtill.execute("UPDATE  supplier SET " +
                        "company_Name=?," +
                        "company_Email=?," +
                        "contact_No=? ," +
                        "location=? " +
                        "WHERE supplier_Id=?",
                supplierDTO.getCompany_name(),
                supplierDTO.getCompany_email(),
                supplierDTO.getCompany_no(),
                supplierDTO.getCompany_location(),
                supplierDTO.getSupplier_id()
        );
    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtill.execute("DELETE FROM supplier WHERE supplier_Id=?", id);

    }
}
