package GB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartWindow extends JFrame {
    JMenuBar menuBar = new JMenuBar();
    JPanel btnPnl= new JPanel(new GridLayout(1,2));
    ClassLoader ldr = this.getClass().getClassLoader();           //при таком способе
    java.net.URL tickURL = ldr.getResource("tick.png");     //картинки нужно размещать на одном уровне с пакетом
    java.net.URL crossURL = ldr.getResource("cross.png");
    java.net.URL dukeURL = ldr.getResource("duke.png");
    ImageIcon tick = new ImageIcon(tickURL);                    //картинка галочки
    ImageIcon cross = new ImageIcon(crossURL);                  //картинка крестика
    ImageIcon duke = new ImageIcon(dukeURL);                    //картинка Дюка

    public StartWindow(){
        super("Тупая прога");   //заголовок
        setSize(600,600);
        setLocation(650,250);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Font font = new Font("Monospaced", Font.BOLD, 32);            //шрифт для кнопки gameBtn
        JButton mascotBtn = new JButton("Показать талисман Java", tick);    //создание кнопки
        mascotBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel lbl1 = new JLabel("Duke",duke, JLabel.CENTER);   //создание метки
                add(lbl1, BorderLayout.NORTH);                      //показ метки в верхней части формы
                lbl1.setToolTipText("Duke is a mascot of Java");    //создание подсказки при наведении курсора
                lbl1.setHorizontalTextPosition(JLabel.CENTER);  //горизонтальная ориентация подписи картинки
                lbl1.setVerticalTextPosition(JLabel.TOP);       //вертикальная ориентация подписи картинки
                setVisible(true);
            }
        });
        JButton exitBtn = new JButton("Stop", cross);
        exitBtn.addActionListener(e -> System.exit(0));     //применение Лямбды
        JButton gameBtn = new JButton("Запустить дебильное клацание");
        gameBtn.setFont(font);                                  //применение шрифта
        gameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GameColor();
            }
        });

        menuBar.add(createEmptyJMenu());
        btnPnl.add(mascotBtn);                  //добавление кнопки на панель
        btnPnl.add(exitBtn);
        setJMenuBar(menuBar);                   //добавление меню на форму
        add(btnPnl, BorderLayout.CENTER);       //добавление панели на форму по центру
        add(gameBtn, BorderLayout.SOUTH);       //добавление кнопки запуска кликера вниз формы
        setVisible(true);
    }

    private JMenu createEmptyJMenu(){      //создание меню в закрытом методе
        JMenu btn1 = new JMenu("Начало осмысления");
        JMenu btn2 = new JMenu("Сюда");
        JMenu btn3 = new JMenu("Не стоит");
        JMenu btn4 = new JMenu("Идти");
        JMenu btn5 = new JMenu("Так как");
        JMenu btn6 = new JMenu("Здесь");
        JMenu btn7 = new JMenu("Ничего");
        JMenuItem btn8 = new JMenuItem("Нет");
        JMenu btn9 = new JMenu("хмм...");
        JMenuItem btn10 = new JMenuItem("и здесь тоже пусто");
        btn9.add(btn10);
        btn7.add(btn8);
        btn7.addSeparator();
        btn7.add(btn9);
        btn6.add(btn7);
        btn5.add(btn6);
        btn4.add(btn5);
        btn3.add(btn4);
        btn2.add(btn3);
        btn1.add(btn2);
        return btn1;
    }
}
