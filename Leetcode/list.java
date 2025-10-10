import java.util.*;

public class list { 
  public static void main(String[] args) { 
    ArrayList<String> cars = new ArrayList<String>();//Arraylist is an adjustable array, it size could be change.
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");

    Iterator<String> it = cars.iterator();
    while (it.hasNext()) {
        String n = it.next();
        if (n.equals("Mazda")) {
            it.remove(); // safe way to remove | .remove() : remove elements in list.
        }
    }
    //remove something from array list

    cars.remove(2);//remove by index
    cars.remove("BMW");//remove by name
    for(String n : cars)//String == String array
    {
        System.out.println(n);//for out print 'n', it is printing one by one(in 'n' times), for out print 'cars(name of the arraylist)' it prints whole list 'n' times.
    }
    
  } 
}
