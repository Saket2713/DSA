//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    ArrayList<String> result = new ArrayList<String>();
    public boolean isSafe(int i ,int j ,int n){
        if(i>=0 && i<n && j>=0 && j<n){
            return true;
        }
        return false;
    }
    
    public void solve(int i, int j, int[][] mat ,int n, ArrayList<String> Temp){
        if(!isSafe(i,j,n) || mat[i][j] == 0){
            return; 
        }
        StringBuffer sb = new StringBuffer();
      
        for (String s : Temp) {
            sb.append(s);
        }
        String str = sb.toString();
        if(i==n-1 && j==n-1){
            
            result.add(str);
            return;
        }
        
        mat[i][j] = 0;
        Temp.add("D");
        solve(i+1,j,mat,n,Temp);
        Temp.remove(Temp.size()-1);
        
        Temp.add("L");
        solve(i,j-1,mat,n,Temp);
        Temp.remove(Temp.size()-1);
        
        Temp.add("R");
        solve(i,j+1,mat,n,Temp);
        Temp.remove(Temp.size()-1);
        
        Temp.add("U");
        solve(i-1,j,mat,n,Temp);
        Temp.remove(Temp.size()-1);
        
        mat[i][j] = 1;
        
    }
    
    public ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> Temp = new ArrayList<>();
        
        
        
         solve(0,0,mat,mat.length,Temp);
        
        return result;
        
    }
}
