// Janson Chiu and Yuxi Ma 
// jaachiu yma71
// 12B
// Autocomplete.java
// This file does the autocompleting of the string 
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
public class Autocomplete {
	 // Initializes the data structure from the given array of terms.
	 private final Term[] terms;
	 
	 public Autocomplete(Term[] terms) {
		 if(terms == null) {
			 throw new NullPointerException("Terms can not be NULL");
		 }
		 this.terms = new Term[terms.length];
		 for(int i=0; i<terms.length; i++) {
			 this.terms[i] = terms[i];
		 }
		  Arrays.sort(this.terms);
	 
	 }
         // This method returns all the terms that start with the given prefix in descending order of weight 
	 public Term[] allMatches(String prefix) {
		 Term myPrefix = new Term(prefix, 0);
		 
		 Comparator<Term> prefixCompare = Term.byPrefixOrder(prefix.length());
	     Comparator<Term> reverse = Term.byReverseWeightOrder();
	     
	     int firstOne = BinarySearchDeluxe.firstIndexOf(terms, myPrefix, prefixCompare);
	     int lastOne = BinarySearchDeluxe.lastIndexOf(terms, myPrefix, prefixCompare);
	     
	     if(firstOne == -1) {
	    	 return new Term[0];
	  
	     }else if(lastOne == -1) {
	    	 return new Term[0];
	     }
	     
	     Term[] returning = new Term[lastOne-firstOne+1];	     
	     int count = 0;
	     for (int i = firstOne; i <= lastOne; i++) {
	    	 returning[count++] = terms[i];
	     }
	     Arrays.sort(returning, reverse);
	     return returning;
	 }
		 // Returns the number of terms that start with the given prefix.
     public int numberOfMatches(String prefix) {
    	 Term myPrefix = new Term(prefix, 0);
    	 
    	 Comparator<Term> prefixCompare = Term.byPrefixOrder(prefix.length());
    	 int firstOne = BinarySearchDeluxe.firstIndexOf(terms, myPrefix, prefixCompare);
    	 int lastOne = BinarySearchDeluxe.lastIndexOf(terms, myPrefix, prefixCompare);
    	 
    	 if(firstOne == -1 ) {
    	     return 0;
    	 }else if(lastOne == -1) {
    		 return 0;
    	 }
    	 return lastOne - firstOne + 1;
    	 
     }
         // copied Autocomplete me 
	 // unit testing (required)
	 public static void main(String[] args) throws IOException{
                 String filename = args[0];
                 Scanner in = new Scanner( new File(filename));
                 int N = in.nextInt();
                 Term[] terms = new Term[N];
                 for(int i = 0; i<N;i++){
                    long weight = in.nextLong();
                    String query = in.nextLine().trim();
                    terms[i] = new Term(query, weight);
                 }
                 in.close();

                 int k = Integer.parseInt(args[1]);
                 Autocomplete autocomplete = new Autocomplete(terms);
                 Scanner stdin = new Scanner(System.in);
                 while(stdin.hasNextLine()){
                    String prefix = stdin.nextLine();
                    Term[] results = autocomplete.allMatches(prefix);
                    for(int i =0; i< Math.min(k, results.length); i++)
                        System.out.println(results[i]);
                 }
                 stdin.close();
         }
}
