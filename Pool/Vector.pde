class Vector
{
 float x;
 float y;
 float vectorLength;

Vector(Vector v)
{
  x=v.x;
 y=v.y;
 vectorLength=sqrt( (x*x) + (y*y));
 
}  

Vector(int vX,int vY)
{
 x=vX;
 y=vY;
 vectorLength=sqrt( (x*x) + (y*y));
 
 
}
float vectorLength(Vector v)
 {
  return( sqrt( (v.x*v.x) + (v.y*v.y))  );
 }

Vector vectorNormal(Vector v)
{
 float temp_fp = 1/vectorLength;
 print(v.x);
 v.x *= temp_fp;
 v.y *= temp_fp;
// print(v.x);
 return( v );
}

Vector AddVect( Vector v1, Vector v2 )
{
 Vector v=new Vector(0,0);
 v.x = v1.x + v2.x;
 v.y = v1.y + v2.y;
 return( v );
}
 

Vector SubVect( Vector v1, Vector v2 )
{
 Vector v=new Vector(0,0);
 v.x = v1.x - v2.x;
 v.y = v1.y - v2.y;
 return( v );
}

Vector ScaleIncrease( Vector v, int s )
{
 v.x *= s;
 v.y *= s;
 return( v );
}

Vector ScaleDecrease( Vector v, int s)
{
 v.x /= s;
 v.y /= s;
 return( v );
}


float DotProduct( Vector v1, Vector v2 )
{
 return((v1.x*v2.x) + (v1.y*v2.y));
}

}
 
