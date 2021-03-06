package entities.plants;

import entities.bullets.Bullet;
import entities.bullets.FrozenPea;
import graphics.ThreadPool;
import managers.GamePlayer;
import sounds.SoundPlayer;
import javax.swing.*;
import java.awt.*;

/**
 * Represents the snow-pea shooters
 */
public class SnowPea extends Plant {

    private static final String path = "Game accessories\\sounds\\shoot.wav";

    /**
     * Instantiates this class
     * @param xLocation The initial x location
     * @param yLocation The initial y location
     * @param gamePlayer The owning game player
     */
    public SnowPea(int xLocation, int yLocation, GamePlayer gamePlayer) {
        super(100, xLocation, yLocation, gamePlayer, 150, 150);
    }

    @Override
    public void initialise(GamePlayer gamePlayer) {
        super.initialise(gamePlayer);
        setAppearance(new ImageIcon("Game accessories\\images\\Gifs\\SnowPea-Shooter-unscreen.gif").getImage());
    }

    @Override
    public void setAppearance(Image appearance) {
        super.setAppearance(appearance);
    }

    @Override
    public int getYLocation() {
        return super.getYLocation();
    }

    @Override
    public int getXLocation() {
        return super.getXLocation();
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
    public synchronized void injure(int lifeTakenAway) {
        super.injure(lifeTakenAway);
    }

    /**
     * Creates and has executed a new bullet
     */
    public void shoot() {
        if(gamePlayer.isNotMuted())
            ThreadPool.execute(new SoundPlayer(path, 500, false));
        Bullet newBullet = new FrozenPea(xLocation, yLocation, gamePlayer);
        newBullet.initialise(gamePlayer);
        gamePlayer.add(newBullet);
        ThreadPool.execute(newBullet);
    }

    @Override
    public void die() {
        super.die();
    }

    @Override
    public void run() {
        while (gamePlayer.isNotGameFinished() && life > 0) {
            if(gamePlayer.isGamePaused()) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ignore) { }
            } else {
                try {
                    Thread.sleep(1000);
                    shoot();
                } catch (InterruptedException ignore) {
                }
            }
        }
        if(life == 0) {
            setAppearance(new ImageIcon("Game accessories\\images\\Gifs\\pea_shooter_dying.gif").getImage());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignore) { }
            die();
        }
    }
}
