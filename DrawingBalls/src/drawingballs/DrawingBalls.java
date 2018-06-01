/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawingballs;

import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 *
 * @author AM
 */
public class DrawingBalls extends Application {
    private static final Random random = new Random();
    
    private static final double HEIGHT = 500;
    private static final double WIDTH = 800;
    
    private static final int NUMBER_OF_WHITE_BALLS = 6;
    private static final int NUMBER_OF_BLACK_BALLS = 4;
    
    private int numberOfDraws = 0;
    private int numberWhiteFirst = 0;
    private int numberBlackFirst = 0;
    private int numberWhiteSecond = 0;
    private int numberBlackSecond = 0;
    
    Group root = new Group();
    
    Text numberOfDrawsLabel;
    Text firstBallDrawn;
    Text secondBallDrawn;
    Text whiteBallDrawnLabel;
    Text numberWhiteFirstLabel;
    Text numberWhiteSecondLabel;
    Text blackBallDrawnLabel;
    Text numberBlackFirstLabel;
    Text numberBlackSecondLabel;
    
    public void printResults(){
        root.getChildren().removeAll
                (numberOfDrawsLabel, firstBallDrawn, secondBallDrawn, whiteBallDrawnLabel, 
                numberWhiteFirstLabel, numberWhiteSecondLabel, blackBallDrawnLabel, 
                numberBlackFirstLabel, numberBlackSecondLabel);
        
        numberOfDrawsLabel = 
                new Text("Total Number Of Draws: " + numberOfDraws);
        numberOfDrawsLabel.setTextAlignment(TextAlignment.LEFT);
        numberOfDrawsLabel.setTranslateX(20);
        numberOfDrawsLabel.setTranslateY(HEIGHT - 150);
        root.getChildren().add(numberOfDrawsLabel);
        
        firstBallDrawn = 
                new Text("First Ball Drawn:");
        firstBallDrawn.setTextAlignment(TextAlignment.CENTER);
        firstBallDrawn.setTranslateX(450);
        firstBallDrawn.setTranslateY(HEIGHT - 150);
        root.getChildren().add(firstBallDrawn);
        
        secondBallDrawn = 
                new Text("Second Ball Drawn:");
        secondBallDrawn.setTextAlignment(TextAlignment.CENTER);
        secondBallDrawn.setTranslateX(600);
        secondBallDrawn.setTranslateY(HEIGHT - 150);
        root.getChildren().add(secondBallDrawn);
        
        whiteBallDrawnLabel = 
                new Text("White Ball Drawn:");
        whiteBallDrawnLabel.setTextAlignment(TextAlignment.LEFT);
        whiteBallDrawnLabel.setTranslateX(300);
        whiteBallDrawnLabel.setTranslateY(HEIGHT - 100);
        root.getChildren().add(whiteBallDrawnLabel);
        
        numberWhiteFirstLabel = 
                new Text(numberWhiteFirst + " times\n"
                        + "(" + (numberOfDraws==0 ? 0 : (double)numberWhiteFirst/numberOfDraws) + "%)");
        numberWhiteFirstLabel.setTextAlignment(TextAlignment.CENTER);
        numberWhiteFirstLabel.setTranslateX(450);
        numberWhiteFirstLabel.setTranslateY(HEIGHT - 100);
        root.getChildren().add(numberWhiteFirstLabel);
        
        numberWhiteSecondLabel = 
                new Text(numberWhiteSecond + " times\n"
                        + "(" + (numberOfDraws==0 ? 0 : (double)numberWhiteSecond/numberOfDraws) + "%)");
        numberWhiteSecondLabel.setTextAlignment(TextAlignment.CENTER);
        numberWhiteSecondLabel.setTranslateX(600);
        numberWhiteSecondLabel.setTranslateY(HEIGHT - 100);
        root.getChildren().add(numberWhiteSecondLabel);
        
        blackBallDrawnLabel = 
                new Text("Black Ball Drawn:");
        blackBallDrawnLabel.setTextAlignment(TextAlignment.LEFT);
        blackBallDrawnLabel.setTranslateX(300);
        blackBallDrawnLabel.setTranslateY(HEIGHT - 50);
        root.getChildren().add(blackBallDrawnLabel);
        
        numberBlackFirstLabel = 
                new Text(numberBlackFirst + " times\n"
                        + "(" + (numberOfDraws==0 ? 0 : (double)numberBlackFirst/numberOfDraws) + "%)");
        numberBlackFirstLabel.setTextAlignment(TextAlignment.CENTER);
        numberBlackFirstLabel.setTranslateX(450);
        numberBlackFirstLabel.setTranslateY(HEIGHT - 50);
        root.getChildren().add(numberBlackFirstLabel);
        
        numberBlackSecondLabel = 
                new Text(numberBlackSecond + " times\n"
                        + "(" + (numberOfDraws==0 ? 0 : (double)numberBlackSecond/numberOfDraws) + "%)");
        numberBlackSecondLabel.setTextAlignment(TextAlignment.CENTER);
        numberBlackSecondLabel.setTranslateX(600);
        numberBlackSecondLabel.setTranslateY(HEIGHT - 50);
        root.getChildren().add(numberBlackSecondLabel);
    }
    
