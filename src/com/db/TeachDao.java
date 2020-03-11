package com.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeachDao {
    Db db;
    ResultSet rs;

    public TeachDao() {
        db = new Db();
    }

    private String searchMassage(String name) {
        String institute_id = null;
        String sql = String.format("select * from user where name='%s'", name);
        rs = db.selectSqlDate(sql);
        try {
            while (rs.next()) {
                institute_id = rs.getString("institute_id");
            }
            return institute_id;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String[][] ArrayListToArray(ArrayList<ArrayList<String>> data){
        String[][] allData = new String[data.size()][8];
        for (int i=0;i<data.size();i++){
            ArrayList<String> al = data.get(i);
            allData[i][0] = String.valueOf(i+1);
            for(int j=0;j<al.size();j++){
                allData[i][j+1]=al.get(j);
            }
        }
        return allData;
    }

    private String getYesNo(String name){
        if(name.equals("1")){
            return "是";
        }else{
            return "否";
        }
    }

    public String[][] getData(String name) {
        String institute_id = searchMassage(name);
        String sql = String.format("select user.user_name,institute.institute,form.time,form.hb,form.fr,form.ky," +
                "form.tw from form,institute,user where form.institute_id=institute.id and form.user_id=user.id " +
                "and form.institute_id='%s'", institute_id);
        rs = db.selectSqlDate(sql);
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        try {
            while (rs.next()) {
                ArrayList<String> al = new ArrayList<>();
                al.add(rs.getString("user_name"));
                al.add(rs.getString("institute"));
                al.add(rs.getString("time"));
                al.add(getYesNo(rs.getString("hb")));
                al.add(getYesNo(rs.getString("fr")));
                al.add(getYesNo(rs.getString("ky")));
                al.add(rs.getString("tw"));
                data.add(al);
            }
            return ArrayListToArray(data);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
