//Janson Chiu and Yuxi Ma 
// jaachiu yma71
// 12B 
// BinarySearchDeluxe.java
// This file helps search the terms in the array 

import java.util.Comparator;
import java.util.Collections;
public class BinarySearchDeluxe {
	 // Returns the index of the first key in a[] that equals the search key,
	 // or -1 if no such key.
     public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
         if (a.length == 0) {
             return -1; 
         }  
         int high = a.length-1;
         int low = 0;
         int mid = low + (high - low) / 2;
         int compareNum = comparator.compare(a[mid], key);
         while (low < high) {
             if (compareNum == 0) {
                 high = mid;
             } else if (compareNum < 0) {
                 low = mid + 1;
             } else {
                 high = mid - 1;
             } 
             mid = ((high-low)/ 2)+ low;
             compareNum = comparator.compare(a[mid], key);
         }
         if (compareNum == 0) {
             return mid;
         }else{
             return -1;
         }     
     }
	 // Returns the index of the last key in a[] that equals the search key,
	 // or -1 if no such key.
     public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
	 if (a.length == 0) {
             return -1; 
         }
         int foundNum = -1;
         int compare;
         int high = a.length - 1;
         int low = 0;
         int middle = low+(high-low)/2;
         while (low <= high) { 
         // This pretty much compares the value that is pointed by with mid and the key 
         // compares the value pointed to by mid and the key
             compare = comparator.compare(a[middle], key);
             if (compare > 0) { // sees if the compare is greater than 0
                 high = middle-1;
             }else if (compare < 0) { // sees if the compare is less than 0 
                 low = middle+1;
             } else {
                 low = middle + 1;
                 foundNum = middle;
             }
             middle = ((high-low)/2)+low;
         }
     return foundNum; // returns the number that is found 
 }

	 // unit testing (required)
    public static void main(String[] args) {	 
	Integer[] numbers = {10, 9, 8, 7, 6, 5, 5, 4, 3, 2, 1};
	    	System.out.print(BinarySearchDeluxe.firstIndexOf (numbers, 10, Collections.reverseOrder()));
	    	System.out.println(BinarySearchDeluxe.lastIndexOf(numbers, 10, Collections.reverseOrder()));
	    	System.out.print(BinarySearchDeluxe.firstIndexOf (numbers, 4, Collections.reverseOrder()));
	    	System.out.println(BinarySearchDeluxe.lastIndexOf(numbers, 4, Collections.reverseOrder()));
	    	System.out.print(BinarySearchDeluxe.firstIndexOf (numbers, 11, Collections.reverseOrder()));
	    	System.out.println(BinarySearchDeluxe.lastIndexOf(numbers, 11, Collections.reverseOrder()));
    }
}


