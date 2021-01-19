
import java.util.*;


public class Brackets {
    //Solution to HackerRank Balanced Brackets Challange

    static String isBalanced(String s) { 
        // will solve by implementing a list
        // add each char to a linked list
        LinkedList<Character> list = new LinkedList<>();

        //retrieve some values for more compact code
        int n = s.length();
        char c;
        char last;
        for(int i = 0;i<n;i++){
            c = s.charAt(i);
            //we add to the list if opening a new bracket
            if(c=='{'||c=='['||c=='('){
                list.add(s.charAt(i));
            //and pop it if closing
            //if bracket we are closing doesn't match
            //return no
            }else if(list.size()>0){
                last = list.removeLast();
                if((c=='}' && last!='{')||(c==']' && last!='[')||(c==')' && last!='(')){
                    return "NO";
                }
            //if list is empty we are trying to close a bracket with none open 
            }else{
                return "NO";
            }
        }

        //if we still have elements left to pop
        //it is not a balanced set of brackets
        if (list.size()>0) {
            return "NO";
        }
        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
