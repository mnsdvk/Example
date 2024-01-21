


public class Node<E> 
{
		public E element; 
		public Node<E> next;
		public Node( E o, Node<E> n) 
		{
			element = o;
	        next = n ;
		}
		public E getElement() 
		{
			return element; 
		}
		public Node<E> getNext() 
		{ 
			return next; 
		}
		public void setElement(E newElem ) 
		{ 
			element = newElem; 
		}
		public void setNext( Node<E> newNext) 
		{ 
			next = newNext; 
		}

}


