import controlP5.*;
import oscP5.*;
import netP5.*;

public float engBor = 0; // Engaged/Bored
public float exc = 0; // Excitement
public float excLon = 0; // Excitement Long Term
public float med = 0; // Meditation
public float fru = 0; // Frustration

OscP5 oscP5;
ControlP5 cp5;

Slider2D s;

void setup() {
  size(1024,768);
//  cp5 = new ControlP5(this);
//  s = cp5.addSlider2D("lines")
//         .setPosition(width-200,height-200)
//         .setSize(100,100)
//         .setArrayValue(new float[] {50, 50})
//         .setMinX(1)
//         .setMinY(1)
//         .setMaxY(5)
//         .setMaxX(5)
//         //.disableCrosshair()
//         ;
//         
//  smooth();÷
    oscP5 = new OscP5(this, 7400);
  // plug the OSC messages for the Affectiv values
  oscP5.plug(this,"updateEngBor","/AFF/Engaged/Bored");
  oscP5.plug(this,"updateExc","/AFF/Excitement");
  oscP5.plug(this,"updateExcLon","/AFF/Excitement Long Term");
  oscP5.plug(this,"updateMed","/AFF/Meditation");
  oscP5.plug(this,"updateFru","/AFF/Frustration");
}

float cnt;
void draw() {
  
  frameRate(60 );
  
  background(0);
  pushMatrix();
  translate(width/2,height/8);
  noStroke();
  fill(50);
//  rect(0, -100, 400,200);
  strokeWeight(1);
  line(0,0,200, 0);
  stroke(255);
  
 
  for(int i=1;i<50;i++) {
    
    float y0 =fru  ;
    float y1 = exc * 1.31* i ;
//    float y0 = cos(map(i-1,0,fru,-PI,PI)) * exc; 
//    float y1 = cos(map(i,0,fru,-PI,PI)) * exc;
//      float y0 = s.arrayValue()[0];
//      float y1 =  s.arrayValue()[1];

//    print("y0,y1: " + exc +","+ fru );
//    line((i-1),y0,i,y1);
    noFill();
    beginShape();
    curveVertex(i-y0,  i-y1);
    curveVertex((width*i),  height/8*i*y0*.033);
    curveVertex(width*i*y1*0.25,  height);
    curveVertex(0, 0);
    curveVertex(0, 0);
////  curveVertex(32, 100);
  endShape();  
  }
//  noFill();
  

  
  popMatrix();
}

public void updateEngBor(float theValue) {
  engBor = theValue;
//    println("eng/Bor: " + engBor);

}

public void updateExc(float theValue) {
  exc = theValue;
//  println(exc);
}

public void updateExcLon(float theValue) {
  excLon = theValue;
//  println(excLon );
}

public void updateMed(float theValue) {
  med = theValue;
  
}

public void updateFru(float theValue) {
  fru = theValue;
//  println("Fru: " + fru);
}
