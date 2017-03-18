package sokoban;

import java.awt.*;
import javax.swing.*;

public class ImageImplement extends JPanel {

    private Image img;

    public ImageImplement(String img) {
        this(Toolkit.getDefaultToolkit().createImage(img));
    }

    public ImageImplement(Image img) {
        this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(new GridBagLayout());
    }

    public void paintComponent(Graphics g) {

        g.drawImage(img, 0, 0, this);
    }
}
