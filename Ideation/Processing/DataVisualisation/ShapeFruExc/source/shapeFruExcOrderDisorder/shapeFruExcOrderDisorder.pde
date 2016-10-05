 
import oscP5.*;
import netP5.*;

public float engBor = 0; // Engaged/Bored
public float exc = 0; // Excitement
public float excLon = 0; // Excitement Long Term
public float med = 0; // Meditation
public float fru = 0; // Frustration

OscP5 oscP5;

void setup(){
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

void draw(){
  background(150);
 float xstart = 1;
float ynoise = 1;
translate(width/2, height/2,2);
  for(float y = -(height/8); y <=(height/8); y +=3){
    ynoise+=0.02;
    float xnoise = xstart;
    for(float x = -(width/8); x <= (width/8); x +=3){
      xnoise+=0.02;
//      drawPoint(x,y,noise(xnoise,ynoise));
      drawPoint(x,y,noise(random(ynoise*exc,xnoise*fru)));
    }
  } 
}
void drawPoint(float x, float y, float noiseFactor){
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
