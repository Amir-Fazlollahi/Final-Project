package entities.plants;

import entities.bullets.Bullet;
import entities.bullets.RadicalPea;
import graphics.ThreadPool;
import managers.GamePlayer;
import sounds.SoundPlayer;

import javax.swing.*;
import java.awt.*;

public class GaltingPeaShooter extends Plant {

    private static final String path = "Game accessories\\sounds\\shoot.wav";

    public GaltingPeaShooter(int xLocation, int yLocation, GamePlayer gamePlayer) {
        super(70, xLocation, yLocation, gamePlayer, 188, 144);
    }

    @Override
    public void initialise(GamePlayer gamePlayer) {
        super.initialise(gamePlayer);
        setAppearance(new ImageIcon("Game accessories\\images\\Gifs\\Gatling-Pea-unscreen.gif").getImage());
    }

    @Override
    public void setAppearance(Image appearance) {
        super.setAppearance(appearance);
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
    public int getWidth() {
        return super.getWidth();
    }

    @Override
    public int getHeight() {
        return super.getHeight();
    }

    @Override
    public Image getAppearance() {
        return super.getAppearance();
    }

    @Override
    public synchronized void injure(int lifeTakenAway) {
        super.injure(lifeTakenAway);
    }

    public void shoot() {
        if(gamePlayer.isNotMuted())
            ThreadPool.execute(new SoundPlayer(path, 500, false));
        Bullet newBullet = new RadicalPea(xLocation, yLocation, gamePlayer);
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
                    Thread.sleep(400);
                    shoot();
                } catch (InterruptedException ignore) {
                }
            }
        }
        if(life == 0) {
            try {
                Thread.sleep(750);
            } catch (InterruptedException ignore) {
            }
            die();
        }
    }
}
