//{ Driver Code Starts
    import java.util.*;
    class TestClass 
    {
        public static void main(String args[] ) throws Exception 
        {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();
            while(T>0)
            {
            	int N = sc.nextInt();
            	
            	int x[] = new int[N];
       			int y[] = new int[N];
            	for(int i = 0; i < N; i++)
            		x[i] = sc.nextInt();
	for(int i = 0; i < N; i++)
            		y[i] = sc.nextInt();
            	System.out.println(new GfG(). maxPoints(x,y,N));
            T--;
            
System.out.println("~");
}
        }
    }
// } Driver Code Ends


class GfG{
    int maxPoints(int X[],int Y[],int N) {
        //You are required to complete this method
        int ans=0;
        for(int i=0;i<N;i++){
            HashMap<Double,Integer>map =new HashMap<>();
            double x=0;
            for(int j=0;j<N;j++){
                if(i!=j){
                    if(X[j]-X[i]==0) x=Integer.MAX_VALUE;
                    else x=(double)(Y[j]-Y[i])/(double)(X[j]-X[i]);
                    map.put(x,map.getOrDefault(x,0)+1);
                    ans=Math.max(ans,map.get(x));
                }
            }
        }
        return ans+1;
   }
}