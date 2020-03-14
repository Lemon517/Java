package com.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileOutputStream;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.ss.usermodel.Sheet;  
import org.apache.poi.ss.usermodel.Workbook;  

public class Db {

    //登陆本地数据库
    private static final String url = "jdbc:mysql://127.0.0.1:3306/yqxt";
    private static final String user = "root";
    private static final String password = "123456";

    private static ResultSet ret = null;
    private static final String name = "com.mysql.jdbc.Driver";
    public Connection conn = null;
    public PreparedStatement pst = null;

    public Db() {
        try {
        	//指定连接类型  
            Class.forName(name);
            //获取连接  
            conn = DriverManager.getConnection(url, user, password);                 
            Workbook book = new HSSFWorkbook();             
            String Table_Name = "form";             
            Sheet sheet = book.createSheet(Table_Name);        
            Statement st = (Statement) conn.createStatement();  
            String sql = "select * from yqxt." + Table_Name;  
            ResultSet rs = st.executeQuery(sql);  
            Row row1 = sheet.createRow(0);  
            ResultSetMetaData rsmd = rs.getMetaData();  
            int colnum = rsmd.getColumnCount();  
            for (int i = 1; i <= colnum; i++) {  
                String name = rsmd.getColumnName(i);   
                Cell cell = row1.createCell(i - 1);   
                cell.setCellValue(name);  
            }   
            int idx = 1;  
            while (rs.next()) {  
                Row row = sheet.createRow(idx++);  
                for (int i = 1; i <= colnum; i++) {  
                    String str = rs.getString(i);   
                    Cell cell = row.createCell(i - 1);  
                    cell.setCellValue(str);  
                }  
            }  
            book.write(new FileOutputStream("E://" + Table_Name + ".xls"));  
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //查询及其他
    public void changeMySqlDate(String sql) {
        try {
            System.out.println("接收到的参数为：" + sql);
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    //插入删除操作
    public ResultSet selectSqlDate(String sql) {
        try {
            System.out.println("接收到的插入参数为：" + sql);
            pst = conn.prepareStatement(sql);
            ret = pst.executeQuery();
            return ret;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
     

    //关闭mysql
    public void closeMySql() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //关闭数据表
    public void closeChart() {
        try {
            this.pst.close();
            ret.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
