package com.db;

import java.sql.SQLException;

public class LoginDao {
    public boolean LoginCheck(String name, String password,String type) {
        Db db = new Db();
        String sql = String.format("select * from user where name='%s' and password='%s' and type='%s'",
                name, password, type);
        try {
            return db.selectSqlDate(sql).next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
