class TimeMap {

    private static class Pair {
        int time;
        String value;

        public Pair(int time, String value) {
            this.time = time;
            this.value = value;
        }
    }

    private Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        List<Pair> list = map.get(key);
        String ans = "";

        int left = 0, right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid).time <= timestamp) {
                ans = list.get(mid).value;
                left = mid + 1;  // search right
            } else {
                right = mid - 1; // search left
            }
        }

        return ans;
    }
}