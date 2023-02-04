import java.util.Stack;

/**
 * stack
 */
public class stack {

  public static void main(String[] args) {
    Stack<String> stack = new Stack<String>();

    System.out.println(stack.empty()); // true
    
    stack.push("java");
    stack.push("javascript");
    stack.push("typescript");
    
    System.out.println(stack.empty()); // false

    System.out.println(stack); // [java, javascript, typescript]

    String poped = stack.pop();

    System.out.println("poped: "+poped); // poped: typescript

    System.out.println(stack); // [java, javascript]

    System.out.println("top in stack (last in): "+stack.peek()); // top in stack (last in): javascript
    
    
    
  }
}