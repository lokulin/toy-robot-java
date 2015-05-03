package com.lauchlin.toyrobot;
import com.lauchlin.toyrobot.Util.*;

public class Robot {

  private Point location;
  private double facing;
  private Table table;

  public Robot(Point location, double facing, Table table)
  {
    this.location = location;
    this.facing = facing;
    this.table = table;
  }

  public Robot move() {
    return this.place(this.location.plus(new Point(Math.sin(Math.PI * facing),
                                            Math.cos(Math.PI * facing))),
                      this.facing,
                      this.table);
  }

  public Robot left() {
    return this.place(this.location, Util.fmod(this.facing - 0.5, 2.0), this.table);
  }

  public Robot right() {
    return this.place(this.location, Util.fmod(this.facing + 0.5, 2.0), this.table);
  }

  public Robot report() {
    if ( table != null ) System.out.println(this.location.toString() + "," + this.facing);
    return this;
  }

  public Robot place(Point location, double facing, Table table) {
    if ( table != null && table.contains(location) ) {
      return new Robot(location, facing, table);
    } else {
      return this;
    }
  }

}
