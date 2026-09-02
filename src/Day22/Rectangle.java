package Day22;

public class Rectangle {
    int length;
    int width;
    public Rectangle(int length,int width){
        this.length=length;
        this.width=width;
    }
    static int area(Rectangle r){
        return r.length*r.width;
    }
    static int perimeter(Rectangle r){
        return 2*(r.length+r.width);
    }

    static void main() {
        Rectangle r1=new Rectangle(4,7);
        Rectangle r2=new Rectangle(6,9);
        System.out.println("area of r1 "+area(r1));
        System.out.println("perimeter of r2 "+perimeter(r2));
    }
}
