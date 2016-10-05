import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import oscP5.*; 
import netP5.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class AffCBoxes extends PApplet {




public float engBor = 0; // Engaged/Bored
public float exc = 0; // Excitement
public float excLon = 0; // Excitement Long Term
public float med = 0; // Meditation
public float fru = 0; // Frustration

int numSquares = 10;

OscP5 oscP5;

public void setup() {
   size(640,480); 
  frameRate(24);
  oscP5 = new OscP5(this, 7400);
  
  // plug the OSC messages for the Affectiv values
  oscP5.plug(this,"updateEngBor","/AFF/Engaged/Bored");
  oscP5.plug(this,"updateExc","/AFF/Excitement");
  oscP5.plug(this,"updateExcLon","/AFF/Excitement Long Term");
  oscP5.plug(this,"updateMed","/AFF/Meditation");
  oscP5.plug(this,"updateFru","/AFF/Frustration");
  
}

public void draw(){
 for(int i = 0; i < numSquares*numSquares; i++)
  {
//    fill(random(0,33),random(60,70),random(130,139));
//    rect(20*i,20,50,50); 
    for(int k = 0; k < numSquares*numSquares; k++){
    fill(random(0,33)*i*exc,random(60,90)*fru,random(110,139)*med);
      rect(20*i,20*k,50,50);  
    }
  } 
}

public void updateEngBor(float theValue) {
  engBor = theValue;

}

public void updateExc(float theValue) {
  exc = theValue;
}

public void updateExcLon(float theValue) {
  excLon = theValue;
}

public void updateMed(float theValue) {
  med = theValue;
  
}

public void updateFru(float theValue) {
  fru = theValue;
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--full-screen", "--bgcolor=#666666", "--hide-stop", "AffCBoxes" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
