import java.util.Arrays;
import java.util.Comparator;

/**
 * Autocomplete.
 */
public class Autocomplete {
   private Term[] terms;
   

	/**
	 * Initializes a data structure from the given array of terms.
	 * This method throws a NullPointerException if terms is null.
	 */
   public Autocomplete(Term[] terms) {
      if (terms == null) {
         throw new NullPointerException();
      }
      Arrays.sort(terms);
      this.terms = terms;
      
   }

	/** 
	 * Returns all terms that start with the given prefix, in descending order of weight. 
	 * This method throws a NullPointerException if prefix is null.
	 */
   public Term[] allMatches(String prefix) {
      if (prefix == null) {
         throw new NullPointerException();
      }
   
      int index1 = BinarySearch.firstIndexOf(terms, new Term(prefix, 0),
            Term.byPrefixOrder(prefix.length()));
      int index2 = BinarySearch.lastIndexOf(terms, new Term(prefix, 0),
            Term.byPrefixOrder(prefix.length()));
         
      int count = (1 + (index2 - index1));
      Term[] results = new Term[count];
       
      return results;
      
   }
}



