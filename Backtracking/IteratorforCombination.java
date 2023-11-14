class CombinationIterator {
    //backtracking
    List<String> result = null;
    int pos = 0;

    public CombinationIterator(String characters, int combinationLength) {
        result = new ArrayList<>();
        combinations(new StringBuilder(), characters, combinationLength,0);

    }

    public String next() {
        return result.get(pos++);
    }

    public boolean hasNext() {
        return pos  < result.size();

    }
    private void combinations(StringBuilder current, String characters, int combinationLength, int index){
        if(current.length() == combinationLength){
            result.add(current.toString());
            return;
        }
        for(int i = index; i < characters.length(); i++){
            current.append(characters.charAt(i));
            combinations(current, characters, combinationLength, i+1);
            current.deleteCharAt(current.length()-1);
        }
    }
}


//  TC: O(n*2^n)
//  SC: O(n)