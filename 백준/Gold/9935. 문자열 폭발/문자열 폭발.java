import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine(), target = br.readLine();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
		    sb.append(s.charAt(i));
		    boolean flag = true;
		    if (sb.length() >= target.length()) {
		        for (int j = 0; j < target.length(); j++) {
		            if (sb.charAt(sb.length() - 1 - j) != target.charAt(target.length() - 1 - j)) {
		                flag = false;
		                break;
		            }
		        }
		        if (flag) sb.setLength(sb.length() - target.length());
		    }
    	}
		System.out.println(sb.length() == 0 ? "FRULA" : sb);
	}
}