// Janson Chiu and Yumi Ma 
// jaachiu yma71
// 12B
// Term.java
// This file defines the terms  

import java.lang.NullPointerException;
import java.util.Arrays;
import java.util.Comparator;

public class Term implements Comparable<Term> {
	 String query;
	 long weight;
	 public Term(String query, long weight) { 
		 this.query = query;
		 this.weight = weight;
                 if(weight < 0 ){ // if the weight is less than 0 then it won't be a valid weight  
       	             throw new IllegalArgumentException();
                 }
                 if(query == null){ // this checks if the query equals null and if so it will throw a null pointer exception 
                     throw new NullPointerException();
                 }
	
	 }
	 // This program compares the Terms by weight 
	 public static Comparator<Term> byReverseWeightOrder(){
		 return new Comparator<Term>() {
		 public int compare(Term num1, Term num2) {
			 if(num1.weight > num2.weight) {
				 return -1;
			 }else if (num1.weight == num2.weight) {
				 return 0;
			 }
			 return 1;
		 }
		 }
		 ;
	 }
	 public static Comparator<Term> byPrefixOrder(int r){ 
         	return new Comparator<Term>() {
         // This function compares two terms 
         	public int compare(Term a, Term b) {
        	         if(b.query.length() < r ||  a.query.length() < r) {
        		 	return a.query.compareTo(b.query);
        		 }
        	 	 return a.query.substring(0, r).compareTo(b.query.substring(0, r));
         	}
         	}
         	;
	 }
	 
	 public int compareTo(Term that) {
		 return query.compareTo(that.query);
	 }
	 // This prints the term with weight separated by a tab space and then the query 
	 public String toString() {
		 return(this.weight+"	"+this.query);
	 }
	 // unit testing (required)
	 public static void main(String[] args) {
		 Term[] terms = {new Term("Random", 3), new Term("jake", 8), new Term("Section", 5), new Term("Bristol", 20)};
			for (Term term : terms) System.out.println(term);
			
			// by Reverse Weight Order
			Arrays.sort(terms, Term.byReverseWeightOrder());
			for (Term term : terms) System.out.println(term);
			
			// By prefix order 
			Arrays.sort(terms, Term.byPrefixOrder(2));
			for (Term term : terms) System.out.println(term);
		
			Arrays.sort(terms);
			for (Term term : terms) System.out.println(term);
	 }
}
