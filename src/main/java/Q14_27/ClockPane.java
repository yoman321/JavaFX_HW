/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q14_27;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;

import java.util.*;
import static java.lang.System.out;
/**
 *
 * @author luoph
 */
public class ClockPane extends Pane{
    
    //Create variable
    private int hour;
    private int minute;
    private int second;
    private double graphRadius = 250;
    
    //Create constructors
    public ClockPane(){
        setCurrentTime();
        paintClock();
    }
    public ClockPane(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        paintClock();
    }
    //Create getters
    public int getHour(){
        return hour;
    }
    public int getMinute(){
        return minute;
    }
    public int getSecond(){
        return second;
    }
    public double getGraphRadius(){
        return graphRadius;
    }
    //Create setters
    public void setHour(){
        this.hour = hour;
        paintClock();
    }
    public void setMinute(){
        this.minute = minute;
        paintClock();
    }
    public void setSecond(){
        this.second = second;
        paintClock();
    }
    public void setClockRadius(){
        this.graphRadius = graphRadius;
        paintClock();
    }
    //Create methods
    public void setCurrentTime(){
        Calendar currentTime = new GregorianCalendar();
        
        this.hour = currentTime.get(Calendar.HOUR_OF_DAY);
        this.minute = currentTime.get(Calendar.MINUTE);
        this.second = currentTime.get(Calendar.SECOND);
    }
    public void paintClock(){
        //Circle variable
        double centerX = graphRadius / 2;
        double centerY = graphRadius / 2;
        double clockRadius = 100;
        double degrees = 360 / 12 / 5;
        ArrayList<Line> linesArray = new ArrayList<>();
        ArrayList<Text> numLines = new ArrayList<>();
        
        //Create clock with details
        Circle clockFrame = new Circle(centerX, centerY, clockRadius);
        clockFrame.setFill(Color.WHITE);
        clockFrame.setStroke(Color.BLACK);
        
        //Create clock lines
        for (int i=0; i<60; i++){
            double length1 = clockRadius * 0.975;
            if (i % 5 == 0){
                length1 = clockRadius * 0.95;
            }
            double length2 = clockRadius;
            double x1 = centerX + length1 *
            Math.sin(i * (2 * Math.PI / 60));
            double y1 = centerY - length1 *
            Math.cos(i * (2 * Math.PI / 60));
            double x2 = centerX + length2 *
            Math.sin(i * (2 * Math.PI / 60));
            double y2 = centerY - length2 *
            Math.cos(i * (2 * Math.PI / 60));
            linesArray.add(new Line(x1, y1, x2, y2));
        }
        
        //Create clock digits
        double angle = 30;
        for (int i=1; i<13; i++){
            double xPos = 0;
            double yPos = 0;
            
            if (angle > 90){
                angle = 30;
            }
            double angle1 = Math.toRadians(angle);
            switch(i){
                case 1: yPos = 125 - (Math.cos(angle1) * 80);
                        xPos = 125 + (Math.sin(angle1) * 80);break;
                case 2: yPos = 125 - (Math.cos(angle1) * 82);
                        xPos = 125 + (Math.sin(angle1) * 82);break;
                case 3: yPos = 130 + (Math.cos(angle1) * 85);
                        xPos = 125 + (Math.sin(angle1) * 85);break;
                case 4: yPos = 125 + (Math.sin(angle1) * 85);
                        xPos = 125 + (Math.cos(angle1) * 85);break;
                case 5: yPos = 125 + (Math.sin(angle1) * 90);
                        xPos = 125 + (Math.cos(angle1) * 80);break;
                case 6: yPos = 125 + (Math.sin(angle1) * 91);
                        xPos = 122 - (Math.cos(angle1) * 95);break;
                case 7: yPos = 125 + (Math.cos(angle1) * 95);
                        xPos = 125 - (Math.sin(angle1) * 95);break;
                case 8: yPos = 125 + (Math.cos(angle1) * 98);
                        xPos = 125 - (Math.sin(angle1) * 92);break;
                case 9: yPos = 130 - (Math.cos(angle1) * 95);
                        xPos = 125 - (Math.sin(angle1) * 90);break;
                case 10: yPos = 125 - (Math.sin(angle1) * 85);
                        xPos = 125 - (Math.cos(angle1) * 92);break;
                case 11: yPos = 125 - (Math.sin(angle1) * 82);
                        xPos = 125 - (Math.cos(angle1) * 93);break;
                case 12: yPos = 125 - (Math.sin(angle1) * 81);
                        xPos = 118 - (Math.cos(angle1) * 95);break;
            }
            numLines.add(new Text(xPos, yPos, Integer.toString(i)));
            angle += 30;
        }
        //Draw second hand
        double sLength = clockRadius * 0.8;
        double secondX = centerX + sLength *
        Math.sin(second * (2 * Math.PI / 60));
        double secondY = centerY - sLength *
        Math.cos(second * (2 * Math.PI / 60));
        Line sLine = new Line(centerX, centerY, secondX, secondY);
        sLine.setStroke(Color.RED);
        
        // Draw minute hand
        double mLength = clockRadius * 0.65;
        double xMinute = centerX + mLength *
        Math.sin(minute * (2 * Math.PI / 60));
        double minuteY = centerY - mLength *
        Math.cos(minute * (2 * Math.PI / 60));
        Line mLine = new Line(centerX,centerY, xMinute, minuteY); 
         mLine.setStroke(Color.BLUE);
        
         // Draw hour hand
        double hLength = clockRadius * 0.5;
        double hourX = centerX + hLength *
        Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        double hourY = centerY - hLength *
        Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        Line hLine = new Line(centerX, centerY, hourX, hourY);
        hLine.setStroke(Color.GREEN);
        
        //Add everything to pane
        getChildren().clear();
        getChildren().addAll(clockFrame, sLine, mLine, hLine);
        for (int i=0; i<linesArray.size(); i++){
            getChildren().add(linesArray.get(i));
        }
        for (int i=0; i<numLines.size(); i++){
            getChildren().add(numLines.get(i));
        }
    }
    
}
