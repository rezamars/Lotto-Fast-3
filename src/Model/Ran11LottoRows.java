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
//this class handles the randomizing of the 11 lottorows with 4 fixed numbers in all 11 rows
public class Ran11LottoRows {
    
    private Right right1;
    private Left left1;
    private Center center1;
    private Button ranButton;
    private int[] fixed4NumbersArray;
    
    private Label[] lottoLabelArray;
    private int[] lottoNumberArray= new int[77];
    private Random ran = new Random();
    private  boolean[] numberFlagArray = new boolean[35];
    
    private int[] arrayOf31 = new int[31];
    private int[] twoDublicatesArray = new int[2];
    
    
    public Ran11LottoRows(Right right, Left left, Center center){
        
        this.left1 = left;
        this.right1 = right;
        this.center1 = center;
        this.ranButton = right1.getRanButton();
        this.lottoLabelArray = center1.getLottoLabelArray();
        this.fixed4NumbersArray = left1.get4FixedNumbersArray();
        
        
        addRanButtonListener();
    }
    
    //adds listener to the ran-button, starts filling the 11 lottorows with 4 fixed numbers,
    //then, randomizes the rest (3 other numbers in all 11), making sure that all 1 to 35 numbers 
    //are included, also 2 dublettes in row 11, then it sorts all 11 rows and sets colours to all lottolabels
    public void addRanButtonListener(){
        
        ranButton.setOnAction(e -> {
            fillTheLottoArrayWith0AndThefixedNumbers();
            randomize11Rows();
            sortArray7();
            setLottoLabelColours();
            fillThe11RowsInLabels();
        });
            
    }
    
    //handles the counting of amount of fixednumbers chosen by the user
    //if 4 numbers chosen, the ranbutton becomes clickable
    public void setRanButtonEnabling(){
        
        int exCounter = 0;
        
        for(int x = 0 ; x < 4 ; x++){
            if (fixed4NumbersArray[x] != (-1)){
                exCounter++;
            }
        }
        
        if (exCounter == 4){
            ranButton.setDisable(false);
        }
        else{
            ranButton.setDisable(true);
        }
    }
    
    //fills the lottonumber-array with the 4 fixed numbers chosen by the user
    public void fillTheLottoArrayWith0AndThefixedNumbers(){
        
        for (int i = 0 ; i < 77 ; i++){
            lottoNumberArray[i] = 0;
        }
        
        //2 vars that specifies the first and last position of the fixed numbers 
        //in all 11 lotto-rows
        int fixedNumberFromIndex = 0;
        int fixedNumberUntilIndex = 0;
        
        for(int x = 0 ; x<77 ; x+=7){
            
            if ( x == 0){
                fixedNumberFromIndex = 0;
                fixedNumberUntilIndex = 3;
            }
            else if( x == 7){
                fixedNumberFromIndex = 7;
                fixedNumberUntilIndex = 10;
            }
            else if( x == 14){
                fixedNumberFromIndex = 14;
                fixedNumberUntilIndex = 17;
            }
            else if( x == 21){
                fixedNumberFromIndex = 21;
                fixedNumberUntilIndex = 24;
            }
            else if( x == 28){
                fixedNumberFromIndex = 28;
                fixedNumberUntilIndex = 31;
            }
            else if( x == 35){
                fixedNumberFromIndex = 35;
                fixedNumberUntilIndex = 38;
            }
            else if( x == 42){
                fixedNumberFromIndex = 42;
                fixedNumberUntilIndex = 45;
            }
            else if( x == 49){
                fixedNumberFromIndex = 49;
                fixedNumberUntilIndex = 52;
            }
            else if( x == 56){
                fixedNumberFromIndex = 56;
                fixedNumberUntilIndex = 59;
            }
            else if( x == 63){
                fixedNumberFromIndex = 63;
                fixedNumberUntilIndex = 66;
            }
            else if( x == 70){
                fixedNumberFromIndex = 70;
                fixedNumberUntilIndex = 73;
            }
            
            //filling the 4 fixed numbers of all rows
            int loopIter = 0;
            for(int k = fixedNumberFromIndex ; k <= fixedNumberUntilIndex ; k++){
                lottoNumberArray[k] = (fixed4NumbersArray[loopIter])+1;
                loopIter++;
            }
            
            
        }
        
    }
    
