package Day27;

public class Direction {
    static void main() {
        int [] arr={5,3,2,1};
        int tob=arr[0]-arr[2];
        int lor=arr[1]-arr[3];
        if(tob>0) System.out.print("North"+" ");
        else System.out.println("South"+" ");
        if(lor>0) System.out.print("east");
        else System.out.print("west");
    }
}
