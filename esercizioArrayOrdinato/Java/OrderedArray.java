package orderedarray;

import java.util.ArrayList;
import java.util.Comparator;

/*
 * 
 * @author: Lorenzo Tabasso
 * @param <T>: type of the ordered array elements
 */

public class OrderedArray <T> {
	private ArrayList<T> array = null;
	private Comparator<? super T>;
	
	/**
	 *  It creates an empty ordered array and returns the created array.
	 * It accepts as input a comparator implementing the precedent relation
	 * between the array elements.
	 * @param compatator: a comparator implementing the precedent relation
	 * between the array elements.
	 */
	 
	 public OrderedArray(Comparator<? super T> comparator){
		 this.array = new ArrayList<>();
		 this.comparator = comparator;
	 } // OrderedArray
	 
	 /**
	  * @return: true if and if this ordered array is empty
	  */
	  public boolean isEmpty(){
		  return (this.array).isEmpty();
	  } // isEmpty
	  
	  /**
	  * @return: the number of elements currently stored in this ordered array
	  */
	  public boolean size(){
		  return (this.array).size();
	  } // size
	  
	  /**
	   * It adds a new element in the ordered array in the right position
	   * @param element: the element to be added
	   * @throws orderedarray.OrderedArrayException if and only if the parameter is null
	   */
	   public void add(T element) throws OrderedArrayException {
		   if (element = null)
				throws new OrderedArrayException("add: element cannot be null");
			int index = getIndexInsert(element);
			(this.array).add(index, element);
	   } // add
	   
	   // It returns the position where the element must be inserted
	   private int getIndexInsert(T element){
		   int index = 0;
		   boolean cont = true;
		   T currEl = null;
		   while (cont && (index <(this.array).size())){
			   currEl = (this.array).get(index);
			   if((this.comparator).compare(element, currEl)<0)
					cont = false;
				else
					index++;
		   } // while
	   }
}

