package sokoban;

import javax.swing.JLayeredPane;

public class Robot extends Ruchome {

    public Robot(int x, int y, JLayeredPane laypane){
        super(x,y);
        String textura="src/"+Program.graf+"/robot.png";
        draw(laypane, textura);
    }
}
