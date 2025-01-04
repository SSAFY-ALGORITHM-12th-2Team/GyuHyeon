import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<Character> s = new Stack<Character>();
		StringBuilder sb = new StringBuilder(); 
		for (int i = 0; i < str.length(); i++) {
		    if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') sb.append(str.charAt(i) + "");
		    else {
		        if (str.charAt(i) == '(') s.push(str.charAt(i));
		        else if (str.charAt(i) == ')') {
		            while (!s.isEmpty() && s.peek() != '(') sb.append(s.pop());
		            if (!s.isEmpty()) s.pop();
		        }
		        else {
		            while (!s.isEmpty() && pr(s.peek()) >= pr(str.charAt(i))) sb.append(s.pop());
		            s.push(str.charAt(i));
		        }
		    }
		}
		
		while (!s.isEmpty()) sb.append(s.pop());
		System.out.println(sb);
	}
	
	public static int pr(char op) { // operator priority
	    if (op == '*' || op == '/') return 2;
        else if (op == '+' || op == '-') return 1;
        else return 0;
	}
}