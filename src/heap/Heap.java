package heap;

public interface Heap<Item> {

    void add(Item item);
    
    void remove(Item item);
    
    Item max();
    
    Item min();
    
    
}
