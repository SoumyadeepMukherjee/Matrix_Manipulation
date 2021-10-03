class Solution {

    private int[] f;

    public int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] ret = new int[m][n];
        int[] row = new int[m];
        int[] col = new int[n];
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                q.add(new int[]{matrix[i][j], i, j});
        while (!q.isEmpty()) {
            int target = q.peek()[0];
            List<int[]> list = new ArrayList<>();
            while (!q.isEmpty() && q.peek()[0] == target)
                list.add(q.poll());
            f = new int[n + m];
            for (int i = 0; i < n + m; i++) f[i] = i;
            for (int[] arr : list) {
                int t1 = find(arr[1]);
                int t2 = find(arr[2] + m);
                if (t1 != t2)
                    f[t1] = t2;
            }
            Map<Integer, List<int[]>> map = new HashMap<>();
            for (int[] arr : list) {
                int t = find(arr[1]);
                if (!map.containsKey(t))
                    map.put(t, new ArrayList<>());
                map.get(find(arr[1])).add(arr);
            }
            //System.out.println(list.size());
            for (List<int[]> group : map.values()) {
                int rank = 0;
                for (int[] arr : group) {
                    int i = arr[1], j = arr[2];
                    rank = Math.max(rank, Math.max(row[i], col[j]) + 1);
                }
                for (int[] arr : group) {
                    int i = arr[1], j = arr[2];
                    ret[i][j] = rank;
                    row[i] = Math.max(row[i], rank);
                    col[j] = Math.max(col[j], rank);
                }
            }
        }
        return ret;
    }

    private int find(int x) {
        if (f[x] == x)
            return f[x];
        return f[x] = find(f[x]);
    }
}
