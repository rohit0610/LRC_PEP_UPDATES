import java.io.*;
import java.util.*;

public class KSWES {

	public static void solution(int[] arr, int vidx,int n , int k,int[] subsetSum,int sf, ArrayList<ArrayList<Integer>> ans) {
		//write your code here
		if(vidx == arr.length){
		    if(sf == k){
		        int sum = subsetSum[0];
		        boolean yes = true;
		        for(int i=1; i<subsetSum.length; i++){
		            if(subsetSum[i] == sum){
		                continue;
		            }else{
		                yes = false;
		                break;
		            }
		        }
		        if(yes){
		            for(ArrayList<Integer> a : ans){
		                System.out.print(a+" ");
		            }
		            System.out.println();
		        }
		    }
		    return;
		}
		for(int j =0; j<ans.size(); j++){
		    if(ans.get(j).size() ==0){
		        ans.get(j).add(arr[vidx]);
		        subsetSum[j] += arr[vidx];
		        solution(arr, vidx +1, n, k, subsetSum, sf+1, ans);
		        ans.get(j).remove(ans.get(j).size()-1);
		        subsetSum[j] -= arr[vidx];
		        break;
		    }else{
		        ans.get(j).add(arr[vidx]);
		        subsetSum[j] += arr[vidx];
		        solution(arr, vidx +1, n, k, subsetSum, sf, ans);
		        ans.get(j).remove(ans.get(j).size()-1);
		        subsetSum[j] -= arr[vidx];
		    }
		}
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		int sum = 0;
		for(int i =  0 ; i < arr.length; i++) {
			arr[i] = scn.nextInt();
			sum += arr[i];
		}
		int k = scn.nextInt();
		// if k is equal to 1, then whole array is your answer 
		if(k == 1) {
			System.out.print("[");
			for(int i = 0 ; i  < arr.length; i++) {
				System.out.print(arr[i] + ", ");
			}
			System.out.println("]");
			return;
		}
		//if there are more subsets than no. of elements in array or sum of all elements is not divisible by k
		if(k > n || sum % k != 0) {
			System.out.println("-1");
			return;
		}
		int[] subsetSum = new int[k];
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(int i = 0; i < k; i++) {
			ans.add(new ArrayList<>());
		}
		solution(arr,0,n,k,subsetSum,0,ans);
	}
	
	

}