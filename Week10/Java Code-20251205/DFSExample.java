import java.util.*;

public class DFSExample {

    public static void dfs(Map<Character, List<Character>> graph, Character start) {
        Stack<Character> stack = new Stack<>();
        ArrayList<Character> visited = new ArrayList<>();

        visited.add(start);
        stack.push(start);

        while (!stack.isEmpty()) {
            Character v = stack.pop();
            System.out.println(v);  // process the node

            for (Character u : graph.getOrDefault(v, Collections.emptyList())) {
                if (!visited.contains(u)) {
                    visited.add(u);
                    stack.push(u);
                }
            }
        }
    }

    public static void main(String[] args) {
        // Example graph as adjacency list
        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('a', new ArrayList<>(Arrays.asList('b', 'd')));
        graph.put('b', new ArrayList<>(Arrays.asList('c', 'f')));
        graph.put('c', new ArrayList<>(Arrays.asList('a', 'd')));
        graph.put('d', new ArrayList<>(Arrays.asList('e')));
        graph.put('e', new ArrayList<>());
        graph.put('f', new ArrayList<>(Arrays.asList('c')));

        dfs(graph, 'a');
    }
}
