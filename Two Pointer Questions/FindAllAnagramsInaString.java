class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        //using two pointer and sliding window
        int plen = p.length();
        int slen = s.length();

        if(plen > slen){
            return new ArrayList<>();
        }

        int[] pfreq = new int[26];
        int[] window = new int[26];

        for(int i = 0 ; i < plen ; i++){
            pfreq[p.charAt(i)-'a']++;
            window[s.charAt(i)- 'a']++;
        }

        List<Integer> list = new ArrayList<>();

        if(Arrays.equals(pfreq,window)){
            list.add(0);
        }

        for(int i = plen ; i< slen ; i++){
            window[s.charAt(i-plen)-'a']--;
            window[s.charAt(i)-'a']++;

            if(Arrays.equals(pfreq,window)){
                list.add(i-plen+1);
            }
        }
        return list;

    }
}
// TC: O(n)
// SC: O(1)

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        //using HashMap and two pointer
        List<Integer> list = new ArrayList<>();

        if(p.length()> s.length()){
            return list;
        }

        Map<Character,Integer> smap = new HashMap<>();
        Map<Character,Integer> pmap = new HashMap<>();


        for(int i = 0 ; i < p.length(); i++){
            smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i),0)+1);
            pmap.put(p.charAt(i), pmap.getOrDefault(p.charAt(i),0)+1);
        }

        if(smap.equals(pmap)){
            list.add(0);
        }

        int left = 0 , right = p.length();

        while(right < s.length()){
            //acquire
            char acquire = s.charAt(right++);
            smap.put(acquire, smap.getOrDefault(acquire,0)+1);

            //release
            char release = s.charAt(left++);
            smap.put(release, smap.getOrDefault(release,0)-1);

            if(smap.get(release)==0){
                smap.remove(release);
            }

            if(smap.equals(pmap)){
                list.add(left);
            }
        }
        return list;

    }
}

// TC: O(m)
// SC: O(m+n)