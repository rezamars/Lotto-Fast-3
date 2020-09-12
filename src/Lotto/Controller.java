/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lotto;

import Graphic.Center;
import Graphic.Left;
import Graphic.QuestionWindow;
import Graphic.Right;
import Graphic.Top;
import Model.Clear;
import Model.Ran8LottoRows;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Reza
 */
//this class is controller of the program, it contains instance variables and the main-method
public class Controller extends Application {
    
    private Top top = new Top();
    private Right right = new Right();
    private Center center = new Center();
    private Left left = new Left(right,center);
    
    private Ran8LottoRows ran11LottoRows;
    private QuestionWindow questionWindow = new QuestionWindow(right);
    
    private Clear clear = new Clear(right, left, center);
    
    
    @Override
    public void start(Stage primaryStage) {
        
        //get screenresolution
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        
        //set screen-size, procentage of screenresolution
        primaryStage.setX(primaryScreenBounds.getMinX());
        primaryStage.setY(primaryScreenBounds.getMinY());
        primaryStage.setWidth((primaryScreenBounds.getWidth())/1.3);
        primaryStage.setHeight((primaryScreenBounds.getHeight())/1.1);
        
        //Create object of the view and sending references
        View v = new View(primaryStage, top, left, center, right);
        
        ran11LottoRows = new Ran8LottoRows(right, left, center);
        
        left.setRan8RowsReference(ran11LottoRows);
        
        questionWindow.addQuestionButtonListener();
        
        clear.addClearButtonListener();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