    @Override
    public void start(Stage primaryStage) {
        
//        draw2BallsNTimes.setTranslateX(220); 
//        draw2BallsNTimes.setTranslateY(HEIGHT - 50);
//        draw2BallsNTimes.setText("Draw 2 balls from the box\n"
//                + "(and return them afterwards)");
//        draw2BallsNTimes.setTextAlignment(TextAlignment.CENTER);
//        draw2BallsNTimes.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });
        
        Text numberOfSuccessiveDrawsLabel = 
                new Text("Number Of\n"
                        + "Successive Draws");
        numberOfSuccessiveDrawsLabel.setTextAlignment(TextAlignment.CENTER);
        numberOfSuccessiveDrawsLabel.setTranslateX(20);
        numberOfSuccessiveDrawsLabel.setTranslateY(HEIGHT - 90);
        
        TextField inputNumberOfDraws = new TextField("1");
        inputNumberOfDraws.setTranslateX(120); 
        inputNumberOfDraws.setTranslateY(HEIGHT - 100);
        inputNumberOfDraws.setMaxWidth(70);
        
        Rectangle box = new Rectangle(150, 100);
        box.setTranslateX(20);
        box.setTranslateY(20);
        box.setStroke(Color.BLACK);
        box.setFill(Color.LIGHTGRAY);
        Text boxDescription;
        boxDescription = new Text("Box contains:\n\n"
                + NUMBER_OF_WHITE_BALLS + " white balls\n"
                + NUMBER_OF_BLACK_BALLS + " black balls");
        boxDescription.setFont(new Font(16));
        boxDescription.setTextAlignment(TextAlignment.CENTER);
        boxDescription.setFill(Color.BLACK);
        boxDescription.setStroke(Color.BLACK);
        boxDescription.setTranslateX(box.getTranslateX() + box.getWidth()/2 - boxDescription.getBoundsInParent().getWidth()/2);
        boxDescription.setTranslateY(box.getTranslateY() + box.getHeight()/2 - boxDescription.getBoundsInParent().getHeight()/3);
        
        
        Button draw2Balls = new Button();
        
        draw2Balls.setTranslateX(20); 
        draw2Balls.setTranslateY(HEIGHT - 50);
        draw2Balls.setText("Draw 2 balls from the box\n"
                + "(and return them afterwards)");
        draw2Balls.setTextAlignment(TextAlignment.CENTER);
        draw2Balls.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                int numberOfSuccessiveDraws;
                try {
                    numberOfSuccessiveDraws = 
                        Integer.parseInt(inputNumberOfDraws.getText());
                    
                    numberOfDraws += numberOfSuccessiveDraws;
                    
                    for (int i = 0; i < numberOfSuccessiveDraws; i++) {
                        int numberOfBlackBalls = NUMBER_OF_BLACK_BALLS;
                        int numberOfWhiteBalls = NUMBER_OF_WHITE_BALLS;
                        
                        //FIRST BALL DRAW
                        if (random.nextInt(numberOfBlackBalls + numberOfWhiteBalls) < numberOfBlackBalls){ //BLACK IS DRAWN FIRST
                            numberOfBlackBalls--;
                            numberBlackFirst++;
                        } else { //WHITE IS DRAWN FIRST
                            numberOfWhiteBalls--;
                            numberWhiteFirst++;   
                        }
                        
                        //SECOND BALL DRAW
                        if (random.nextInt(numberOfBlackBalls + numberOfWhiteBalls) < numberOfBlackBalls){ //BLACK IS DRAWN SECOND
                            numberOfBlackBalls--;
                            numberBlackSecond++;
                        } else { //WHITE IS DRAWN SECOND
                            numberOfWhiteBalls--;
                            numberWhiteSecond++;   
                        }
                    }
                    
                    printResults();
                }
                catch (NumberFormatException e){
                    
                }
            }
        });
        
        Button resetDraw = new Button();
        
        resetDraw.setTranslateX(200); 
        resetDraw.setTranslateY(HEIGHT - 50);
        resetDraw.setText("Reset\n"
                + "Draw");
        resetDraw.setTextAlignment(TextAlignment.CENTER);
        resetDraw.setOnAction(event -> {
            numberOfDraws = 0; 
            numberBlackFirst = 0;
            numberWhiteFirst = 0;
            numberBlackSecond = 0;
            numberWhiteSecond = 0;
        });
            
        printResults();
        
        
//        root.getChildren().addAll
//                (numberOfDrawsLabel, firstBallDrawn, secondBallDrawn, whiteBallDrawnLabel, 
//                numberWhiteFirstLabel, numberWhiteSecondLabel, blackBallDrawnLabel, 
//                numberBlackFirstLabel, numberBlackSecondLabel);
        root.getChildren().addAll(numberOfSuccessiveDrawsLabel, inputNumberOfDraws, draw2Balls, resetDraw, box, boxDescription);
        
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        
        primaryStage.setTitle("Drawing balls");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
                update();
            }
        }.start();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void update(){
        printResults();
    }
    
}
