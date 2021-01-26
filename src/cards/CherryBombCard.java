package cards;

import enums.GameDifficulty;
import javax.swing.*;
import java.awt.*;

public class CherryBombCard extends Card {

    private final int rechargeTime;
    private static CherryBombCard cherryBombCard = null;

    private CherryBombCard(GameDifficulty gameDifficulty, int xLocation, int yLocation) {
        super(new ImageIcon("Game accessories\\images\\Cards\\card_cherrybomb.png").getImage(),
                xLocation, yLocation, 150);
        if(gameDifficulty == GameDifficulty.HARD)
            rechargeTime = 45000;
        else rechargeTime = 30000;
    }

    public static CherryBombCard getInstance(GameDifficulty gameDifficulty, int xLocation, int yLocation) {
        if(cherryBombCard == null)
            cherryBombCard = new CherryBombCard(gameDifficulty, xLocation, yLocation);
        return cherryBombCard;
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
    }

    @Override
    public void setCardImage(Image cardImage) {
        super.setCardImage(cardImage);
    }

    @Override
    public Image getCardImage() {
        return super.getCardImage();
    }

    @Override
    public int getXLocation() {
        return super.getXLocation();
    }

    @Override
    public int getYLocation() {
        return super.getYLocation();
    }

    @Override
    public int getRequiredEnergy() {
        return super.getRequiredEnergy();
    }

    @Override
    public int getWidth() {
        return super.getWidth();
    }

    @Override
    public int getHeight() {
        return super.getHeight();
    }

    @Override
    public boolean getEnabled() {
        return super.getEnabled();
    }

    @Override
    public void use() {
        setCardImage(new ImageIcon("Game accessories\\images\\Cards\\card_cherrybomb_used.png").getImage());
        setEnabled(false);
        try {
            Thread.sleep(rechargeTime);
        } catch (InterruptedException ignore) { }
        setCardImage(new ImageIcon("Game accessories\\images\\Cards\\card_cherrybomb.png").getImage());
        setEnabled(true);
    }

    @Override
    public void run() {
        use();
    }
}
