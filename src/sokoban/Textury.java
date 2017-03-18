package sokoban;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Textury extends Object {
    private int map_x;
    private int map_y;
    private JPanel panel;

    public Textury(int x, int y){
        this.map_x=50*y+200;
        this.map_y=50*x;
    }
    void draw(JLayeredPane laypane, String textura){
        panel = new ImageImplement(textura);
        panel.setSize(50,50);
        panel.setLocation(map_x, map_y);
        laypane.add(panel, new Integer(0), 0);
    }
}
