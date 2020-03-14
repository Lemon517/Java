package com.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InputData {
    ResultSet rs;
    Db db;

    public InputData() {
        db = new Db();
    }

    private String[] searchMassage(String name) {
        String sql = "select * from user where name='" + name + "'";
        String[] stuMassage = new String[6];
        rs = db.selectSqlDate(sql);
        try {
            while (rs.next()) {
                stuMassage[0] = rs.getString("id");
                stuMassage[1] = rs.getString("institute_id");
                stuMassage[2] = rs.getString("user_name");
                stuMassage[3] = rs.getString("institute");
                stuMassage[4] = rs.getString("class");
                stuMassage[5] = rs.getString("remark");
            }
            return stuMassage;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean inputData(String name, String hb, String fr, String ky, String fx, String tw, String teacher, String phone) {
        Date day = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data = df.format(day);
        System.out.println(String.format("%s %s %s %s %s %s %s %s",
                name, hb, fr, ky, fx, tw, teacher, phone));
        String[] stuMassage = searchMassage(name);
        if (stuMassage != null) {
            String sql = String.format("insert into form (user_id,institute_id,user_name,institute,class,remark,time,hb,fr,ky,fx,tw,teacher,phone)" +
                    "values('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')", stuMassage[0], stuMassage[1], stuMassage[2], stuMassage[3], stuMassage[4], stuMassage[5], data, hb, fr, ky, fx, tw, teacher, phone);
            db.changeMySqlDate(sql);
            return true;
        } else {
            return false;
        }

    }
}
