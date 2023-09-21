package lk.ijse.fisheryharbour.model;

import lk.ijse.fisheryharbour.dto.EmployeeAttendanceDTO;
import lk.ijse.fisheryharbour.utill.DateTimeUtil;
import lk.ijse.fisheryharbour.utill.SQLUtill;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeAttendanceModel {

    public boolean isEmployeeExsist(String id) throws SQLException, ClassNotFoundException {
        ResultSet set = SQLUtill.execute("SELECT * FROM employee WHERE employee_Id=?", id);
        if (set.next()) {
            return true;
        }
        return false;
    }

    public boolean isEmployeeTodayExsist(String id) throws SQLException, ClassNotFoundException {
        ResultSet set = SQLUtill.execute("SELECT * FROM attendance WHERE employee_Id=? and date=?", id, DateTimeUtil.dateNow());
        if (set.next()) {
            return false;
        }
        return true;
    }

    public boolean save(EmployeeAttendanceDTO employeeAttendanceDTO) throws SQLException, ClassNotFoundException {
        return SQLUtill.execute("INSERT INTO attendance VALUES (?,?,?)",
                DateTimeUtil.timeNow(),
                DateTimeUtil.dateNow(),
                employeeAttendanceDTO.getEmployee_Id()
        );
    }

    public ArrayList<String> getAllId() throws SQLException, ClassNotFoundException {
        ResultSet set = SQLUtill.execute("SELECT employee_Id FROM attendance WHERE date=?", DateTimeUtil.dateNow());
        ArrayList<String> list = new ArrayList<>();

        while (set.next()) {
            list.add(set.getString(1));
        }
        return list;
    }
}
