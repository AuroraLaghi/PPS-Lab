import lab01.tdd.CircularList;
import lab01.tdd.SelectStrategy;
import java.util.LinkedList;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private LinkedList<Integer> list;
    private int pos;

    public CircularListImpl(){
        list = new LinkedList<Integer>();
        pos = 0;
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void add(int element) {
        list.add(element);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Optional<Integer> next() {
        if(isEmpty()){
            return Optional.empty();
        }
        return getNext();
    }

    @Override
    public Optional<Integer> previous() {
        if(isEmpty()){
            return Optional.empty();
        }
        if(pos == 0){
            pos = list.size() - 1;
        } else {
            pos--;
        }
        final Optional<Integer> previous = Optional.of(list.get(pos));
        return previous;
    }

    @Override
    public void reset() {
        pos = 0;
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        if(isEmpty()){
            return Optional.empty();
        }
        while (!strategy.apply(list.get(pos))){
            if(pos == (list.size() -1)){
                pos = 0;
            }else {
                pos ++;
            }
        }
        return getNext();
    }

    private Optional<Integer> getNext() {
        final Optional<Integer> currentValue = Optional.of(list.get(pos));
        if(pos == (list.size() -1)){
            pos = 0;
        } else {
            pos++;
        }
        return currentValue;
    }
}
