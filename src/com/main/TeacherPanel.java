package com.main;

import com.db.TeachDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherPanel extends JFrame implements ActionListener {
    private JButton reEnter;
    private JPanel buttonPanel;
    private JButton ok, quit;
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
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.add(sp, BorderLayout.CENTER);
    }

    public void init() {
        td = new TeachDao();
        buttonPanel = new JPanel();
        reEnter = new JButton("刷新当前数据");
        ok = new JButton("提交");
        quit = new JButton("退出");
        buttonPanel.add(reEnter);
        buttonPanel.add(ok);
        buttonPanel.add(quit);
        tableData();
    }

    private void tableData() {
        String[] titles = {"序号", "姓名", "学院","班级", "时间", "是否湖北籍", "是否存在有发热", "近14天是否接触可疑人员","是否今日返校","体温","班主任联系方式","个人联系方式"};
        String[][] data = td.getData(name);
        JTable table =new JTable(data,titles);
        sp=new JScrollPane(table);
        this.repaint();
    }

    private void addActionListener() {
        reEnter.addActionListener(this);
        ok.addActionListener(this);
        quit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(reEnter.getActionCommand())) {
            tableData();
        }else if (e.getActionCommand().equals(quit.getActionCommand())) {
            System.exit(0);
        }if(e.getActionCommand().equals(ok.getActionCommand())) {
        	tableData();
            if(e.getActionCommand().equals(ok.getActionCommand())){
                JOptionPane.showMessageDialog(null, "提交成功", "成功",JOptionPane.INFORMATION_MESSAGE);

            }else{
                JOptionPane.showMessageDialog(null, "提交失败", "失败",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
