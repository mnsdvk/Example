

public class timevrtex 
{
	public int tm;
	public Vrtex v;
	public Vrtex v2;
	public timevrtex(int time,Vrtex ve,Vrtex ve2 ) 
	{
		tm=time;
		v=ve;
		v2=ve2;
	}
	public void sett(int g) 
	{
		tm=g;
	}
    public void setv(Vrtex g) 
    {
    	v=g;
    }
    public void setv2(Vrtex f) 
    {
    	v2=f;
    }
}
