/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Graphic.Center;
import Graphic.Left;
import Graphic.Right;
import java.util.Random;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

/**
 *
 * @author Reza
 */
//this class handles the randomizing of the 8 lottorows with 3 fixed numbers in all 8 rows
public class Ran8LottoRows {
    
    private Right right1;
    private Left left1;
    private Center center1;
    private Button ranButton;
    private int[] fixed3NumbersArray;
    
    private Label[] lottoLabelArray;
    private int[] lottoNumberArray= new int[56];
    private Random ran = new Random();
    private  boolean[] numberFlagArray = new boolean[35];
    
    private int[] arrayOf32 = new int[32];
    
    
    public Ran8LottoRows(Right right, Left left, Center center){
        
        this.left1 = left;
        this.right1 = right;
        this.center1 = center;
        this.ranButton = right1.getRanButton();
        this.lottoLabelArray = center1.getLottoLabelArray();
        this.fixed3NumbersArray = left1.get3FixedNumbersArray();
        
        
        addRanButtonListener();
    }
    
    //adds listener to the ran-button, starts filling the 8 lottorows with 3 fixed numbers,
    //then, randomizes the rest (4 other numbers in all 8), making sure that all 1 to 35 numbers 
    //are included,  then it sorts all 8 rows and sets colours to all lottolabels
    public void addRanButtonListener(){
        
        ranButton.setOnAction(e -> {
            fillTheLottoArrayWith0AndThefixedNumbers();
            randomize8Rows();
            sortArray7();
            setLottoLabelColours();
            fillThe11RowsInLabels();
        });
            
    }
    
    //handles the counting of amount of fixednumbers chosen by the user
    //if 3 numbers chosen, the ranbutton becomes clickable
    public void setRanButtonEnabling(){
        
        int exCounter = 0;
        
        for(int x = 0 ; x < 3 ; x++){
            if (fixed3NumbersArray[x] != (-1)){
                exCounter++;
            }
        }
        
        if (exCounter == 3){
            ranButton.setDisable(false);
        }
        else{
            ranButton.setDisable(true);
        }
    }
    
    //fills the lottonumber-array with the 3 fixed numbers chosen by the user
    public void fillTheLottoArrayWith0AndThefixedNumbers(){
        
        for (int i = 0 ; i < 56 ; i++){
            lottoNumberArray[i] = 0;
        }
        
        //2 vars that specifies the first and last position of the fixed numbers 
        //in all 8 lotto-rows
        int fixedNumberFromIndex = 0;
        int fixedNumberUntilIndex = 0;
        
        for(int x = 0 ; x<56 ; x+=7){
            
            if ( x == 0){
                fixedNumberFromIndex = 0;
                fixedNumberUntilIndex = 2;
            }
            else if( x == 7){
                fixedNumberFromIndex = 7;
                fixedNumberUntilIndex = 9;
            }
            else if( x == 14){
                fixedNumberFromIndex = 14;
                fixedNumberUntilIndex = 16;
            }
            else if( x == 21){
                fixedNumberFromIndex = 21;
                fixedNumberUntilIndex = 23;
            }
            else if( x == 28){
                fixedNumberFromIndex = 28;
                fixedNumberUntilIndex = 30;
            }
            else if( x == 35){
                fixedNumberFromIndex = 35;
                fixedNumberUntilIndex = 37;
            }
            else if( x == 42){
                fixedNumberFromIndex = 42;
                fixedNumberUntilIndex = 44;
            }
            else if( x == 49){
                fixedNumberFromIndex = 49;
                fixedNumberUntilIndex = 51;
            }
            
            //filling the 3 fixed numbers of all rows
            int loopIter = 0;
            for(int k = fixedNumberFromIndex ; k <= fixedNumberUntilIndex ; k++){
                lottoNumberArray[k] = (fixed3NumbersArray[loopIter])+1;
                loopIter++;
            }
            
            
        }
        
    }
    
