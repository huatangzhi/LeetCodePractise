import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by hp on 2016/12/31.
 */

public class findRightInterval {

    public int[] findRightInterval(Interval[] intervals){
        int result[] = new int[intervals.length];
        java.util.NavigableMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0;i < intervals.length; ++i){
            map.put(intervals[i].start, i);

        }
        for(int i = 0; i < intervals.length; ++i){
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i].end);
            result[i] = (entry != null) ? entry.getValue() : -1;
        }

        return result;
    }

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}
