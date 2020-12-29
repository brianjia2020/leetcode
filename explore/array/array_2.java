package explore.array;

public class array_2 {
    public int[] replaceElements(int[] arr) {
        int max=Integer.MIN_VALUE;
        for(int i =arr.length-2;i>0;i--){
            max = Math.max(arr[i+1],max);
            int temp = arr[i];
            arr[i] = max;
            max = Math.max(temp,max);
        }
        arr[0] = max;
        arr[arr.length-1]=-1;
        return arr;
    }
}
