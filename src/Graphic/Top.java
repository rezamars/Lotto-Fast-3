/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphic;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author Reza
 */
//the top-object of the borderpane
public class Top extends HBox{
    
    private Label lottoLabel = new Label("Lotto, 4 fasta nummer, 11 rader");
    private Label lottoImageLabel = new Label();
    private String imagePath = "lotto.png";
    private Image image;
    
    
    public Top() {
        
        //Basic settings
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(10, 10, 10, 10));  
        this.setSpacing(30);
        
        //load image
        try {
            
            image = new Image(imagePath);
            
        }
        catch(Exception e) {
            System.out.println("Gick ej att ladda tipset-bild!");
            //System.exit(0);
            return;
        }
        
        //set the image to the graphic
        lottoImageLabel.setGraphic(new ImageView(image));
        
        //Font and colour settings
        Font font ;
        font = Font.font("Arial", FontWeight.BOLD, 40);
        lottoLabel.setFont(font);
        lottoLabel.setTextFill(Color.GREEN);

        
        this.getChildren().add(lottoImageLabel);
        this.getChildren().add(lottoLabel);;

        
    }
    
    
    
}
