package codility;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Hashtable;

import net.yaoo.CodilityPlayaR;


public class                    CodilitySolution                    {

    protected   Class<?>                    toTest_class;
    protected   Object                      toTest;
    protected   Method                      solution;
    protected   int []                      res;
    protected   int []                      empty   = new int [] {};
    protected   Hashtable<String,Method>    mthds   = new Hashtable<String,Method>();

    protected   class           Logger
    extends                     CodilityPlayaR                      {

    }

    protected int               invokeI                         (String mthd,Object ...args)    {
        try {

            if (mthd.equals("solution")){
                return (int) solution.invoke(toTest, args);
            }
            else {
                @SuppressWarnings("unused")
                Method[] mthds=toTest_class.getDeclaredMethods();
            }
        }
        catch (IllegalAccessException e)        { Logger.log(e);;       }
        catch (IllegalArgumentException e)      { Logger.log(e);;       }
        catch (InvocationTargetException e)     { Logger.log(e);;       }
        return -1;
    }

    protected int[]             invoke                          (String method,Object ...args)  {
        try {

            if (method.equals("solution")){
                return (int[]) solution.invoke(toTest, args);
            }
            else {
                Method mthd= mthds.get(method);
                return (int[]) mthd.invoke(toTest, args);
            }
        }
        catch (IllegalAccessException e)        { Logger.log(e);;       }
        catch (IllegalArgumentException e)      { Logger.log(e);;       }
        catch (InvocationTargetException e)     { Logger.log(e);;       }
        return null;
    }

    public                      CodilitySolution                    ()                              {
        try { @SuppressWarnings("unused")
        int err=1/0; } catch (Throwable t){
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream             ps = new PrintStream(baos);
            t.printStackTrace(ps);
            String s=baos.toString();
            String pack="codility.";
            int len=pack.length();
            int pos1=s.indexOf(pack,s.indexOf(pack)+len);
            s=s.substring(pos1+len);
            int pos2=s.indexOf(".");

            String className=pack+s.substring(0, pos2)+".Solution";

            Class<?> toTest_class;
            try {
                toTest_class = Class.forName(className);
                toTest = toTest_class.newInstance();

                Method[] methods=toTest_class.getDeclaredMethods();
                for (int i=0; i<methods.length; i++){
                    mthds.put(methods[i].getName(), methods[i]);
                    if (methods[i].getName().equals("solution")){
                        solution=methods[i];
                    }
                }

            }
            catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                Logger.log(e);
            }


        }
    }

}
