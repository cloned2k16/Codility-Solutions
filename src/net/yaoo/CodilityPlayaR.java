package net.yaoo;

import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class 					CodilityPlayaR 						{

	private static Class<?> 	classe	=	null;
	private static PrintStream  out		=	System.out;

	
	private static void 		log									(Object  ...args) 				{
	 String fmt = "[";
	 for(int i=0; i<args.length; i++) fmt+=((i==0)?"":",")+"%s";
	 log(fmt+"]",args);
	}
	
	private static void 		log									(String fmt, Object  ...args) 	{
	 	String msg = String.format(fmt, args);
	 	out.println(msg);
	}

	public static void 			main								(String[] args) 				{
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
