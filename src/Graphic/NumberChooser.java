/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphic;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Reza
 */
//this class handles the window that the user can click which 3 fixed numbers
//he or she choses to have in all the 8 rows from the 35 numbers
public class NumberChooser {
    
    private BorderPane borderPane = new BorderPane();
    private Stage numberChooserStage = new Stage();
    private Scene ncScene = new Scene(borderPane, 535, 160);
    private Button[] buttonArray = new Button[35];
    private Left left1;
    private Label[] fixed3LabelArray;
    private int fixedIndex = 0;
    private  String strAdd = "  ";
    private int[] fixed3NumbersArray;
    private HBox[] hboxArray = new HBox[7];
    
    private NumberChooser numberChooser;
    
    
    public NumberChooser(Left left){
        
        this.left1 = left;
        this.fixed3NumbersArray = left1.get3FixedNumbersArray();
        this.fixed3LabelArray = left1.getFixed3LabelArray();
        this.numberChooser = left1.getNumberChooser();
        
    }
    
    //Cretaes objects of the Hbox-array and the buttonarray and adds the buttons to the hboxes
    //It also sets font and sizes
    public void initButtonArray(){
        
        //create new objects of the hboxes
        for (int h = 0 ; h < hboxArray.length ; h++){
            hboxArray[h] = new HBox();
        }
        
        Font buttonFont ;
        buttonFont = Font.font("Arial", FontWeight.BOLD, 20);
        
        //adding the buttons to the layout
        for (int y = 0 ; y < buttonArray.length ; y++){
            buttonArray[y] = new Button("" + (y+1) + "");
            if(y<9){
                buttonArray[y].setText(" " + (y+1) + " ");
                hboxArray[0].getChildren().add(buttonArray[y]);
            }
            else if(y == 9){
                buttonArray[y].setText("" + (y+1) + "");
                hboxArray[0].getChildren().add(buttonArray[y]);
            }
            else if((y>9) && (y<20)){
                hboxArray[1].getChildren().add(buttonArray[y]);
            }
            else if((y>19) && (y<30)){
                hboxArray[2].getChildren().add(buttonArray[y]);
            }
            else if((y>29) && (y<35)){
                hboxArray[3].getChildren().add(buttonArray[y]);
            }
            
            buttonArray[y].setFont(buttonFont);
            buttonArray[y].setMinSize(35, 25);
        }
        
    }
    
    //addes the hboxes to the window and sets some settings and properties
    public void initNumberChooser(int index){
        
        fixedIndex = index;
        
        numberChooserStage.setTitle("Välj nummer!");
        
        VBox topd = new VBox();
        topd.setPadding(new Insets(0, 10, 0, 10));  
        topd.setSpacing(1);
        
        topd.getChildren().addAll(hboxArray);
        
        borderPane.setTop(topd);
        
        numberChooserStage.setScene(ncScene);
        
        addFixedNumberButtonListener();
        
    }
    
    //Visualizes the window
    public void showNumberChooser(){
        numberChooserStage.show();
    }
    
    
    //adds listener to the buttons in numberchooser
    //sends the index of the button clicked to the method that 
    //handles enabling and disabling of the numbers that the user
    //wants to have as fixed numbers
    //When the user choses the number, the window closes
    public void addFixedNumberButtonListener(){
	     
        for(int x = 0 ; x < buttonArray.length ; x++){
                
	        buttonArray[x].setOnMouseClicked(event -> {
                    
                    showNumberChooser();
                    for(int loopIndex = 0 ; loopIndex < buttonArray.length ; loopIndex++){
                        
                        if(event.getSource() == buttonArray[loopIndex]){
                            
                            if (loopIndex < 9){
                                strAdd = "  " + Integer.toString(loopIndex+1) + " ";
                            }
                            else {
                                strAdd = "" + Integer.toString(loopIndex+1) + " ";
                            }
                            fixed3LabelArray[fixedIndex].setText(strAdd);
                            setFixedNumbersInNumberArrayAndDisable(fixedIndex, loopIndex);
                            
                            this.left1.getRan8Lottorows().setRanButtonEnabling();
                            
                            numberChooserStage.close();
                        }
                        
                        else {
                             
                        }
                    }
                    
                    
                });
        }
    }     
    
    //saves the number that the user want to have as fixed number 
    //enables and disables the numbers the user chooses
    public void setFixedNumbersInNumberArrayAndDisable(int exIndex, int number){
        
        int a = 0;
        a = fixed3NumbersArray[exIndex];
        
        if (a != -1){
            buttonArray[a].setDisable(false);
        }
        
        fixed3NumbersArray[exIndex] = number;
        buttonArray[number].setDisable(true);
    }
    
    public Button[] getButtonArray(){
        return this.buttonArray;
    }
    
    
}
