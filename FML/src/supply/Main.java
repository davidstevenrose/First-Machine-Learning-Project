package supply;
/**
*
*@author drose
*/

public class Main {

    /**
     * A method that uses recursion to raise a to the power of b.
     * @param b the base
     * @param p the power
     * @return b^p
     */
    public static int power(int b, int p){
        if(p==0){
            return 1;
        }
        return b * power(b, p-1);
    };

    public static int factorial(int f){
        if(f==0){
            return 1;
        }
        return f * factorial(f-1);
    }

    public static int fib(int f){
        if(f==0 || f==1){
            return 1;
        }
        return fib(f-1)+fib(f-2);
    }

    public static void main(String[] args){
        //System.out.println("5 to the power of 6 is "+power(39676,89765));
    }
}
