package com.main;

import com.db.LoginDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JFrame implements ActionListener {
    private JButton login, cancel;
    private JPasswordField passwordField;
    private JTextField nameField;
    private JPanel loginPanel, passwordPanel, namePanel, checkPanel;
    private LoginDao thisLoginDao;
    private JRadioButton studentLogin, teacherLogin;

    public LoginPanel() {
        init();
        this.setTitle("用户登录");
        this.setSize(400, 240);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(4, 1));
        this.setResizable(false);
        this.add(namePanel);
        this.add(passwordPanel);
        this.add(checkPanel);
        this.add(loginPanel);
        addActionListener();
    }

    public void init() {
        thisLoginDao = new LoginDao();
        ButtonGroup bg = new ButtonGroup();
        studentLogin = new JRadioButton("学生登录", true);
        teacherLogin = new JRadioButton("学院负责人登录");
        bg.add(studentLogin);
        bg.add(teacherLogin);
        login = new JButton("登录");
        cancel = new JButton("退出");
        JLabel name = new JLabel("用户名");
        JLabel password = new JLabel("密    码");
        nameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginPanel = new JPanel();
        loginPanel.add(login);
        loginPanel.add(cancel);
        passwordPanel = new JPanel();
        passwordPanel.add(password);
        passwordPanel.add(passwordField);
        namePanel = new JPanel();
        namePanel.add(name);
        namePanel.add(nameField);
        checkPanel = new JPanel();
        checkPanel.add(studentLogin);
        checkPanel.add(teacherLogin);
    }

    public void addActionListener() {
        login.addActionListener(this);
        cancel.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(login.getActionCommand())) {
            String name = nameField.getText();
            String password = passwordField.getText();
            String type = "-1";
            if (studentLogin.isSelected()) {
                type = "2";
            } else if (teacherLogin.isSelected()) {
                type = "1";
            }
            if (thisLoginDao.LoginCheck(name, password, type)) {
                if (type.equals("2")) {
                    new StudentPanel(name);
                    this.setVisible(false);
                } else if (type.equals("1")) {
                    new TeacherPanel(name);
                    this.setVisible(false);
                }
            } else {
                JOptionPane.showMessageDialog(null, "密码或用户名错误", "密码错误",
                        JOptionPane.WARNING_MESSAGE);
            }
        } else if (e.getActionCommand().equals(cancel.getActionCommand())) {
            System.exit(0);
        }
    }
}
