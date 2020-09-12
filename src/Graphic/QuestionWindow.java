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
//This class opens a new window(Stage) that contains a short description about this program
public class QuestionWindow {
    
    private BorderPane borderPane = new BorderPane();
    private Stage questionStage = new Stage();
    private Scene ncScene = new Scene(borderPane, 450, 280);
    
    private HBox hbox = new HBox();
    private Button explanationButton;
    private Right right;
    private Label explanationLabel1 = new Label();
    private Label explanationLabel2 = new Label();
    
    
    public QuestionWindow(Right right1){
        
        this.right = right1;
        this.explanationButton = right.getExplanationButton();
        
        questionStage.setTitle("Förklaring!");
        questionStage.setScene(ncScene);
        
        //Description-text
        String explanationText1 = "\nLottorads-generering:";
        String explanationText2 = "\nDetta program genererar 11 lottorader. \nAnvändaren väljer 4 fasta nummer "
                + "som är fasta nummer i \nalla 11 rader. De resterande numren (3 nummer i alla rader) \ni alla raderna slumpas "
                + "fram av programmet där \nde övriga numren (de resterande 31 numren) är med \n1 gång på slumpvis valda "
                + "platser. På så sätt är alla \nnumren (1 till 35) garanterad med minst 1 gång. \nDet finns 2 undantag på den "
                + "11:e raden som innehåller 2 \nslumpvis valda nummer som är dubletter." ;
        
        //Setting fonts and text
        Font text1Font ;
        text1Font = Font.font("Arial", FontWeight.BOLD, 20);
        explanationLabel1.setFont(text1Font);
        
        Font text2Font ;
        text2Font = Font.font("Arial", FontWeight.NORMAL, 15);
        explanationLabel2.setFont(text2Font);
        
        
        explanationLabel1.setText(explanationText1);
        explanationLabel2.setText(explanationText2);
        
        VBox topd = new VBox();
        topd.setPadding(new Insets(0, 10, 0, 10));  
        topd.setSpacing(1);
        borderPane.setTop(topd);
        
        //Adding the labels to the graphic
        topd.getChildren().add(explanationLabel1);
        topd.getChildren().add(explanationLabel2);
    }
    
    //Shows or opens the window
    public void showExplanationWindow(){
        
        questionStage.show();
    }
    
    
    //adds listener to the explanation-button
    public void addQuestionButtonListener(){
	     
	        explanationButton.setOnMouseClicked(event -> {
                    
                    showExplanationWindow();
                    
                });
        
    }     
    
    
    
    
}
