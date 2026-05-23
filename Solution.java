class Solution {
    public int[] searchRange(int[] nums, int target) {
    int low = 0;
    int high = nums.length -1;

    int leftIndex = searchleftIndex(nums, low, high, target);
    if(leftIndex == -1) return new int [] { -1, -1};
    int rightIndex = searchRighIndex(nums, leftIndex, high, target);
    return new int[] {leftIndex, rightIndex};
    }

    private int searchleftIndex(int[] nums,int low, int high, int target) {

        while(low<=high) {
            int mid = low + (high -low)/2;

            if(nums[mid] == target) {

                if (mid == 0 || nums[mid-1] != target) {
                    return mid;
                } else {
                    high = mid -1;
                }

            }else if(nums[mid] < target) {
                low = mid+1;
            } else {
                high = mid -1;
            }
        }

        return -1;
    }

        private int searchRighIndex(int[] nums,int low, int high, int target) {

        while(low<=high) {
            int mid = low + (high -low)/2;

            if(nums[mid] == target) {

                if (mid == high || nums[mid+1] != target) {
                    return mid;
                } else {
                    low = mid +1;
                }

            }else if(nums[mid] < target) {
                low = mid+1;
            } else {
                high = mid -1;
            }
        }

        return -1;
    }
}
