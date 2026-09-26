import java.util.*;

class DayPrice {
    int day;
    int price;

    public DayPrice(int day, int price) {
        this.day = day;
        this.price = price;
    }
}

class StockSpanner {

    Stack<DayPrice> stack;
    int day;

    public StockSpanner() {
        stack = new Stack<>();
        day = -1;
        stack.push(new DayPrice(-1, -1));
    }

    public int next(int price) {
        day++;
        int span;

        while (true) {
            if (stack.size() == 1) {

                // agar sirf sentinel bacha hai to span = current day + 1
                span = day - stack.peek().day;
                stack.push(new DayPrice(day, price));
                break;
            }

            DayPrice top = stack.peek();

            if (top.price > price) {

                // pehla greater element mil gaya
                span = day - top.day;
                stack.push(new DayPrice(day, price));
                break;

            } else {

                // chhote ya equal price ko hata do
                stack.pop();
            }
        }

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
