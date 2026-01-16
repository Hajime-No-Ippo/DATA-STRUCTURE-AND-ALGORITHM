import java.util.*;
public class TSP{
    // 先建立一个向无向图添加节点的方法，更方便维护
    // 要不要把步数，方法，是否遍历过做成一个node呢？

    // 加一个全局变量
    static int best = Integer.MAX_VALUE;
    
    static void addUndirected(List<int[]>[] g, int u , int v, int val ) {
        // 加一条有向边 u -> v，权重 w
        // 哦所以这里 u ， v就是两个点的名称，然后w就代表距离了，所以无向图反而要加两次，默认是有方向这一说的
        // 所以把u连接到v，再把v连接回u
        g[u].add(new int[]{v, val});
        g[v].add(new int[]{u, val});
    }

    public static void main(String[] args) {
        System.out.println("\n" + minmumTSP());
    }
    public static int minmumTSP() {
        // 创建一个容量为5的邻接表
        int n = 5;
        List<int[]>[] g = new ArrayList[n];
        // 让每个点可以相互串联 -> 变成一个 ArrayList；
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        
        // A -> 0 , B -> 1 , C -> 2, D -> 3, E -> 4 五点映射值
        // 创建联系
        addUndirected(g, 0, 1, 2); // A-B
        addUndirected(g, 1, 2, 2); // B-C
        addUndirected(g, 2, 3, 3); // C-D
        addUndirected(g, 3, 4, 4); // D-E

        addUndirected(g, 4, 0, 2); // E-A
        addUndirected(g, 0, 3, 1); // A-D
        addUndirected(g, 0, 2, 3); // A-C
        addUndirected(g, 4, 1, 6); // E-B
        
        // 创建一个步数收集器
        int step = 0;
        // 创建一个步骤计步器，走满了就说明全走到了
        int count = 0;
        // 创建一个是否访问过的限制条件, 创建默认肯定全是false
        boolean[] visited = new boolean[n];
        // 创建一个路径表示器
        List<String> ans = new ArrayList<>();

        // 开始递归！
        best = Integer.MAX_VALUE;
        visited[0] = true;
        dfs(g, 0, step, visited, count, ans);
        // visited[0] = false;
        for(int i = 0; i < ans.size(); i++) {
            if(i % 4 != 0) {
                System.out.print(ans.get(i) + " ");
            }else{
                System.out.println();
                System.out.print(ans.get(i) + " ");
            }
        }
        return best;
    }

    private static void dfs(List<int[]>[] g,
        int u,
        int step,
        boolean[] visited,
        int count,
        List<String> ans) {
         // 当我们没有走到最后点，以及我们没有走到遍历过的点上的时候，我们就加步数
         // 所以当走完了，我们就返回，走到走过的点上，我们也返回

         // 先检查是不是走了五步，这是前提条件
         // base case
        if(count == 4) {
            // OK既然走到了，下一个约束就是他是不是走回家了
            for (int[] s : g[u]) {
                if(s[0] == 0) {
                    best = Math.min(best, step + s[1]);
                    return;
                }
            }
        }

        for(int[] e : g[u]) {
            // 记录下一个点，还是说是上一个点是什么？
            // 哦是下一个点，理解没错，草
            int nextPoint = e[0];
            // 记录走过的距离还是下一步的距离？
            // 那这个就是下一步的距离了
            int val = e[1];
            // System.out.println("val=" + val);

            if(!visited[nextPoint]) {
                visited[nextPoint] = true;
                ans.add(
                    switch(nextPoint) {
                        case 0 -> "A ->";
                        case 1 -> "B ->";
                        case 2 -> "C ->";
                        case 3 -> "D ->";
                        case 4 -> "E ->";
                        default -> "";
                    }
                );
    
                // 继续递归！
                dfs(g, nextPoint, step + val, visited, count + 1, ans);
                // System.out.println("u=" + u + " count=" + count);
                // 回溯约束！
                visited[nextPoint] = false;

                // 做选择
                // 递归到 nextPoint
                // 撤销选择（回溯）
            }
        }
    }
}