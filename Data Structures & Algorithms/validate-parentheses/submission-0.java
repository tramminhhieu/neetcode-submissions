class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        
        if (c == '(' || c == '[' || c == '{') {
            stack.push(c);
        } else {
            if (stack.isEmpty()) {
                return false;
            }
            
            char pre = stack.peek();
            
            if (c == ')' && pre == '(') {
                stack.pop();
            } else if (c == ']' && pre == '[') {
                stack.pop();
            } else if (c == '}' && pre == '{') {
                stack.pop();
            } else {
                return false;
            }
        }
    }
    return stack.isEmpty();
    }
}
