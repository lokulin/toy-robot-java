package com.lauchlin.toyrobot;

public class App
{
    private Table table;
    private Robot robot;

    public App() {
        this.table = new Table(new Point(0,0), new Point(4,4));
        this.robot = new Robot(new Point(0,0), 0.0, null);
            }

    public void run() {
        robot = robot.place(new Point(0,0), 0.0, table);
        robot = robot.move();
        robot = robot.report();
    }

    public static void main( String[] args )
    {
      App app = new App();
      app.run();
    }
}
