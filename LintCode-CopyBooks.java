package LeetCode;

/*
Given an array A of integer with size of n( means n books and number of pages of each book) and k people to copy the book.
You must distribute the continuous id books to one people to copy.
(You can give book A[1],A[2] to one people, but you cannot give book A[1], A[3] to one people,
because book A[1] and A[3] is not continuous.) Each person have can copy one page per minute.
Return the number of smallest minutes need to copy all the books.

Have you met this question in a real interview?
Yes
Example
Given array A = [3,2,4], k = 2.

Return 5( First person spends 5 minutes to copy book 1 and book 2 and second person spends 4 minutes to copy book 3. )

Challenge
Could you do this in O(n*k) time ?
 */

public class LintCodeCopyBooks {

    public int copyBooks(int[] pages, int K) {
        int n = pages.length;
        if (K > n) {
            K = n;
        }
        int[][] dp = new int[K + 1][n + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }

        for (int k = 1; k <= K; k++) {
            dp[k][0] = 0;
            for (int i = 1; i <= n; i++) {
                dp[k][i] = Integer.MAX_VALUE;
                int sum = 0;
                for (int j = i; j >= 0; j--) {
                    dp[k][i] = Math.min(dp[k][i], Math.max(dp[k - 1][j], sum));
                    if (j > 0) {
                        sum += pages[j - 1];
                    }
                }
            }
        }
        return dp[K][n];
    }

    public static void main(String[] args) {
        testcase1();
    }

    private static void testcase1() {
        LintCodeCopyBooks solu = new LintCodeCopyBooks();
        System.out.println(solu.copyBooks(new int[]{3, 2, 4}, 2));
    }
}
