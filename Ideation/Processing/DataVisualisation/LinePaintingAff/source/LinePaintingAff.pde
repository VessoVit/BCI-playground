import oscP5.*;
import netP5.*;

public float engBor = 0; // Engaged/Bored
public float exc = 0; // Excitement
public float excLon = 0; // Excitement Long Term
public float med = 0; // Meditation
public float fru = 0; // Frustration

OscP5 oscP5;

void setup(){
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

void draw(){
  
  for(int i = 0; i < 30; i++){
   stroke(69,138,207); //Blue - Excitment
   line(0,45*(exc+0.01)*i,width,45*(exc+0.01)*i);
//   rect(0,45*i,width,45*i);   
   stroke(229,65,118); // Red - Frustration
//   line(0,(46.69+1.61)*i+.08,width,(46.69+1.61)*i+0.08);
   line(0,(46.69*(fru+1.61))*i+.08,width,(46.69*(fru+1.61))*i+0.08);
   stroke(219,190,62); //Gold - engBor
   line(0,(46.69*(engBor+1.61))*i+.08,width,(46.69*(engBor+1.61))*i+0.08);
   stroke(219,118,57); // Orange - Med
   line(0,45*(med+0.01)*i,width,45*(med+0.01)*i);
   stroke(120,229,0); //excLong term
   line(0,15*(excLon+0.01)*i,width,15*(excLon+0.01)*i);

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
