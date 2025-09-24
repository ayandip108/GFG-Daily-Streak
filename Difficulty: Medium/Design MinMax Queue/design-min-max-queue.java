class SpecialQueue {
    
    List<Integer> list;
    List<Integer> list2;
    public SpecialQueue() {
        // Define Data Structures
        list = new ArrayList<>();
        list2 = new ArrayList<>();
    }

    public void enqueue(int x) {
        // Insert element into the queue
        list.add(x);
        list2.add(x);
        Collections.sort(list2);
    }

    public void dequeue() {
        // Remove element from the queue
        if(list.size() > 0) {
            Object o = list.get(0);
            list.remove(0);
            list2.remove(o);
            Collections.sort(list2);
        }
        
        
    }

    public int getFront() {
        // Get front element
        return list.get(0);
    }

    public int getMin() {
        // Get minimum element
        return list2.get(0);
    }

    public int getMax() {
        // Get maximum element
        return list2.get(list2.size()-1);
    }
}