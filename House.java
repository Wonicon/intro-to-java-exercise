// assignment 4 14.4

import java.util.Date;

public class House implements Cloneable, Comparable {
  private int id;
  private double area;
  private java.util.Date whenBuilt;

  public House(int id, double area) {
    this.id = id;
    this.area = area;
    whenBuilt = new java.util.Date();
  }

  public int getId() {
    return id;
  }

  public double getArea() {
    return area;
  }

  public Date getWhenBuilt() {
    return whenBuilt;
  }

  /**
   * Override the protected clone method define in the Object
   * class, and strengthen its accessibility
   */
  @Override
  public Object clone() throws CloneNotSupportedException {
    House o = (House)super.clone();
    if (whenBuilt != null) {  // Learnt from Date.clone().
      o.whenBuilt = (java.util.Date) whenBuilt.clone();
    }
    return o;
  }

  /** Implement the compareTo method define in Comparable */
  @Override
  public int compareTo(Object o) {
    if (area > ((House)o).area)
      return 1;
    else if (area < ((House)o).area)
      return -1;
    else
      return 0;
  }
}
