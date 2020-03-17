package com.main;
import com.db.LeaderDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeaderPanel extends JFrame implements ActionListener {
    private JButton reEnter;
    private JPanel buttonPanel;
    private JButton quit,out;
    private LeaderDao td;
    private JScrollPane sp;
    private String name;
    public LeaderPanel(String name) {
        this.name = name;
        init();
        addActionListener();
        this.setTitle(String.format(" %s 查看今日统计", name));
        this.setSize(700, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.add(sp, BorderLayout.CENTER);
    }

    public void init() {
        td = new LeaderDao();
        buttonPanel = new JPanel();
        reEnter = new JButton("刷新当前数据");
        out = new JButton("导出数据");
        quit = new JButton("退出");
        buttonPanel.add(reEnter);
        buttonPanel.add(quit);
        buttonPanel.add(out);
        tableData();
    }

    private void tableData() {
        String[] titles = {"序号", "姓名", "学院", "上报时间", "是否湖北籍", "是否存在有发热", "近14天是否接触过感染者", "是否准备今日返校","体温"};
        String[][] data = td.getData(name);
        JTable table =new JTable(data,titles);
        sp=new JScrollPane(table);
        this.repaint();
    }

    private void addActionListener() {
        reEnter.addActionListener(this);
        out.addActionListener(this);
        quit.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(reEnter.getActionCommand())) {
            tableData();
        }else if (e.getActionCommand().equals(quit.getActionCommand())) {
            System.exit(0);
        }else if (e.getActionCommand().equals(out.getActionCommand())) {
        	JOptionPane.showMessageDialog(null, "导出成功", "成功",JOptionPane.INFORMATION_MESSAGE);

        }else{
            JOptionPane.showMessageDialog(null, "导出失败", "失败",JOptionPane.ERROR_MESSAGE);
        }
    }
}