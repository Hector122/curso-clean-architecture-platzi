package Others;

public class IfStringIsSubstringOfAnother {

    public boolean isSubstring(String sub, String str) {
        if (str.equals(sub)) return true;

        if (sub.length() > str.length()) return false;

        int m = sub.length(); // substring to look
        int n = str.length(); // complete string

        for (int i = 0; i < n - m; i++) {
            int j;

            for (j = 0; j < m; j++) {
                if (str.charAt(i + j) != sub.charAt(j)) {
                    break;
                }
            }

            if (j == m) {
                System.out.println("Present at index " + i);
                return true;
            }
        }
        return false;
    }

}
