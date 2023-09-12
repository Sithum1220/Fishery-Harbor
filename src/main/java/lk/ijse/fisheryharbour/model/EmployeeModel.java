package lk.ijse.fisheryharbour.model;

import lk.ijse.fisheryharbour.dto.EmployeeDTO;
import lk.ijse.fisheryharbour.utill.SQLUtill;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeModel {

    public ArrayList<String> getAllEmployeeId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtill.execute("SELECT employee_Id FROM employee ORDER BY LENGTH(employee_Id),employee_Id");
        ArrayList<String> list = new ArrayList<>();

        while (resultSet.next()) {
            list.add(resultSet.getString(1));
        }
        return list;
    }

    public boolean save(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException {
        return SQLUtill.execute("insert into employee VALUES (?,?,?,?,?,?,?,?,?,?,?,?)",
                employeeDTO.getEmployee_Id(),
                employeeDTO.getEmail(),
                employeeDTO.getFirst_Name(),
                employeeDTO.getLast_Name(),
                employeeDTO.getContact_No(),
                employeeDTO.getNic(),
                employeeDTO.getPassword(),
                employeeDTO.getUser_Name(),
                employeeDTO.getRole(),
                employeeDTO.getHouse_No(),
                employeeDTO.getStreet(),
                employeeDTO.getCity());
    }

    public EmployeeDTO getData(String id) throws SQLException, ClassNotFoundException {
        ResultSet set = SQLUtill.execute("SELECT * FROM employee where employee_Id=?", id);

        EmployeeDTO employeeDTO = new EmployeeDTO();

        if (set.next()) {
            employeeDTO.setEmployee_Id(set.getString(1));
            employeeDTO.setEmail(set.getString(2));
            employeeDTO.setFirst_Name(set.getString(3));
            employeeDTO.setLast_Name(set.getString(4));
            employeeDTO.setContact_No(set.getString(5));
            employeeDTO.setNic(set.getString(6));
            employeeDTO.setRole(set.getString(9));
            employeeDTO.setHouse_No(set.getString(10));
            employeeDTO.setStreet(set.getString(11));
            employeeDTO.setCity(set.getString(12));
        }
        return employeeDTO;
    }

    public boolean update(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException {
        return SQLUtill.execute("UPDATE  employee SET " +
                        "email=?," +
                        "first_Name=?," +
                        "last_Name=? ," +
                        "contact_No=? ," +
                        "nic=? ," +
                        "role=?," +
                        "house_No=?," +
                        "street=?," +
                        "city=?" +
                        "WHERE employee_Id=?",
                employeeDTO.getEmail(),
                employeeDTO.getFirst_Name(),
                employeeDTO.getLast_Name(),
                employeeDTO.getContact_No(),
                employeeDTO.getNic(),
                employeeDTO.getRole(),
                employeeDTO.getHouse_No(),
                employeeDTO.getStreet(),
                employeeDTO.getCity(),
                employeeDTO.getEmployee_Id()
        );
    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtill.execute("DELETE FROM employee WHERE employee_Id=?", id);

    }
}
