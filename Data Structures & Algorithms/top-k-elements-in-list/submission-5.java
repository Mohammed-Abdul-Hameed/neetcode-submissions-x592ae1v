class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // create a map

        Map<Integer, Integer> frequency = new HashMap<>();

        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        // bucket

        List<Integer>[] buckets = new List[nums.length + 1];
        for (int key : frequency.keySet()) {
            int f = frequency.get(key);

            if (buckets[f] == null) {
                buckets[f] = new ArrayList<>();
            }
            buckets[f].add(key);
        }

        int[] ans = new int[k];
        int index = 0;

        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    ans[index++] = num;
                    if (index == k)
                        return ans;
                }
            }
        }
        return ans;
    }
}
