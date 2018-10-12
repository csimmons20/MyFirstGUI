package org.sla;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;

import javafx.stage.FileChooser;
import javafx.scene.control.Button;

import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ChoiceBox;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;


public class Main extends Application {
    Image blue;
    Image BBB;
    Image LA;
    Image yellow;

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("My First Java GUI Program");

        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            System.out.println(selectedFile.getPath());
            String file =  new File(selectedFile.getAbsolutePath()).toURI().toString();
            Image newImage = new Image(file);
            //theImageView.setImage(file);
        }


        Button button = new Button("Select File");
        button.setOnAction(e -> {
            fileChooser.showOpenDialog(primaryStage);
        });






        //create Purple Butterfly
        FileInputStream input = new FileInputStream("src/org/sla/Butterfly.png");
        Image image = new Image(input);

        //create Blue Butterfly
        FileInputStream inny = new FileInputStream("src/org/sla/BlueButterfly.png");
        blue = new Image(inny);

        //Create Yellow Butterfly
        FileInputStream inin = new FileInputStream("src/org/sla/YellowButterfly.jpg");
        yellow = new Image(inin);

        //create Lady bug
        FileInputStream ladybug = new FileInputStream("src/org/sla/Ladybug.jpg");
        LA = new Image(ladybug);

        //create Bee
        FileInputStream bee = new FileInputStream("src/org/sla/Bee.png");
        BBB = new Image(bee);

        ImageView theImageView = new ImageView(image);
        theImageView.setFitHeight(500);
        theImageView.setFitWidth(500);

        ImageView theImageView2 = new ImageView(BBB);
        theImageView.setFitHeight(500);
        theImageView.setFitWidth(500);

        ImageView theImageView3 = new ImageView(LA);
        theImageView.setFitHeight(500);
        theImageView.setFitWidth(500);

        ImageView theImageView4 = new ImageView(blue);
        theImageView.setFitHeight(500);
        theImageView.setFitWidth(500);

        ImageView theImageView5 = new ImageView(yellow);
        theImageView.setFitHeight(500);
        theImageView.setFitWidth(500);

        //Create menu button
        MenuButton menu = new MenuButton("Home");
        MenuItem butterflyMenuItem = new MenuItem("Butterfly");
        MenuItem beeMenuItem = new MenuItem("Bee");
        MenuItem ladybugMenuItem = new MenuItem ("Lady Bug");
        menu.getItems().addAll(butterflyMenuItem, beeMenuItem, ladybugMenuItem);
        //MenuItem a = new MenuButton()
        //Give methods for menu button
        menu.setOnAction(e->{
                    System.out.println("menu action happened");
                }

                );
        butterflyMenuItem.setOnAction(e-> {
                System.out.println("butterflyMenuItem action happened");

                    theImageView.setImage(blue);

        }


        );
        beeMenuItem.setOnAction(e->{
                    System.out.println("beeMenuItem action happened");

                    theImageView.setImage(BBB);
        }

        );
        ladybugMenuItem.setOnAction(e->{
                    System.out.println("ladybugMenuItem action happened");

                    theImageView.setImage(LA);
                }

        );

        ChoiceBox cb = new ChoiceBox();
        cb.getItems().addAll("BB1", "BB2", "BB3");
        cb.setOnAction(e-> {
                    System.out.println("choice box action happened");

                    if (cb.valueProperty().get().equals("BB1")) {
                        System.out.println("BB1 action happened");

                        theImageView.setImage(image);
                    }

                    if (cb.valueProperty().get().equals("BB2")) {
                        System.out.println("BB2 action happened");

                        theImageView.setImage(blue);
                    }

                    if (cb.valueProperty().get().equals("BB3")) {
                        System.out.println("BB3 action happened");

                        theImageView.setImage(yellow);
                    }
                }

        );


        HBox insect = new HBox();
        insect.getChildren().add(theImageView);
        insect.getChildren().add(menu);
        insect.getChildren().add(cb);
        insect.getChildren().add(button);




        Scene scene = new Scene(insect, 1000, 1000);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
