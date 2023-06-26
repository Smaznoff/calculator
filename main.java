import java.io.IOException;
import java.util.Scanner;

 public class main {
         public static void main(String[] args) throws IOException {
                 System.out.println("Введите пример");   // краткая инструкция
                 Scanner x1 = new Scanner(System.in);
                 String s1 = x1.next();
                 String s = calc(s1);
                 System.out.println(s);
         }
        public static String calc(String x) throws IOException {
               // System.out.println("Введите пример");   // краткая инструкция
                //Scanner x = new Scanner(System.in);
                Converter converter = new Converter();
                int a = 0;
                int b = -1;
                int p=0;
                String z = "";
                int oper_index = 0;
                String[] actions = {"+", "-", "/", "*"};
                String[] regexActions = {"\\+", "-", "/", "\\*"};
                do {
                        //String s = x.next();
                        String s = x;
                        for (int i = 0; i < s.length(); i++) {
                                if ((s.charAt(i)=='+') || (s.charAt(i)=='-') || (s.charAt(i)=='*') || (s.charAt(i)=='/')) {
                                        p+=1;
                                }
                        }
                        for (int i = 0; i < actions.length; i++) {
                                if (s.contains(actions[i])) {
                                        oper_index = i;
                                }
                        }
                        if ((s.length() < 3) || (p>1)) {
                                throw new IOException();
                        }
                        if (s.equals("exit")) {
                                break;
                        }
                        //String[] strings = s.split("\\W");
                        String[] operator = s.split("\\w");
                        String[] d = s.split(regexActions[oper_index]);
                        z = operator[operator.length - 1];

                        boolean isRoman = converter.isRoman(d[0]);
                        if(isRoman){
                                a = converter.romanToInt(d[0]);
                                b = converter.romanToInt(d[1]);
                        }
                        else {
                                a = Integer.parseInt(d[0]);
                                b = Integer.parseInt(d[1]);
                                if ((z=="/") && (b==0)) {
                                        throw new ArithmeticException();
                                }
                        }
                        //z=actions[oper_index];
                        int k=operation(a, b, z);
                        if ((a <= 10 && b <= 10) || (b==-1)) {
                                if(isRoman){
                                        return (converter.intToRoman(k));
                                }
                                else{
                                        return String.valueOf((k));
                                }
                                // System.out.println("Ответ : " + operation(a, b, z));
                        } else {
                                throw new IOException();
                        }
                }
                while (true);
                return z;
        }

        private static int operation(int a, int b, String z) {
                switch (z) {
                        case "*":
                                return a * b;
                        case "+":
                                return a + b;
                        case "-":
                                return a - b;
                        case "/":
                                return a / b;
                        case ":":
                                return a / b;
                        default:
                                return 0;
                }
        }
}
