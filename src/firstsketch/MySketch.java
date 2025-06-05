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
    private Car car1;
    private Car car2;
    private boolean showInfo = false;
    private boolean showInfo2 = false;
 
  public void settings() {
    size(400, 400);
  }

  public void setup() {
    background(255);
    car1 = new Car(this, 0, 200, 10, "images/car.png");
    car2 = new Car(this, 50, 250, 1, "images/car.png");
  }
  
  public void draw() {
    background(255);
    car1.draw();
    car2.draw();
    drawCollisions();
    
    if (keyPressed){
        if (keyCode == LEFT){
            car1.move(-5, 0);
        } else if (keyCode == RIGHT){
            car1.move(5, 0);
        } else if (keyCode == UP){
            car1.move(0,-5);
        } else if (keyCode == DOWN){
            car1.move(0,5);
        }
    }
    if (showInfo){
        car2.displayInfo(this);
    }
    if (showInfo2){
        car1.displayInfo(this);
    }
  }
  
  public void mousePressed(){
      if (car2.isClicked(mouseX,mouseY)){
          showInfo = !showInfo;
      } else {
          showInfo = false;
      }
      if (car1.isClicked(mouseX, mouseY)){
          showInfo2 = !showInfo2;
      } else {
          showInfo2 = false;
      }
  }
  
  public void drawCollisions(){
      if(car1.isCollidingWith(car2)){
          fill(255,0,0);
          this.text("oouch",car2.x, car2.y);
      }
  }
}
