import java.util.*;

public class KeywordList {

    private LinkedList<Keyword> lst;

    public KeywordList(){
        this.lst = new LinkedList<Keyword>();
    }

    // 插入排序：count 小在前；同 count 時 weight 小在前；再同則維持插入順序
    public void add(Keyword keyword){
        int i = 0;
        while (i < lst.size()){
            Keyword cur = lst.get(i);
            if (keyword.getCount() < cur.getCount()){
                break;
            } else if (keyword.getCount() == cur.getCount()){
                if (keyword.getWeight() < cur.getWeight()){
                    break;
                }
            }
            i++;
        }
        lst.add(i, keyword);
    }

    public void outputIndex(int i){
        if (i < 0 || i >= lst.size()){
            System.out.println("InvalidOperation");
        } else {
            System.out.println(lst.get(i).toString());
        }
    }

    public void outputCount(int c){
        LinkedList<Keyword> res = new LinkedList<>();
        for (Keyword k : lst){
            if (k.getCount() == c) res.add(k);
        }
        if (res.isEmpty()){
            System.out.println("NotFound");
        } else {
            printKeywordList(res);
        }
    }

    public void outputHas(String pattern){
        LinkedList<Keyword> res = new LinkedList<>();
        for (Keyword k : lst){
            if (k.getName().contains(pattern)) res.add(k);
        }
        if (res.isEmpty()){
            System.out.println("NotFound");
        } else {
            printKeywordList(res);
        }
    }

    public void outputName(String pattern){
        LinkedList<Keyword> res = new LinkedList<>();
        for (Keyword k : lst){
            if (k.getName().equals(pattern)) res.add(k);
        }
        if (res.isEmpty()){
            System.out.println("NotFound");
        } else {
            printKeywordList(res);
        }
    }

    public void outputFirstN(int n){
        if (n > lst.size()){
            System.out.println("InvalidOperation");
            return;
        }
        LinkedList<Keyword> res = new LinkedList<>();
        for (int i = 0; i < n; i++){
            res.add(lst.get(i));
        }
        printKeywordList(res);
    }

    public void outputScore(){
        double score = 0.0;
        for (Keyword k : lst){
            score += k.getCount() * k.getWeight();
        }
        // 題目範例要求一位小數
        System.out.printf("%.1f%n", score);
    }

    public void deleteIndex(int i){
        // 刪除操作越界時不輸出
        if (i >= 0 && i < lst.size()){
            lst.remove(i);
        }
    }

    public void deleteCount(int c){
        lst.removeIf(k -> k.getCount() == c);
    }

    public void deleteHas(String pattern){
        lst.removeIf(k -> k.getName().contains(pattern));
    }

    public void deleteName(String name){
        lst.removeIf(k -> k.getName().equals(name));
    }

    public void deleteFirstN(int n){
        // 刪到可刪數量，不輸出
        int times = Math.min(Math.max(n, 0), lst.size());
        for (int i = 0; i < times; i++){
            lst.removeFirst();
        }
    }

    public void deleteAll(){
        lst.clear();
    }

    private void printKeywordList(LinkedList<Keyword> kLst){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < kLst.size(); i++){
            if(i > 0) sb.append(" ");
            sb.append(kLst.get(i).toString());
        }
        System.out.println(sb.toString());
    }
}






