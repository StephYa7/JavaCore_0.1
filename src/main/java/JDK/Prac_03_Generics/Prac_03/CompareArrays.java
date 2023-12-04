package JDK.Prac_03_Generics.Prac_03;

public class CompareArrays {
    public static <T> boolean compareArrays(T[] firstArrays, T[] secondArrays) {
        if (firstArrays.length != secondArrays.length) {
            return false;
        }
        for (int i = 0; i < firstArrays.length; i++) {
            if (!firstArrays[i].equals(secondArrays[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] g1 = {1, 2};
        Integer[] g2 = {2, 1};
        Integer[] q1 = {1, 2, 3};
        Integer[] q2 = {1, 2, 3};
        Integer[] e1 = {2};
        Integer[] e2 = {3};
        String[] a1 = new String[0];
        String[] a2 = new String[0];
        ;
        System.out.println(CompareArrays.compareArrays(g1, g2));
        System.out.println(CompareArrays.compareArrays(q1, q2));
        System.out.println(CompareArrays.compareArrays(e1, e2));
        System.out.println(CompareArrays.compareArrays(a1, a2));
    }
}