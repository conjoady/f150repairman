/*
 * John Coady 
 * Westfield state university
 * cais 220
 */
package f150repairman;

import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 *
 * @author John Coady
 */
public class mainhandler implements EventHandler<MouseEvent> 
{           
            private ArrayList<Text> textlist;
            private static ArrayList<Text> text0list = new ArrayList<>();
            private static ArrayList<Text> outlist = new ArrayList<>();
            private F150repairman repairman = new F150repairman();
            private Text link;
            private ArrayList<Group> grouplist;
            
    /**
     * contructor for the eventhandler
     * @param groups takes the arraylist from readfile() in main class
     */
    public mainhandler(ArrayList<Group> groups){
            grouplist = groups;
            }
            
            
    
            /**
             * loads new listpane content on mouse event
             * @param event 
             */
            @Override
            public void handle(MouseEvent event) {
            
                link = (Text)event.getTarget();
                Group group;
                
                for(int i = 0; i < grouplist.size(); i++){
                    if (link.equals(grouplist.get(i).getgroupName())){
                        outlist.addAll(grouplist.get(i).getlinks());
                        group = grouplist.get(i);
                        repairman.setCenter(outlist);
                        repairman.changeHandler(new VideoHandler(group));
                    }
                }
             
            }
            
            
            
            
            }
        
            
        

