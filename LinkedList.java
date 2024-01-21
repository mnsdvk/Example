



public class LinkedList<E> 
{
		public Node<E> head;
		public int size;
		public Node<E> tail;
		public LinkedList() {
			head =null;
			tail=null;
			size=0;
		}
		public boolean isEmpty() {
			if (head==null) {return true;}
			else {return false;}
		}
	   public void addFirst(Node<E> v) {
		   v.setNext(head);
		   head=v;
		   size=size+1;
	   }
	   public void addLast(Node<E> v) {
		 
		   v.setNext(null);
		   if (tail==null){
			   tail=v;head=v; size=size+1;}
		   else {   tail.setNext(v);
		   tail=v;
		   size=size+1;}
	   }
	   public void removeFirst() {
		   Node<E> t=head;
		   head=t.getNext();
		   t.setNext(null);
		   size=size-1;
	   }
	   
	   
	   public void delete(Node<E> v) {
			if (v.element==head.element) {removeFirst();}
			else {Node<E> s=head;
			while (s.getNext().element!=v.element) {s=s.getNext();}
				
				Node<E> r=s.getNext();
				s.setNext(r.getNext());
				r.setNext(null);
				size--;
			
			}
			
		}
		
	   
	   
	   public boolean ismember(Node<E> v) {
		   Node<E> l=head;
		   while (l!=null) {
			   if (v.element==l.element) {return true;}
			   else {l=l.getNext();}
		   }
		   return false;
		   }
      
	   
	   public E get(int i)
	   {
		   Node<E> tmp=head;
		   while(i!=0)
		   {
			   tmp=tmp.getNext();
			   i--;
		   }
		   return tmp.getElement();
	   }
	   
	   public static void main(String[] args)
	   {
	    	LinkedList<Integer> m =new LinkedList<Integer>();
	    	Integer i1 =1; Node<Integer> n1=new Node<Integer> (i1,null);
	    	Integer i2 =2; Node<Integer> n2=new Node<Integer> (i2,null);
	    	Integer i3 =3; Node<Integer> n3=new Node<Integer> (i3,null);
	    	Integer i4 =4; Node<Integer> n4=new Node<Integer> (i4,null);
	    	Integer i5 =5; Node<Integer> n5=new Node<Integer> (i5,null);
	    	Integer i6 =6; Node<Integer> n6=new Node<Integer> (i6,null);
	    	m.addLast(n1);
	    	m.addLast(n2);
	    	m.addLast(n3);
	    	m.addLast(n4);
	    	m.addLast(n5);
	    	System.out.println(m.size);
	    	m.addLast(n1);
	    	System.out.println(m.size);
	    	
	    }
}

