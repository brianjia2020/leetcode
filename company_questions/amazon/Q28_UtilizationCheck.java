package company_questions.amazon;

public class Q28_UtilizationCheck {

    public static void main(String[] args) {
        int instances = 1;
        int[] averageUtils = new int[]{5, 10, 80};
        System.out.println(getInstances(2,averageUtils));
    }

    public static int getInstances(int instances, int[] averageUtils){
        int i =0;
        while (i<averageUtils.length){
            if(averageUtils[i]<25){
                if(instances/2>1){
                    instances /= 2;
                }
                i+=10;
            } else if(averageUtils[i]>=25&&averageUtils[i]<=75){
                i++;
            } else {
                if(instances*2<=(2*Math.pow(10,8))) {
                    instances *= 2;
                }
                i+=10;
            }
        }
        return instances;
    }
}
