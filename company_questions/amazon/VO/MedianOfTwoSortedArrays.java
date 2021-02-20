package company_questions.amazon.VO;

public class MedianOfTwoSortedArrays {


    //O(n)
    public double findMedianOfTwoSortedArrays(int[] A, int[] B){
        int i=0,j=0,k=0;
        int[] res = new int[A.length+B.length];
        while(i<A.length&&j<B.length){
            if(A[i]<=B[j]){
                res[k++] = A[i++];
            } else {
                res[k++] = B[j++];
            }
        }
        while(i<A.length) res[k++] = A[i++];
        while(j<B.length) res[k++] = B[j++];

        if((A.length+B.length)%2==0) return res[res.length/2];
        else return (res[res.length/2]+res[res.length/2-1])/2.0;
    }

    //O(logn)
    public double findMedianOfTwoSortedArrays2(int[] A, int[] B){
        int m = A.length, n = B.length;
        if(m>n) return findMedianOfTwoSortedArrays(B,A);
        if(m==0) {
            return n%2==0?(B[n/2]+B[n/2-1])/2.0:B[n/2];
        }
        int k = m+n;
        int i=0,j=A.length;
        int aNum=0,bNum=0;
        while(i<=j){
            aNum = (i+j)/2;
            bNum = k/2-aNum;
            double L1 = aNum==0?Integer.MIN_VALUE:A[aNum-1];
            double R1 = aNum==m?Integer.MAX_VALUE:A[aNum];
            double L2 = bNum==0?Integer.MIN_VALUE:B[bNum-1];
            double R2 = bNum==n?Integer.MAX_VALUE:B[bNum];
            if(L1>R2){
                j = aNum-1;
            } else if(L2>R1){
                i = aNum+1;
            } else {
                if(k%2==0) return (Math.max(L1,L2)+Math.min(R1,R2))/2.0;
                else return Math.min(R1,R2);
            }
        }
        return -1;
    }
}
