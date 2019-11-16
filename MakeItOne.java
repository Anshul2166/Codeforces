import java.util.*;

public class MakeItOne{
    public static void main(String args[]){
        Scanner obj=new Scanner(System.in); 
    }
    static void simplify(){
        //This is method 1
	    int gcd=findGCD(num,denom);
	    num=num/gcd;
	    denom=denom/gcd;
	    System.out.println("The simple fraction is "+num+"/"+denom);
	}
	static int findGCD(int num1, int num2) {
        //This is method 2
        
        //base case
        if(num2 == 0){
            return num1;
        }
        return findGCD(num2, num1%num2);
    }

}