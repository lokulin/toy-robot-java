package com.lauchlin.toyrobot;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.util.stream.Stream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class App
{
    private Table table;
    private Robot robot;

    public App() {
        this.table = new Table(new Point(0,0), new Point(4,4));
        this.robot = new Robot(new Point(0,0), 0.0, null);
    }

    public static void run(String line) {
        System.out.println(line);
        //robot = robot.place(new Point(0,0), 0.0, table);
        //robot = robot.move();
        //robot = robot.report();
    }

    public static void main( String[] args )
    {
      //App app = new App();

      try {
        Stream<String> stream;

        if (args.length == 0) {
          stream = (new BufferedReader(new InputStreamReader(System.in))).lines();
        } else {
          stream = Files.lines(Paths.get(args[0]), Charset.defaultCharset());
        }

        stream.forEach(App::run);
      } catch (IOException | SecurityException ex) {
        System.out.println("Could not read input.");
      }
    }
}
