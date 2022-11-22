package algorithmsolution;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static int smallestNonOccuringInteger(int [] arr){

        //Using a set to get all unique elements in the array
        Set<Integer> set = new HashSet<>();
        for (int i : arr){
            if (i > 0){
                set.add(i);
            }
        }
        //setting a counter that starts from one, and then check
        //the first number that doesn't exist in the set created above
        for (int i=1; i<= arr.length; i++){
            if (!set.contains(i)){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,6,4,1,2};
        int[] secondArr = {5, -1, -3};
        //first non occuring integer in both sample arrays should be five and one
        System.out.println(smallestNonOccuringInteger(arr));
        System.out.println(smallestNonOccuringInteger(secondArr));
    }
}
