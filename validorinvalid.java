import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.io.PrintWriter;

class validorinvalid{
    static String replace;
    static String old;
    static int len;
    static int status;
    public static void recur(int ptr){
        if (ptr<len-2){
            int temp=Character.toLowerCase(old.charAt(ptr+1))-Character.toLowerCase(old.charAt(ptr+2));
            //System.out.println(temp);
            if ((temp<=3)&&(temp>=-3)){
                if (ptr==-1)replace=replace+"aa";
                else{
                    if (replace.charAt(ptr+1)=='a')replace=replace+"aa";
                    else replace=replace+"bb";
                }
            }else{
                if (temp<0)replace=replace+"ab";
                else replace=replace+"ba";
            }
            recur(ptr+1);
        }
    }
    public static void check(int ptr){
        if (ptr<len){
        if (ptr==0){
            if (replace.charAt(0)=='a')check(1);
            else status=-1;
        }else{
            if (replace.charAt(ptr)=='a'){
                boolean c1=(ptr==len-1);
                boolean c2=(ptr<len-1)&&(replace.charAt(ptr+1)=='a');
                boolean c3=(ptr<len-2)&&(replace.charAt(ptr+1)=='b')&&(replace.charAt(ptr+2)=='b');
                if (c1||c2||c3)check(ptr+1);
                else {
                    //if (ptr==2)System.out.println((ptr<len-2)+" "+(replace.charAt(ptr+1)=='b')+" "+(replace.charAt(ptr+2)=='b'));
                    System.out.println("hi "+ptr);
                    status=-1;
                }
            }else{
                if ((ptr==len-2)&&(replace.charAt(ptr+1)=='b')){}
                else if ((ptr<len-2)&&(replace.charAt(ptr+1)=='b')&&(replace.charAt(ptr+2)=='a'))check(ptr+2);
                else {
                    System.out.println("hey "+ptr);
                    status=-1;
                }
            }

        }}
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            old=Reader.next();
            replace="";
            status=0;
            len=old.length();
            recur(-1);
            System.out.println(replace);
            len=2*(len-1);
            check(0);
            if (status==-1)System.out.println("invalid");
            else System.out.println("valid");
        }
    }
}
