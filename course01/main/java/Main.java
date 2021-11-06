public class Main {
    static char[] cs;
    static boolean[] vis;
    public static boolean reorderedPowerOf2(int n) {
        cs = String.valueOf(n).toCharArray();
        vis = new boolean[cs.length];
        return dfs(0);
    }
     static boolean dfs(int idx) {
         if(cs[0] == '0') {
            return false;
        }
        int cnt = 0;
        int cur = Integer.parseInt(new String(cs));
        System.out.println(cur);
        if(Integer.bitCount(cur) == 1) {
            return true;
        }
        // 全排列
        // 1 2 3
        // 1 3 2

        for(int i = 0; i < cs.length; i++) {
            if(vis[i]) {
                continue;
            }
            swap(idx, i);
            vis[i] = true;
            if(dfs(i)) {
                return true;
            }
            vis[i] = false;
            swap(idx, i);
        }
        return false;
    }
    static void swap(int i, int j) {
        char c = cs[i];
        cs[i] = cs[j];
        cs[j] = c;
    }
    public static void main(String[] args) {
        int x = Integer.MIN_VALUE;
        System.out.println(x);
        System.out.println(x & -x);
    }
}
