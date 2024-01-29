class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //using binary search

        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1 > n2){
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = n1;

        while(low <= high){
            int mid1 = (low+high)/2;
            int mid2 = (n1+n2+1)/2 - mid1;

            int maxLeft1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1-1];
            int minRight1 = (mid1 == n1) ? Integer.MAX_VALUE : nums1[mid1];

            int maxLeft2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2-1];
            int minRight2 = (mid2 == n2) ? Integer.MAX_VALUE : nums2[mid2];

            if(maxLeft1 <= minRight2 && maxLeft2 <= minRight1){
                if((n1+n2)%2 == 0){
                    return (double) (Math.max(maxLeft1,maxLeft2) + Math.min(minRight1,minRight2))/2;
                }
                else{
                    return (double) (Math.max(maxLeft1,maxLeft2));
                }
            }
            else if(maxLeft1 > minRight2){
                high = mid1-1;
            }
            else{
                low =mid1 +1;
            }

        }
        return -1;
    }
}

// TC: O(log(m+n))
// SC: O(1)


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //brute force with space optimized

        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;

        int i = 0 , j = 0 , k = 0;

        int index1 = (n/2)-1;
        int element1 = -1;

        int index2 = (n/2);
        int element2 = -1;


        while(i < n1 & j < n2){
            if(nums1[i] < nums2[j]){

                if(k == index1){
                    element1 = nums1[i];
                }
                if( k == index2){
                    element2 = nums1[i];
                }
                i++;
            }
            else{
                if(k == index1){
                    element1 = nums2[j];
                }
                if( k == index2){
                    element2 = nums2[j];
                }
                j++;
            }
            k++;
        }

        while(i < n1){
            if(k == index1){
                element1 = nums1[i];
            }
            if( k == index2){
                element2 = nums1[i];
            }
            i++;
            k++;
        }

        while(j < n2){
            if(k == index1){
                element1 = nums2[j];
            }
            if( k == index2){
                element2 = nums2[j];
            }
            j++;
            k++;
        }

        if(n%2 == 0){
            return (double) (element1 + element2)/2;
        }
        else{
            return (double) (element2);
        }

    }
}

// TC: O(m+n)
// SC: O(1)


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //brute force

        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;

        int i = 0 , j = 0 , k = 0;

        int[] res = new int[n];



        while(i < n1 && j < n2){
            if(nums1[i]  < nums2[j]){
                res[k++] = nums1[i++];
            }
            else{
                res[k++] = nums2[j++];
            }
        }


        while(i < n1){
            res[k++] = nums1[i++];
        }

        while(j < n2){
            res[k++] = nums2[j++];
        }

        int mid = n/2;
        if (n %2 ==0){
            return (double) (res[mid] + res[mid-1])/2;
        }
        else{
            return (double) (res[mid]);
        }

    }
}

// TC: O(m+n)
// SC: O(m+n)