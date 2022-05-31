class ContainsDuplicate {
    //https://leetcode.com/problems/contains-duplicate/
    fun containsDuplicate(nums: IntArray): Boolean {
        val map = mutableMapOf<Int, Int>()

        for (i in nums.indices){
            if (map.containsKey(i)) return true

            map[nums[i]] = i
        }
        return false
    }
}