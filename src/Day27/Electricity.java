package Day27;

import java.util.Scanner;

public class Electricity {
    static void main() {
        Scanner sc= new Scanner(System.in);
        int num=sc.nextInt();
        int amt=0;
            if(num>0&&num<=50){
                amt+=num*2;
            }
            else if(num>50&&num<=150){
                amt+=50*2+(num-50)*3;
            }
            else if(num>150&&num<=250){
                amt+=50*2+100*3+(num-150)*4;
            }else if(num>250){
                amt+=50*2+100*3+100*4+(num-250)*5;
            }
        System.out.print(amt);
    }
}
