package sokoban;

import javax.swing.JLayeredPane;

public class Wall extends Textury {

    public Wall(int x, int y, JLayeredPane laypane){
        super(x,y);
        String textura="src/"+Program.graf+"/sciana.png";
        draw(laypane,textura);
    }
}
