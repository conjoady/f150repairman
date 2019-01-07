/*
 * John Coady 
 * Westfield state university
 * cais 220
 */
package f150repairman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import javafx.scene.text.Text;

/**
 *
 * @author John
 */
public class Group {
    private Text groupName;
    private ArrayList<Text> repairs;
    private HashMap map = new HashMap();
    
    /**
     *  Group class knows which repairs are associated with what system in the truck
     * and also correlates each repair link with a URL
     * @param groupName specifies the system of the vehicle
     * @param repair specifies a specific part or repair
     * @param URL path to a youtube video
     */
    public Group(Text groupName, ArrayList<Text> repair, ArrayList<String> URL){
        if (repair.size() != URL.size()){
            System.out.println("File Error");
        }
        this.groupName = groupName;
        repairs = repair;
        
        for (int i = 0; i < repair.size(); i++){
            map.put(repair.get(i),URL.get(i));
        }
    }
    
    
    public String getURL(Text key){
        String URL = (String)map.get(key);
        return URL;
    }
    
    
    public Text getgroupName(){
    return this.groupName;
    }
    
    
    public ArrayList<Text> getlinks(){
    return repairs;
    }
}
