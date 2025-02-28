package main.algorithms;

public class DinamycProg {
	public static void main(String[] args) {
        int[] weights = {1, 2, 3};
        int[] values = {10, 15, 40};
        int capacity = 5;

        int maxValue = knapsack(weights, values, capacity);
        System.out.println("Valor máximo da mochila: " + maxValue);
    }

    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;

        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights[i - 1] > w) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(
                        values[i - 1] + dp[i - 1][w - weights[i - 1]], // Incluir o item
                        dp[i - 1][w] // Excluir o item
                    );
                }
            }
        }

        // O valor máximo é armazenado em dp[n][capacity]
        return dp[n][capacity];
    }
}