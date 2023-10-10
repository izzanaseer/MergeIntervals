import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void mergeIntervals(List<int[]> intervals){
        if (intervals.size() <= 1){
            return;
        }

        int mergedIndex = 0;
        for (int count = 1; count < intervals.size(); count++)
        {
            int[] current = intervals.get(count);
            int[] previous = intervals.get(mergedIndex);

            if (current[0] <= previous[1])
            {
                previous[1] = Math.max(previous[1], current[1]);
            }
            else
            {
                mergedIndex++;
                intervals.set(mergedIndex, current);
            }
        }

        while (intervals.size() > mergedIndex + 1)
        {
            intervals.remove(intervals.size() - 1);
        }
    }
    public static void main(String[] args) {
        List<int[]> intervals = new ArrayList<>();
        intervals.add(new int[]{1, 3});
        intervals.add(new int[]{2, 6});
        intervals.add(new int[]{8, 10});
        intervals.add(new int[]{10, 11});
        intervals.add(new int[]{15, 18});

        System.out.println("Input:");
        for (int[] interval : intervals)
        {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }

        mergeIntervals(intervals);

        System.out.println();
        System.out.println("Output:");
        for (int[] interval : intervals)
        {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
}