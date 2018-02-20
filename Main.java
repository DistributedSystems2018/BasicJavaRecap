import java.util.*;

public class Main {
    public static void main(String[] args) {
	System.out.println("Number of arguements: " + args.length);
	for(int i=0; i<args.length; i++){
		System.out.println(i+1 +". "+ args[i] + ", length of the arg: " + args[i].length());
	}
	System.out.println("Printing the arguements in reverse order:");
	for(int i=args.length-1; i>=0; i--){
		System.out.println(args[i]);
	}
    System.out.println("Recursive fibonacci: " + Main.fibbo(3));
	System.out.println("Iterative fibonacci: " + Main.itfibbo(3));
	System.out.println("Fibonacci sequence: ");
	Main.fibboseq(3);
	System.out.println("Sum of the Integer arguements: ");
	System.out.println(Main.sumofargs(args));
	Main.evenargs(args);
	Main.argsinorder(args);
	Main.argsinAlOrder(args);
	Main.multipleargs(args);
	if(args[0].matches("-?\\d+")){
		System.out.println("Divisors of " + args[0] + ":");
		Main.printdivisors(Integer.parseInt(args[0]));
	}
	System.out.println("Square root of 81: " + (int) Math.sqrt(81));
	System.out.println("Result of polish notation for (1 2 3 * +): " + Main.polishnotation("1 2 3 * +"));
    }

    public static int fibbo(int a){
	if(a==0)
		return 0;
	if (a==1)
		return 1;
	return fibbo(a-1)+fibbo(a-2);
    }

    public static int itfibbo(int a){

	int first = 1;
	int prev = 1;
		
	for(int i=2; i<a; i++) {
		int temp = first;
		first+= prev;
		prev = temp;
	}
	return first; 
    }

    public static void fibboseq(int a){

	int first = 1;
	int prev = 1;

	System.out.println(first + "\n" + prev);
	for(int i=2; i<a; i++) {
		int temp = first;
		first+= prev;
		System.out.println(first);
		prev = temp;
	}
    }

   public static void printdivisors(int a){
	
	for(int i=1; i<=a; i++){
		if(a%i==0)
			System.out.println(i);
	}
   }

   public static int sumofargs(String[] argu){

   	int result=0;
   	for(String i: argu){
   		if(i.matches("-?\\d+")){
   			result+=Integer.parseInt(i);
   		}
   	}
   	return result;
   }

   public static void evenargs(String[] argu){
   	System.out.println("Even Integer arguements");
   	for(String i: argu){
   		if(i.matches("-?\\d+") && Integer.parseInt(i)%2==0){
   			System.out.println(i);
   		}
   	}
   }

   public static void argsinorder(String[] arg){
   	System.out.println("Integer arguements in numerical order:");
   	List<Integer> l=new ArrayList<Integer>();

   	for(String i: arg){
   		if(i.matches("-?\\d+")){
   			l.add(Integer.parseInt(i));
   		}
	}
   	Collections.sort(l);
   	for(Integer i:l){
   		System.out.println(i);
   	}
   }

   public static void argsinAlOrder(String[] arg){
   	System.out.println("Noninteger arguements in alphabetical order:");
   	List<String> l=new ArrayList<String>();

   	for(String i: arg){
   		if(!i.matches("-?\\d+")){
   			l.add(i);
   		}
	}
   	Collections.sort(l);
   	for(String i:l){
   		System.out.println(i);
   	}
   }

   public static void multipleargs(String[] arg){
   	System.out.println("Arguements having multiple copies:");

   	HashMap<String, Integer> hmap = new HashMap<String, Integer>();

   	for(String i:arg){
   		if(!hmap.containsKey(i)){
   			hmap.put(i,1);
   		}else{
   			hmap.put(i, hmap.get(i) + 1);
   		}
   	}

   	for(Map.Entry<String,Integer> entry: hmap.entrySet()){
   		if(entry.getValue()>1){
   			 System.out.println("arguement: " + entry.getKey() + "   number of arguement:" + entry.getValue());
   		}
   	}
   }

   public static int polishnotation(String arg){
   	Stack<Integer> st = new Stack<Integer>();
   	int a=0;
   	int b=0;
   	int res=0;
   	for(String i : arg.split(" ")){
   		if(i.matches("-?\\d+")){
   			st.push(new Integer(Integer.parseInt(i)));
   		}else{
   			if(i.equals("+")){
   				a = (int) st.pop();
   				b = (int) st.pop();
   				res=a+b;
   				st.push(new Integer(res));
   				}
   				else if(i.equals("*")){
   				a = (int) st.pop();
   				b = (int) st.pop();
   				res=a*b;
   				st.push(new Integer(res));
   				}
   				else if(i.equals("-")){
   				a = (int) st.pop();
   				b = (int) st.pop();
   				res=a-b;
   				st.push(new Integer(res));
   				}
   				else if(i.equals("/")){
   				a = (int) st.pop();
   				b = (int) st.pop();
   				res=a/b;
   				st.push(new Integer(res));
   				}
   			}
   		}
   	return (int) st.pop();
   }
}