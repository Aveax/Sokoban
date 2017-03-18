package sokoban;

import java.awt.*;
import javax.swing.*;

import java.util.List;
import java.util.ArrayList;

public class FSok extends JFrame {

    private List<Textury> list = new ArrayList<>();
    //private Textury[] textury;
    private int liczwall=0;
    private int liczfloor=0;
    private int liczendfloor=0;
    private Box[] box;
    private int liczbox=0;
    private Robot robot;

    private JLayeredPane laypane;
    private JPanel tlo;
    private JLabel move;
    private JLabel kom;
    private JLabel quit;

    private JButton up;
    private JButton down;
    private JButton left;
    private JButton right;

    private int q,w;
    private int[][] tabmap;
    //0 puste pola
    //1 sciany
    //2 podloga
    //3 pola endu
    //4 skrzynki
    //5 robot

    public FSok(int[][] tablica,int a, int b){
        //Stworzenie okna
        super( "Sokoban" );
        tabmap=tablica;
        q=a;
        w=b;
        int szer; szer=250+w*50;
        int wys;if(q>5){wys=(q+1)*50;}else{wys=300;}
        this.setSize(szer,wys);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocation(10,10);
        this.setFocusable(true);
        //Widocznosc paneli
        laypane = new JLayeredPane();
        laypane.setBounds(0,0,szer,wys);
        this.add(laypane, BorderLayout.CENTER);
        //Tlo
        tlo=new ImageImplement("src/"+Program.graf+"/tlo.jpg");
        tlo.setSize(szer,wys);
        laypane.add(tlo, new Integer(0), 0);
        //Ilosc ruchow
        move = new JLabel();
        move.setBounds(10, 10, 200, 40);
        move.setFont(new Font("Calibri",Font.BOLD, 25));
        move.setForeground(Color.RED);
        move.setFocusable(false);
        move.setText("Moves: 0.");
        laypane.add(move, new Integer(1), 0);
        //Quit
        quit = new JLabel();
        quit.setBounds(10, 70, 200, 40);
        quit.setFont(new Font("Calibri",Font.BOLD, 25));
        quit.setForeground(Color.RED);
        quit.setFocusable(false);
        quit.setText("Q - quit.");
        laypane.add(quit, new Integer(1), 0);
        //Komunikat
        kom = new JLabel();
        kom.setBounds(10,40,200,40);
        kom.setFocusable(false);
        kom.setText("Game completed.");
        kom.setFont(new Font("Calibri",Font.BOLD, 25));
        kom.setForeground(Color.RED);
        kom.setVisible(false);
        laypane.add(kom, new Integer(1), 0);
        //Tablice
        //textury = new Textury[liczelem(1)+liczelem(2)+liczelem(4)+1+liczelem(3)];
        box = new Box[liczelem(4)];

        //Tworzenie mapy z lista
        for(int x=0;x<q;x++){
            for(int y=0;y<w;y++){
                if(tabmap[x][y]==1){ list.add(new Wall(x,y,laypane)); liczwall++;}
                if(tabmap[x][y]==2){ list.add(new Floor(x,y,laypane)); liczfloor++;}
                if(tabmap[x][y]==3){ list.add(new EndFloor(x,y,laypane)); liczendfloor++;}
                if(tabmap[x][y]==4){ list.add(new Floor(x,y,laypane)); liczfloor++; box[liczbox] = new Box(x,y,laypane); liczbox++;tabmap[x][y]=2;}
                if(tabmap[x][y]==5){ list.add(new Floor(x,y,laypane)); liczfloor++; robot = new Robot(x,y,laypane);tabmap[x][y]=2;}
            }
        }
        //Tworzenie mapy
//		for(int x=0;x<q;x++){
//			for(int y=0;y<w;y++){
//				if(tabmap[x][y]==1){ textury[liczwall+liczfloor+liczendfloor] = new Wall(x,y,laypane); liczwall++;}
//				if(tabmap[x][y]==2){ textury[liczwall+liczfloor+liczendfloor] = new Floor(x,y,laypane); liczfloor++;}
//				if(tabmap[x][y]==3){ textury[liczwall+liczfloor+liczendfloor] = new EndFloor(x,y,laypane); liczendfloor++;}
//				if(tabmap[x][y]==4){ textury[liczwall+liczfloor+liczendfloor] = new Floor(x,y,laypane); liczfloor++; box[liczbox] = new Box(x,y,laypane); liczbox++;tabmap[x][y]=2;}
//				if(tabmap[x][y]==5){ textury[liczwall+liczfloor+liczendfloor] = new Floor(x,y,laypane); liczfloor++; robot = new Robot(x,y,laypane);tabmap[x][y]=2;}
//			}
//		}

        //Buttony
        up = new JButton();
        up.setBounds(60,150,50,50);
        laypane.add(up, new Integer(1), 0);
        up.setFocusable(false);
        up.setIcon(new ImageIcon("src/"+Program.graf+"/up.png"));

        down = new JButton();
        down.setBounds(60,200,50,50);
        laypane.add(down, new Integer(1), 0);
        down.setFocusable(false);
        down.setIcon(new ImageIcon("src/"+Program.graf+"/down.png"));

        left = new JButton();
        left.setBounds(10,200,50,50);
        laypane.add(left, new Integer(1), 0);
        left.setFocusable(false);
        left.setIcon(new ImageIcon("src/"+Program.graf+"/left.png"));

        right = new JButton();
        right.setBounds(110,200,50,50);
        laypane.add(right, new Integer(1), 0);
        right.setFocusable(false);
        right.setIcon(new ImageIcon("src/"+Program.graf+"/right.png"));

    }

    private int liczelem(int z){
        int ret=0;
        for(int x=0;x<q;x++){
            for(int y=0;y<w;y++){
                if(tabmap[x][y]==z){ret++;}
            }
        }
        return ret;
    }

    public Robot getrobot(){

        return robot;
    }
    public Box getbox(int z){

        return box[z];
    }
    public int getliczbox(){

        return liczbox;
    }
    public int getliczendfloor(){

        return liczendfloor;
    }
    public int getmapelement(int xx, int yy){

        return tabmap[xx][yy];
    }
    public void setIloscRuchow(int ir){

        move.setText("Moves: "+ir+".");
    }
    public void setWin(){

        kom.setVisible(true);
    }
    public JButton getUpButton(){

        return up;
    }
    public JButton getDownButton(){

        return down;
    }
    public JButton getRightButton(){

        return right;
    }
    public JButton getLeftButton(){

        return left;
    }
}
