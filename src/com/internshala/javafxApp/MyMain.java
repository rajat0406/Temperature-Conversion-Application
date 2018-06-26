package com.internshala.javafxApp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {
	public static void main(String[] args){
		launch(args);
		//System.out.println("Main");

	}

	@Override
	public void init() throws Exception {
		super.init();
		System.out.println("Init");
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("Start");
		FXMLLoader loader = new
				FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();
		MenuBar menuBar=createMenu();
		rootNode.getChildren().add(0,menuBar);

		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter Tool");
		//primaryStage.setResizable(false);
		primaryStage.show();

	}
	private MenuBar createMenu(){
		Menu filemenu = new Menu("File");
		MenuItem newmenuitem = new MenuItem("New");
		newmenuitem.setOnAction(event -> {
			System.out.println("Item clicked");
		});


		SeparatorMenuItem newseperatoritem= new SeparatorMenuItem();

		MenuItem exitmenuitem= new MenuItem("Exit");
		exitmenuitem.setOnAction(event -> {
			Platform.exit();
			System.exit(0);
		});
		filemenu.getItems().addAll(newmenuitem,newseperatoritem,exitmenuitem);

		Menu viewmenu = new Menu("View");
		MenuItem toolwindow=new MenuItem("Toolbar");
		viewmenu.getItems().addAll(toolwindow);

		Menu helpmenu = new Menu("Help");
		MenuItem aboutApp=new MenuItem("About");
		aboutApp.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public  void handle(ActionEvent event) {
				aboutApp();
			}
		});


		helpmenu.getItems().addAll(aboutApp);

		MenuBar menubar = new MenuBar();
		menubar.getMenus().addAll(filemenu,viewmenu,helpmenu);
		return menubar;
	}
	public static void aboutApp()
		{
		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("My First DesktopApp");
		alertDialog.setHeaderText("Learning JavaFx");
		alertDialog.setContentText("I am just a begineer soon i will just be pro and start developing awesome games");
		ButtonType ybt=new ButtonType("Yes");
		ButtonType nbt=new ButtonType("No");
		alertDialog.getButtonTypes().setAll(ybt,nbt);


		Optional<ButtonType> clickedBtn= alertDialog.showAndWait();
		if(clickedBtn.isPresent()&& clickedBtn.get()==ybt )
			System.out.println("Yes ButtonClicked");
		else
			System.out.println("No ButtonClicked");
	}

	@Override
	public void stop() throws Exception {
		super.stop();
		System.out.println("Stop");
	}
}
