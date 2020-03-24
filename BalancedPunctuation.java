package assignment3;

import algs4.StdIn;
import algs4.StdOut;
import week3inclass.ArrayStack;
//Anh Nguyen
public class BalancedPunctuation {
	public static boolean punctuate(String inVar) {
		ArrayStack<Character> stack = new ArrayStack<>(inVar.length());
		for (int i = 0; i < inVar.length(); i++) {
			char c = inVar.charAt(i);
			if (c == '('||c=='['||c=='{') {
				stack.push(c);
			}
			else if (c == ')'||c==']'||c=='}') {
				if (stack.isEmpty()) {
					return false;
				}
				else {
					char cCheck = stack.pop();
					if((c == ')' && cCheck != '(') || (c == ']' && cCheck != '[') || (c == '}' && cCheck != '{')) {
						return false;
					}
					if(inVar.isEmpty()==true) {
						return true;
					}
				}
			}
		}
		if (stack.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	public static void main(String[] args) {
		StdOut.print("Enter a string of parentheses, brackets: ");
		String s = StdIn.readLine();
		boolean outPut = punctuate(s);
		if(outPut==false) {
			StdOut.println("The parentheses are not balanced!");
		}
		else if(outPut==true) {
			StdOut.println("The parentheses are balanced!");
		}
	}
}
