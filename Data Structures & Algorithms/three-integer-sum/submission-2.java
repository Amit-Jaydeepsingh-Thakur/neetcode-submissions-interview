class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int i = 0, l = 0, r = nums.length - 1, target = 0;
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for (i = 0; i <= nums.length - 2; i++) {
            int sum = 0;
            l = i + 1;
            r = nums.length - 1;

            // if (nums[i] == nums[i + 1]) {
            //     continue;
            // }

            while (l < r) {
                sum = nums[i] + nums[l] + nums[r];

                if (sum == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);

                    //System.out.println("Here");

                    if (!ans.contains(list)) {
                        ans.add(list);
                    }
                    //ans.add(list);
                    l++;
                    r--;
                } else if (sum > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        return ans; 
    }
}
