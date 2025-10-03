import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WordCounter {
    private String urlStr;
    private String content;

    public WordCounter(String urlStr){
        this.urlStr = urlStr;
    }

    private String fetchContent() throws IOException{
        URL url = new URL(this.urlStr);
        URLConnection conn = url.openConnection();
        InputStream in = conn.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        StringBuilder retVal = new StringBuilder();
        String line = null;

        while ((line = br.readLine()) != null){
            retVal.append(line).append("\n");
        }

        return retVal.toString();
    }

    // 回傳字元c在P中最後一次出現的位置，若無則回傳-1
    public int last(char c, String P){
        for (int i = P.length() - 1; i >= 0; i--) {
            if (P.charAt(i) == c) return i;
        }
        return -1;
    }

    // Boyer-Moore (bad character rule only)
    public int BoyerMoore(String T, String P){
        int n = T.length();
        int m = P.length();
        int count = 0;
        int i = m - 1;

        while (i < n) {
            int j = m - 1;
            int k = i;
            while (j >= 0 && T.charAt(k) == P.charAt(j)) {
                k--;
                j--;
            }
            if (j < 0) {
                count++;
                i += m; // 找到一次後直接跳過 pattern 長度
            } else {
                int l = last(T.charAt(k), P);
                i += Math.max(1, j - l);
            }
        }
        return count;
    }

    public int countKeyword(String keyword) throws IOException{
        if (content == null){
            content = fetchContent();
        }
        content = content.toUpperCase();
        keyword = keyword.toUpperCase();

        return BoyerMoore(content, keyword);
    }
}