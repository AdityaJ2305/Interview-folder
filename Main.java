class Main{
    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 4, 3, 2, 1};
        int[] arr2 = {5, 3, 1, 2, 2, 2, 2, 3, 4, 5};
        
        int[] result1 = check(arr);
        int[] result2 = check(arr2);
        
        System.out.println("Array 1 -> Max Increasing: " + result1[0] + ", Max Decreasing: " + result1[1]);
        System.out.println("Array 2 -> Max Increasing: " + result2[0] + ", Max Decreasing: " + result2[1]);
    }
    
    private static int[] check(int[] arr){
        int maxI = 0;  // Max increasing sequence length
        int maxD = 0;  // Max decreasing sequence length
        int curri = 0;  // Current increasing sequence length
        int currd = 0;  // Current decreasing sequence length
        
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > arr[i - 1]){  // Increasing subsequence
                curri++;
                currd = 0;  // Reset decreasing counter
                maxI = Math.max(maxI, curri + 1);  // +1 to count the current element
            }
            else if(arr[i] < arr[i - 1]){  // Decreasing subsequence
                currd++;
                curri = 0;  // Reset increasing counter
                maxD = Math.max(maxD, currd + 1);  // +1 to count the current element
            }
            else {  // If equal, reset both (or could treat it as part of either)
                curri++;
                currd++;
            }
        }
        
        return new int[] {maxI, maxD};  // Return max increasing and max decreasing lengths
    }
}