/////////////////////////////////////////////////////////// 
//globals 
Ball[] theBalls; 
int numBalls; 
int totalBalls = 17; 

void setup() {  
 ellipseMode(CENTER); 
size(400,600);
 theBalls = new Ball[totalBalls]; 
 numBalls = 0;
frameRate(15); 

int x=200;
 int nX;
 int y=400;
 int redFlag=0;
 
 for(int i=1;i<6;i++){
 nX=x;
 for(int n=1;n<(i+1);n++){
 color aColor=color(0,0,0);
 if (redFlag==0)
 {
 aColor = color(255,255,0);
 redFlag=1;
 }
 else
 {
 aColor = color(255,0,0);
 redFlag=0;
 }
 theBalls[numBalls]=new Ball(nX,y,20,0,0,aColor,numBalls,1);
 nX+=20;
 numBalls++;
 }
 y+=20;
 x-=10;
 }

}  

void draw() {  
 color backDrop=color(0,255,0);
 background(backDrop); 

 for (int i=0; i < numBalls; i++) { 
    
   for(int j=0;j < numBalls;j++){
   
   if(theBalls[i]!=theBalls[j]){
   theBalls[i].checkBallCollision(theBalls[i],theBalls[j]);
   }
   }
   }
 for (int i=0; i < numBalls; i++){
   theBalls[i].moveMe(); 
   theBalls[i].drawMe();
 }
 drawCorners();
 loop(); 
}  



void keyPressed(){ 
 if (keyCode == ENTER) { 
   //create a new ball 
   if(numBalls+1!=totalBalls){
   color aColor = color(255,255,255); 
   theBalls[numBalls] = new Ball(100,(int) random(height-20), 20,0,-10, aColor,numBalls,2); 
    numBalls = (numBalls+1)%totalBalls; 
   }else
   {
     theBalls[15].v.x=-20;
     theBalls[15].v.y=-20;
   }
 
 } 

 if (keyCode == UP)
  {
   theBalls[15].v.y=-20;
  }
  if (keyCode == DOWN)
  {
    theBalls[15].v.y=20;
  }
  if (keyCode == LEFT)
  {
   theBalls[15].v.x=-20;
  }
  if (keyCode == RIGHT)
  {
   theBalls[15].v.x=20;
  } 
  
  }

void drawCorners()
{
   int x1=0;
   int y1=0;
   
   int x2=width;
   int y2=0;
   
   int x5=0;
   int y5=height;
   
   int x6=width;
   int y6=height;
   
   
   fill(0,0,0); 
   ellipse(x1,y1,50,50); 
   ellipse(x2,y2,50,50); 
   ellipse(x5,y5,50,50); 
   ellipse(x6,y6,50,50); 
}
