class Ball { 
 int xPos; 
 int yPos; 
 int bSize; 
 Vector v; 
int ballID;
  color bColor; 
int mass=1;
int oldX;
int oldY;
 //constructor 
 Ball(int theX, int theY, int theSize, int theDX, int theDY, color theColor,int ballID,int bMass) { 
   xPos = theX; 
   yPos = theY; 
   bSize = theSize; 
   this.v=new Vector(theDX,theDY); 
   this.ballID=ballID;
   bColor = theColor; 
   mass=bMass;
 } 

 //moves the ball 
 void moveMe() { 
   oldX=xPos;
   oldY=yPos;
   xPos += v.x; 
   yPos += v.y;
  
  
    if(v.x<0){
   v.x+=1;}else if(v.x>0){
   v.x-=1;}else if(v.x==0){
    } 
  if(v.y<0){
   v.y+=1;}else if(v.y>0){
   v.y-=1;}else if(v.y==0){
    }    
  // v.x-=0.05;
  // v.y-=0.05;
   bounceMe(); 
 } 

 //draws the ball 
 void drawMe() { 
   fill(bColor); 
   ellipse(xPos, yPos, bSize, bSize); 
 } 
  
 //checks for collisions with edge 
 void bounceMe() { 
   if ((xPos+(bSize*0.5) >= width) || (xPos <= 10)) 
    { v.x = -v.x;
    xPos=oldX;} 
   if ((yPos+(bSize*0.5) >= height) || (yPos <= 10)) 
  { v.y = -v.y;
   yPos=oldY; }


 }

 
 void checkBallCollision(Ball ball1, Ball ball2){
  
 //Calculate distance between circles
 int xOff=ball1.xPos-ball2.xPos;
 int yOff=ball1.yPos-ball2.yPos;
 
 float a = sq(xOff);
 float b = sq(yOff);
 float c = a + b;
 float d = abs(sqrt(c)); 

//if greater than sum of circle radii, collision occurs
 if(d<20){
 //Find normalized vector between circles
 Vector n=new Vector((xOff),(yOff)); 
 n.vectorNormal(n);
 
 //find the length along n both circles move vectors are
 
 float a1 = ball1.v.DotProduct(n,ball1.v);
 float a2 = ball2.v.DotProduct(n,ball2.v);  
 
int optimizmedP=(int)(2*(a1-a2))/(ball1.mass+ball2.mass);
optimizmedP=abs(optimizmedP);


// Calculate v1, the new movement vector of circle1


Vector v1 = new Vector(n);
v1.x=v1.x+ball1.v.x;
v1.y=v1.y+ball1.v.y;
v1.x-= (optimizmedP * ball2.mass);
v1.y-= (optimizmedP * ball2.mass);

// Calculate v2, the new movement vector of circle1

Vector v2 = new Vector(n);
v2.x=v2.x+ball1.v.x;
v2.y=v2.y+ball1.v.y;
v2.x+=(optimizmedP * ball1.mass);
v2.y+=(optimizmedP * ball1.mass);


ball1.v.x=constrain((int)v1.x,-20,20);
ball1.v.y=constrain((int)v1.y,-20,20);
ball2.v.x=constrain((int)v2.x,-25,25);
ball2.v.y=constrain((int)v2.y,-25,25);


 }

 }
}
