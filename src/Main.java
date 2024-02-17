import java.util.*;

public class Main {
    public static void main(String[] args) {

        //isPalindrome();
        System.out.println(decimalToBinary(101));


    }

    private static LinkedList<Integer> decimalToBinary(int number) {
        Stack<Integer> reminderStack = new Stack<>();
        LinkedList<Integer> result = new LinkedList<>();

        while(number>0){
            int reminder = number %2;
            reminderStack.push(reminder);
            number/=2;
        }
        Iterator<Integer> iterator = reminderStack.iterator();
        while (iterator.hasNext()){
            Integer binaryNumber= iterator.next();
            result.push(binaryNumber);
            //System.out.println(binaryNumber);
        }
        return result;
    }

    private static void isPalindrome() {
        System.out.println(checkForPalindromeWithStack("abccba"));
        System.out.println(checkForPalindromeWithStack("Was it a car or a cat i saw ?"));
        System.out.println(checkForPalindromeWithStack("I did, did I?"));
        System.out.println(checkForPalindromeWithStack("hello"));
        System.out.println(checkForPalindromeWithStack("Don't node"));

        System.out.println("*** *** *** *** ***");

        System.out.println(checkForPalindromeWithQueues("abccba"));
        System.out.println(checkForPalindromeWithQueues("Was it a car or a cat i saw ?"));
        System.out.println(checkForPalindromeWithQueues("i did, did i?"));
        System.out.println(checkForPalindromeWithQueues("hello"));
        System.out.println(checkForPalindromeWithQueues("Don't node"));
    }

    private static boolean checkForPalindromeWithQueues(String text) {
        text = organizedText(text);
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        char[] chars = text.toCharArray();
        for (var c : chars) {
            stack.push(c);
            queue.offer(c);
        }
        while(!queue.isEmpty()){
            var cQ= queue.remove();
            var cS=stack.pop();
            //System.out.println(cS+"?"+cQ);
            if(cQ!=cS){
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    public static boolean checkForPalindromeWithStack(String text) {
        text = organizedText(text);
        Stack<Character> stackOriginal = new Stack<>();
        Stack<Character> stackTemp = new Stack<>();
        Stack<Character> stackReversed = new Stack<>();

        char[] chars = text.toCharArray();
        for (var c : chars) {
            stackOriginal.push(c);
            stackTemp.push(c);
        }
        for (var c : chars) {
            Character charTemp = stackTemp.pop();
            stackReversed.push(charTemp);
        }
        //System.out.println(stackOriginal + "\n" + stackReversed);
        if (stackOriginal.equals(stackReversed))
            return Boolean.TRUE;
        return Boolean.FALSE;
    }

    private static String organizedText(String text) {
        return text.toLowerCase().replaceAll("[.,!?\"'\\-\\s]", "");
    }
}