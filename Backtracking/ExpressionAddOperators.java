class Solution {

    private List<String> result = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        //dfs
        // dfs(index, path, currentResult, prevIndex, string, target)

        dfs(0,"",0,0,num, target);
        return result;

    }

    private void dfs(int index, String path, long currentResult, long prevIndex, String num, int target){
        if(index == num.length()){
            if(currentResult == target){
                result.add(path);
                return;
            }
        }
        for(int j = index ; j < num.length(); j++){
            //skip leading zero number

            if(j>index && num.charAt(index) == '0'){
                break;
            }
            long currNum = Long.parseLong(num.substring(index,j+1));
            if(index==0){
                //first num pick it without adding any operator
                dfs(j+1, path+ currNum, currNum, currNum ,num, target);
            }
            else{
                dfs(j+1,path + "+" + currNum,currentResult+ currNum, currNum, num, target);
                dfs(j+1,path + "-" + currNum, currentResult-currNum, -currNum, num,target);
                dfs(j+1,path + "*" + currNum, currentResult-prevIndex + prevIndex*currNum, prevIndex*currNum, num,target);

            }
        }
    }
}

// TC: O(n*n)
// SC: O(n)