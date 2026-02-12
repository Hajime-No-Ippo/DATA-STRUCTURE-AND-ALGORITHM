import java.util.Collections;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.*;

class Node{
    int val;
    Node left, right;

    public Node(int val){
        this.val = val;
        left = right = null;
    }
}
// class PrimeNumbers {
//     public static void main(String[] args) {
//         int n = 12; // You can change this value to find primes up to a different number
//             boolean[] isPrime = new boolean[n]; 
//             isPrime[0] = true;
//             isPrime[1] = true;

//             for(int p = 2; p * p < n; p++){
//                 if( isPrime[p] == false){
//                     for(int m = p * p; m < n; m += p){
//                         isPrime[m] = true;
//                     }
//                 }
//             }

//             for(int i = 2; i < n; i++){
//                 if(isPrime[i] == false){
//                     System.out.println(i + " is a prime number.");
//                 }
//             }
//     }
// }

class BinaryTree{
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(3);

        System.out.println("Inorder traversal of binary tree:");
        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(Node root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Deque<Node> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++){
                Node node = q.poll();
                level.add(node.val);
                if(node.right != null) q.offer(node.right); 
                if(node.left != null) q.offer(node.left); 
            }
            res.add(level);
        }
        Collections.reverse(res);
        return res;
    }
}

// 回家路径 + 压栈弹栈 + 区别化输出
public class getHome {
    public String getHome(String a){
        Deque<String> q = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);
        
        while(sc.hasNextLine()){
            String dir = sc.nextLine();

            if(dir.equals("Arrived")){
                break;
            }
            if(dir.equals("Go Back")){
                if(!q.isEmpty()) q.pop();
                continue;
            }
            if(dir.equals("Go North") || dir.equals("Go South") || dir.equals("Go West" )|| dir.equals("Go East")){
                q.offer(dir);
            }
        }

        sc.close();

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            String dir = q.pop().trim();
            
            if(sb.length() > 0)sb.append("\n");
            switch(dir){
                case "Go North" -> sb.append("Go South");
                case "Go South" -> sb.append("Go North");
                case "Go West" -> sb.append("Go East");
                case "Go East" -> sb.append("Go West");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        getHome s = new getHome();
        String res = s.getHome("");
        System.out.println(res);
    }
}


// Dijkstra算法模板
class Dijkstra {
    static class Edge {
        int to, w;
        Edge(int to, int w) { this.to = to; this.w = w; }
    }

    // n: 节点数，graph[u] 是 u 的边列表
    static int[] dijkstra(int n, List<Edge>[] graph, int src) {
        int INF = Integer.MAX_VALUE / 4;
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        // {dist, node}
        pq.offer(new int[]{0, src});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0], u = cur[1];

            // 过期条目（lazy delete）
            if (d != dist[u]) continue;

            for (Edge e : graph[u]) {
                int v = e.to;
                int nd = d + e.w;
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.offer(new int[]{nd, v});
                }
            }
        }
        return dist;
    }
}

// 用BFS做IP地址划分
class Solution {
    static class State {
        int idx, seg;
        String path;
        State(int idx, int seg, String path) {
            this.idx = idx;
            this.seg = seg;
            this.path = path;
        }
    }
    public List<String> restoreIpAddresses(String s) {
        // 初始化一个用于输出的结果
        List<String> ans = new ArrayList<>();

        // 定义一个值用来储藏一下字符串的长度
        int n = s.length();

        // 如果这个字符串的值本身就没办法做IP地址，比如小于4，没办法分成四段，或者大于12，分成四段后还是会超界，直接返回这个空ans
        if(n < 4 || n > 12) return ans;

        // 初始化一个栈，用于储藏state的BFS算法
        Deque<State> q = new ArrayDeque<>();

        // 把头一一个节点放到我们的BFS初始化栈里
        q.offer(new State(0,0,""));

        // 设置栈的处理边界
        while(!q.isEmpty()){
            // 从栈里取出当前字符串的值，第几位->index， 第几步->seg， 当前的分界ip地址 -> path
            State cur = q.poll();

            // 定义区分剩下后的 index，和步骤 seg -> 剪枝
            int idx = cur.idx, seg = cur.seg;
            int remain = n - idx;
            int need = 4 - seg;

            // 更细的去设置边界，如果剩余的字符数量比需要的步骤都少，比如还剩两步，字符串数量都不够2了，肯定分不了了 -> 设置下界
            // 还需要的步骤 * 3 都比所剩的字符串要少，那肯定会超界了 -> 设置上界
            if(remain < need || remain > 3 * need) continue;

            // idx == n 决定 能不能收答案
            // seg == 4 决定 能不能继续扩展（答案：不能）
            if(seg == 4){
                if(idx == n) ans.add(cur.path);
                continue;
            }

            for(int len = 1; len <= 3; len++){
                // 当前处理到字符串哪个位置 + 开始处理的字符串位置 比字符串长度总数大后
                if(idx + len > n) break;

                // 当目前处理的字符串长度大于1，并且第一位为0，说明有前置0，需要舍去
                if(len > 1 && s.charAt(idx) == '0') break;

                // 把目前处理的字符串转化为整数进行比对大小
                int val = Integer.parseInt(s.substring(idx, idx + len));

                // 计算值是否超界了
                if(val > 255) continue;

                // 如果是第一个值，不加分界点，如果不是，加分界点
                String nextPath = (seg == 0) ? cur.path + val : cur.path + "." + val;
                q.offer(new State(idx + len, seg + 1, nextPath));
            }
        }
        return ans;
    }
    // 并查集模板
    class DSU {
        int[] parent;
    
