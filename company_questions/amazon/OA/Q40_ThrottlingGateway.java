package company_questions.amazon.OA;

public class Q40_ThrottlingGateway {
    public static void main(String[] args) {
        int n = 27;
        int[] requestTime = new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7,7,7,7, 11, 11, 11, 11};
        System.out.println(countLosses(n,requestTime));
    }

    public static int countLosses(int n, int[] requestTime){
        int ans = 0 ;
        for(int i = 0 ;  i < n; i++){

            if(i  >2 && requestTime[i] == requestTime[i-3]){
                ans++;
            } else if(i > 19 && (requestTime[i] - requestTime[i-20]) <10){
                ans++;
            } else if( i > 59 && (requestTime[i] - requestTime[i-60]) <60 ){
                ans++;
            }
        }
        return ans;
    }
}
