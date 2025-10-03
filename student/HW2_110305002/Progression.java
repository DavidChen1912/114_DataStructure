public abstract class Progression<T> {
    // --- 區塊1：欄位宣告 ---
    // first: 數列的起始值
    // curr: 目前數列的位置（每次 nextValue() 會改變）
    protected T first;
    protected T curr;

    // --- 區塊2：建構子 ---
    // 初始化 first 和 curr
    public Progression(T first) {
        this.first = first;
        this.curr = first;
    }

    // --- 區塊3：firstValue() ---
    // 將 curr 重設為 first，並回傳 first
    public T firstValue() {
        curr = first;
        return first;
    }

    // --- 區塊4：nextValue() ---
    // 抽象方法，讓子類別決定「下一個值」怎麼算
    public abstract T nextValue();

    // --- 區塊5：printProgression ---
    // 印出前 n 個數列值（包含 first value）
    public void printProgression(int n) {
        if (n <= 0) {
            System.out.println();
            return;
        }
        StringBuilder result = new StringBuilder();
        result.append(firstValue()); // 先印出第一個值

        for (int i = 1; i < n; i++) {
            result.append(" ").append(nextValue()); // 用空格分隔
        }

        System.out.println(result);
    }
}
