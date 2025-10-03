public class GeomProgression<T extends Number> extends Progression<T>{

    // --- 區塊1：欄位宣告 ---
    // base: 等比數列的公比
    private T base;

    // --- 區塊2：建構子 ---
    // 初始化 first（起始值）和 base（公比）
    public GeomProgression(T first, T base) {
        super(first);
        this.base = base;
    }
    
    // --- 區塊3：multiply 方法 ---
    // 負責將兩個 T 型態的數字相乘，並檢查溢位
    @SuppressWarnings("unchecked")
    private T multiply(T a, T b) {
        if(a instanceof Integer){
            try {
                Integer erasedValue = Math.multiplyExact(a.intValue(), b.intValue());
                return (T)erasedValue;
            } catch (ArithmeticException e) {
                throw new ArithmeticException("Integer overflow detected in progression!");
            }
        }
        else if(a instanceof Double){
            Double erasedValue = a.doubleValue() * b.doubleValue();
            if (erasedValue.isInfinite() || erasedValue.isNaN()) {
                throw new ArithmeticException("Double overflow or invalid value detected in progression!");
            }
            return (T)erasedValue;
        }
        else{
            throw new UnsupportedOperationException("Type not supported");
        }       
    }
    
    // --- 區塊4：nextValue 方法 ---
    // 計算下一個等比數列的值（curr = curr * base）
    public T nextValue() {
        curr = multiply(curr, base);
        return curr;
    }
}
