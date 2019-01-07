/*
 * John Coady 
 * Westfield state university
 * cais 220
 */
package f150repairman;

import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;

/**
 *
 * @author John Coady
 */
public class VideoHandler implements EventHandler<MouseEvent> {
    
    private ArrayList<Text> list;
    private Group group;
    private F150repairman repairman = new F150repairman();
    
    /**
     *  
     * @param group pass the group that the link is contained within
     */
    public VideoHandler(Group group){
    list = group.getlinks();
    this.group = group;
    }
    
    /**
     * responsible for finding the desired video URL and passing it to the
     * launchvid method
     * @param event MouseEvent from the system
     */
    @Override
    public void handle(MouseEvent event) {
       
        Text repair = (Text)event.getTarget();
        
        launchvid(group.getURL(repair));
    
    }

    /**
     * takes a URL and creates a WebView node which is passed to the main class
     * for display
     * @param url 
     */
    private void launchvid(String url){
        WebView view = new WebView();
        view.setVisible(true);
        view.getEngine().load(url);
        repairman.launchvideo(view);
    }
    
}