    //filling (at randomized positions) the arrayOf32 with all numbers (1-35) except the 3 fixed numbers
    public void randomize8Rows(){
        
        //Initializer
        for (int i = 0 ; i < arrayOf32.length ; i++){
            arrayOf32[i] = 0;
        }
        
        for(int a = 0 ; a < arrayOf32.length ; a++){
            
            int ra = ran.nextInt(35);
            for(int t = 0 ; t<3 ; t++){ 
                if ((ra+1) != fixed3NumbersArray[t]+1){
                    arrayOf32[a] = (ra + 1);
                    
                }
            }
            
        }
        
        
        int x= 0;
        while( x<arrayOf32.length ){
            
            for(int i = 0 ; i<arrayOf32.length ; i++){
                
                if(((arrayOf32[x] == arrayOf32[i]) && (i!=x)) || ((fixed3NumbersArray[0]+1) == arrayOf32[i]) || 
                        ((fixed3NumbersArray[1]+1) == arrayOf32[i]) || ((fixed3NumbersArray[2]+1) == arrayOf32[i]) 
                        ){
                    int ra = ran.nextInt(35);
                    arrayOf32[i] = (ra + 1);
                    x=0;
                }
            }
            x++;
        }
        
        
        fillTheRestOfLottoArray();
        
    }
    
    //filling the position 4 to 7 in the lottonumber-array with the randomized arrayOf32 
    public void fillTheRestOfLottoArray(){
        
        int randomNumberFromIndex = 0;
        int randomNumberUntilIndex = 0;
        int arrayOf32loopIter = 0;
        
        for(int x = 0 ; x<56 ; x+=7){
            
            if ( x == 0){
                randomNumberFromIndex = 3;
                randomNumberUntilIndex = 6;
            }
            else if( x == 7){
                randomNumberFromIndex = 10;
                randomNumberUntilIndex = 13;
            }
            else if( x == 14){
                randomNumberFromIndex = 17;
                randomNumberUntilIndex = 20;
            }
            else if( x == 21){
                randomNumberFromIndex = 24;
                randomNumberUntilIndex = 27;
            }
            else if( x == 28){
                randomNumberFromIndex = 31;
                randomNumberUntilIndex = 34;
            }
            else if( x == 35){
                randomNumberFromIndex = 38;
                randomNumberUntilIndex = 41;
            }
            else if( x == 42){
                randomNumberFromIndex = 45;
                randomNumberUntilIndex = 48;
            }
            else if( x == 49){
                randomNumberFromIndex = 52;
                randomNumberUntilIndex = 55;
            }
            
            for(int k = randomNumberFromIndex ; k <= randomNumberUntilIndex ; k++){
                lottoNumberArray[k] = arrayOf32[arrayOf32loopIter];
                arrayOf32loopIter++;
            }
            
        }
        
    }
    
