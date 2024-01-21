

import java.util.*;

public class Graph 
{

	public LinkedList<Vrtex> Graph =new LinkedList<Vrtex>();
public LinkedList<Edge> edgelist =new LinkedList<Edge>();
public LinkedList<timevrtex> timelist=new LinkedList<timevrtex>();
public LinkedList<timevrtex> finallist=new LinkedList<timevrtex>();
public LinkedList<timevrtex> finallist2=new LinkedList<timevrtex>();
public Vector<taxi> taxilist=new Vector<taxi>();




public void addVrtex(Vrtex v) {
Node<Vrtex> p=new Node<Vrtex>(v,null);
int i=0;
int j=0;
Node<Vrtex> a=Graph.head;
while (i<Graph.size) 
{
	if (p.element.name.equals(a.element.name)) 
		{
			j++;
			return;
		}
	else 
		{
			a=a.getNext();i++;
		}
}
if (j==0) 
	{
		Graph.addLast(p);
	}
	
}

public void addone(Edge e) 
{
	Node<Vrtex> a=new Node<Vrtex>(e.one,null);
	Node<Vrtex> b=new Node<Vrtex>(e.two,null);
	Node<Vrtex> g=Graph.head;
	int i=0;
	int j=0;
	while (i<Graph.size) 
	{
		if (g.getElement().name.equals(e.one.name) ) 
		{
		    g.getElement().t.addLast(b);
		    j++;
		    return;
		} 
		else 
			{
				g=g.getNext();
				i++;
			}
	}
	
	if (j==0) 
		{
			Graph.addLast(a); 
			a.getElement().t.addLast(b);
		}
	
}


public void addtwo(Edge e) 
{
	Node<Vrtex> a=new Node<Vrtex>(e.one,null);
	Node<Vrtex> b=new Node<Vrtex>(e.two,null);
	Node<Vrtex> g=Graph.head;
	int i=0;
	int j=0;
	while (i<Graph.size) 
	{
		if (g.getElement().name.equals(e.two.name) )
		{
			g.getElement().t.addLast(a);
			j++;
			return;
		} 
		else 
			{
				g=g.getNext();
				i++;
			}
	}
	if (j==0) 
		{
			Graph.addLast(b);
			b.getElement().t.addLast(a);
		}
	
}
public void addEdge(Edge e)
{
	Node<Edge> e1=new Node<Edge>(e,null);
	Edge s=new Edge(e.two,e.one,e.time);
	Node<Edge> s1=new Node<Edge>(s,null);
	addVrtex(e.one);
	addVrtex(e.two);
	addone(e);
	addtwo(e);
	edgelist.addLast(e1);
	edgelist.addLast(s1);
	
}

public void children(Vrtex v)
{
	LinkedList<Vrtex> r=v.t;
	
	for(Node<Vrtex> n=r.head;n!=null;n=n.next)
		{
			System.out.println(n.element.name);
		}
}
public LinkedList<Vrtex> gettv()
{
	return Graph;
}


public Edge returnedge(Vrtex a,Vrtex b) 
{
	Node<Edge> e=edgelist.head;
	while (e!=null) 
	{
		if (a.name.equals(e.element.one.name)&&b.name.equals(e.element.two.name)) 
			{
				return e.element;
			}
		else 
			{
				e=e.getNext();
			}
	}
	return null;
}
public Node<timevrtex> min(LinkedList<timevrtex> l) 
{
	Node<timevrtex> u=l.head;
	Node<timevrtex> v=l.head;
	while (u!=null) 
	{
		
		if (u.element.tm<v.element.tm) 
			{v=u;u=u.getNext();}
		else 
			{u=u.getNext();}
	}
	return v;		
}
public Vrtex gtvrtexfrmstring(String str) 
{
	Node<Vrtex> k=Graph.head;
	while (k!=null) 
	{
		if (str.equals(k.element.name)) 
			{return k.element;}
		else 
			{k=k.getNext();}
	}
	return null;
}
	public LinkedList<timevrtex> Initial1(LinkedList<Vrtex> k) 
	{
		 LinkedList<timevrtex> Timelist=new LinkedList<timevrtex>();
		Node<Vrtex> p=k.head;
		while (p!=null) 
		{
			timevrtex t=new timevrtex(1000,p.element,p.element);
	        Node<timevrtex> t1=new Node<timevrtex>(t,null);
	        {
			    Timelist.addLast(t1);
			    p=p.getNext();
		    }		
		}	
		return Timelist;	
}

public LinkedList<timevrtex> Initial2(Vrtex a,Vrtex b,LinkedList<timevrtex> Timelist) 
{
		Node<timevrtex> o=Timelist.head;
		while(o!=null) 
		{
			Node<Vrtex> n=new Node<Vrtex>(o.element.v,null);
		
		    if (a.name.equals(o.element.v.name)) 
		    	{o.element.sett(0);o=o.getNext();}
		    else 
		    	{
		    		if (a.t.ismember(n)) 
		    		{
			           if (returnedge(a,n.element)==null) 
				          {o=o.getNext();}
			           else 
			               {
			                   o.element.sett(returnedge(a,n.element).time);
		                       o.element.setv(a);o=o.getNext();
		                    }
		            }
		            else 
			            {o=o.getNext();}
	            }
        }
	return Timelist;
}

public LinkedList<timevrtex> Initial3(Vrtex a,Vrtex b,LinkedList<timevrtex> Timelist) {
	 LinkedList<timevrtex> Finallist=new LinkedList<timevrtex>();
	while (Timelist.size!=0) {
	Node<timevrtex> m=min(Timelist);
	
	Node<timevrtex> m2=new Node<timevrtex>(m.element,null);
	Finallist.addLast(m2);
	
	Timelist.delete(m);
	
	Node<timevrtex> n=min(Timelist);
	Node<timevrtex> j=Timelist.head;
	while (j!=null) {
		Node<Vrtex> x=new Node<Vrtex>(j.element.v2,null);
		if (n.element.v2.t.ismember(x)) {
		
			if (returnedge(n.element.v2,j.element.v2)==null) {j=j.getNext();}
			else {
			if
			
		(j.element.tm>(n.element.tm+returnedge(n.element.v2,j.element.v2).time)) {
			j.element.sett(n.element.tm+returnedge(n.element.v2,j.element.v2).time);
			j.element.setv(n.element.v2);j=j.getNext();
		}
		else {j=j.getNext();}
		}}
		else {j=j.getNext();}
}

}
return Finallist;
}




public void Initial4(Vrtex a,Vrtex b,LinkedList<timevrtex> Finallist) {
	 LinkedList<timevrtex> Finallist2=new LinkedList<timevrtex>();
	
	Node<timevrtex> h=Finallist.head;
	String g=new String(b.name);
	while (h!=null) 
	{
		
		if (g.equals(h.element.v2.name)) 
		{
			Finallist2.addFirst(h);
		if ( ! h.element.v.name.equals(a.name))   {  g=h.element.v.name;h=Finallist.head;
		} else {break;}
		}
		else {h=h.getNext();}
		
	}
	
	Finallist2.addFirst(Finallist.head);
	
	Node<timevrtex> w=Finallist2.head;
	while (w!=null) {System.out.print(w.element.v2.name+", ");w=w.getNext();}
	
}





public void Shortestpath(Vrtex a,Vrtex b) {
	if (a.name==b.name) {System.out.println(a.name);}
	else {
	Initial1( Graph);
	LinkedList<timevrtex> u=Initial2(a,b,Initial1(Graph));
	LinkedList<timevrtex> v=Initial3(a,b,u);
	Initial4(a,b,v);}
	
}


public int Shortesttime(Vrtex a,Vrtex b) {
	Initial1( Graph);
	LinkedList<timevrtex> u=Initial2(a,b,Initial1(Graph));
	LinkedList<timevrtex> v=Initial3(a,b,u);
	Node<timevrtex> s=v.head;
	while (s!=null) {
		if (b.name.equals(s.element.v2.name)) {return s.element.tm;}
		else {s=s.getNext();}
	}
	return 0;
}
	
public void addtaxi(taxi a) {
	taxilist.add(a);
}

public Vector<taxi> availtaxi(int a) {
	Vector<taxi> availtaxilist=new Vector<taxi>();
	int i=0;
	while (i<taxilist.size()) {
		if (taxilist.get(i).availability<a) {availtaxilist.add(taxilist.get(i));i++;}
		else {i++;}
		
	}
	return availtaxilist;
}

public taxi selectedtaxi(Vrtex a,int b) {
	Vector<taxi> z=availtaxi(b);
	taxi s=z.get(0);
	int i=0;
	while (i<z.size()) {
		if (Shortesttime(a,s.currentposition)>Shortesttime(a,z.get(i).currentposition)) { 
	        s=z.get(i);i++;
		}
		else {i++;}
		
}
return s;
}

public void customerreq(Vrtex a,Vrtex b,int t) {
	System.out.println();
	Vector<taxi> e=availtaxi(t);
	System.out.println("Available taxis:");

	int f=0;
	while (f<e.size()) {Vrtex v=e.get(f).currentposition;
		System.out.print("path of taxi "+e.get(f).name+" ");Shortestpath(v,a);
		System.out.println("time taken is " +Shortesttime(a,v)+" units");
		f++;
		
	}
	System.out.println();
	
	
	System.out.println("** Choose taxi "+selectedtaxi(a,t).name+" to service the customer request ***");
	
	System.out.print("path of customer ");Shortestpath(a,b);System.out.println("  time taken is "+Shortesttime(a,b)+" units");
selectedtaxi(a,t).updatetaxi(t+Shortesttime(a,selectedtaxi(a,t).currentposition)+Shortesttime(a,b),b);
	
}

public void printtaxiposition (int t) {
	Vector<taxi> y=availtaxi(t);
	int i=0;
	while (i<y.size()) {
		System.out.println("Taxi"+y.get(i).name+": "+y.get(i).currentposition.name);i++;
	}
}

}
