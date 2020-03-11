package com.main;

import com.db.TeachDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherPanel extends JFrame implements ActionListener {
    private JButton reEnter;
    private JPanel buttonPanel;
    private TeachDao td;
    private JScrollPane sp;
    private String name;
    public TeacherPanel(String name) {
        this.name = name;
        init();
        addActionListener();
        this.setTitle(String.format("用户 %s 查看今日统计", name));
        this.setSize(700, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(buttonPanel, BorderLayout.NORTH);
        this.add(sp, BorderLayout.CENTER);
    }

    public void init() {
        td = new TeachDao();
        buttonPanel = new JPanel();
        reEnter = new JButton("刷新当前数据");
        buttonPanel.add(reEnter);
        tableData();
    }

    private void tableData() {
        String[] titles = {"序号", "姓名", "学院", "时间", "是否接触湖北人", "是否存在有发热", "是否接触可以人员","体温"};
        String[][] data = td.getData(name);
        JTable table =new JTable(data,titles);
        sp=new JScrollPane(table);
        this.repaint();
    }

    private void addActionListener() {
        reEnter.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(reEnter.getActionCommand())) {
            tableData();
        }
    }
}
