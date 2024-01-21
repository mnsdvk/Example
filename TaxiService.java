
public class TaxiService 
{
	Graph abc=new Graph();
	public void performAction(String actionMessage)
	{
		int j=0; 
		while(actionMessage.charAt(j) !=' ')
		{  
			j=j+1; 
		}
		String manu2=actionMessage.substring(0,j);
		if(manu2.equals("edge"))
		{
			String str=actionMessage.substring(j+1,actionMessage.length());
			int time; 
			int k=0;  
			int a=0;
			while(k<str.length() && str.charAt(k) !=' ') 
			{
				k=k+1;
			}
			String source=str.substring(0,k);
			k=k+1;
			a=k;
			while(k<str.length() && str.charAt(k) !=' ') 
			{
				k=k+1;
			}
			String destination=str.substring(a,k);k=k+1;a=k;
			String number=str.substring(a,str.length());
			char [] answer =number.toCharArray();int x=0;a=0;
			while (a<number.length())
			{
				x= (10* x  + (int)answer[a]-48);
				a=a+1;
			} 
			time=x;
			Vrtex v1=abc.gtvrtexfrmstring( source);
			Vrtex v2=abc.gtvrtexfrmstring( destination);
			Vrtex v3=new Vrtex(source);
			Vrtex v4=new Vrtex(destination);
			Node<Vrtex> v5=new Node<Vrtex>(v3,null);
			Node<Vrtex> v6=new Node<Vrtex>(v4,null);
			if (v1!=null&&v2!=null) 
			{
				Edge e=new Edge(v1,v2,time);abc.addEdge(e);
			} 
			else 
			{
				if (v1==null&&v2==null) 
				{
					Edge e1=new Edge(v3,v4,time);abc.addEdge(e1);
				}	else 
				{
					if (v1==null) 
					{
						Edge e2=new Edge(v3,v2,time);abc.addEdge(e2);
					} 
					else 
					{
						if (v2==null) 
						{
							Edge e3=new Edge(v1,v4,time);abc.addEdge(e3);
						}
					}
				}
			}
		}

		if(manu2.equals("taxi"))
		{
			String str=actionMessage.substring(j+1,actionMessage.length());

			int k=0;  int a=0;
			while(k<str.length() && str.charAt(k) !=' ') 
			{
				k=k+1; 
			}
			String taxiname=str.substring(0,k);a=k;

			String taxiposition=str.substring(k+1,str.length());

			Vrtex v1=abc.gtvrtexfrmstring(taxiposition);
			if (v1==null) 
			{
				System.out.println("No such Vrtex");
			} 
			else
			{
				taxi z=new taxi(taxiname,v1,0);
				abc.addtaxi(z);
			}


		}

		if(manu2.equals("customer"))
		{
			String str=actionMessage.substring(j+1,actionMessage.length());
			int time;
			int k=0; 
			int a=0;
			while(k<str.length() && str.charAt(k) !=' ') 
			{
				k=k+1; 
			}
			String src=str.substring(0,k);k=k+1;a=k;

			while(k<str.length() && str.charAt(k) !=' ') 
			{
				k=k+1;
			}
			String dst=str.substring(a,k);a=k;

			String number=str.substring(a+1,str.length());
			char [] answer =number.toCharArray();int x=0;a=0;



			while (a<number.length())
			{
				x= (10* x  + (int)answer[a]-48);a=a+1;
			} 
			time=x;
			Vrtex v1=abc.gtvrtexfrmstring(src);
			Vrtex v2=abc.gtvrtexfrmstring(dst);
			if (src.equals(dst)) 
			{
				System.out.println("No need of taxi");
			}
			else 
			{
				if (v1 !=null&&v2 !=null) 
				{
					abc.customerreq(v1,v2,time);
				}
				else 
				{
					System.out.println("No such Vrtex");
				}
			}
		}
		if(manu2.equals("printTaxiPosition"))
		{
			String str=actionMessage.substring(j+1,actionMessage.length());
			char [] answer =str.toCharArray();int x=0;int a=0;
			while (a<answer.length)
			{
				x= (10* x  + ((int)answer[a]-48)  );
				a=a+1;
			}
			abc.printtaxiposition(x);

		}

	}
}