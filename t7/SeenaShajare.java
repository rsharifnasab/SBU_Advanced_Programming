import java.util.*;

public class Main
{
    private int V;
    private LinkedList<Integer> adj[];
    private List<String> persons = new ArrayList<>();

    Main(int v)
    {
        v++;
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v,int w)
    {
        adj[v].add(w);
    }

    void BFS(int s)
    {
        boolean visited[] = new boolean[V];

        LinkedList<Integer> queue = new LinkedList<>();

        visited[s]=true;
        queue.add(s);

        while (queue.size() != 0)
        {
            s = queue.poll();
            System.out.printf(persons.get(s));
            boolean printed = false;
            adj[s].sort(Comparator.comparing(o -> persons.get(o)));
            for (int j = 0; j < adj[s].size(); j++) {
                if (!printed) {
                    System.out.printf("->");
                    printed = true;
                }
                System.out.printf(persons.get(adj[s].get(j)) + " ");
            }
            System.out.println();
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Main g = new Main(n);

        boolean[] hasParent = new boolean[n+1];

        for (int i = 0; i < n; i++) {
            String child = scanner.next();
            int v = g.persons.indexOf(child);
            if (v < 0) {
                g.persons.add(child);
                v = g.persons.indexOf(child);
            }
            String parent = scanner.next();
            int w = g.persons.indexOf(parent);
            if (w < 0) {
                g.persons.add(parent);
                w = g.persons.indexOf(parent);
            }
            g.addEdge(w, v);
            hasParent[v] = true;
        }

        int root = 0;
        for (int i = 0; i < n + 1; i++) {
            if (hasParent[i] == false) {
                root = i;
                break;
            }
        }
        g.BFS(root);
    }
}
