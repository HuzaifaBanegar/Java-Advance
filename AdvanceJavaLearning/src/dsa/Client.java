package dsa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Client {
    public static void main(String[] args) {
        int [] arr = {1,3,2,4};
        nextGreaterElement(arr);

//        Input: nums = [2,7,11,15], target = 9Output: [0,1]
        int[] arr2 = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(arr2, target)));
    }

    public static void nextGreaterElement(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] ans = new int[n];
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){ // 4<2
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i]= -1;
                stack.push(i);
            }else if(arr[stack.peek()] > arr[i]){//4>2
                ans[i]= arr[stack.peek()];
                stack.push(i);
            }
        }

        // {3,4}
        //[0,0,0,-1]
        System.out.println(Arrays.toString(ans));


    }

    public static int[] twoSum(int[] arr, int target){
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for(int i=0; i<n; i++){
            int diff = target - arr[i];
            if(map.containsKey(diff)){
                ans[0]= map.get(diff);
                ans[1]= i;
                break;
            }else{
                map.put(arr[i], i);
            }
        }

        return ans;

    }
}
