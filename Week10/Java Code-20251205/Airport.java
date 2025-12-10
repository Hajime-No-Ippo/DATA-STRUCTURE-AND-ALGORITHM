import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

public class Airport {

    public static void main(String args[]){
    //Parse the CSV file to java
    String filePath = "/Users/tobymiles/CS210 Algorithm_DataStructure/Week10/Java Code-20251205/airports.csv";
    
    //Create the adjacency list
    Map<String, List<String>> graph = new HashMap<>();
    //Create data structure to count the vertices we have in the CSV file
    Set<String> vertices = new HashSet<>();

    int edgeCount = 0;

    try(BufferedReader br = new BufferedReader(new FileReader(filePath))){

        String line = br.readLine();
        while((line = br.readLine()) != null){
            //Seperate the file by using ',' and split function 
            String[] parts = line.split(",");
            //Check if the file is malformed or not, if it is malformed, we skip it to next line
            if(parts.length != 2){
                continue;
            }
            //Trim the vertice and the edges and easy to arrange
            String src = parts[0].trim();
            String dst = parts[1].trim();

            //Using HashSet to get the unique elements by adding all src and dst in it
            vertices.add(src);
            vertices.add(dst);

            //put the vertice into graph and create a edge by using blank arraylist, and using putIfAbsent to ensure we can adding every value to unique key(avoid overwrites)
            graph.putIfAbsent(src, new ArrayList<>());
            //Find the key to adding the values in it
            graph.get(src).add(dst);
            //Adding the count of the edges
            edgeCount++;
        }
    }catch(IOException e){
        System.out.println(e.getMessage());
    }
    catch(Exception e){
        e.printStackTrace();
    }
        // Vertices = 3438
        System.out.println("Total vertices = " + vertices.size());
        // Edges = 34775
        System.out.println("Total edges    = " + edgeCount);
        // Outgoing vertices = 3422
        System.out.println("Only outgoing edges = " + graph.size());

        double density = 0.0;
        density = (double)edgeCount/((double)vertices.size() * (vertices.size()-1));
        // Density = 0.002942
        System.out.println("The D (density) = " + density);

        //Using find_degree to find the degree for specific vertice | For example get '12' for AAL airport
        System.out.println("Degree of 'PVG' airport = " + find_degree(graph,"PVG"));

        //Iterate the graph to get the size of the value => get the edges => store it in Array List
        List<Map.Entry<String, Integer>> list = new ArrayList<>();
        //Traverse all elements in vertices, get whole edges (include Outgoing and incoming)
        for(String k: vertices){
            //declare int for storing degrees
        int degree =  graph.containsKey(k) ? graph.get(k).size() : 0;
        // adding name, degree to a List<Map.Entry()>>
        list.add(Map.entry(k,degree));
        }

        //Sort the list <FLAGGED NOT EVER FIGURE IT OUT>
        list.sort((a,b) -> b.getValue() - a.getValue()); //Desc sorting logic

        System.out.println("Top 5 airports by degree:");
        for (int i = 0; i < 5 && i < list.size(); i++) {
        System.out.println((i + 1) + ". " + list.get(i).getKey()
                       + " → " + list.get(i).getValue());
        }

        
    }

    //Finding function on degrees
    public static int find_degree(Map<String, List<String>> graph,String airport_ID){

        if(graph.containsKey(airport_ID))
        {return graph.get(airport_ID).size();}
        else{
            return -1;
        }
    }

    
    
}

/*try {
    // code that might throw an exception
} catch (ExceptionType e) {
    // what to do if that exception happens
}

try {
    // your logic
} catch (SpecificException e) {
    System.out.println("Friendly error: " + e.getMessage());
} catch (Exception e) {
    e.printStackTrace(); // fallback for unknown errors
}

 */