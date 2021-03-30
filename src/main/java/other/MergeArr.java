package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author Sun
 * @version 1.0.0
 * @ClassName MergeArr.java
 * @Description TODO
 * @createTime 2021年03月30日 22:48:00
 */
public class MergeArr {

    public static void main(String[] args) {

    }

    private static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

    }

    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return new ArrayList<>();
        }

        if (intervals.size() == 1) {
            return intervals;
        }

        intervals.sort((t1, t2) -> {
            return t1.start - t2.start;
        });

        Stack<Interval> stack = new Stack<>();
        stack.push(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval newIntervals = intervals.get(i);
            Interval lastIntervals = stack.peek();
            if (newIntervals.start <= lastIntervals.end) {
                stack.pop();
                stack.push(new Interval(lastIntervals.start, Math.max(newIntervals.end, lastIntervals.end)));
            } else {
                stack.push(newIntervals);
            }
        }

        //stack转数组
        ArrayList<Interval> resultList = new ArrayList<Interval>();
        while (!stack.isEmpty()) {
            resultList.add(stack.pop());
        }
        resultList.sort((t1, t2) -> t1.start - t2.start);
        return resultList;
    }


}
