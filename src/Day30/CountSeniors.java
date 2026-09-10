package Day30;

public class CountSeniors {
    void main(String[] args){
        String[] details ={"1313579440F2036","2921522980M5644"};
        int count=0;
        for(int i=0;i<details.length;i++){
            int num=Integer.parseInt(details[i].substring(11,13));
            if(num>60) count++;
        }
        System.out.println(count);
    }
}