        void init(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
    
        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    
        void union(int a, int b) {
            int ra = find(a);
            int rb = find(b);
            if (ra != rb) parent[ra] = rb;
        }
    }
    // 语法糖：数组排序

import java.util.HashMap;

@sort((a,b) -> (a > b) ? 1 : -1);
}

// Write a Java method that takes in an array of Strings and sorts
// them by how many points they would earn in the game of
// Scrabble, with the lowest scoring words coming first. If two
// words have the same Scrabble score, then they should be
// sorted in alphabetical order. Letters in Scrabble earn the
// following points:
// 1 point – A E I O U L N S T R
// 2 points – D G
// 3 points – B C M P
// 4 points – F H V W Y
// 5 points – K
// 8 points – J X
// 10 points – Q Z

// 先用map存对应分数，会不会减少查询时间
// 然后用自定义排序规则，先按分数排，再按字母顺序排
// public class ScrabbleSorter{
//     public String[] words = {"apple", "bat", "banana", "quiz", "dog", "cat"};
//     public static void main(String[] args) {
//         ScrabbleSorter sorter = new ScrabbleSorter();
//         sorter.sortScrabble(sorter.words);
//         System.out.println(Arrays.toString(sorter.words));
//     }

//     public void sortScrabble(String[] words) {
//         // initialize score map
//         Map<String, Integer> scoreMap = new HashMap<>();
//         scoreMap.put("AEIOULNSTR", 1);
//         scoreMap.put("DG", 2);
//         scoreMap.put("BCMP", 3);
//         scoreMap.put("FHVWY", 4);
//         scoreMap.put("K", 5);
//         scoreMap.put("JX", 8);
//         scoreMap.put("QZ", 10);


//         // custome sort by score and alphabetical order
//         Arrays.sort(words, (a, b) -> {
//             int scoreA = getScore(a, scoreMap);
//             int scoreB = getScore(b, scoreMap);
//             if(scoreA != scoreB){
//                 return scoreA - scoreB; // sort by score
//             } else {
//                 return a.compareTo(b); // sort alphabetically
//             }
//         });
//     }

//     private int getScore(String word, Map<String, Integer> scoreMap) {
//         int score = 0;
//         for(char c : word.toUpperCase().toCharArray()){
//             for(Map.Entry<String, Integer> entry : scoreMap.entrySet()){
//                 if(entry.getKey().indexOf(c) != -1){
//                     score += entry.getValue();
//                     break;
//                 }
//             }
//         }
//         return score;
//     }
// }


public class ScrabbleSorter{
    public String[] words = {"apple", "bat", "banana", "quiz", "dog", "cat"};
    public static void main(String[] args) {
        ScrabbleSorter sorter = new ScrabbleSorter();
        sorter.sortScrabble(sorter.words);
        System.out.println(Arrays.toString(sorter.words));
    }

