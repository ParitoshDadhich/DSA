// method 1
// time o(nlogn) and space o(n)

class Solution {
    public int[][] merge(int[][] arr) {
        if(arr.length <= 1)
            return arr;
        
        Arrays.sort(arr, (a, b) -> (a[0] - b[0]));
        
        List<int[]> list = new ArrayList<>();
        for(int [] i: arr){
            if(list.size() == 0 || list.get(list.size() - 1)[1] < i[0])
                list.add(i);
            else
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], i[1]);
        }
        
        return list.toArray(new int[list.size()][]);
    }
}


