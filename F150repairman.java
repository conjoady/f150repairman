/*
 * John Coady 
 * Westfield state university
 * cais 220
 */
package f150repairman;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;




/**
 *
 * @author John Coady
 */
public class F150repairman extends Application {
    
    private static ArrayList<Group> grouplist = new ArrayList<>();
    private static ArrayList<Text> mainlist = new ArrayList<>();
    private static VBox listpane = new VBox();
    private static String path = ("C://Users/Home/Documents/CS programs/F150repairman/src/JSONFiles/f150init.txt");
    
    /**
     *constructor to make use of built in methods from other classes
     */
    public void F150repairman(){};
    
    /**
     * launches main page
     * @param primaryStage 
     */
    public void start(Stage primaryStage) {
        grouplist = readFile();
        BorderPane borderpane = new BorderPane();
        Scene scene = new Scene(borderpane);
        ImageView topimage = new ImageView("images/lifted-ford-trucks.jpg");
        topimage.setFitHeight(200);
        topimage.setFitWidth(600);
        StackPane stackpane = new StackPane();
        stackpane.getChildren().add(topimage);
        borderpane.setTop(stackpane);
        ImageView bottomimage = new ImageView("images/rclogo_0.gif");
        bottomimage.setFitWidth(600);
        bottomimage.setFitHeight(150);
        StackPane bottomStack = new StackPane();
        bottomStack.getChildren().add(bottomimage);
        borderpane.setBottom(bottomStack);
        borderpane.setCenter(listpane);
        primaryStage.setTitle("F150 virtual repair guide");
        primaryStage.setMinHeight(650);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
       
        for (int i = 0; i < grouplist.size(); i ++){
            mainlist.add(grouplist.get(i).getgroupName());
        }
        
        
        listpane.getChildren().addAll(mainlist);
        listpane.setOnMouseClicked(new mainhandler(grouplist));
        
        
        
    
    }


    public void setCenter(ArrayList<Text> list0){
        listpane.getChildren().removeAll(mainlist);
        listpane.getChildren().addAll(list0);
        
    };

    /**
     *setter for the handler on the listpane
     * @param e eventhandler
     */
    public void changeHandler(EventHandler e){
        listpane.setOnMouseClicked(e);
    }
    
    /**
     *displays a WebView node on a new stage
     * @param node WebView Node
     */
    public void launchvideo(WebView node){
        Stage vidwindow = new Stage();
        Pane vidpane = new Pane();
        vidpane.getChildren().add(node);
        Scene scene = new Scene(vidpane);
        vidwindow.setScene(scene);
        vidwindow.show();
    }

    /**
     * initializes an arraylist with data from the program's source folders
     * @return ArrayList<Group> with all relevent data
     */
    public static ArrayList<Group> readFile() {
    ArrayList<Group> list = new ArrayList<>();
    File dataFile = new File(path);
    FileInputStream fis = null;
        try {
           fis = new FileInputStream(dataFile);
        } catch (FileNotFoundException ex) {
            System.out.println("Application error. Please restart");
        }
    Scanner scan = new Scanner(fis);
    while (scan.hasNext()){
        Text groupName = new Text(scan.nextLine());
        String repairs;
        String url;
        ArrayList<String> urls = new ArrayList<>();
        ArrayList<Text> repair = new ArrayList<>();
        if (scan.nextLine().equals("{")){
            while (!((repairs = scan.nextLine()).equals("}"))){
                repair.add(new Text(repairs));
            }
        }
        if (scan.nextLine().equals("{")){
            while (!((url = scan.nextLine()).equals("}"))){
                urls.add(url);
            }
        }
        list.add(new Group(groupName, repair, urls));
        groupName = null;
        repair = null;
        urls = null;
        
    }
    
    
    
    return list;
}
    
    /** main method
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
