class Solution {
    public int[] productExceptSelf(int[] nums) {
                 int[] result = new int[nums.length];

         int[] prefix = new int[nums.length];
         int[] suffix = new int[nums.length];
         int prefixProduct = 1;
        for (int i = 0; i< nums.length; i++){
           prefix[i] = prefixProduct;
           prefixProduct *= nums[i];
           
        }
        prefixProduct = 1;

         for (int i = nums.length -1; i>=0; i--){
           suffix[i] = prefixProduct;
           prefixProduct *= nums[i];
           
        }

        for (int i = 0; i< nums.length; i++){
          result[i] = prefix[i] * suffix[i];
        }
        return result;
    }
}  
