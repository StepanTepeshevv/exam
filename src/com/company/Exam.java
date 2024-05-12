package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Exam {
    static JButton add_stud = new JButton("Добавить студента");
    static JButton random = new JButton("Перемешать");
    static JButton save = new JButton("Сохранить в файл");
    static JTextField pole_vvoda = new JTextField();
    static JTextArea area1 = new JTextArea("", 30, 10);
    static JTextArea area2 = new JTextArea("", 30, 10);


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.getContentPane().setBackground(Color.decode("#008000"));
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(650, 500);

        frame.setTitle("Курсовая работа Тепешев Степан");

        Label label = new Label("Экзамен");
        label.setFont(new Font("ARIAL", Font.BOLD, 30));
        frame.add(label);

        Label label2 = new Label("Введите ФИО Студента:");
        label2.setFont(new Font("ARIAL", Font.BOLD, 12));
        frame.add(label2);

        Label label3 = new Label("Список студентов:");
        label3.setFont(new Font("ARIAL", Font.BOLD, 12));
        frame.add(label3);

        Label label4 = new Label("Список вариантов:");
        label4.setFont(new Font("ARIAL", Font.BOLD, 12));
        frame.add(label4);

        frame.add(pole_vvoda);
        frame.add(add_stud);
        frame.add(save);
        frame.add(random);

        frame.add(area1);
        frame.add(area2);

        label.setBounds(250, 10, 150, 50);
        label.setForeground(Color.WHITE);

        label2.setBounds(40, 60, 150, 50);
        label2.setForeground(Color.WHITE);

        label3.setBounds(55, 150, 150, 30);
        label3.setForeground(Color.WHITE);

        label4.setBounds(330, 150, 150, 30);
        label4.setForeground(Color.WHITE);

        pole_vvoda.setBounds(200, 70, 170, 30); // ввод студента
        pole_vvoda.setBackground(Color.WHITE);

        add_stud.setBounds(380, 70, 150, 30); // добавить студента
        add_stud.setBackground(Color.WHITE);

        save.setBounds(360, 400, 150, 30); // Сохранить в файл
        save.setBackground(Color.WHITE);

        random.setBounds(100, 400, 120, 30);
        random.setBackground(Color.WHITE);

        area1.setBounds(55, 180, 215, 200); // Таблица слева
        area2.setBounds(330, 180, 215, 200); // Таблица справа


        add_stud.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent Event) {
                add_action(Event);
            }
        });

        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent Event) {
                try {
                    save_action(Event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        random.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent Event) {
                randon_action(Event);
            }
        });
    }

    public static void save_action(ActionEvent Event) throws IOException {
        FileWriter file = new FileWriter("students.txt");
        String[] stud = area2.getText().split("\n");

        for (int i = 0; i < stud.length; i++) {
            file.write(stud[i] + "\n");
        }

        file.close();
        JOptionPane.showMessageDialog(null, "Файл успешно сохранен");
    }

    public static void add_action(ActionEvent Event) {
        area1.append(pole_vvoda.getText() + "\n");
        pole_vvoda.setText(" ");
    }

    public static void randon_action(ActionEvent Event) {
        int a = 1;
        int b = 30;
        String[] s = area1.getText().split("\n");

        for (int i = 0; i < s.length; i++) {
            int i1 = a + (int) (Math.random() * b);
            area2.append(String.valueOf(i1) + " - ");
            area2.append(s[i] + "\n");
        }
    }
}
