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

public class LinePaintingAff extends PApplet {




public float engBor = 0; // Engaged/Bored
public float exc = 0; // Excitement
public float excLon = 0; // Excitement Long Term
public float med = 0; // Meditation
public float fru = 0; // Frustration

OscP5 oscP5;

public void setup(){
  size(1024,768);
  frameRate(30);
  smooth();
  
  oscP5 = new OscP5(this, 7400);
  // plug the OSC messages for the Affectiv values
  oscP5.plug(this,"updateEngBor","/AFF/Engaged/Bored");
  oscP5.plug(this,"updateExc","/AFF/Excitement");
  oscP5.plug(this,"updateExcLon","/AFF/Excitement Long Term");
  oscP5.plug(this,"updateMed","/AFF/Meditation");
  oscP5.plug(this,"updateFru","/AFF/Frustration");
  
  
}

public void draw(){
  
  for(int i = 0; i < 30; i++){
   stroke(69,138,207); //Blue - Excitment
   line(0,45*(exc+0.01f)*i,width,45*(exc+0.01f)*i);
//   rect(0,45*i,width,45*i);   
   stroke(229,65,118); // Red - Frustration
//   line(0,(46.69+1.61)*i+.08,width,(46.69+1.61)*i+0.08);
   line(0,(46.69f*(fru+1.61f))*i+.08f,width,(46.69f*(fru+1.61f))*i+0.08f);
   stroke(219,190,62); //Gold - engBor
   line(0,(46.69f*(engBor+1.61f))*i+.08f,width,(46.69f*(engBor+1.61f))*i+0.08f);
   stroke(219,118,57); // Orange - Med
   line(0,45*(med+0.01f)*i,width,45*(med+0.01f)*i);
   stroke(120,229,0); //excLong term
   line(0,15*(excLon+0.01f)*i,width,15*(excLon+0.01f)*i);

  } 
  println(engBor, exc );
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
    String[] appletArgs = new String[] { "--full-screen", "--bgcolor=#666666", "--hide-stop", "LinePaintingAff" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
