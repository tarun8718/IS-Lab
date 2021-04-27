import java.util.Scanner;

class railfenceCipherHelper {
    int depth;

    String encode(String msg, int depth) throws Exception {
        int r = depth;
        int l = msg.length();
        int c = l / depth;
        int k = 0;
        char mat[][] = new char[r][c];
        // Here we take the input message and depth, create a matrix of characters with
        //  depth as rows and [l/depth] value as colums
        //String enc="" is initialised 
        String enc = "";
        // Matrix is formed with given msg characters
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                if (k != l) {
                    mat[j][i] = msg.charAt(k++);
                } else {
                    mat[j][i] = 'X';
                }
            }
        }
        // Matrix is printed
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                System.out.print(mat[j][i] + " ");
            }
            System.out.println("");
        }
        // enc value updated with cipher text
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                enc += mat[i][j];
            }
        }
        return enc;
    }

    String decode(String encmsg, int depth) throws Exception {
        int r = depth;
        int l = encmsg.length();
        int c = l / depth;
        int k = 0;
        char mat[][] = new char[r][c];
        String dec = "";
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                mat[i][j] = encmsg.charAt(k++);
            }
        }
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                dec += mat[j][i];
            }
        }
        return dec;
    }
}

class railFenceCipher {
    public static void main(String[] args) throws java.lang.Exception {
        railfenceCipherHelper rf = new railfenceCipherHelper();
        String enc, dec;
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        System.out.println("Enter username");
        String msg = myObj.nextLine();
        System.out.println("Enter depth");
        int depth = myObj.nextInt();

        enc = rf.encode(msg, depth);
        dec = rf.decode(enc, depth);
        System.out.println("Simulating Railfence Cipher\n-------------------------");
        System.out.println("Input Message : " + msg);
        System.out.println("Encrypted Message : " + enc);
        System.out.printf("Decrypted Message : " + dec);
    }
}

/*
 * 
 * O/P: 
 * Enter username 
 * TARUNN 
 * Enter depth 2 
 * T A 
 * R U 
 * N N 
 * Simulating Railfence
 * Cipher ------------------------- 
 * Input Message : TARUNN 
 * Encrypted Message :
 * TRNAUN 
 * Decrypted Message : TARUNN
 * 
 * DESC: 
 * 
 * The rail fence cipher (also called a zigzag cipher) is a form of
 * transposition cipher. It derives its name from the way in which it is
 * encoded.
 * 
 * more discpription in encode() function
 * 
 * 
 */