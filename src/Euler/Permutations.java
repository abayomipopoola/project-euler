package Euler;

public class Permutations {

    // print n! permutation of the characters of the string s (in order)
    public  static void perm1(String s) { perm1("", s); }
    private static void perm1(String prefix, String s) {
        int n = s.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, n));
        }

    }

    // print n! permutation of the elements of array a (not in order)
    public static void perm2(String s) {
        int n = s.length();
        char[] a = new char[n];
        for (int i = 0; i < n; i++)
            a[i] = s.charAt(i);
        perm2(a, n);
    }
    private static void perm2(char[] a, int n) {
        if (n == 1) {
            System.out.println(new String(a));
            return;
        }
        for (int i = 0; i < n; i++) {
            swap(a, i, n-1);
            perm2(a, n-1);
            swap(a, i, n-1);
        }
    }

    // swap the characters at indices i and j
    private static void swap(char[] a, int i, int j) {
        char c = a[i];
        a[i] = a[j];
        a[j] = c;
    }

    public static void main(String[] args) {
//        int n = 10;
        String alphabet = "1406357289";//"0123456789";
        int[] p = {2, 3, 5, 7, 11, 13, 17};
//        String elements = alphabet.substring(0, n);
//        perm1(elements);
//        System.out.println();
//        perm2(elements);
        for (int i = 1; i <= 7; i++) {
            for (int j = 0; j < p.length; j++) {
                if (Integer.parseInt("1406357289".substring(i,i+3)) % p[j] != 0){
                    break;
                }
            }
            System.out.println("1406357289".substring(i,i+3));
        }
    }
}