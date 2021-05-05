package aiPackage.game;
//Java program to flatten a stream of arrays 
//using forEach() method 

import java.util.ArrayList; 
import java.util.Arrays; 
import java.util.List; 
import java.util.stream.Stream; 

public class convertArray {
	// Function to flatten a Stream of Arrays 
    public static <T> Stream<T> flattenStream(T[][] arrays) 
    { 
  
        // Create an empty list to collect the stream 
        List<T> list = new ArrayList<>(); 
  
        // Using forEach loop 
        // convert the array into stream 
        // and add the stream into list 
        for (T[] array : arrays) { 
            Arrays.stream(array) 
                .forEach(list::add); 
        } 
  
        // Convert the list into Stream and return it 
        return list.stream(); 
    } 
}
