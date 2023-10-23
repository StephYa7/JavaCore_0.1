package Test;


public class Graphic {

    int a;
    int b;
    int c;
    int d;






    public static void main(String[] args)  {
        int count = 0;
        int n = 1000;

        for (int i = 0; i < 1000; i++) {
            n--;
            for (int j = 0; j < n; j++) {
                count++;

            }

        }
        System.out.println(count);



    }

}