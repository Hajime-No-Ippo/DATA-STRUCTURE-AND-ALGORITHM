import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ReadHashMap {

    public static void main(String[] args) throws IOException {
    String text = new String(
            Files.readAllBytes(Paths.get("/Users/tobymiles/CS210 Algorithm_DataStructure/Week8/Java Code Week 9  Lab 6-20251121/dorian.txt"))
    ).toLowerCase();

    String[] words = text.split("\\W+"); 

        HashMap<String, Integer> map = new HashMap<>();

        //do the insertion
        for(String s : words){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        //print the map
        System.out.print(map);

        //set the filter to get the most frequent 6 character word
        int max = 0;
        for(Map.Entry<String,Integer> s : map.entrySet()){
            if(s.getKey().length() == 6 && s.getValue() > max){max = s.getValue();}
        }
        for(Map.Entry<String,Integer> s : map.entrySet()){
            if(s.getValue() == max)
            {System.out.println("Words: " + s.getKey()+ "\nCounter: " + s.getValue());}
        }
        
    }
}
