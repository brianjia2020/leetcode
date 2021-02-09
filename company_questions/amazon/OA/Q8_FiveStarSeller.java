package company_questions.amazon.OA;

import java.util.*;

public class Q8_FiveStarSeller {
    public static void main(String[] args) {
        int [][] arr =new int[][]{{4,4},{1,2},{3,6}};
        System.out.println(fiveStarSeller2(arr,3,77));
    }

    public static int fiveStarSeller2(int[][] productRatings, int n, int Threshold){
        double rating = 0;
        double[] itemRatings = new double[n];
        for(int i=0;i<productRatings.length;i++) {
            itemRatings[i] = Math.ceil(productRatings[i][0])*100/productRatings[i][1];
            rating += itemRatings[i]/n;
        }
        System.out.println(rating);
        int res = 0;
        while(rating<Threshold){
            int i = findNextRatingPos(productRatings);
            productRatings[i][0]++;
            productRatings[i][1]++;
            res++;
            double newRating = Math.ceil(productRatings[i][0])*100/productRatings[i][1];
            rating = rating - itemRatings[i]/n + newRating/n;
            itemRatings[i] = newRating;
            System.out.println(rating);
        }
        return res;
    }


    public static int fiveStarSeller(int[][] productRatings,int n, int Threshold){
        int count = 0;
        while(getAllRating(productRatings)<Threshold){
            int i = findNextRatingPos(productRatings);
            productRatings[i][0] += 1;
            productRatings[i][1] += 1;
            count++;
        }
        return count;
    }

    public static int findNextRatingPos(int[][] productRatings){
        double maxImprovement = 0;
        int i = 0;
        int pos = 0;
        for(int[] product: productRatings){
            double improvement = Math.ceil(product[0]+1)*100/(product[1]+1) - Math.ceil(product[0])*100/product[1];
            if(improvement>maxImprovement){
                pos = i;
                maxImprovement = improvement;
            }
            i++;
        }
        return pos;
    }

    public static double getAllRating(int[][] productRatings){
        double avgRating = 0;
        for(int i =0;i<productRatings.length;i++){
            avgRating += (Math.ceil(productRatings[i][0])*100/productRatings[i][1]);
        }
        avgRating /= productRatings.length;
        return avgRating;
    }
}
