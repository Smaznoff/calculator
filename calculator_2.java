import java.util.Scanner;

public class calculator_2 {
        public static void main(String[] args) {
                System.out.println("Введите пример");   // краткая инструкция
                Scanner x = new Scanner(System.in);
                Converter converter = new Converter();
                int a = 0;
                int b = -1;
                int p=0;
                String z = "";
                int oper_index = 0;
                String[] actions = {"+", "-", "/", "*"};
                String[] regexActions = {"\\+", "-", "/", "\\*"};
                do {
                        String s = x.next();
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
                                System.out.println("Ошибка");
                                break;
                        }
                        if (s.equals("exit")) {
                                break;
                        }
                        //String[] strings = s.split("\\W");
                        String[] operator = s.split("\\w");
                        String[] d = s.split(regexActions[oper_index]);
                        z = operator[operator.length - 1];
                        try {
                                boolean isRoman = converter.isRoman(d[0]);
                                if(isRoman){
                                        a = converter.romanToInt(d[0]);
                                        b = converter.romanToInt(d[1]);
                                }else {
                                        a = Integer.parseInt(d[0]);
                                        b = Integer.parseInt(d[1]);
                                }
                                        //z=actions[oper_index];
                                int k=operation(a, b, z);
                                if ((a <= 10 && b <= 10) || (b==-1)) {
                                        if(isRoman){
                                                System.out.println(converter.intToRoman(k));
                                        }
                                        else{
                                                System.out.println(k);
                                        }

                                       // System.out.println("Ответ : " + operation(a, b, z));
                                } else {
                                        System.out.println("Введены некорректные данные");
                                }
                        } catch (Exception e) {
                                System.out.println("Ошибка");
                        }
                }
                while (true);
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
