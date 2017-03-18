package sokoban;

import javax.swing.JLayeredPane;

public class Box extends Ruchome {

    public Box(int x, int y, JLayeredPane laypane){
        super(x,y);
        String textura="src/"+Program.graf+"/skrzynka.png";
        draw(laypane,textura);
    }
}
