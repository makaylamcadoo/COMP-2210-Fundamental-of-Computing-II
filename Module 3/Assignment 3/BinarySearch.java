import java.util.Arrays;
import java.util.Comparator;

/**
 * Binary search.
 */
public class BinarySearch {

   /**
    * Returns the index of the first key in a[] that equals the search key, 
    * or -1 if no such key exists. This method throws a NullPointerException
    * if any parameter is null.
    */
   public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
      int start = 0, end = a.length -1;
      int index = -1;
      while(start <= end) {
         int mid = (start + end) / 2;
         int c = comparator.compare(a[mid], key);
         if(c >= 0) {
            if(c == 0) {
               index = mid;
            }
            end = mid - 1;
         }
         else {
            start = mid + 1;
         }
      }
      return index;
   }

   /**
    * Returns the index of the last key in a[] that equals the search key, 
    * or -1 if no such key exists. This method throws a NullPointerException
    * if any parameter is null.
    */
   public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
      int start = 0, end = a.length -1;
      int index = -1;
      while(start <= end) {
         int mid = (start + end) / 2;
         int c = comparator.compare(a[mid], key);
         if(c <= 0) {
            if(c == 0) {
               index = mid;
            }
            start = mid + 1;
         }
         else {
            end = mid - 1;
         }
      }
      return index;
   
   }

}
