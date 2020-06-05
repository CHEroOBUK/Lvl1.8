package GB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameColor extends JFrame {
    public GameColor(){
        super("Изменение цвета центральной кнопки");
        Random random = new Random();
        setSize(600,600);
        setLocation(600,300);
        setResizable(false);        //запрет изменения размера
        Font font = new Font("SansSerif", Font.PLAIN, 54);
        JButton northBtn = new JButton("Север");
        northBtn.setFont(font);
        JButton southBtn = new JButton("Юг");
        southBtn.setFont(font);
        JButton eastBtn = new JButton("<html>В<br>о<br>с<br>т<br>о<br>к</html>");
        eastBtn.setFont(font);
        JButton westBtn = new JButton("<html>З<br>а<br>п<br>а<br>д</html>");    //вертикальная ориентация
        westBtn.setFont(font);
        JButton centerBtn = new JButton("Цетр, клацай");
        centerBtn.setFont(font);
        southBtn.setEnabled(false); //отключаем возможность клика
        eastBtn.setEnabled(false);
        westBtn.setEnabled(false);
        northBtn.setEnabled(false);
        add(northBtn, BorderLayout.NORTH);
        add(southBtn, BorderLayout.SOUTH);
        add(eastBtn, BorderLayout.EAST);
        add(westBtn, BorderLayout.WEST);
        add(centerBtn, BorderLayout.CENTER);
        centerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color1 = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
                Color color2 = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
                centerBtn.setForeground(color1);    //меняется цвет текста
                centerBtn.setBackground(color2);    //меняется цвет фона
            }
        });
        setVisible(true);
    }
}
