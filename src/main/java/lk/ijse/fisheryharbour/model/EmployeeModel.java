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

        while (resultSet.next()){
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
}