    //Sorting every lottorow in acsending order
    public void sortArray7(){
        
        int temp = 0;
        
        for (int i = 0; i < 7; i++) {
            
            for (int j = i; j > 0; j--) {
                
                if (lottoNumberArray[j] < lottoNumberArray [j - 1]) {
                 
                    temp = lottoNumberArray[j];
                    lottoNumberArray[j] = lottoNumberArray[j - 1];
                    lottoNumberArray[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 7 ; i < 14 ; i++) {
            
            for (int j = i; j > 7; j--) {
                
                if (lottoNumberArray[j] < lottoNumberArray [j - 1]) {
                 
                    temp = lottoNumberArray[j];
                    lottoNumberArray[j] = lottoNumberArray[j - 1];
                    lottoNumberArray[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 14; i < 21; i++) {
            
            for (int j = i; j > 14; j--) {
                
                if (lottoNumberArray[j] < lottoNumberArray [j - 1]) {
                 
                    temp = lottoNumberArray[j];
                    lottoNumberArray[j] = lottoNumberArray[j - 1];
                    lottoNumberArray[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 21; i < 28; i++) {
            
            for (int j = i; j > 21; j--) {
                
                if (lottoNumberArray[j] < lottoNumberArray [j - 1]) {
                 
                    temp = lottoNumberArray[j];
                    lottoNumberArray[j] = lottoNumberArray[j - 1];
                    lottoNumberArray[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 28; i < 35; i++) {
            
            for (int j = i; j > 28; j--) {
                
                if (lottoNumberArray[j] < lottoNumberArray [j - 1]) {
                 
                    temp = lottoNumberArray[j];
                    lottoNumberArray[j] = lottoNumberArray[j - 1];
                    lottoNumberArray[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 35; i < 42; i++) {
            
            for (int j = i; j > 35; j--) {
                
                if (lottoNumberArray[j] < lottoNumberArray [j - 1]) {
                 
                    temp = lottoNumberArray[j];
                    lottoNumberArray[j] = lottoNumberArray[j - 1];
                    lottoNumberArray[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 42; i < 49; i++) {
            
            for (int j = i; j > 42; j--) {
                
                if (lottoNumberArray[j] < lottoNumberArray [j - 1]) {
                 
                    temp = lottoNumberArray[j];
                    lottoNumberArray[j] = lottoNumberArray[j - 1];
                    lottoNumberArray[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 49; i < 56; i++) {
            
            for (int j = i; j > 49; j--) {
                
                if (lottoNumberArray[j] < lottoNumberArray [j - 1]) {
                 
                    temp = lottoNumberArray[j];
                    lottoNumberArray[j] = lottoNumberArray[j - 1];
                    lottoNumberArray[j - 1] = temp;
                   }
            }
        }
        
    }
    
    //Setting label-background colour, pink for the randomized numbers-labels
    //and lightblue for the fixed numbers-label
    public void setLottoLabelColours(){
        
        
        for(int i = 0 ; i < 56 ; i++){
            
            BackgroundFill background_fill = new BackgroundFill(Color.PINK,  CornerRadii.EMPTY, Insets.EMPTY); 
            Background background = new Background(background_fill);
            lottoLabelArray[i].setBackground(background);
            lottoLabelArray[i].setStyle("-fx-border-color: black;");
            lottoLabelArray[i].setTextFill(Color.BLACK);
        }
        
        for(int i = 0 ; i < 56 ; i++){
            for(int t = 0 ; t<3 ; t++){ 
                if(lottoNumberArray[i] == fixed3NumbersArray[t]+1){
                    BackgroundFill background_fill = new BackgroundFill(Color.LIGHTBLUE,  CornerRadii.EMPTY, Insets.EMPTY); 
                    Background background = new Background(background_fill);
                    lottoLabelArray[i].setBackground(background);
                }
                
            }
            
        }
        
    }
    
    
    //Method for checking which numbers are included or excluded in the lottonumbers-array
    //Only for debugging purpose
    public void setFlagArray(){
    
        for(int f = 0 ; f < 35 ; f++){
            numberFlagArray[f] = false;
        }
        
        for(int p = 0 ; p < 35 ; p++){
            for(int i = 0 ; i<77 ; i++){
                
                if (lottoNumberArray[i] == (p+1)){
                    numberFlagArray[p] = true;
                }
                
            }
        }    
                
        printTheflagArray();  
        
    }
    
    
    //Writes the boolean-status of the numberFlagArray
    //Only for debugging purpose
    public void printTheflagArray(){
        for(int f = 0 ; f < 35 ; f++){
            System.out.println("FlagArray: " + numberFlagArray[f]);
        }  
        System.out.println("-----------------");
    }
    
    
    
    //filling the labels of the randomized lottorows including 3 fixed numbers in every row
    public void fillThe11RowsInLabels(){
        
        int arrayIndex = 0;
        
        for(int w=0; w<56; w++){
            
            lottoLabelArray[arrayIndex].setText(" " + (Integer.toString(lottoNumberArray[w])) + " ");
                arrayIndex++;
            
        }
        
    }
    
    
}
