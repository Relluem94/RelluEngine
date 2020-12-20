package de.relluem94.vulcan.toolbox.generators;

public class AABB
{
  private float epsilon = 0.0F;
  public float x0;
  public float y0;
  public float z0;
  public float x1;
  public float y1;
  public float z1;
  
  public AABB(float x0, float y0, float z0, float x1, float y1, float z1)
  {
    this.x0 = x0;
    this.y0 = y0;
    this.z0 = z0;
    this.x1 = x1;
    this.y1 = y1;
    this.z1 = z1;
  }
  
  public String toString(){
	  return "X0:" + x0 + " Y0:" + y0 + " Z0:" + z0 + " X1:" + x1 + "Y1:" + y1 + " Z1:" + z1;
  }
  
  public AABB expand(float xa, float ya, float za)
  {
    float _x0 = this.x0;
    float _y0 = this.y0;
    float _z0 = this.z0;
    float _x1 = this.x1;
    float _y1 = this.y1;
    float _z1 = this.z1;
    if (xa < 0.0F) {
      _x0 += xa;
    }
    if (xa > 0.0F) {
      _x1 += xa;
    }
    if (ya < 0.0F) {
      _y0 += ya;
    }
    if (ya > 0.0F) {
      _y1 += ya;
    }
    if (za < 0.0F) {
      _z0 += za;
    }
    if (za > 0.0F) {
      _z1 += za;
    }
    return new AABB(_x0, _y0, _z0, _x1, _y1, _z1);
  }
  
  public AABB grow(float xa, float ya, float za)
  {
    float _x0 = this.x0 - xa;
    float _y0 = this.y0 - ya;
    float _z0 = this.z0 - za;
    float _x1 = this.x1 + xa;
    float _y1 = this.y1 + ya;
    float _z1 = this.z1 + za;
    
    return new AABB(_x0, _y0, _z0, _x1, _y1, _z1);
  }
  
  public float clipXCollide(AABB c, float xa)
  {
    if ((c.y1 <= this.y0) || (c.y0 >= this.y1)) {
      return xa;
    }
    if ((c.z1 <= this.z0) || (c.z0 >= this.z1)) {
      return xa;
    }
    if ((xa > 0.0F) && (c.x1 <= this.x0))
    {
      float max = this.x0 - c.x1 - this.epsilon;
      if (max < xa) {
        xa = max;
      }
    }
    if ((xa < 0.0F) && (c.x0 >= this.x1))
    {
      float max = this.x1 - c.x0 + this.epsilon;
      if (max > xa) {
        xa = max;
      }
    }
    return xa;
  }
  
  public float clipYCollide(AABB c, float ya)
  {
    if ((c.x1 <= this.x0) || (c.x0 >= this.x1)) {
      return ya;
    }
    if ((c.z1 <= this.z0) || (c.z0 >= this.z1)) {
      return ya;
    }
    if ((ya > 0.0F) && (c.y1 <= this.y0))
    {
      float max = this.y0 - c.y1 - this.epsilon;
      if (max < ya) {
        ya = max;
      }
    }
    if ((ya < 0.0F) && (c.y0 >= this.y1))
    {
      float max = this.y1 - c.y0 + this.epsilon;
      if (max > ya) {
        ya = max;
      }
    }
    return ya;
  }
  
  public float clipZCollide(AABB c, float za)
  {
    if ((c.x1 <= this.x0) || (c.x0 >= this.x1)) {
      return za;
    }
    if ((c.y1 <= this.y0) || (c.y0 >= this.y1)) {
      return za;
    }
    if ((za > 0.0F) && (c.z1 <= this.z0))
    {
      float max = this.z0 - c.z1 - this.epsilon;
      if (max < za) {
        za = max;
      }
    }
    if ((za < 0.0F) && (c.z0 >= this.z1))
    {
      float max = this.z1 - c.z0 + this.epsilon;
      if (max > za) {
        za = max;
      }
    }
    return za;
  }
  
  public boolean intersects(AABB c)
  {
    if ((c.x1 <= this.x0) || (c.x0 >= this.x1)) {
      return false;
    }
    if ((c.y1 <= this.y0) || (c.y0 >= this.y1)) {
      return false;
    }
    if ((c.z1 <= this.z0) || (c.z0 >= this.z1)) {
      return false;
    }
    return true;
  }
  
  
  public boolean intersectX(AABB c)
  {
    if ((c.y1 <= this.y0) || (c.y0 >= this.y1)) {
      return false;
    }
    if ((c.z1 <= this.z0) || (c.z0 >= this.z1)) {
      return false;
    }
    return true;
  }
  
  public boolean intersectY(AABB c)
  {
    if ((c.x1 <= this.x0) || (c.x0 >= this.x1)) {
      return false;
    }
    if ((c.z1 <= this.z0) || (c.z0 >= this.z1)) {
      return false;
    }
    return true;
  }
  
  public boolean intersectZ(AABB c)
  {
    if ((c.x1 <= this.x0) || (c.x0 >= this.x1)) {
      return false;
    }
    if ((c.y1 <= this.y0) || (c.y0 >= this.y1)) {
      return false;
    }
    return true;
  }
  
  public void move(float xa, float ya, float za)
  {
    this.x0 += xa;
    this.y0 += ya;
    this.z0 += za;
    this.x1 += xa;
    this.y1 += ya;
    this.z1 += za;
  }
}