package menus;

import manager.GameManager;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.Serializable;

public class Menu extends JPanel implements Serializable {

    protected final GameManager gameManager;
    protected final JFrame gameFrame;
    protected final Image backgroundImage;
    protected final Border selectedItemBorder;
    protected final Font unselectedItemFont;
    protected final Font selectedItemFont;
    protected final Color selectedItemColour;
    protected final Color unselectedItemColour;
    protected final GridBagConstraints constraints;

    public Menu(GameManager gameManager, JFrame gameFrame, Image backgroundImage, LayoutManager layoutManager) {

        super(layoutManager);
        this.gameManager = gameManager;
        this.gameFrame = gameFrame;
        this.backgroundImage = backgroundImage;
        constraints = new GridBagConstraints();

        selectedItemBorder = BorderFactory.createMatteBorder(0, 2, 10, 0, Color.YELLOW);
        unselectedItemFont = new Font("unselected", Font.BOLD, 40);
        selectedItemFont = new Font("selected", Font.BOLD, 45);
        selectedItemColour = new Color(180, 100, 0);
        unselectedItemColour = new Color(80, 10, 0);

    }

    public void getListenersReady() { }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, null);
    }

}
