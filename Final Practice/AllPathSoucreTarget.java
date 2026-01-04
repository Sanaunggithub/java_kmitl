class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length - 1;
        List<Integer>path = new ArrayList<>();
        pathDFS(0, n, graph, path);
        return res;
    }

    public void pathDFS(int current, int target, int[][] graph, List<Integer> path){
        path.add(current);
        if(current == target){
            res.add(new ArrayList<>(path));
        }
       
        else{
            for(int neighbor : graph[current]){
                pathDFS(neighbor, target, graph, path);
            }
        }
        path.remove(path.size() - 1); // removes the current node when it has no neighbor to visit
        return;
    }
}


// 1️⃣ Start at node 0

// Add 0 → path = [0]

// Not target → explore neighbors [1, 2]

// 2️⃣ Go to neighbor 1

// Add 1 → path = [0, 1]

// Not target → explore [3]

// 3️⃣ Go to neighbor 3

// Add 3 → path = [0, 1, 3]

// current == target → save a copy to res
// → res = [[0, 1, 3]]

// Backtrack (remove last) → remove 3
// → path = [0, 1]

// Return to node 1

// 4️⃣ Backtrack from node 1

// All neighbors done → remove 1

// path = [0]

// Return to node 0

// 5️⃣ From node 0, go to next neighbor 2

// Add 2 → path = [0, 2]

// Not target → explore [3]

// 6️⃣ Go to neighbor 3

// Add 3 → path = [0, 2, 3]

// current == target → save copy
// → res = [[0, 1, 3], [0, 2, 3]]

// Backtrack (remove 3) → path = [0, 2]

// Return to node 2

// 7️⃣ Backtrack from node 2

// All neighbors done → remove 2

// path = [0]

// Return to node 0

// 8️⃣ Backtrack from node 0

// All neighbors done → remove 0

// path = []

// Return → DFS ends