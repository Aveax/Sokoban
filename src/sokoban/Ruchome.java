package sokoban;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Ruchome extends Object {

    private int tab_x;
    private int tab_y;
    private int map_x;
    private int map_y;
    private JPanel panel;

    public Ruchome(int x, int y){
        this.tab_x=x;
        this.tab_y=y;
        this.map_x=50*y+200;
        this.map_y=50*x;
    }
    void draw(JLayeredPane laypane, String textura){
        panel = new ImageImplement(textura);
        panel.setSize(50,50);
        panel.setLocation(map_x, map_y);
        laypane.add(panel, new Integer(1), 0);
    }
    void mapxy(){
        this.map_x=50*tab_y+200;
        this.map_y=50*tab_x;
        panel.setLocation(map_x, map_y);
    }
    int get_x(){
        return tab_x;
    }
    int get_y(){
        return tab_y;
    }

    void up(){
        this.tab_x--;
        mapxy();
        panel.setLocation(map_x, map_y);
    }
    void down(){
        this.tab_x++;
        mapxy();
        panel.setLocation(map_x, map_y);
    }
    void left(){
        this.tab_y--;
        mapxy();
        panel.setLocation(map_x, map_y);
    }
    void right(){
        this.tab_y++;
        mapxy();
        panel.setLocation(map_x, map_y);
    }
}
