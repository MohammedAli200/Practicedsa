package Day31;

public class ElevatorRequests {
    void main(String[] args){
        int n=5;
        int[] req={2,0,0};
        int floor=0,count=0;
        for(int i=0;i<req.length;i++){
            if(floor<req[i]){
                count+=req[i]-floor;
                floor=req[i];

            }
            else if(floor>req[i]){
                System.out.println(floor);
                count+=floor-req[i];
                floor=req[i];

            }
        }
        System.out.println(count);
    }
}