    public void sortScrabble(String[] words) {
        // get the score of the words
        int k = 0;
        int[] scores = new int[words.length];
        for(String word : words){
            int score = 0;
            for(char c : word.toUpperCase().toCharArray()){
                switch(c){
                    case 'A', 'E', 'I', 'O', 'U', 'L', 'N', 'S', 'T', 'R' -> score += 1;
                    case 'D', 'G' -> score += 2;
                    case 'B', 'C', 'M', 'P' -> score += 3;
                    case 'F', 'H', 'V', 'W', 'Y' -> score += 4;
                    case 'K' -> score += 5;
                    case 'J', 'X' -> score += 8;
                    case 'Q', 'Z' -> score += 10;
                    default -> score += 0;
                }
            }
            scores[k] = score;
            k++;
        }
        // swap if score are higher
        int i = 0;
        int j = 0;
        while(i < words.length) {
            j = i + 1;
            while(j < words.length) {
                if(scores[i] > scores[j]) {
                    // swap(words, i, j);
                    String tmp = words[i];
                    words[i] = words[j];
                    words[j] = tmp;
                    // swap scores
                    int tmpScore = scores[i];
                    scores[i] = scores[j];
                    scores[j] = tmpScore;
                }
                j++;
            }
            i++;
        }

        i = 0;
        j = 0;
        while(i < words.length) {
            j = i + 1;
            while(j < words.length) {
                if(scores[i] == scores[j]) {
                    if(words[i].compareTo(words[j]) > 0) {
                        String tmp = words[i];
                        words[i] = words[j];
                        words[j] = tmp;
                    }
                }
                j++;
            }
            i++;
        }

    }
}

public class Selection{
    static int[] arr = {1,2,3,0,9,2,1,5,2};
    public static void main(String[] args) {
        SelectionSort(arr);
        for(int a : arr){
            System.out.print(a + ", ");
        }
    }
    public static void SelectionSort(int[] arr) {
        int i = 0;
        int j = i + 1;
        while(i < arr.length - 1) {
            int cur = arr[i];
            int minVal = Integer.MAX_VALUE;
            while(j < arr.length) {
                if(arr[j] < minVal) {
                    minVal = arr[j];
                }
                j++;
            }
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
        }
    }
}

public class Collatz{
    // Write a Java program that reads in a list of numbers, and sorts
    // them according to the number of steps they follow in the Collatz
    // sequence before reaching 1 (most steps comes first). A Collatz
    // sequence starts with a given number and follows the operation
    // below until reaching 1:
    //  If the number is even, divide it by two.
    //  If the number is odd, triple it and add one.
    // State the Big-O complexity of the algorithm you have written,
    // and explain what this means in your own words.
    // Sample Input
    // 6
    // 2
    // 8
    // 13
    // 15
    public static void CollatzSort(int [] nums) {
        int i = 0;
        int[] count = new int[nums.length];
        while(i < nums.length) {
            int stp = 0;
            int tmp = nums[i];
            while(tmp != 1){
                tmp = tmp % 2 == 0 ? tmp / 2 : tmp * 3 + 1;
                count[i] = stp++;
            }
            i++;
        }

        i = 0;
        while(i < nums.length - 1) {
            int j = i + 1;
            if(count[i] > count[j]) {
                swap(count, i, j);
                swap(nums, i, j);
            }
            i++;
        }
        
        for(int b = nums.length - 1; b >= 0; b--) {
            if(b != 0) {
                System.out.print(nums[b] + ",");
            }else{
                System.out.print(nums[b]);
            }
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 8, 13, 15};
        CollatzSort(arr);
    }
}



/*public*/ class TSP{
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
        System.out.println(minmumTSP());
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

class SkipList {
    // Skip List 
    private static final int MAX_LEVEL = 16;
    private static final double P = 0.5;
    private final Node head = new Node(Integer.MIN_VALUE, MAX_LEVEL);
    private int level = 1;
    private final Random rand = new Random();

    static class Node {
        int val;
        Node[] forward;

        Node(int val, int level) {
            this.val = val;
            this.forward = new Node[level];
        }
    }

    private int randomLevel() {
        int lvl = 1;
        while(lvl > MAX_LEVEL && rand.nextDouble() > P) {
            lvl++;
        }
        return lvl;
    }

    public boolean search(int target) {
        Node curr = head;
        for(int i = level - 1; i >= 0; i--) {
            while (curr.forward[i] != null && curr.forward[i].val < target) {
                curr = curr.forward[i];
            }
        }
        curr = curr.forward[0];
        return curr != null && curr.val == target;
    }

    public void add(int num) {
        Node[] update = new Node[MAX_LEVEL];
        Node curr = head;
        for(int i = level - 1; i >= 0; i--) {
        
    }
}

public class Selection{
    static int[] arr = {1,2,3,0,9,2,1,5,2};
    public static void main(String[] args) {
        SelectionSort(arr);
        for(int a = 0; a < arr.length; a++){
            if(a != arr.length - 1){
                System.out.print(arr[a] + ", ");
            }else{
                System.out.print(arr[a]);
            }
        }
    }
    public static void SelectionSort(int[] arr) {
        int i = 0;
        while(i < arr.length - 1) {
            int cur = arr[i];
            int minIdx = i;
            int j = i + 1;
            while(j < arr.length) {
                if(arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
                j++;
            }
            
            int tmp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = tmp;
           
            i++;
        }
    }
}

public class Collatz{
    // Write a Java program that reads in a list of numbers, and sorts
    // them according to the number of steps they follow in the Collatz
    // sequence before reaching 1 (most steps comes first). A Collatz
    // sequence starts with a given number and follows the operation
    // below until reaching 1:
    //  If the number is even, divide it by two.
    //  If the number is odd, triple it and add one.
    // State the Big-O complexity of the algorithm you have written,
    // and explain what this means in your own words.
    // Sample Input
    // 6
    // 2
    // 8
    // 13
    // 15
    
    public static void CollatzSort(int [] nums) {
        int i = 0;
        int[] count = new int[nums.length];
        while(i < nums.length) {
            int stp = 0;
            int tmp = nums[i];
            while(tmp != 1){
                tmp = tmp % 2 == 0 ? tmp / 2 : tmp * 3 + 1;
                count[i] = stp++;
            }
            i++;
        }
        
        Integer[] newNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(newNums, (a, b) -> {
            int scoreA = getter(nums, count, a); // using custom methods
            int scoreB = getter(nums, count, b); // get the value from key
            if(scoreA != scoreB){
                return Integer.compare(scoreA, scoreB); // scoreA - scoreB
            }else{
                return Integer.compare(scoreA, scoreB);
            }// sort by score (from the map) or maybe Comparator -> Integer.compare(scoreA, scoreB)
            // } else {
            //     return a.compareTo(b); // sort alphabetically (by alphabet)
        });
        // Arrays.sort(words, (a, b) -> {
        //     int scoreA = getScore(a, scoreMap); // using custom methods
        //     int scoreB = getScore(b, scoreMap); // get the value from key
        //     if(scoreA != scoreB){
        //         return scoreA - scoreB; // sort by score (from the map) or maybe Comparator -> Integer.compare(scoreA, scoreB)
        //     } else {
        //         return a.compareTo(b); // sort alphabetically (by alphabet)
        //     }
        // });
        
        
        // i = 0;
        // while(i < nums.length - 1) {
        //     int j = i + 1;
        //     if(count[i] > count[j]) {
        //         swap(count, i, j);
        //         swap(nums, i, j);
        //     }
        //     i++;
        // }
        
        for(int b = nums.length - 1; b >= 0; b--) {
            if(b != 0) {
                System.out.print(nums[b] + ",");
            }else{
                System.out.print(nums[b]);
            }
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
    private static int getter(int[] arrA, int[] arrB, int a) {
        int k = 0;
        while(k < arrA.length){
            if(arrA[k] == a) {
                return arrB[k];
            }
            k++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        
        for(int i = 0; i < n; i++){
            int val = sc.nextInt();
            arr[i] = val;
        }
        // sc.close();    
        CollatzSort(arr);
    }
}

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
        System.out.println("\n\nThe minimum steps: " + minmumTSP());
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
                System.out.print("A -> ");
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

// You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

// Connect: A cell is connected to adjacent cells horizontally or vertically.
// Region: To form a region connect every 'O' cell.
// Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
// To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.

 

// Example 1:

// Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]

// Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]

// Explanation:


// In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.

// Example 2:

// Input: board = [["X"]]

// Output: [["X"]]

 

// Constraints:

// m == board.length

class Solution {
    int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if((i == 0 || j == 0 || i == n - 1 || j == m - 1) && board[i][j] == 'O') {
                    // board[i][j] = 'S';
                    dfs(board, i, j, dirs);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }else if(board[i][j] == 'S') {
                    board[i][j] = 'O';
                }
            }
        }
        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < m; j++){
        //         if(board[i][j] == 'S') {
        //             board[i][j] = 'O';
        //         }
        //     }
        // }
    }

    private void dfs(char[][] board, int r, int c, int[][] dirs) {
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != 'O') {
            return;
        }
        board[r][c] = 'S';
        for(int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];
            dfs(board, nr, nc, dirs);
        }
    }
}



    // import java.io.*;
    // import java.util.*;

    public class Solution {
        public static int longest_path(String path, int chance) {
            int maxCount = 0;
            int left = 0;
            int best = 0;
            char[] c = path.toCharArray();

            for(right = 0; right < c.length; right++) {
                if(c[right] == 'X') {
                    maxCount++;
                }
                while(maxCount > chance) {
                    if(c[left] == 'X') {
                        maxCount--;
                    }
                    left++;
                }
                best = Math.max(best, right - left + 1);
            }
        }

        public static void main(String[] args) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            Scanner sc = new Scanner(System.in);
            String path = sc.nextLine();
            int chance = sc.nextInt();
            sc.close();

            int ans = longest_path(path, chance);
            System.out.println(ans);
        }
    }

    public class TwoSum {
        public int twosum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int n : nums) {
                if(map.containsKey(target - n)) {


                }
            }
        }
    }
}