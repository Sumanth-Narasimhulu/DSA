class Solution {
    static class Pair {
        int ele;
        int ind;

        public Pair(int ele, int ind) {
            this.ele = ele;
            this.ind = ind;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++)
            res.add(0);
        List<Pair> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new Pair(nums[i], i));
        }
        mergeSort(arr, res, 0, n - 1);
        return res;

    }

    public void mergeSort(List<Pair> arr, List<Integer> res, int low, int high) {
        if (low >= high)
            return;
        int mid = (low + high) / 2;
        mergeSort(arr, res, low, mid);
        mergeSort(arr, res, mid + 1, high);
        merge(arr, res, low, mid, high);
    }

    public void merge(List<Pair> arr, List<Integer> res, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        int rightCnt = 0;
        List<Pair> temp = new ArrayList<>();
        while (left <= mid && right <= high) {
            if (arr.get(left).ele <= arr.get(right).ele) {
                int ind = arr.get(left).ind;
                int freq = res.get(ind);
                res.set(ind, freq + rightCnt);
                temp.add(arr.get(left));
                left++;

            } else {
                rightCnt++;
                temp.add(arr.get(right));
                right++;
            }
        }
        while (left <= mid) {
            int ind = arr.get(left).ind;
            int freq = res.get(ind);
            res.set(ind, freq + rightCnt);

            temp.add(arr.get(left));

            left++;
        }
        while (right <= high) {
            temp.add(arr.get(right));
            right++;
        }
        for (int i = low; i <= high; i++) {
            arr.set(i, temp.get(i - low));
        }
    }
}