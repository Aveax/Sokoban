package sokoban;

import javax.swing.JLayeredPane;

public class Floor extends Textury {

    public Floor(int x, int y, JLayeredPane laypane){
        super(x,y);
        String textura="src/"+Program.graf+"/podloga.png";
        draw(laypane,textura);
    }
}
