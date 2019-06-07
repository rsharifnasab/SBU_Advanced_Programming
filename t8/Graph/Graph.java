import java.util.*;
public class Graph {

    public static int yal,ras;
    // A user define class to represent a graph.
    // A graph is an array of adjacency lists.
    // Size of array will be V (number of vertices
    // in graph)
    int V;
    LinkedList<Integer>[] adjListArray;

    // constructor
    Graph(int V) {
        this.V = V;
        // define the size of array as
        // number of vertices
        adjListArray = new LinkedList[V];

        // Create a new list for each vertex
        // such that adjacent nodes can be stored

        for(int i = 0; i < V ; i++){
            adjListArray[i] = new LinkedList<Integer>();
        }
    }

    // Adds an edge to an undirected graph
    void addEdge( int src, int dest) {
        // Add an edge from src to dest.
        adjListArray[src].add(dest);

        // Since graph is undirected, add an edge from dest
        // to src also
        adjListArray[dest].add(src);
    }

    void DFSUtil(int v, boolean[] visited) {
        // Mark the current node as visited and print it
        visited[v] = true;
        //System.out.print(v+" ");
        // Recur for all the vertices
        // adjacent to this vertex
        for (int x : adjListArray[v]) {
            if(!visited[x]) DFSUtil(x,visited);
        }

    }
    void connectedComponents() {
        // Mark all the vertices as not visited
        boolean[] visited = new boolean[V];
        for(int v = 0; v < V; ++v) {
            if(!visited[v]) {
                // print all reachable vertices
                // from vSystem.out.println("Following are connected components");
                DFSUtil(v,visited);
                System.out.println();
            }
        }
    }
    int tedad(){
        int ans  = 0;
        boolean[] visited = new boolean[V];
        for(int v = 0; v < V; ++v) {
            if(!visited[v]) {
                // print all reachable vertices
                // from v
                DFSUtil(v,visited);
                //System.out.println();
                ans++;
            }
        }
        return ans -1 ;
    }

    public static int calculator(int[][] datas,int toDel){
      Graph g = new Graph(ras);
      for (int i = 0;i < yal ;i++ ) {
        int a,b;
        a = datas[i][0];
        b = datas[i][1];
        if( a != toDel && b!= toDel)
          g.addEdge(a,b);
      }
      return g.tedad();
    }

    public static void main(String[] args){
      Scanner s = new Scanner(System.in);

      ras = s.nextInt() + 1;
      yal = s.nextInt();
      int[][] datas = new int[yal][2];
      Graph asli = new Graph(ras);
      for (int i = 0;i < yal ;i++ ) {
        int a,b;
        a = s.nextInt();
        b = s.nextInt();
        asli.addEdge(a,b);
        datas[i][0] = a;
        datas[i][1] = b;
      }
      int TMHA = asli.tedad();
      List<Integer> ans = new LinkedList<>();
      for(int i =0; i < ras; i++){
        int newTHM = calculator(datas,i) - 1;
        if ( newTHM > TMHA) ans.add(i);
      }
      Collections.sort(ans);
      for (Integer i : ans ) {
        System.out.println(i);
      }

    }
}
