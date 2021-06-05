
import java.awt.Point;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sambasu
 */
public class boba {
    private int x;
    private int y;
    private int width;
    private int height;
    private String message;

    public boba(int x, int y , int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
      
    }

    public boolean insideBoba(Point p) {
        double mouseX = p.getX();
        double mouseY = p.getY();

        boolean insideX = mouseX > x && mouseX < (x + width);
        boolean insideY = mouseY > y && mouseY < (y + height);

        return insideX && insideY;
    }


    //getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    //setters
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}
