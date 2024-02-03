package Matrix;

import java.util.Collections;
import java.util.NavigableMap;
import java.util.TreeMap;

public abstract class AbstractMatrix<I,T> implements Matrix<I,T> {

    protected final NavigableMap<I, T> matrix;

    private final T zero;

    protected AbstractMatrix(NavigableMap<I,T> matrix, T zero) {
        this.matrix = Collections.unmodifiableNavigableMap(matrix);
        this.zero = zero;
    }

    @Override
    public T value(I index){
        if (index == null){
            throw new IllegalArgumentException("Illegal index argument");
        }
        return this.matrix.get(index);
    }

    @Override
    public T zero(){
        return this.zero;
    }

    @Override
    public NavigableMap<I, T> representation(){
        return new TreeMap<>(this.matrix);
    }

}
