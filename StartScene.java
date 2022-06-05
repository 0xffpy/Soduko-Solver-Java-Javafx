package application;

import application.Main.Title;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class StartScene extends Parent{
	private Text text;
	private String diff;
	private Title[][] titles = new Title[9][9];
	private Text[] numbers = {new Text("1"),new Text("2"),new Text("3"),new Text("4"),new Text("5"),
					  new Text("6"),new Text("7"),new Text("8"),new Text("9")};
	private int[][] board = new int[9][9];
	private Soduko sd;
	private Text textCaution = new Text();
	private int currentPane = 0;
	private Parent[] panes = {pane1(),pane2(),pane3(),BorderPane()};

	StartScene(){
		prefHeight(1200);
		prefWidth(1000);
		super.getChildren().add(panes[currentPane]);
		
		
	}
	private Parent pane1() {
		VBox vbox = new VBox();
		vbox.setAlignment(Pos.CENTER);
		vbox.setPrefSize(1200, 1000);
		vbox.setSpacing(10);
		vbox.setBackground(new Background(
                new BackgroundImage(
                        new Image("wp6626988.jpg"),
                        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
                        new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
                        new BackgroundSize(1200, 1000, true, true, false, true))));
		text = new Text("Welcome to soduko: hopefully you enjoy the game love you !!!");
		Font font = Font.font("Verdana", FontWeight.EXTRA_BOLD, 48);
		text.setFont(font);
		text.setFill(Color.BURLYWOOD);
		vbox.getChildren().addAll(Title(),text,Buttons());
		return vbox;
		
	}
	private Parent pane2() {
		VBox vbox = new VBox();
		vbox.setAlignment(Pos.CENTER);
		vbox.setPrefSize(1200, 1000);
		vbox.setSpacing(10);
		vbox.setBackground(new Background(
                new BackgroundImage(
                        new Image("pane1.jpg"),
                        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
                        new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
                        new BackgroundSize(1200, 1000, true, true, false, true))));
		text = new Text("Only use the numbers 1 to 9,\r\n"
				+"Avoid trying to guess the solution to the puzzle,\r\n"
				+ "Only use each number once in each row, column, & grid,\r\n"
				+ "Use the process of elimination as a tactic,\r\n"
				+ "Use cross-hatching and penciling in techniques\r\n."
				+"Firstly you have to click on the box that you want to add the button\r\n"
				+" then you will see the numbers click on the number you want. ");
		Font font = Font.font("Verdana", FontWeight.EXTRA_BOLD, 48);
		text.setFont(font);
		text.setFill(Color.BURLYWOOD);
		vbox.getChildren().addAll(Title(),text,Buttons());
		return vbox;
	}
	private Parent pane3() {
		VBox vbox = new VBox();
		vbox.setAlignment(Pos.CENTER);
		vbox.setPrefSize(1200, 1000);
		vbox.setSpacing(10);
		text = new Text("Choose the diffuclty please");
		Font font = Font.font("Verdana", FontWeight.EXTRA_BOLD, 48);
		text.setFont(font);
		text.setFill(Color.DARKRED);
		Button button1 = new Button("Easy");
		Button button2 = new Button("Medium");
		Button button3 = new Button("Hard!!");
		button1.setOnAction(e->{
			diff = "E";
			sd = new Soduko(new int[9][9],diff);
			updateBoard();
		});
		button2.setOnAction(e->{
			diff = "M";
			sd = new Soduko(new int[9][9],diff);
			updateBoard();
		});
		button3.setOnAction(e->{
			diff = "H";
			sd = new Soduko(new int[9][9],diff);			
			updateBoard();
		});
		VBox buttons = new VBox(button1,button2,button3);
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(10);
		vbox.getChildren().addAll(Title(),text,buttons,Buttons());
		vbox.setBackground(new Background(
                new BackgroundImage(
                        new Image("pane1.jpg"),
                        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
                        new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
                        new BackgroundSize(1200, 1000, true, true, false, true))));
		
		return vbox;
		
	}
	private Parent Buttons() {
		HBox buttons = new HBox();
		Button button = new Button("Next");
		Button button2 = new Button("Prev");
		buttons.setAlignment(Pos.CENTER);
		buttons.setPrefSize(350,350);
		button.setPrefSize(100, 10);
		button2.setPrefSize(100, 10);
		buttons.getChildren().addAll(button2,button);
		buttons.setSpacing(15);
		button.setOnAction(e->{
			super.getChildren().remove(panes[currentPane]);
			if(currentPane == panes.length-1) {
				currentPane = 0;
			}
			else {
				currentPane++;
			}
			super.getChildren().add(panes[currentPane]);
		});
		button2.setOnAction(e->{
			super.getChildren().remove(panes[currentPane]);
			if(currentPane == 0) {
				currentPane = panes.length-1;
			}
			else {
				currentPane --;
			}
			super.getChildren().add(panes[currentPane]);
		});
		return buttons;
	}
	private Parent Title() {
		HBox hbox = new HBox();
		Font font = Font.font("Verdana", FontWeight.EXTRA_BOLD, 60);
		Text title = new Text("Soduko Bitches !!!!");
		title.setFont(font);
		title.setStroke(Color.SADDLEBROWN);
		hbox.getChildren().add(title);
		hbox.setAlignment(Pos.TOP_CENTER);
		return hbox;
	}
	private Parent BorderPane() {
		BorderPane pane = new BorderPane();
		pane.setBackground(new Background(
                new BackgroundImage(
                        new Image("1853567.jpg"),
                        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
                        new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
                        new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true))));
		pane.setPrefSize(1200, 1000);
		pane.setRight(VBox());
		pane.setBottom(HBox());
		pane.setLeft(new HBox(new Text("                                  ")));
		pane.setTop(TextPane());
		pane.setCenter(pane());
		return pane;
	}
	private Parent pane() {
		Pane pane = new Pane();
		Text text = new Text();
		text.setTranslateX(50);
		text.setTranslateY(50);
		pane.getChildren().add(text);
		pane.setPrefSize(1000, 1000);
		for(int i = 0;i<9;i++) {
			for(int j = 0;j<9;j++) {
				Title title = new Title(i,j);
				titles[i][j] = title;
				title.setY(i);
				title.setX(j);
				title.setTranslateY(i*100);
				title.setTranslateX(j*100);
				pane.getChildren().add(title);
			}
		}
		return pane;
	}
	private Parent HBox() {
		HBox hbox = new HBox();
		for(int i = 0 ; i<9;i++) {
			numbers[i].setFont(Font.font(30));
			hbox.getChildren().add(numbers[i]);
		}
		hbox.setAlignment(Pos.TOP_CENTER);
		hbox.setSpacing(100);
		return hbox;
	}
	private Parent VBox() {
		VBox vbox = new VBox();
		Button bt1 = new Button("Solve Soduko");
		Button bt2 = new Button("Reset");
		vbox.setAlignment(Pos.CENTER);
		vbox.setSpacing(10);
		vbox.getChildren().addAll(bt1,bt2);
		bt1.setOnAction(e->{
			sd.sodukoSolver();
			updateBoard();
		});
		bt2.setOnAction(e->{
			sd = new Soduko(new int[9][9],"H");
			resetFuction();
			updateBoard();
		});
		return vbox;
	}
	private Parent TextPane() {
		HBox hbox = new HBox();
		textCaution.setFont(Font.font(45));
		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().addAll(textCaution);
		return hbox;
		
	}
	private void updateBoard() {
		for(int i = 0;i<9;i++) {
			for(int j = 0;j<9;j++) {
				if(sd.returnValue(i, j) == 0) {
					continue;
				}
				else { 
					titles[i][j].setText(String.valueOf(sd.returnValue(i, j)));
					titles[i][j].setValue(sd.returnValue(i, j));
				}
			}
		}
	}
	private void resetFuction() {
		for(int i = 0; i<9;i++) {
			for(int j = 0; j<9;j++) {
				titles[i][j].setValue(0);
				titles[i][j].setText("");
			}
		}
	}
	private class Title extends StackPane{
		private Text text = new Text();
		private int y;
		private int x;
		private int value= 0;
		Title(int y,int x){
			 Line line = new Line();
			 Line line1 = new Line();
			 Rectangle border = new Rectangle(100,100);
			 border.setFill(null);
			 border.setStroke(Color.LIGHTGRAY);
			 if(y%3==0 || x%3==0) {
				 if(y%3==0 && x%3==0) {
					 line = new Line(0,0,0,100);
					 line.setTranslateX(-49);
					 line1 = new Line(0,0,100,0);
					 //line.setTranslateX(100);
					 line1.setTranslateY(-49);
					 line.setStroke(Color.BLACK);
					 line1.setStroke(Color.BLACK);
					 super.getChildren().addAll(line,line1);
				 }
				 else if(x%3==0) {
					 line = new Line(0,0,0,100);
					 line.setTranslateX(-49);
					 //line.setTranslateY(100);
					 super.getChildren().add(line);

				 }
				 else {
					 line = new Line(0,0,100,0);
					 //line.setTranslateX(100);
					 line.setTranslateY(-49);
					 super.getChildren().add(line);

				 }
				 super.setAlignment(Pos.CENTER_LEFT);
				 line.setStroke(Color.BLACK);
			 }
			 text.setFont(Font.font(40));
			 super.setAlignment(Pos.CENTER);
			 super.getChildren().addAll(border,text);
			 setOnMouseClicked(e->{
				 if(this.getValue()==0) {
					 textCaution.setText("");
					 numbers[0].setOnMouseClicked(r->{
						 if(sd.setBoard(this.getY(), this.getX(), Integer.parseInt(numbers[0].getText()))) {;
						 	setText(numbers[0].getText());
						 }
						 else
							 textCaution.setText("You cant do that !!!");
					 });
					 numbers[1].setOnMouseClicked(r->{
						 if(sd.setBoard(this.getY(), this.getX(), Integer.parseInt(numbers[1].getText()))) {
						 	setText(numbers[1].getText());
						 }
						 else
							 textCaution.setText("You cant do that !!!");
					 });
					 numbers[2].setOnMouseClicked(r->{
						 if(sd.setBoard(this.getY(), this.getX(), Integer.parseInt(numbers[2].getText()))) {
						 	setText(numbers[2].getText());
						 }
						 else
							 textCaution.setText("You cant do that !!!");
					 });
					 numbers[3].setOnMouseClicked(r->{
						 if(sd.setBoard(this.getY(), this.getX(), Integer.parseInt(numbers[3].getText()))) {
						 	setText(numbers[3].getText());
						 }
						 else
							 textCaution.setText("You cant do that !!!");
					 });
					 numbers[4].setOnMouseClicked(r->{
						 if(sd.setBoard(this.getY(), this.getX(), Integer.parseInt(numbers[4].getText()))) {
						 	setText(numbers[4].getText());
						 }
						 else
							 textCaution.setText("You cant do that !!!");
					 });
					 numbers[5].setOnMouseClicked(r->{
						 if(sd.setBoard(this.getY(), this.getX(), Integer.parseInt(numbers[5].getText()))) {
						 	setText(numbers[5].getText());
						 }
						 else
							 textCaution.setText("You cant do that !!!");
					 });
					 numbers[6].setOnMouseClicked(r->{
						 if(sd.setBoard(this.getY(), this.getX(), Integer.parseInt(numbers[6].getText()))) {
						 	setText(numbers[6].getText());
						 }
						 else
							 textCaution.setText("You cant do that !!!");
					 });
					 numbers[7].setOnMouseClicked(r->{
						 if(sd.setBoard(this.getY(), this.getX(), Integer.parseInt(numbers[7].getText()))) {
						 	setText(numbers[7].getText());
						 }
						 else
							 textCaution.setText("You cant do that !!!");
					 });
					 numbers[8].setOnMouseClicked(r->{
						 if(sd.setBoard(this.getY(), this.getX(), Integer.parseInt(numbers[8].getText()))) {
						 	setText(numbers[8].getText());
						 }
						 else
							 textCaution.setText("You cant do that !!!");
					 });
				 }
				 else {
					 System.out.println(this.getValue());
					 textCaution.setText("You cant do that !!!");
				 }
				 sd.printArray();
				 System.out.println();
					

			 });
		}
		
		void setText(String Value) {
			if(!Value.equals(""))
				value = Integer.parseInt(Value);
			String value = Value+"";
			
			text.setText(value);
		}
		int getY() {
			return y;
		}
		void setY(int y ) {
			this.y = y;
		}
		void setX(int x ) {
			this.x = x;
			
		}
		int getX() {
			return x;
		}
		int getValue() {
			return value;
		}
		void setValue(int value) {
			this.value = value;
		}
		
	}
	
	
	
	
}
