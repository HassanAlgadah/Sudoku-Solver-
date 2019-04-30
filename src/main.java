public class main {
    public static void main(String[] args) {

        int table [] = {6,8,0,0,0,0,0,0,0,
                        4,0,3,0,0,5,6,0,0,
                        9,7,0,6,0,3,0,5,0,
                        0,0,0,0,0,0,3,0,0,
                        0,1,0,3,0,9,7,0,6,
                        0,3,4,0,5,0,0,9,0,
                        0,0,0,7,0,0,5,0,8,
                        0,4,7,0,0,0,1,0,2,
                        0,0,0,0,0,0,0,0,0};

        Sudoku my = new Sudoku(table);
        int k = 1;
        int j = 0;

        for (int i = 0; i < table.length; i++) {
            if(j%3==0&&j!=0){

                System.out.print("-----------------------");
                System.out.println(" ");
                j=0;
            }
            System.out.print(table[i]);
            System.out.print(" ");

            if(k%3==0){
                System.out.print("|");
                System.out.print(" ");
            }

            if(k%9==0){
                System.out.println("");
                j++;
            }
            k++;
        }
        my.Solve();
        System.out.println();
        System.out.println("___________________________________________________________________");
        System.out.println();
        for (int i = 0; i < table.length; i++) {
            if(j%3==0&&j!=0){

                System.out.print("-----------------------");
                System.out.println(" ");
                j=0;
            }
            System.out.print(table[i]);
            System.out.print(" ");

            if(k%3==0){
                System.out.print("|");
                System.out.print(" ");
            }

            if(k%9==0){
                System.out.println("");
                j++;
            }
            k++;
        }




    }
}
