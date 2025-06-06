/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package firstsketch;
import processing.core.PApplet;
import processing.core.PImage;

/**
 *
 * @author 342348646
 */
public class Mulan {
    public int x;
    public int y;
    private int speed;
    private PApplet app;
    private PImage image;
    private int width, height;
    private String health;
    
    public Mulan(PApplet p, int x, int y, int speed, String imagePath){
        this.app = p;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.image = app.loadImage(imagePath);
        this.width = image.width;
        this.height = image.height;
    }
    
    public boolean isCollidingWith(Mulan other){
        boolean isLeftOfOtherRight = x < other.x + other.width;
        boolean isRightOfOtherLeft = x + width > other.x;
        boolean isAboveOtherBottom = y < other.y + other.height;
        boolean isBelowOtherTop = y + height > other.y;
        return isLeftOfOtherRight && isRightOfOtherLeft && isAboveOtherBottom && isBelowOtherTop;
    }   
    public boolean isClicked(int mouseX, int mouseY){
        int centerX = x+(image.pixelWidth/2);
        int centerY = y+(image.pixelHeight/2);
        float d = PApplet.dist(mouseX, mouseY, centerX, centerY);
        
        return d < 16;
    }
    public void displayInfo(PApplet p){
        app.fill(0);
        app.text("Health: " + health, x, y-50);
    }
    public void move(int dx, int dy){
        x+=dx;
        y+=dy;
    }
    public void draw(){ 
        app.image(image, x, y);
    }
}
