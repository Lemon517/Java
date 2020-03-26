package com.main;

import com.db.InputData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentPanel extends JFrame implements ActionListener {
    private JLabel hb, fr, ky, tw, fx, teacher, phone;
    private ButtonGroup hb_g, fr_g, ky_g, fx_g;
    private JRadioButton hb_y, hb_n, fr_y, fr_n, ky_y, ky_n, fx_y, fx_n;
    private JTextField tw_field,teacher_field,phone_field;
    private JPanel[] panel;
    private JButton ok, quit;
    private InputData input;
    private String name;

    public StudentPanel(String name) {
        this.name = name;
        init();
        this.setTitle(String.format("请 %s 提交今日数据", name));
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(15, 1));
        for (JPanel jPanel : panel) {
            this.add(jPanel);
        }
        addActionListener();
    }

    public void init() {
        input = new InputData();
        panel = new JPanel[16];
        for (int i = 0; i < panel.length; i++) {
            panel[i] = new JPanel();
        }
        hb = new JLabel("是否接触过来自武汉或湖北的人");
        hb_g = new ButtonGroup();
        hb_n = new JRadioButton("否", true);
        hb_y = new JRadioButton("是");
        hb_g.add(hb_n);
        hb_g.add(hb_y);
        panel[0].add(hb);
        panel[1].add(hb_y);
        panel[1].add(hb_n);

        fr = new JLabel("最近是否有发热，咳嗽等症状");
        fr_g = new ButtonGroup();
        fr_n = new JRadioButton("否", true);
        fr_y = new JRadioButton("是");
        fr_g.add(fr_n);
        fr_g.add(fr_y);
        panel[2].add(fr);
        panel[3].add(fr_y);
        panel[3].add(fr_n);

        ky = new JLabel("附近是否有可疑或者感染者");
        ky_g = new ButtonGroup();
        ky_n = new JRadioButton("否", true);
        ky_y = new JRadioButton("是");
        ky_g.add(ky_n);
        ky_g.add(ky_y);
        panel[4].add(ky);
        panel[5].add(ky_y);
        panel[5].add(ky_n);
        
        fx = new JLabel("是否今日返校");
        fx_g = new ButtonGroup();
        fx_n = new JRadioButton("否", true);
        fx_y = new JRadioButton("是");
        fx_g.add(fx_n);
        fx_g.add(fx_y);
        panel[6].add(fx);
        panel[7].add(fx_y);
        panel[7].add(fx_n);

        tw = new JLabel("请输入今日体温（单位:摄氏度）");
        tw_field = new JTextField(10);
        panel[8].add(tw);
        panel[9].add(tw_field);
        
        teacher = new JLabel("请输入班主任联系方式");
        teacher_field = new JTextField(10);
        panel[10].add(teacher);
        panel[11].add(teacher_field);
        
        phone = new JLabel("请输入个人联系方式");
        phone_field = new JTextField(10);
        panel[12].add(phone);
        panel[13].add(phone_field);
        
        ok = new JButton("提交");
        quit = new JButton("退出");
        panel[14].add(ok);
        panel[15].add(quit);
    }

    public void addActionListener() {
        ok.addActionListener(this);
        quit.addActionListener(this);
    }

    public String getIsCheck(JRadioButton button) {
        if (button.isSelected()) {
            return "1";
        } else {
            return "0";
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(ok.getActionCommand())) {
            String hb_str = getIsCheck(hb_y);
            String fr_str = getIsCheck(fr_y);
            String ky_str = getIsCheck(ky_y);
            String fx_str = getIsCheck(ky_y);
            String tw_str = tw_field.getText();
            String teacher_str = teacher_field.getText();
            String phone_str = phone_field.getText();
            if(input.inputData(name, hb_str, fr_str, ky_str, fx_str, tw_str, teacher_str, phone_str)){
                JOptionPane.showMessageDialog(null, "信息已上报成功", "成功",JOptionPane.INFORMATION_MESSAGE);

            }else{
                JOptionPane.showMessageDialog(null, "请补全信息提交", "失败",JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getActionCommand().equals(quit.getActionCommand())) {
            System.exit(0);
        }
    }
}
