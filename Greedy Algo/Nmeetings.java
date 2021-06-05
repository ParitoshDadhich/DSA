package greedyAlgo;
import java.util.*;
public class Nmeetings {
	
	
	public static void main(String arg[]) {
		int N = 8;
		int S[] = {75250, 50074, 43659, 8931, 11273,
				27545, 50879, 77924};
		int F[] = {112960, 114515, 81825, 93424, 54316,
				35533, 73383, 160252};
		System.out.println(maxMeetings(S, F, N));
	}
	
	public static int maxMeetings(int start[], int end[], int n)
    {
        int arr[][] = new int[n][2];
        
        for(int i=0; i<n; i++){
            arr[i][0] = start[i];
            arr[i][1] = end[i];
        }
        
        Arrays.sort(arr, (a, b) -> (a[1] == b[1])? a[0]-b[0] : a[1]-b[1]);
        
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0][1]);
        int k=0;
        for(int i=1; i<n; i++){
            if(list.get(k) <= arr[i][0]){
                list.add(arr[i][1]);
                k++;
            }
        }
        
        return list.size();
    }
}
