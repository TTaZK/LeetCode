package leetcode_with_name;

public class Remove_Duplicates_from_Sorted_Array_II_80 {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        // 当前元素如果不比 i 前两个元素大的话，说明 i 与当前位置之间的元素都是重复元素
        for (int n : nums)
            if (i < 2 || n > nums[i - 2])
                nums[i++] = n;
        return i;
    }

    // Question wants us to return the length of new array after removing duplicates and that
    // we don't care about what we leave beyond new length ,
    // hence we can use i to keep track of the position and update the array.

    // Remove Duplicates from Sorted Array(no duplicates) :
    public int removeDuplicates1(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 1 || n > nums[i - 1])
                nums[i++] = n;
        return i;
    }

    //Remove Duplicates from Sorted Array II (allow duplicates up to 2):
    public int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i - 2])
                nums[i++] = n;
        return i;
    }
}
