/*
    Problem: Union of Two Sorted Arrays

    Description:
    Given two sorted arrays nums1 and nums2, return their union as a sorted array
    without duplicates.

    Approach: Two Pointers

    Time Complexity: O(n + m)
    Space Complexity: O(n + m)

    Key Idea:
    - Use two pointers to traverse both arrays
    - Compare elements and add smaller one to result
    - Skip duplicates while adding elements
    - Append remaining elements after one array is exhausted

    Notes:
    - Input arrays must be sorted
    - Result should contain unique elements only
*/

import java.util.*;

class UnionOfTwoSortedArrays {
    public int[] unionArray(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();

        int i = 0, j = 0;

        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                if(res.isEmpty() || res.get(res.size() - 1) != nums1[i]){
                    res.add(nums1[i]);
                }
                i++;
                j++;
            }
            else if(nums1[i] < nums2[j]){
                if(res.isEmpty() || res.get(res.size() - 1) != nums1[i]){
                    res.add(nums1[i]);
                }
                i++;
            }
            else {
                if(res.isEmpty() || res.get(res.size() - 1) != nums2[j]){
                    res.add(nums2[j]);
                }
                j++;
            }
        }

        while(i < nums1.length){
            if(res.isEmpty() || res.get(res.size() - 1) != nums1[i]){
                res.add(nums1[i]);
            }
            i++;
        }

        while(j < nums2.length){
            if(res.isEmpty() || res.get(res.size() - 1) != nums2[j]){
                res.add(nums2[j]);
            }
            j++;
        }

        int[] ans = new int[res.size()];
        for(int k = 0; k < res.size(); k++){
            ans[k] = res.get(k);
        }

        return ans;
    }

    public static void main(String[] args){
        UnionOfTwoSortedArrays sol = new UnionOfTwoSortedArrays();

        int[] nums1 = {1, 2, 2, 3, 4};
        int[] nums2 = {2, 3, 5};

        int[] res = sol.unionArray(nums1, nums2);

        for(int x : res){
            System.out.print(x + " ");
        }
        // Output: 1 2 3 4 5
    }
}