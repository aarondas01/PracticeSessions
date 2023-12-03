class Solution {
    public List<String> cellsInRange(String s) {
        List<String> res = new ArrayList<>();

        char rs = s.charAt(1);
        char re = s.charAt(4);

        char cs = s.charAt(0);
        char ce = s.charAt(3);

        for(char c = cs ; c <= ce; c++){
            for(char r = rs ; r <= re; r++){
                res.add(new String(new char[]{c,r}));
            }
        }
        return res;
    }
}

//TC: O(n*m)
//SC: O(m*n)