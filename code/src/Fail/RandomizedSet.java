package Fail;

import java.util.*;

public class RandomizedSet {
    private Map<Integer, Integer> hs = new HashMap();
    private List<Integer> al = new ArrayList<>();
    private Random r = new Random();

    public RandomizedSet() {
    }

    public boolean insert(int val) {
        if (hs.containsKey(val)) return false;
        hs.put(val, hs.size());
        al.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!hs.containsKey(val)) return false;
        int size=al.size();
        int index = hs.get(val);

        Integer last = al.remove(size-1);
        hs.remove(val);
        if(size-1!=index) { //当要移除的元素不是最后一个元素时
            hs.replace(last, size - 1, index);
            al.set(index, last);
        }
        return true;
    }

    public int getRandom() {
        int i = r.nextInt(hs.size());
        return al.get(i);
    }
}
