package bracechecker;

public class BraceChecker{

    private String text;
    private Stack stack;

    public BraceChecker(String text) {
        this.text = text;
        stack = new Stack();
    }

    public void check() {
        for (int i = 0; i < text.length(); i++) {
            switch (text.charAt(i)) {
                case '(':
                case '[':
                case '{':
                    stack.push(text.charAt(i));
                    break;
                case ')':
                case ']':
                case '}':
                    char temp = text.charAt(i);
                    char tos = stack.pop();

                    if (tos == 0) {
                        System.out.println("ERROR! Closed " + temp + " at position " + i +" but never was opened");
                        break;
                    }

                    if ( (temp == ')' && tos == '(') ||
                            (temp == ']' && tos == '[') ||
                            (temp == '}' && tos == '{')) {
                        //if true it will pop automatically
                    } else {
                        System.out.println("ERROR! Opened " + tos + " but closed " + temp + " at position " + i);
                    }

                    int last;
                    while ((last = stack.pop()) != 0)
                        System.out.println("ERROR! Opened " + (char) last + " but never was closed");
                    break;
            }
        }
    }
}