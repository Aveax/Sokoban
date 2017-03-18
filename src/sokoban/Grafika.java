package sokoban;

import java.awt.*;

import javax.swing.*;

public class Grafika extends JFrame{

    private JLayeredPane laypane;
    private JPanel tlo;
    private JButton graf1;
    private JButton graf2;
    private JPanel grafika1;
    private JPanel grafika2;

    public Grafika(){
        super("Sokoban Grafika");
        this.setSize(220,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocation(500,300);
        laypane = new JLayeredPane();
        laypane.setBounds(0,0,220,300);
        this.add(laypane, BorderLayout.CENTER);

        tlo=new ImageImplement("src/"+Program.graf+"/tloopc.png");
        tlo.setSize(300,450);
        laypane.add(tlo, new Integer(0), 0);

        graf1 = new JButton();
        graf1.setBounds(20,50,100,50);
        laypane.add(graf1, new Integer(1), 0);
        setFocusable(false);
        graf1.setIcon(new ImageIcon("src/"+Program.graf+"/graf/grafika1.png"));

        graf2 = new JButton();
        graf2.setBounds(20,150,100,50);
        laypane.add(graf2, new Integer(1), 0);
        setFocusable(false);
        graf2.setIcon(new ImageIcon("src/"+Program.graf+"/graf/grafika2.png"));

        grafika1=new ImageImplement("src/grafika1/end.png");
        grafika1.setLocation(150,50);
        grafika1.setSize(50,50);
        laypane.add(grafika1, new Integer(1), 0);

        grafika2=new ImageImplement("src/grafika2/end.png");
        grafika2.setLocation(150, 150);
        grafika2.setSize(50,50);
        laypane.add(grafika2, new Integer(1), 0);
    }
    public JButton getgraf1(){

        return graf1;
    }
    public JButton getgraf2(){

        return graf2;
    }
}
