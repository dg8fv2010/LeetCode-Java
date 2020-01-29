package LeetCode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/*
Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.



Example:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

Output:  [1,2,4,7,5,3,6,8,9]

Explanation:



Note:

The total number of elements of the given matrix will not exceed 10,000.
 */

public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix==null || matrix.length==0) {
            return new int[0];
        }
        int M = matrix.length;
        int N = matrix[0].length;
        int[] rst = new int[M*N];
        int idx = 0;

        ArrayList<Integer> media = new ArrayList<>();
        for (int d=0;d<M+N-1;d++) {
            media.clear();
            int r = d < N ? 0 : d-N+1;
            int c = d < N ? d : N-1;
            while (r<M && c>=0) {
                media.add(matrix[r][c]);
                r++;
                c--;
            }
            if (d % 2 == 0) {
                Collections.reverse(media);
            }

            for (int i=0;i<media.size();i++) {
                rst[idx++] = media.get(i);
            }
        }

        return rst;
    }

    public int[] findDiagonalOrder2(int[][] matrix) {
        if (matrix==null || matrix.length==0) {
            return new int[0];
        }
        int M = matrix.length;
        int N = matrix[0].length;
        int[] rst = new int[M*N];
        int idx = 0;
        int cur_r = 0;
        int cur_c = 0;
        int dir = 1;
        while (cur_r<M && cur_c<N) {
            rst[idx++] = matrix[cur_r][cur_c];

            int new_r = cur_r + (dir==1?-1:1);
            int new_c = cur_c + (dir==1?1:-1);

            if (new_r<0 || new_r>=M || new_c<0 || new_c>=N) {
                if (dir == 1) {
                    if (new_c < N) {
                        new_r = 0;
                    } else {
                        new_r = cur_r + 1;
                        new_c = N-1;
                    }
                } else {
                    if (new_r < M) {
                        new_c = 0;
                    } else {
                        new_r = M-1;
                        new_c = cur_c + 1;
                    }
                }
                dir = 1 - dir;
            }
            cur_c = new_c;
            cur_r = new_r;
        }


        return rst;
    }

    public static void main(String[] args) {
        int[][] arr1 = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] arr2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        DiagonalTraverse solu = new DiagonalTraverse();
        System.out.println("1:"+solu.findDiagonalOrder2(arr2));
    }
}
