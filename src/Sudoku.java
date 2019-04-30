public class Sudoku {
    private int[] table = new int[81];
    private int[] saved = new int[81];
    int save = 0;
    int start = 1;
    Stack<Integer> back = new ArrayStack<>(81);
    Stack<Integer> futa = new ArrayStack<>(81);
    Stack<Integer> hold = new ArrayStack<>(81);


    public Sudoku(int[] k) {
        table = k;
    }

    public boolean col(int[] col, int pos) {
        int[] colarr = new int[82];
        colarr[0] = 0;

        for (int i = 1; i < col.length; i++) {
            colarr[i] = col[i - 1];
        }
        colarr[81] = col[80];
        int k = pos + 1;
        while (k >= 10) {
            k = k - 9;
        }
        int[] co = new int[9];
        int count = 0;
        for (int i = k; count < 9; i = i + 9) {
            co[count++] = colarr[i];

        }
        boolean secondone = false;
        for (int i = 0; i < co.length; i++) {
            if (secondone && col[pos] == co[i]) {
                return false;
            }
            if (col[pos] == co[i]) {
                secondone = true;
            }
        }
        return true;
    }


    public boolean row(int[] row, int pos) {
        int[] colarr = new int[82];
        colarr[0] = 0;
        for (int i = 1; i < row.length; i++) {
            colarr[i] = row[i - 1];
        }
        colarr[81] = row[80];
        int k = pos + 1;
        while (k >= 10) {
            k = k - 9;
        }
        int back = pos - k + 1;
        int[] co = new int[9];
        int count = 0;

        for (int i = back + 1; count < 9; i++) {
            co[count++] = colarr[i];
//            System.out.print(co[count - 1]);
        }

        boolean secondone = false;
        for (int i = 0; i < co.length; i++) {
            if (secondone && row[pos] == co[i]) {
                return false;
            }
            if (row[pos] == co[i]) {
                secondone = true;
            }

        }
        return true;
    }

    public boolean block(int[] bl, int pos) {
        int[] colarr = new int[82];
        colarr[0] = 0;
        for (int i = 1; i < bl.length; i++) {
            colarr[i] = bl[i - 1];
        }
        colarr[81] = bl[80];
        int k = pos + 1;
        while (k >= 10) {
            k = k - 9;
        }

        int block = pos + 1;

        if (k == 9 || k == 6 || k == 3) {
            block = block - 2;
        }
        if (k == 8 || k == 5 || k == 2) {
            block = block - 1;
        }

        if (block > 9 && block < 19 || block > 36 && block < 46 || block > 63 && block < 73) {
            block = block - 9;
        }
        if (block > 18 && block < 28 || block > 45 && block < 55 || block > 72) {
            block = block - 18;
        }

        int[] co = new int[9];
        int count = 0;

        for (int i = block; count < 9; i++) {
            co[count++] = colarr[i];
//            System.out.print(co[count - 1]);
            if (count == 3 || count == 6) {
                i = i + 6;
            }
        }
        boolean secondone = false;
        for (int i = 0; i < co.length; i++) {
            if (secondone && bl[pos] == co[i]) {
                return false;
            }
            if (bl[pos] == co[i]) {
                secondone = true;
            }

        }
        return true;
    }

    public int findclose(int[] arr) {
        int k = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    public void Solve() {
        int find = findclose(table);
        Solve(table, find);
    }

    private boolean Solve(int[] zg, int pos) {
        int count = 1;
        int postion = findclose(zg);
        while (findclose(zg) != -1) {
            boolean solz = false;
            if (futa.empty()) {
                back.push(postion);
            }
            for (int i = count; i < 10; i++) {
                zg[postion] = i;
                boolean colm = this.col(zg, postion);
                boolean row = this.row(zg, postion);
                boolean block = this.block(zg, postion);
                System.out.print(postion);
                System.out.print("{" + i + "}");
                System.out.println();
                if (colm && row && block) {
                    if (!futa.empty()) {
                        count = 1;
                        int g = back.pop();
                        back.push(g);
                        if (g != postion) {
                            back.push(postion);
                        }
                        postion = futa.pop();
                        back.push(postion);
                        solz = true;
                        System.out.println("sol2");
                        break;
                    }
                    count = 1;
                    postion = findclose(zg);
                    solz = true;
                    System.out.println("solved");
                    break;
                }
            }
            if (!solz) {
                zg[postion] = 0;
                System.out.println("not");
                int j = postion;
                System.out.println("this is j " + j);

                futa.push(j);
                int k;
                back.pop();
                if (!back.empty()) {
                    k = back.pop();
                    if (k == j) {
                        k = back.pop();
                    }
                    back.push(k);
                } else {
                    k = pos;
                }
                System.out.println("this is k " + k);

                count = zg[k] + 1;
                postion = k;
            }
        }
        return true;
    }
}



