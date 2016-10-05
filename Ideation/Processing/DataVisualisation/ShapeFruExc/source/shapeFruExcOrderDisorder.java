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

public class shapeFruExcOrderDisorder extends PApplet {

 



public float engBor = 0; // Engaged/Bored
public float exc = 0; // Excitement
public float excLon = 0; // Excitement Long Term
public float med = 0; // Meditation
public float fru = 0; // Frustration

OscP5 oscP5;

public void setup(){
 size(1000,1000,P3D);
background(150);
stroke(0,50);
fill(255,200 );
  oscP5 = new OscP5(this, 7400);
// plug the OSC messages for the Affectiv values
  oscP5.plug(this,"updateEngBor","/AFF/Engaged/Bored");
  oscP5.plug(this,"updateExc","/AFF/Excitement");
  oscP5.plug(this,"updateExcLon","/AFF/Excitement Long Term");
  oscP5.plug(this,"updateMed","/AFF/Meditation");
  oscP5.plug(this,"updateFru","/AFF/Frustration");
}

public void draw(){
  background(150);
 float xstart = 1;
float ynoise = 1;
translate(width/2, height/2,2);
  for(float y = -(height/8); y <=(height/8); y +=3){
    ynoise+=0.02f;
    float xnoise = xstart;
    for(float x = -(width/8); x <= (width/8); x +=3){
      xnoise+=0.02f;
//      drawPoint(x,y,noise(xnoise,ynoise));
      drawPoint(x,y,noise(random(ynoise*exc,xnoise*fru)));
    }
  } 
}
public void drawPoint(float x, float y, float noiseFactor){
  pushMatrix();
  translate(x * noiseFactor*4,y*noiseFactor*4-y);
  float edgeSize = noiseFactor * 26;
  ellipse(0,0,edgeSize,edgeSize);
  popMatrix();
}


public void updateEngBor(float theValue) {
  engBor = theValue;
    println("eng/Bor: " + engBor);

}

public void updateExc(float theValue) {
  exc = theValue;
  println(exc);
}

public void updateExcLon(float theValue) {
  excLon = theValue;
  println(excLon );
}

public void updateMed(float theValue) {
  med = theValue;
  
}

public void updateFru(float theValue) {
  fru = theValue;
  println("Fru: " + fru);
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--full-screen", "--bgcolor=#666666", "--hide-stop", "shapeFruExcOrderDisorder" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
