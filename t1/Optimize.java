import java.util.Scanner;
public class Optimize
{

    public static void main(String [] args)
	  {
        Scanner sc = new Scanner(System.in);
        int numDouble = 0;
        int numInt = 0;
        int numFloat = 0;
        int numChar = 0;
        int numShort = 0;
        int numLong = 0;
        int numByte = 0;

        int t = sc.nextInt();
		    for (int i = 0; i<t; i++ )
        {
          System.err.println("i : " + i);
          if (sc.hasNextByte())
          {
            numByte++;
            String s = sc.next();
            System.err.println("byte detected : " + s);
          }

          else if (sc.hasNextShort())
          {
            numShort++;
            String s = sc.next();
            System.err.println("short detected : " + s);
          }

          else if (sc.hasNextInt())
          {
            numInt++;
            String s = sc.next();
            System.err.println("int detected : " + s);
          }

          else if (sc.hasNextLong())
          {
            numLong++;
            String s = sc.next();
            System.err.println("long detected : " + s);
          }

          else if (sc.hasNextFloat())
          {
              numFloat++;
              String s = sc.next();
              System.err.println("float detected : " + s);
          }

          else if (sc.hasNextDouble())
          {
              numDouble++;
              String s = sc.next();
              System.err.println("double detected : " + s);
          }

          else if (sc.hasNext())
          {
              numChar++;
              String s = sc.next();
              System.err.println("char detected : " + s);
          }
        }
        int size =
         numDouble * Double.BYTES +
         numInt * Integer.BYTES +
         numFloat * Float.BYTES +
         numChar * 2 +
         numShort * Short.BYTES +
         numLong * Long.BYTES +
         numByte * 1;

        System.out.println(size);
   }
}
