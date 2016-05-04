package net.yaoo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

public class 					CodilityPlayaR 						{

	private static Class<?> 	classe	=	null;
	private static PrintStream  out		=	System.out;

	
	public static void 		log									(Object  ...args) 				{
	 String fmt = "[";
	 for(int i=0; i<args.length; i++) fmt+=((i==0)?"":",")+"%s";
	 log(fmt+"]",args);
	}
	
	public static void 		log									(String fmt, Object  ...args) 	{
		for (int n=0; n<args.length; n++) {
			Object o=args[n];
			if (o instanceof int[]) 	args[n] = Arrays.toString((int[])o);
			if (o instanceof Exception) {
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				PrintStream 			ps = new PrintStream(baos);
				((Throwable)o).printStackTrace(ps);
				args[n] = baos.toString();
			}
		}
	 	String msg = String.format(fmt, args);
	 	out.println(msg);
	}

	@SuppressWarnings("unused")
	public static void 			main								(String[] args) 
			throws 				Exception 															{
		log("here we go");

		String 		classToTest 	=	"codility.BinaryGap.Solution";
		Class<?> []	paramsType		=  { int.class };
		
		
		try {
				classe 			= Class.forName(classToTest);
				Method testMthd = classe.getMethod("solution", paramsType);
				Object solution = classe.newInstance();
				
				int [] testSuite	= 	{1,2,3
										,4,5
										,8,9
										,16,17
										,32,33
										,64,65
										,128,129
										,256,257
										,512,513
										,1024,1025
										,2048,2049
										,4096,4097
										,8192,8193
										,16384,16385
										,32768,32769
										,65536,65537
										,0x20000,0x20001
										,0x40000,0x40001
										,0x80000,0x80001
										,0x100000,0x100001
										,0x200000,0x200001
										,0x400000,0x400001
										,0x800000,0x800001
										,0x1000000,0x1000001
										,0x2000000,0x2000001
										,0x4000000,0x4000001
										,0x8000000,0x8000001
										,0x10000000,0x10000001
										,0x20000000,0x20000001
										,0x40000000,0x40000001
										};
				ArrayList<Integer> reslts	=	new ArrayList<Integer>();
				
				for (int i=0; i<testSuite.length; i++) {
				 int res= (int) testMthd.invoke(solution, testSuite[i]);
				 reslts.add(res);
				}
				
				log(reslts);
				
				Method testMthd_org = classe.getMethod("solution_org", paramsType);
if (false){				
				Timer t1=new Timer("solution_org");
				t1.start();
				for (int i=0 ; i< Integer.MAX_VALUE; i++) {
					testMthd_org.invoke(solution, i);			
				}
				t1.end();
				log(t1);
}				
				Timer t2=new Timer("solution");
				t2.start();
				for (int i=0 ; i< Integer.MAX_VALUE>>8; i++) {
					testMthd.invoke(solution, i);			
				}
				t2.end();
				log(t2);
				
				int a[] = null;
				
				classToTest 	=	"codility.CyclicRotation.Solution";
				paramsType		= (Class<?>[]) new Class<?>[] {  Class.forName("[I"),int.class };
				
				classe 			= Class.forName(classToTest);
				testMthd 		= classe.getMethod("solution"	, paramsType);
				solution 		= classe.newInstance();
 		 Method testMthd_brute  = classe.getMethod("brute"		, paramsType);

			int ror			= 0;
			log(testMthd.invoke(solution,  null 						,ror));
			log(testMthd.invoke(solution,  new int [] {} 				,ror));
			log(testMthd.invoke(solution,  new int [] {1,2,3,4,5,6,7} 	,ror++));
			log(testMthd.invoke(solution,  new int [] {1,2,3,4,5,6} 	,ror++));

 		 		int loops = 0x800000;
 		 		while (0 <loops){
 		 		 int numEl=(int)(Math.random()*100);
 		 		 int el[]=new int [numEl];
 		 		 for (int i=0;i<numEl;i++) el[i]=(int)(Math.random()*2000-1000);
 		 		 int K=(int)(Math.random()*100);
 		 		 int [] A=(int[]) testMthd_brute.invoke(solution,  el	,K);
 		 		 int [] B=(int[]) testMthd		.invoke(solution,  el	,K);
 		 		 if (!Arrays.equals(A, B) ) {
 		 			 
 		 			 log("ERROR! %s != %s",A,B);
 		 			 break;
 		 		 }
 		 		 --loops;
 		 		}
 		 		
 		 		log("loops left: %d",loops);
 		 		

		} 
		catch 		( ClassNotFoundException 	e) 		{
			log(e);
		}
		catch 		( InstantiationException 	e) 		{
			log(e);
		}
		catch 		( NoSuchMethodException 	e) 		{
			log(e);
		} 
		catch 		( SecurityException 		e) 		{
			log(e);
		} 
		catch 		( IllegalAccessException
					| InvocationTargetException 
					| IllegalArgumentException 	
												e) 		{
			log(e);
		} 
		
		//catch (Throwable t) {}
		
		log("Done.");
	}


}

	class						Timer								{
		public					Timer	(String label)				{
			this.label = label;
		}
		private	String			label;
		private	long			st=-1
				,				en=0;
		private long 			ellapsed = -1;
		
		public	void			start	()							{
			st=System.currentTimeMillis();
		}
		
		public long				end		() 
				throws 			Exception							{
			if (-1==st) throw new Exception("timer not started yet!");
			en=System.currentTimeMillis();
			ellapsed=en-st;
			return ellapsed;
		}
		
		public long				getTime ()							{
			return ellapsed;
		}
		
		public String			toString()							{
			return String.format("T:%s::(%f) sec.",label,(float)ellapsed/1000);
		}
	}