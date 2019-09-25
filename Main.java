package Home_Work_2;

public class Main {

    static String[][] Split(String S) throws InvalidMatrixSizeExeption {
        long CountSpaces = S.chars().filter(ch -> ch == ' ').count();
        long CountSlashes = S.chars().filter(ch -> ch == '\n').count();
        if(CountSlashes != 3)
            throw new InvalidMatrixSizeExeption("Invalid number of delimiters");
        if(CountSpaces != 12)
            throw new InvalidMatrixSizeExeption("Invalid number of spaces");

        String[][] newS = new String[4][4];
        String[] SS;

            SS = S.split("\n");

            for(int i = 0; i < 4; i++){
                newS[i] = SS[i].split(" ");
            }
        return newS;
    }

    static int Change(String[][] S){
        int[][] newInt = new int[4][4];
        int sum = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                try {
                    newInt[i][j] = Integer.parseInt(S[i][j]);
                    sum += newInt[i][j];
                }
                catch (NumberFormatException e){
                   e.printStackTrace();
                   return 0;
                }
            }
        }
        return sum / 2;
    }
    public static void main(String[] args) {

        String S = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        String word[][] = new String[4][4];
        try {
            word = Split(S);
        } catch (InvalidMatrixSizeExeption invalidMatrixSizeExeption) {
            invalidMatrixSizeExeption.printStackTrace();
        }
       int result =  Change(word);
        System.out.println(result);
    }
}
