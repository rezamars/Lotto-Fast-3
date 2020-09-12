/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Graphic.Center;
import Graphic.Left;
import Graphic.Right;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author Reza
 */
//this class handles the clear button to reset the chosen numbers
//and resets the rows randomized
public class Clear {
    
    private Button clearButton;
    private Button ranButton;
    private Right right;
    private Left left;
    private Center center;
    
    private Label[] fixed4LabelArray;
    private int[] fixed4NumbersArray;
    
    private Button[] NChooserButtonArray;
    private Label[] lottoLabelArray;
    
    
    public Clear(Right right1, Left left1, Center center1){
        
        this.right = right1;
        this.clearButton = right1.getClearButton();
        this.left = left1;
        this.center = center1;
        this.lottoLabelArray = center.getLottoLabelArray();
        
        this.fixed4LabelArray = left.getFixed4LabelArray();
        this.fixed4NumbersArray = left.get4FixedNumbersArray();
        
        this.ranButton = right.getRanButton();
        this.NChooserButtonArray = left.getNumberChooser().getButtonArray();
        
        
        addClearButtonListener();
        
    }
    
    //adds listener to the clear-button
    //resets the fixed numbers and enables all the numbers to choose
    public void addClearButtonListener(){
        
        clearButton.setOnAction(e -> {
            
            for(int y = 0 ; y < 4 ; y++){
                fixed4LabelArray[y].setText("     ");
                fixed4NumbersArray[y] = -1;
            }
            for(int z = 0 ; z < 35 ; z++){
                NChooserButtonArray[z].setDisable(false);
            }
            for(int i = 0 ; i < 77 ; i++){
                lottoLabelArray[i].setStyle("-fx-border-color: none;");
                lottoLabelArray[i].setBackground(null);
            }
            
            ranButton.setDisable(true);
            clearLottoRows();
        });
            
    }
    
    //clears the labels for the lottorows
    public void clearLottoRows(){
        
        for(int w = 0 ; w < lottoLabelArray.length ; w++){
            lottoLabelArray[w].setText("");
        }
        
    }
    
}
