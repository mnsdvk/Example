

public class taxi 
{
	 Vrtex currentposition;
	 int availability;
	 String name;
	 public taxi(String tax,Vrtex a,int b) 
	 {
		 currentposition=a;
		 availability=b;
		 name=tax;
	 }
	 
	 public void updatetaxi(int h,Vrtex a)
	 {
		 availability=h;
		 currentposition=a;
	
	 }

}
