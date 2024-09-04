import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), results);
        return results;
    }

    private static void backtrack(int[] candidates, int target, int start, List<Integer> path, List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<>(path));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, path, results); // Recur with the same index i
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] candidates = new int[n];
        
        for (int i = 0; i < n; i++) {
            candidates[i] = scanner.nextInt();
        }
        
        int target = scanner.nextInt();
        
        List<List<Integer>> result = combinationSum(candidates, target);
        
        System.out.println(result);
        
        scanner.close();
    }
}
