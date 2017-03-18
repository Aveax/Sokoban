package sokoban;

import javax.swing.JLayeredPane;

public class EndFloor extends Textury {

    public EndFloor(int x, int y, JLayeredPane laypane){
        super(x,y);
        String textura="src/"+Program.graf+"/end.png";
        draw(laypane, textura);
    }
}
