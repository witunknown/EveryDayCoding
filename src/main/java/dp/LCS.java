package dp;

import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.TimeUnit;

/**
 * Created byX on 2021-03-09 23:39
 * Desc:最长公共子串
 */
public class LCS {

    public static void main(String[] args) {
        System.out.println(LCS("2LQ74WK8Ld0x7d8FP8l61pD7Wsz1E9xOMp920hM948eGjL9Kb5KJt80", "U08U29zzuodz16CBZ8xfpmmn5SKD80smJbK83F2T37JRqYfE76vh6hrE451uFQ100ye9hog1Y52LDk0L52SuD948eGjLz0htzd5YF9J1Y6oI7562z4T2"));

    }

    public static String LCS(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0) {
            return null;
        }

        if (str1.length() == 1) {
            if (str2.indexOf(str1.charAt(0)) > 0) {
                return str1;
            } else {
                return null;
            }
        }

        if (str2.length() == 1) {
            if (str1.indexOf(str2.charAt(0)) > 0) {
                return str2;
            } else {
                return null;
            }
        }

        int[][] comp = new int[str1.length()][str2.length()];
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    comp[i][j] = 1;
                } else {
                    comp[i][j] = 0;
                }
            }
        }

        int[][] maxLength = new int[str1.length()][str2.length()];

        //下三角矩阵
        for (int i = 0; i < str1.length(); i++) {
            int before = 0;
            for (int j = 0; j < (str1.length() - i) && j < str2.length(); j++) {
                if (comp[i + j][j] == 0) {
                    before = 0;
                    maxLength[i + j][j] = 0;
                } else {
                    maxLength[i + j][j] = 1 + before;
                    before = maxLength[i + j][j];
                }
            }
        }
        //上三角
        for (int i = 1; i < str2.length(); i++) {
            int before = 0;
            for (int j = 0; j < (str2.length() - i) && j < str1.length(); j++) {
                if (comp[j][i + j] == 0) {
                    before = 0;
                    maxLength[j][i + j] = 0;
                } else {
                    maxLength[j][i + j] = 1 + before;
                    before = maxLength[j][j + i];
                }
            }
        }

        int max = 0;
        int index = 0;
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (maxLength[i][j] > max) {
                    max = maxLength[i][j];
                    index = i;
                }

            }
        }

        return str1.substring(index - max + 1, index + 1);
    }

    public static String LCS2(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0) {
            return null;
        }

        if (str1.length() == 1) {
            if (str2.indexOf(str1.charAt(0)) > 0) {
                return str1;
            } else {
                return null;
            }
        }

        if (str2.length() == 1) {
            if (str1.indexOf(str2.charAt(0)) > 0) {
                return str2;
            } else {
                return null;
            }
        }

        int[][] dp = new int[str1.length()][str2.length()];

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(0)) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = 0;
            }
        }

        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i) == str1.charAt(0)) {
                dp[0][i] = 1;
            } else {
                dp[0][i] = 0;
            }
        }

        int max = 0;
        int index = 0;
        for (int i = 1; i < str1.length(); i++) {
            for (int j = 1; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    index = i;
                }
            }
        }

        index++;
        return str1.substring(index - max, index);
    }
}
