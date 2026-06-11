public class StockBuySell {
    public static int stockBuySell(int[] arr, int n) {
        int[] maxRight = new int[n];
        maxRight[n-1] = arr[n-1];

        for(int i = n-2; i >= 0; i--){
            maxRight[i] = Math.max(maxRight[i+1], arr[i]);
        }

        int max = 0;

        for(int i = 0; i < n; i++){
            max = Math.max(max, maxRight[i] - arr[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 5, 8, 11, 9};

        int res = stockBuySell(arr, arr.length);

        System.out.println(res);
    }
}