    //filling (at randomized positions) the arrayOf31 with all numbers (1-35) except the 4 fixed numbers,
    //also randomizing the 2 dublettes in row 11
    public void randomize11Rows(){
        
        for (int i = 0 ; i < arrayOf31.length ; i++){
            arrayOf31[i] = 0;
        }
        
        for(int a = 0 ; a < arrayOf31.length ; a++){
            
            int ra = ran.nextInt(35);
            for(int t = 0 ; t<4 ; t++){ 
                if ((ra+1) != fixed4NumbersArray[t]+1){
                    arrayOf31[a] = (ra + 1);
                    
                }
            }
            
        }
        
        
        int x= 0;
        while( x<arrayOf31.length ){
            
            for(int i = 0 ; i<arrayOf31.length ; i++){
                
                if(((arrayOf31[x] == arrayOf31[i]) && (i!=x)) || ((fixed4NumbersArray[0]+1) == arrayOf31[i]) || 
                        ((fixed4NumbersArray[1]+1) == arrayOf31[i]) || ((fixed4NumbersArray[2]+1) == arrayOf31[i]) || 
                        ((fixed4NumbersArray[3]+1) == arrayOf31[i])){
                    int ra = ran.nextInt(35);
                    arrayOf31[i] = (ra + 1);
                    x=0;
                }
            }
            x++;
        }
        
        
        int twoRan1 = ran.nextInt(35);
        twoDublicatesArray[0] = twoRan1+1;
        int twoRan2 = ran.nextInt(35);
        twoDublicatesArray[1] = twoRan2+1;
        
        for(int i = 0 ; i < 2 ; i++){
            
            if( (twoDublicatesArray[0] == twoDublicatesArray[1]) || ((fixed4NumbersArray[0]+1) == twoDublicatesArray[i]) || 
                        ((fixed4NumbersArray[1]+1) == twoDublicatesArray[i]) || ((fixed4NumbersArray[2]+1) == twoDublicatesArray[i]) || 
                        ((fixed4NumbersArray[3]+1) == twoDublicatesArray[i]) || (twoDublicatesArray[i] == arrayOf31[30])){
                int ra = ran.nextInt(35);
                twoDublicatesArray[i] = ra+1;
            }
        }
        
        fillTheRestOfLottoArray();
        
    }
    
    //filling the position 5 till 7 in the lottonumber-array with the randomized arrayOf31 
    //and the 2 dublettes in row 11
    public void fillTheRestOfLottoArray(){
        
        int randomNumberFromIndex = 0;
        int randomNumberUntilIndex = 0;
        int arrayOf31loopIter = 0;
        
        for(int x = 0 ; x<77 ; x+=7){
            
            if ( x == 0){
                randomNumberFromIndex = 4;
                randomNumberUntilIndex = 6;
            }
            else if( x == 7){
                randomNumberFromIndex = 11;
                randomNumberUntilIndex = 13;
            }
            else if( x == 14){
                randomNumberFromIndex = 18;
                randomNumberUntilIndex = 20;
            }
            else if( x == 21){
                randomNumberFromIndex = 25;
                randomNumberUntilIndex = 27;
            }
            else if( x == 28){
                randomNumberFromIndex = 32;
                randomNumberUntilIndex = 34;
            }
            else if( x == 35){
                randomNumberFromIndex = 39;
                randomNumberUntilIndex = 41;
            }
            else if( x == 42){
                randomNumberFromIndex = 46;
                randomNumberUntilIndex = 48;
            }
            else if( x == 49){
                randomNumberFromIndex = 53;
                randomNumberUntilIndex = 55;
            }
            else if( x == 56){
                randomNumberFromIndex = 60;
                randomNumberUntilIndex = 62;
            }
            else if( x == 63){
                randomNumberFromIndex = 67;
                randomNumberUntilIndex = 69;
            }
            else if( x == 70){
                randomNumberFromIndex = 74;
                randomNumberUntilIndex = 76;
            }
            
            if( x == 70 ){
                lottoNumberArray[74] = arrayOf31[30];
                lottoNumberArray[75] = twoDublicatesArray[0];
                lottoNumberArray[76] = twoDublicatesArray[1];
            }
            else{
                for(int k = randomNumberFromIndex ; k <= randomNumberUntilIndex ; k++){
                lottoNumberArray[k] = arrayOf31[arrayOf31loopIter];
                arrayOf31loopIter++;
                }
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
        
        temp = 0;
        
        for (int i = 56; i < 63 ; i++) {
            
            for (int j = i; j > 56; j--) {
                
                if (lottoNumberArray[j] < lottoNumberArray [j - 1]) {
                 
                    temp = lottoNumberArray[j];
                    lottoNumberArray[j] = lottoNumberArray[j - 1];
                    lottoNumberArray[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 63 ; i < 70; i++) {
            
            for (int j = i; j > 63; j--) {
                
                if (lottoNumberArray[j] < lottoNumberArray [j - 1]) {
                 
                    temp = lottoNumberArray[j];
                    lottoNumberArray[j] = lottoNumberArray[j - 1];
                    lottoNumberArray[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 70; i < 77; i++) {
            
            for (int j = i; j > 70; j--) {
                
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
        
        
        for(int i = 0 ; i < 77 ; i++){
            
            BackgroundFill background_fill = new BackgroundFill(Color.PINK,  CornerRadii.EMPTY, Insets.EMPTY); 
            Background background = new Background(background_fill);
            lottoLabelArray[i].setBackground(background);
            lottoLabelArray[i].setStyle("-fx-border-color: black;");
            lottoLabelArray[i].setTextFill(Color.BLACK);
        }
        
        for(int i = 0 ; i < 77 ; i++){
            for(int t = 0 ; t<4 ; t++){ 
                if(lottoNumberArray[i] == fixed4NumbersArray[t]+1){
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
    
    
    
    //filling the labels of the randomized lottorows including 4 fixed numbers in every row
    public void fillThe11RowsInLabels(){
        
        int arrayIndex = 0;
        
        for(int w=0; w<77; w++){
            
            lottoLabelArray[arrayIndex].setText(" " + (Integer.toString(lottoNumberArray[w])) + " ");
                arrayIndex++;
            
        }
        
    }
    
    
}
