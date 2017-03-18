package sokoban;

import java.awt.*;

import javax.swing.*;

public class Opcje extends JFrame {
    private JLayeredPane laypane;
    private JPanel tlo;
    private JButton map1;
    private JButton map2;
    private JButton map3;
    private JButton map4;
    private JButton map5;
    private JButton map6;
    private JButton map7;
    private JButton map8;
    private JButton map9;
    private JLabel maps;

    private JButton graf;

    public Opcje(){
        super("Sokoban Maps");
        this.setSize(300,450);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocation(500,300);
        laypane = new JLayeredPane();
        laypane.setBounds(0,0,300,450);
        this.add(laypane, BorderLayout.CENTER);
        tlo=new ImageImplement("src/"+Program.graf+"/tloopc.png");
        tlo.setSize(300,450);
        laypane.add(tlo, new Integer(0), 0);
        maps = new JLabel();
        maps.setBounds(65,20,200,70);
        maps.setFocusable(false);
        maps.setText("Maps");
        maps.setFont(new Font("Calibri",Font.BOLD, 70));
        maps.setForeground(Color.YELLOW);
        maps.setVisible(true);
        laypane.add(maps, new Integer(1), 0);
        //Button grafiki
        graf = new JButton();
        graf.setBounds(100,340,100,50);
        laypane.add(graf, new Integer(1), 0);
        setFocusable(false);
        graf.setIcon(new ImageIcon("src/"+Program.graf+"/graf/grafika.png"));

        //Buttony
        map1 = new JButton();
        map1.setBounds(51,100,48,48);
        laypane.add(map1, new Integer(1), 0);
        setFocusable(false);
        map1.setIcon(new ImageIcon("src/"+Program.graf+"/1-9/1.png"));


        map2 = new JButton();
        map2.setBounds(126,100,48,48);
        laypane.add(map2, new Integer(1), 0);
        setFocusable(false);
        map2.setIcon(new ImageIcon("src/"+Program.graf+"/1-9/2.png"));

        map3 = new JButton();
        map3.setBounds(201,100,48,48);
        laypane.add(map3, new Integer(1), 0);
        setFocusable(false);
        map3.setIcon(new ImageIcon("src/"+Program.graf+"/1-9/3.png"));

        map4 = new JButton();
        map4.setBounds(51,175,48,48);
        laypane.add(map4, new Integer(1), 0);
        setFocusable(false);
        map4.setIcon(new ImageIcon("src/"+Program.graf+"/1-9/4.png"));

        map5 = new JButton();
        map5.setBounds(126,175,48,48);
        laypane.add(map5, new Integer(1), 0);
        setFocusable(false);
        map5.setIcon(new ImageIcon("src/"+Program.graf+"/1-9/5.png"));

        map6 = new JButton();
        map6.setBounds(201,175,48,48);
        laypane.add(map6, new Integer(1), 0);
        setFocusable(false);
        map6.setIcon(new ImageIcon("src/"+Program.graf+"/1-9/6.png"));

        map7 = new JButton();
        map7.setBounds(51,250,48,48);
        laypane.add(map7, new Integer(1), 0);
        setFocusable(false);
        map7.setIcon(new ImageIcon("src/"+Program.graf+"/1-9/7.png"));

        map8 = new JButton();
        map8.setBounds(126,250,48,48);
        laypane.add(map8, new Integer(1), 0);
        setFocusable(false);
        map8.setIcon(new ImageIcon("src/"+Program.graf+"/1-9/8.png"));

        map9 = new JButton();
        map9.setBounds(201,250,48,48);
        laypane.add(map9, new Integer(1), 0);
        setFocusable(false);
        map9.setIcon(new ImageIcon("src/"+Program.graf+"/1-9/9.png"));
    }

    public JButton getmap1(){

        return map1;
    }
    public JButton getmap2(){

        return map2;
    }
    public JButton getmap3(){

        return map3;
    }
    public JButton getmap4(){

        return map4;
    }
    public JButton getmap5(){

        return map5;
    }
    public JButton getmap6(){

        return map6;
    }
    public JButton getmap7() {
        return map7; }
    public JButton getmap8(){

        return map8;
    }
    public JButton getmap9(){

        return map9;
    }
    public JButton getgraf(){

        return graf;
    }
}
