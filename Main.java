import java.util.Arrays;
import java.util.Scanner;

/*
Вычислить n-ое треугольного число(сумма чисел от 1 до n)
Вычислить n! (произведение чисел от 1 до n)
Вывести все простые числа от 1 до 1000 (простые числа - это числа которые делятся только на себя и на единицу без остатка. Чтобы найти остаток от деления используйте оператор % , например 10%3 будет равно единице)
Реализовать простой калькулятор ("введите первое число"... "Введите второе число"... "укажите операцию, которую надо выполнить с этими числами"... "ответ: ...")
* Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69. Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.
*/
public class Main {
    public static void main(String[] args) {

        String menu="";
        Boolean runAgain=true;
        do {
            menu=showMenu();
            switch (menu){
                case "1":
                    ex1();
                    break;
                case "2":
                    ex2();
                    break;
                case "3":
                    ex3(1000);
                    break;
                case "4":
                    ex4();
                    break;
                case "5":
                    ex5();
                    break;
                case "0":
                    runAgain=false;
                    break;
                default:
                    System.out.println("Ошибка ввода пункта!");
                    break;
            }
 //           while (menu!="0"); - глюк Java!, не работает даже когда я точно ввел 0!!!(menu=="0")
        } while (runAgain);
    }
    static String showMenu(){
        System.out.println("Выберите задачу:");
        System.out.println("1.Вычислить n-ое треугольного число(сумма чисел от 1 до n).");
        System.out.println("2.Вычислить n! (произведение чисел от 1 до n)");
        System.out.println("3.Вывести все простые числа от 1 до 1000 (простые числа - это числа которые делятся только на себя и на единицу без остатка.");
        System.out.println("4.Реализовать простой калькулятор");
        System.out.println("5.* Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69. Требуется восстановить выражение до верного равенства.");
        System.out.println("0.Закончить");
        Scanner scanner = new Scanner(System.in);
        String p = scanner.nextLine();
        return p;
    }
    static int getn (String s){
        System.out.println(s);
        int n=0;
        boolean stupidUser=false;
        do {
            stupidUser=false;
            try {
                Scanner scanner = new Scanner(System.in);
                n = scanner.nextInt();
            } catch (Throwable t) {
                System.out.println("Ошибка ввода");
                stupidUser=true;
            }
        } while (stupidUser);
        return n;
    }


    //Вычислить n-ое треугольного число(сумма чисел от 1 до n)
    static void ex1(){
        int n=getn("Введите n:");
        int sum=0;
        for (int i = 1; i <= n; i++) {
            sum+=i;
        }
        System.out.println("Сумма чисел с 1 до "+n+" равна "+sum);
    }
    static void ex2(){
        int n=getn("Введите n:");
        int f=1;
        for (int i = 1; i <= n; i++) {
            f*=i;
        }
        System.out.println(n+"!="+f);
    }
    /*
    Вывести все простые числа от 1 до 1000 (простые числа - это числа которые делятся только на себя и на единицу без остатка.
    Чтобы найти остаток от деления используйте оператор % , например 10%3 будет равно единице)
     */
    static void ex3(int maxn){
        Boolean easyNum=true;
        for (int i = 2; i<=maxn ; i++) {
            easyNum=true;
            for (int j = 2; j <= i/2; j++) { //на выше чем половина числа все равно не делиться нечего
                if (i%j==0){
                    easyNum=false;
                    break;
                }

            }
            if (easyNum) {
                System.out.println(i);

            }

        }
    }
    //Реализовать простой калькулятор ("введите первое число"... "Введите второе число"... "укажите операцию, которую надо выполнить с этими числами"... "ответ: ...")
    static void ex4(){
      int a=getn("введите первое число");
      int b=getn("введите второе число");
      System.out.println("укажите операцию, которую надо выполнить с этими числами");
      Scanner scanner = new Scanner(System.in);
      String oper = scanner.nextLine();
        switch (oper){
            case "+":
                System.out.println("ответ:"+(a+b));
                break;
            case "-":
                System.out.println("ответ:"+(a-b));
                break;
            case "*":
                System.out.println("ответ:"+(a*b));
                break;
            case "/":
                if (b==0){
                    System.out.println("на ноль делить нельзя!");
                } else {
                    System.out.println("ответ:" + ((float) a / b));
                }
                break;
            default:
                System.out.println("только +,-,*,/");
                break;
        }
    }
    /*
     * Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69.
     * Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.
     */

    // На вход строка 2?3?4, массив где ? - [1,3], и номер как разбить, например 0 - 20304, а 56 = 25364. почти, только 65 получилось, но это и не важно
    static int replaceSymbol (String num, int [] where,int i){
        int Finish=num.length();
        String str="";
        for (int j = where.length-1; j >= 0 ; j--) {
            str=((i/(int)Math.pow(10,j))%10)+num.substring(where[j]+1,Finish)+str;
            Finish=where[j];
        }
        str=num.substring(0, Finish)+str;
        return Integer.parseInt(str);



    }
    static int[] getAllValue (String num){
        int count=0;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i)=='?'){
                count++;
            }
        }
        int[] arr= new int [(int)Math.pow(10, count)];
        int [] where=new int [count];
        int j=0;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i)=='?'){
                where[j]=i;
                j++;
            }
        }


        for (int i = 0; i < arr.length; i++) {
                arr[i]=replaceSymbol(num,where,i);
        }
        return arr;
    }
    static void ex5(){
        System.out.println("введите уравнение вида 2? + ?5 = 69 (пробелы обязательны!)");
        Scanner scanner = new Scanner(System.in);
        String equal = scanner.nextLine();
        //String equal = "2? + ?5 = 69";
        String[] nums_equal=equal.split(" ");

        int[] q_arr;
        int[] w_arr;
        int[] e_arr;
        q_arr=getAllValue(nums_equal[0]);
        w_arr=getAllValue(nums_equal[2]);
        e_arr=getAllValue(nums_equal[4]);
        boolean hasFinded=false;
        for (int q:q_arr
             ) {
            for (int w:w_arr
                 ) {
                for (int e:e_arr
                     ) {
                    if ((q+w)==e){
                        System.out.println("Решение: "+q+" + "+w+" = "+e);
                        hasFinded=true;
                        break;
                    }

                }
                if (hasFinded) {
                    break;
                }
            }

        if (hasFinded){
            break;
            }
        }
        if (hasFinded==false){
            System.out.println("Решений нет");
        }



    }
}