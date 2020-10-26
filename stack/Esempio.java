package it.polimi.deib.se.ex04.stack;

public class Esempio {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(2);
        stack.push(4);
		stack.push(5);
		stack.pop();
		stack.pop();
		for(Integer s : stack){
			System.out.println(s);
		}
		
	}

}
