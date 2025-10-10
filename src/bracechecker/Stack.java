package bracechecker;

public class Stack {
    private char[] array = new char[10];
    private int tos;

    public void push(char value){
        if (tos == array.length - 1) {
            System.out.println("Stack is full");
        } else {
            array[++tos] = value;
        }
    }

    public char pop(){
        if (tos < 0) {
            System.out.println("Stack is empty");
            return 0;
        } else {
            return array[tos--];
        }
    }
}
