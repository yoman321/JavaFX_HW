/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q14_27;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**^S
 *
 * @author luoph
 */
public class Q14_27 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        //Create clock
        ClockPane clock = new ClockPane();
        
        //Creatte pane
        BorderPane pane = new BorderPane();
        
        //Create label
        String timeString = clock.getHour()+":"+clock.getMinute()+":"+clock.getSecond();
        Label timeLabel = new Label(timeString);
        
        //Add clock and label to pane
        pane.setCenter(clock);
        pane.setBottom(timeLabel);
        pane.setAlignment(timeLabel, Pos.BOTTOM_CENTER);
        
        Scene scene = new Scene(pane, 250, 250);
        primaryStage.setTitle("Q14.27");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**z
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
