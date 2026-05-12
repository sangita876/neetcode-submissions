class Solution {
    public int minMeetingRooms(List<Interval>intervals) {
        int n = intervals.size();

        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int rooms = 0;
        int endPointer = 0;

        for (int i = 0; i < n; i++) {
            // Current meeting starts before earliest meeting ends
            // So we need one extra room
            if (start[i] < end[endPointer]) {
                rooms++;
            } else {
                // One meeting ended, so reuse that room
                endPointer++;
            }
        }

        return rooms;
    }
}