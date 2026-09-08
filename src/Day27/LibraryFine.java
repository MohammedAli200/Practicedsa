package Day27;

public class LibraryFine {
    static void main() {
        int d1=9;
        int m1=6;
        int y1=2015;
        int d2=6;
        int m2=6;
        int y2=2015;
        int fine =fine(d1,m1,y1,d2,m2,y2);
        System.out.println(fine);
    }
    public static int fine(int d1, int m1, int y1, int d2, int m2, int y2){
        int fine =0;

        if(y2==y1&&m2==m1){
            if(d2>d1){
                int diff=d2-d1;
                fine=diff*15;
                return fine;
            }
        }else if(y1==y2){
            if(m2>m1){
                int diff=m2-m1;
                fine=diff*500;
                return fine;
            }
        }else if(y2!=y1){
            fine=10000;
            return fine;
        }
        return fine;
    }

}
