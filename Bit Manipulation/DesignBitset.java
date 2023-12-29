class Bitset {
    //using Hashset
    private int size;
    private Set<Integer> ones = new HashSet<>();
    private Set<Integer> zeros = new HashSet<>();

    public Bitset(int size) {
        this.size = size;
        for(int i = 0 ; i < size ; i++){
            zeros.add(i);
        }
    }
    // tc: O(1)
    public void fix(int idx) {
        ones.add(idx);
        zeros.remove(idx);
    }
    // tc: O(1)
    public void unfix(int idx) {
        ones.remove(idx);
        zeros.add(idx);
    }
    // tc: O(1)
    public void flip() {
        Set<Integer> temp = ones;
        ones = zeros;
        zeros = temp;
    }
    // tc: O(1)
    public boolean all() {
        return ones.size() == size;
    }
    // tc: O(1)
    public boolean one() {
        return ones.size() >=1;
    }
    // tc: O(1)
    public int count() {
        return ones.size();
    }
    // TC: O(n)
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < size; i++){
            if(ones.contains(i)){
                sb.append("1");
            }
            else if(zeros.contains(i)){
                sb.append("0");
            }
        }
        return sb.toString();
    }
}

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */

