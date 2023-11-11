class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {


        int len = nums.length;
        double[] result = new double[len - k + 1];
        if (k == 1) {
            for (int i = 0; i < len; i++) {
                result[i] = (double) nums[i];
            }
            return result;
            // return Arrays.stream(nums).asDoubleStream().toArray();
        }

        Comparator<Integer> comparator = (a, b) -> (nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : Integer.compare(a, b));
        TreeSet<Integer> left = new TreeSet<>(comparator.reversed());
        TreeSet<Integer> right = new TreeSet<>(comparator);

        for (int i = 0; i < len; i++) {
            if (i >= k) {
                removeElement(left, right, nums, i - k);
            }
            addElement(left, right, i);
            if (i >= k - 1) {
                result[i - (k - 1)] = getMedian(left, right, nums);
            }
        }

        return result;
    }

    private void addElement(TreeSet<Integer> left, TreeSet<Integer> right, int idx) {
        left.add(idx);
        right.add(left.pollFirst());
        if (left.size() < right.size()) {
            left.add(right.pollFirst());
        }
    }

    private void removeElement(TreeSet<Integer> left, TreeSet<Integer> right, int[] nums, int idx) {
        if (right.contains(idx)) {
            right.remove(idx);
            if (left.size() == right.size() + 2) {
                right.add(left.pollFirst());
            }
        } else {
            left.remove(idx);
            if (left.size() < right.size()) {
                left.add(right.pollFirst());
            }
        }
    }

    private double getMedian(TreeSet<Integer> left, TreeSet<Integer> right, int[] nums) {
        if (left.size() == right.size()) {
            return ((double) nums[left.first()] + nums[right.first()]) / 2;
        }
        return nums[left.first()];
    }
}

// TC: O(n*logk)
// SC: O(k)