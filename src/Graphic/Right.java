/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphic;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;

/**
 *
 * @author Reza
 */
//the right-object of the borderpane
public class Right extends VBox{
    
    private Button explanationButton = new Button("Förklaring ?");
    private Button ranButton = new Button("Slumpa 8 rader");
    
    private HBox spaceHbox1 = new HBox();
    private HBox spaceHbox2 = new HBox();
    
    private HBox spaceHbox3 = new HBox();
    private HBox spaceHbox4 = new HBox();
    private Button clearButton = new Button("  Återställ  ");
    
    
    public Right(){
        
        this.setAlignment(Pos.TOP_CENTER);
        
        this.setPadding(new Insets(75, 10, 10, 10));  
        this.setSpacing(1);
        
        //get screenresolution
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        double width = primaryScreenBounds.getWidth();
        
        
        //Setting font and settings of the explanation-button
        explanationButton.setStyle("-fx-text-fill: orange;");
        Font explButtonFont ;
        explButtonFont = Font.font("Arial", FontWeight.BOLD, 20);
        explanationButton.setFont(explButtonFont);
        explanationButton.setMinSize(100, 40);
        this.getChildren().add(explanationButton);
        
        //HBox that acts to fill up space
        spaceHbox1.setPadding(new Insets(10, 10, 100, (width/8)));
        
        this.getChildren().add(spaceHbox1);
        
        
        //setting properties and font of ranbutton
        ranButton.setDisable(true);
        ranButton.setStyle("-fx-text-fill: blue;");
        Font countButtonFont ;
        countButtonFont = Font.font("Arial", FontWeight.BOLD, 20);
        ranButton.setFont(countButtonFont);
        ranButton.setMinSize(100, 40);
        
        //HBox that acts to fill up space
        spaceHbox2.setPadding(new Insets(10, 10, 10, (width/8)));
        
        //add items to the screen
        this.getChildren().add(ranButton);
        this.getChildren().add(spaceHbox2);
          
        //setting font and color of clearbutton
        Font clearButtonFont ;
        clearButtonFont = Font.font("Arial", FontWeight.BOLD, 20);
        clearButton.setFont(clearButtonFont);
        clearButton.setStyle("-fx-text-fill: purple;");
        clearButton.setMinSize(100, 40);
        
        spaceHbox3.setPadding(new Insets(65, 10, 10, (width/8)));
        
        this.getChildren().add(spaceHbox3);
        this.getChildren().add(clearButton);
        
    }
    
    
    public Button getRanButton(){
        return this.ranButton;
    }
    
    public Button getClearButton(){
        return this.clearButton;
    }
    
    public Button getExplanationButton(){
        return this.explanationButton;
    }
    
}
