package com.javafx.test;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/*
 * @author putengfei
 * @created 2017-12-20
*/
public class JavaFXTest extends Application {
	TextField tf;
	Button num1,num2,num3,num4,num5,num6,num7,num8,num9,num0;
	Button equal,clear,point,add,sub,mul,div;
	public BorderPane getPane() {
		BorderPane bPane = new BorderPane(); 
		HBox hBox = new HBox();
		GridPane gPane = new GridPane();
		TextField tf = new TextField();
		tf.setAlignment(Pos.BOTTOM_RIGHT);
		tf.setEditable(false);
		 num0 = new Button("0");
		 num1 = new Button("1");
		 num2 = new Button("2");
		 num3 = new Button("3");
		 num4 = new Button("4");
		 num5 = new Button("5");
		 num6 = new Button("6");
		 num7 = new Button("7");
		 num8 = new Button("8");
		 num9 = new Button("9");
		 point = new Button(".");
		 clear = new Button("C");
		 mul = new Button("*");
		 div = new Button("/");
		 sub = new Button("-");
		 add = new Button("+");
		 equal = new Button("=");
		hBox.getChildren().addAll(tf,clear);
		tf.prefHeightProperty().bind(gPane.heightProperty().divide(4));
		tf.prefWidthProperty().bind(gPane.widthProperty().divide(4).multiply(3));
		clear.prefHeightProperty().bind(gPane.heightProperty().divide(4));
		clear.prefWidthProperty().bind(gPane.widthProperty().divide(4));
		num0.prefHeightProperty().bind(gPane.heightProperty().divide(5));
		num0.prefWidthProperty().bind(gPane.widthProperty().divide(4));
		num1.prefHeightProperty().bind(gPane.heightProperty().divide(5));
		num1.prefWidthProperty().bind(gPane.widthProperty().divide(4));
		num2.prefHeightProperty().bind(gPane.heightProperty().divide(5));
		num2.prefWidthProperty().bind(gPane.widthProperty().divide(4));
		num3.prefHeightProperty().bind(gPane.heightProperty().divide(5));
		num3.prefWidthProperty().bind(gPane.widthProperty().divide(4));
		num4.prefHeightProperty().bind(gPane.heightProperty().divide(5));
		num4.prefWidthProperty().bind(gPane.widthProperty().divide(4));
		num5.prefHeightProperty().bind(gPane.heightProperty().divide(5));
		num5.prefWidthProperty().bind(gPane.widthProperty().divide(4));
		num6.prefHeightProperty().bind(gPane.heightProperty().divide(5));
		num6.prefWidthProperty().bind(gPane.widthProperty().divide(4));
		num7.prefHeightProperty().bind(gPane.heightProperty().divide(5));
		num7.prefWidthProperty().bind(gPane.widthProperty().divide(4));
		num8.prefHeightProperty().bind(gPane.heightProperty().divide(5));
		num8.prefWidthProperty().bind(gPane.widthProperty().divide(4));
		num9.prefHeightProperty().bind(gPane.heightProperty().divide(5));
		num9.prefWidthProperty().bind(gPane.widthProperty().divide(4));
		add.prefHeightProperty().bind(gPane.heightProperty().divide(5));
		add.prefWidthProperty().bind(gPane.widthProperty().divide(4));
		sub.prefHeightProperty().bind(gPane.heightProperty().divide(5));
		sub.prefWidthProperty().bind(gPane.widthProperty().divide(4));
		mul.prefHeightProperty().bind(gPane.heightProperty().divide(5));
		mul.prefWidthProperty().bind(gPane.widthProperty().divide(4));
		div.prefHeightProperty().bind(gPane.heightProperty().divide(5));
		div.prefWidthProperty().bind(gPane.widthProperty().divide(4));
		equal.prefHeightProperty().bind(gPane.heightProperty().divide(5));
		equal.prefWidthProperty().bind(gPane.widthProperty().divide(4));
		point.prefHeightProperty().bind(gPane.heightProperty().divide(5));
		point.prefWidthProperty().bind(gPane.widthProperty().divide(4));
		gPane.setPadding(new Insets(10,10,12.5,10));
		gPane.addRow(1, num7,num8,num9,div);
		gPane.addRow(2, num4,num5,num6,mul);
		gPane.addRow(3, num1,num2,num3,sub);
		gPane.addRow(4, num0,point,equal,add);
		bPane.setCenter(gPane);
		bPane.setTop(hBox);
		return bPane;
	}
	@Override
	public void start(Stage primaryStage)  {
		Scene scene = new Scene(getPane(),240,180);
		primaryStage.setTitle("Calculator");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
	}

	
}
