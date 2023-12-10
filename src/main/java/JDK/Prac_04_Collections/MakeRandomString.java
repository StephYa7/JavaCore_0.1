package JDK.Prac_04_Collections;

public class MakeRandomString {

    public static String makeRandomSequenceString(int minLength, int maxLength) {
        int start = (maxLength - minLength) + 1;
        int end = minLength - 1;
        int length = (int) (Math.random() * start) + end;
        StringBuilder sb = new StringBuilder();
        sb.append(randomCharFromUnicodeRange(65, 90));
        for (int i = 0; i < length; i++) {
            sb.append(randomCharFromUnicodeRange(97, 122));
        }
        return sb.toString();
    }

    private static char randomCharFromUnicodeRange(int firstIndex, int lastIndex) {
        int start = lastIndex - firstIndex + 1;
        int end = firstIndex;
        int result = (int) (Math.random() * start + end);
        return (char) result;
    }
}