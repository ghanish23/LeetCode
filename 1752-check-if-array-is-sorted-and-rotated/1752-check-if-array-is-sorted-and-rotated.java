import java.util.Scanner;
class Solution {
public boolean check(int[] arr) {
    int n = arr.length;
    int count =0;
    for(int i=0; i<n; i++){
            if(arr[i]>arr[(i+1) %n]){
                count++;
            }
        }
        return count <= 1;
    }

public static void main(String [] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int arr[] = new int[n];
    for(int i=0; i<n; i++){
        System.out.print("Enter elements: ");
        arr[i] = sc.nextInt();
    }
    Solution sol = new Solution();
    boolean ans = sol.check(arr);
    if(ans){
        System.out.print("The array is sorted");
    }
    else{
        System.out.print("not sorted");
    }
}
}