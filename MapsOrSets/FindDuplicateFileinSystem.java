class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        // using HashMap
        // <content,List<filePaths>>

        Map<String,List<String>> map = new HashMap<>();
        for(String path : paths){
            String[] dir = path.split(" ");
            String filePath = dir[0];

            for(int i =1  ; i <dir.length; i++){
                String content = dir[i].substring(dir[i].indexOf("("), dir[i].indexOf(")"));

                if(!map.containsKey(content)){
                    map.put(content, new ArrayList<>());
                }
                map.get(content).add(filePath + "/" + dir[i].substring(0, dir[i].indexOf("(")) );

            }
        }
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            if(entry.getValue().size() > 1){
                res.add(entry.getValue());
            }
        }
        return res;
    }
}
// TC: O(n*l)
// SC: O(n)