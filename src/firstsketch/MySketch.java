/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package firstsketch;
import processing.core.PApplet;

/**
 *
 * @author 342348646
 */
public class MySketch extends PApplet {
    private Mulan mulan;
    String userInput = "";
    private boolean showInfo = false;
    private boolean showInfo2 = false;
    int stage = 0;
    static final int speed = 1;
    int health = 100;
 
  public void settings() {
    size(400, 400);
  }

  public void setup() {
    background(255);
    textSize(20);
    mulan = new Mulan(this, 20, 30, speed, "images/person.png");
  }
  
  public void draw() {
    background(255);
        
    if (stage == 0){
        fill(0);
        if (stage == 0){
            fill(0);
            text("Press Enter to continue", 20, 50);
            text(userInput, 20, 100);
        } else if (stage == 1){
            mulan.draw();
        }
    }
    
    if (keyPressed){
        if (keyCode == LEFT){
            mulan.move(-speed, 0);
        } else if (keyCode == RIGHT){
            mulan.move(speed, 0);
        } else if (keyCode == UP){
            mulan.move(0,-speed);
        } else if (keyCode == DOWN){
            mulan.move(0,speed);
        }
    }
    if (showInfo){
        mulan.displayInfo(this);
    }
  }
  
    public void keyPressed(){
        if (stage == 0){
            if (keyCode == ENTER){
                stage = 1;
                mulan = new Mulan(this, 20, 30, speed, "images/person.png");
            } else if (key != CODED){
                userInput += key;
            }
        }
    }
    
  public void mousePressed(){
      if (mulan.isClicked(mouseX,mouseY)){
          showInfo = !showInfo;
      } else {
          showInfo = false;
      }
  }
}