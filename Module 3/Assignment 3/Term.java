import java.util.Comparator;

/**
 * Autocomplete term representing a (query, weight) pair.
 * 
 */
public class Term implements Comparable<Term> {
   Term terms[];
   String query;
   Long weight;
   /**
    * Initialize a term with the given query and weight.
    * This method throws a NullPointerException if query is null,
    * and an IllegalArgumentException if weight is negative.
    */
   public Term(String query, long weight) {
      if(query == null) {
         throw new NullPointerException();
      }
      if(weight < 0) {
         throw new IllegalArgumentException();
      }
      this.query = query;
      this.weight = weight;
   }

   /**
    * Compares the two terms in descending order of weight.
    */
   public static Comparator<Term> byDescendingWeightOrder() {
      return 
         new Comparator<Term>() {
            @Override
            public int compare(Term t1, Term t2) {
               return Long.valueOf(t2.weight).compareTo(Long.valueOf(t1.weight));
            }
         };
   }

   /**
    * Compares the two terms in ascending lexicographic order of query,
    * but using only the first length characters of query. This method
    * throws an IllegalArgumentException if length is less than or equal
    * to zero.
    */
   public static Comparator<Term> byPrefixOrder(int length) {
      if(length <= 0) {
         throw new IllegalArgumentException();
      }
      return 
         new Comparator<Term>() {
            @Override
            public int compare(Term t1, Term t2) {
               String q1 = t1.query, q2 = t2.query;
               q1 = q1.substring(0, Math.min(length, q1.length()));
               q2 = q2.substring(0, Math.min(length, q2.length()));
               return q1.compareTo(q2);
            }
         };
   }

   /**
    * Compares this term with the other term in ascending lexicographic order
    * of query.
    */
   @Override
   public int compareTo(Term other) {
      Term t = (Term)other;
      return this.query.compareTo(t.query);
   
   }

   /**
    * Returns a string representation of this term in the following format:
    * query followed by a tab followed by weight
    */
   @Override
   public String toString(){
      return query + "\t" + weight;
   }

}

