package lk.ijse.fisheryharbour.utill;

import java.util.ArrayList;

public class NewId {

    public static String newId(ArrayList<String> list, GetType getType) {
        String lastId = null;
        for (int i = 0; i < list.size(); i++) {
            lastId = list.get(i);
        }

        switch (getType) {
            case EMPLOYEE:
                try {
                    String[] split = lastId.split("E-0");
                    int idNum = Integer.parseInt(split[1]);
                    idNum++;
                    return "E-0" + idNum;
                } catch (Exception e) {
                    return "E-01";
                }

            case SUPPLIER:
                try {
                    String[] split = lastId.split("S-0");
                    int idNum = Integer.parseInt(split[1]);
                    idNum++;
                    return "S-0" + idNum;
                } catch (Exception e) {
                    return "S-01";
                }

            case OWNER:
                try {
                    String[] split = lastId.split("O-0");
                    int idNum = Integer.parseInt(split[1]);
                    idNum++;
                    return "O-0" + idNum;
                } catch (Exception e) {
                    return "O-01";
                }

            default:
                return null;
        }


    }

    public enum GetType {
        EMPLOYEE, SUPPLIER, OWNER
    }
}
