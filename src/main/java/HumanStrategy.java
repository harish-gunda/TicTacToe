import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HumanStrategy {

    int[][] board2d;

    public int[][] convert1dstringTo2darray(String s) {
        int[][] b = new int[3][3];
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                b[i][j] = Integer.parseInt(String.valueOf(s.charAt(i*3+j)));
            }
        }
        return b;
    }

    public boolean probability(float p){
        Random rand = new Random(); //instance of random class
        int upperbound = 100;
        //generate random values from 1-100
        int int_random = rand.nextInt(upperbound)+1;
        int pStar = Math.round(p*100);
        return pStar < int_random;
    }



    public int nextOptimalStep(String board,String player, float p) {
        if (probability(p)){
            List<Integer> indexes = new ArrayList<>();
            for(int i=0;i<9;i++){
                if(board.charAt(i)=='0'){
                    indexes.add(i);
                }
            }
            Random rand = new Random();
            if (indexes.size()==0){
                return -1;
            }

//            System.out.println("random");
            return indexes.get(rand.nextInt(indexes.size()));
        }
        //rule 1
        for (int i = 0; i < 9; i++) {
            board2d = convert1dstringTo2darray(board);
            if (board.charAt(i) == '0'){
                board2d[i/3][i%3] = 2;
                if (Game.checkwin(board2d,i, Integer.parseInt(player))==Integer.parseInt(player)) {
//                    System.out.println("rule 1");
                    return i;
                }
                board2d[i/3][i%3] = 0;
            }


        }

        // rule 2
        String opposition = player == "1" ? "2" : "1";
        for (int i = 0; i < 9; i++) {
            board2d = convert1dstringTo2darray(board);
            if (board.charAt(i) == '0'){
                board2d[i/3][i%3] = 1;
                if (Game.checkwin(board2d,i, Integer.parseInt(opposition))==Integer.parseInt(opposition)) {
//                    System.out.println("rule 2");
                    return i;
                }
                board2d[i/3][i%3] = 0;
            }
        }


        //rule 3
        String check;
        int count = 0;
        for (int i = 0; i < 9; i++) {
            if (board.charAt(i) == '0') {
                int row = i / 3;
                int col = i % 3;
                check = "";
                count = 0;
                for (int r1 = 0; r1 < 3; r1++) {
                    if (r1 != row) {
                        check += String.valueOf(board.charAt(r1 * 3 + col));
                    }
                }
                if (check.equals("0" + player) || check.equals(player + "0")) {
//                    System.out.println("row");
                    count += 1;
                }
                check = "";
                for (int c1 = 0; c1 < 3; c1++) {
                    if (c1 != col) {
                        check += String.valueOf(board.charAt(row * 3 + c1));
                    }
                }
                if (check.equals("0" + player) || check.equals(player + "0")) {
//                    System.out.println("col");
                    count += 1;
                }
                check = "";
                if (row == col) {
                    int r1 = 0;
                    int c1 = 0;
                    while (r1 < 3) {
                        if (r1 == row) {
                            r1++;
                            c1++;
                            continue;
                        }
                        check += String.valueOf(board.charAt(r1 * 3 + c1));
                        r1++;
                        c1++;
                    }
                }
                if (check.equals("0" + player) || check.equals(player + "0")) {
//                    System.out.println("d1");
                    count += 1;
                }
                check = "";
                if ((row == 1 && col==1) || java.lang.Math.abs(row - col) == 2) {
                    int r1 = 0;
                    int c1 = 2;
                    while (r1 < 3) {
                        if (r1 == row) {
                            r1++;
                            c1--;
                            continue;
                        }
                        check += String.valueOf(board.charAt(r1 * 3 + c1));
                        r1++;
                        c1--;
                    }
                }
                if (check.equals("0" + player) || check.equals(player + "0")) {
//                    System.out.println("d2");
                    count += 1;
                }
                if (count >= 2) {
//                    System.out.println("rule 3");
                    return i;
                }
            }
        }

        //rule 4
        String temp = player;
        player = opposition;
//        System.out.println("Opposition: "+opposition);
        for (int i = 0; i < 9; i++) {
            if (board.charAt(i) == '0') {
                int row = i / 3;
                int col = i % 3;
                check = "";
                count = 0;
                for (int r1 = 0; r1 < 3; r1++) {
                    if (r1 != row) {
                        check += String.valueOf(board.charAt(r1 * 3 + col));
                    }
                }
                if (check.equals("0" + player) || check.equals(player + "0")) {
//                    System.out.println("row");
                    count += 1;
                }
                check = "";
                for (int c1 = 0; c1 < 3; c1++) {
                    if (c1 != col) {
                        check += String.valueOf(board.charAt(row * 3 + c1));
                    }
                }
                if (check.equals("0" + player) || check.equals(player + "0")) {
                    count += 1;
//                    System.out.println("col");
                }
                check = "";
                if (row == col) {
                    int r1 = 0;
                    int c1 = 0;
                    while (r1 < 3) {
                        if (r1 == row) {
                            r1++;
                            c1++;
                            continue;
                        }
                        check += String.valueOf(board.charAt(r1 * 3 + c1));
                        r1++;
                        c1++;
                    }
                }
                if (check.equals("0" + player) || check.equals(player + "0")) {
//                    System.out.println("d1");
                    count += 1;
                }
                check = "";
                if ((row == 1 && col==1) || java.lang.Math.abs(row - col) == 2) {
                    int r1 = 0;
                    int c1 = 2;
                    while (r1 < 3) {
                        if (r1 == row) {
                            r1++;
                            c1--;
                            continue;
                        }
                        check += String.valueOf(board.charAt(r1 * 3 + c1));
                        r1++;
                        c1--;
                    }
                }
                if (check.equals("0" + player) || check.equals(player + "0")) {
//                    System.out.println("d2");
                    count += 1;
                }
                if (count >= 2) {
//                    System.out.println("rule 4");
                    return i;
                }
            }
        }

        player = temp;
        // Rule 5
        if (board.charAt(4) == '0') {
//            System.out.println("rule 5");
            return 4;
        }

        // Rule 6
        if (board.charAt(0) == opposition.charAt(0) && board.charAt(8) == '0') {
//            System.out.println("rule 6");
            return 8;
        }
        if (board.charAt(2) == opposition.charAt(0) && board.charAt(6) == '0') {
//            System.out.println("rule 6");
            return 6;
        }
        if (board.charAt(6) == opposition.charAt(0) && board.charAt(2) == '0') {
//            System.out.println("rule 6");
            return 2;
        }
        if (board.charAt(8) == opposition.charAt(0) && board.charAt(0) == '0') {
//            System.out.println("rule 6");
            return 0;
        }

        // Rule 7
        for (int i=0; i<9; i+=2) {
            if (board.charAt(i)=='0') {
//                System.out.println("rule 7");
                return i;
            }
        }

        // Rule 8
        for (int i=1; i<9; i+=2) {
            if (board.charAt(i)=='0') {
//                System.out.println("rule 8");
                return i;
            }
        }
        return -1;
    }

}
