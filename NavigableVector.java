package Matrix;

import java.util.Map;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.TreeMap;

public class NavigableVector<T> extends AbstractMatrix<Integer, T> {

    private NavigableVector(NavigableMap<Integer,T> matrix, T zero){
        super(matrix, zero);
    }
    public static <S> NavigableVector<S> from(Map<Integer, S> vector, S zero) {

        Objects.requireNonNull(vector);
        Objects.requireNonNull(zero);

        NavigableMap<Integer, S> navigableMap = new TreeMap<>(vector);
        
        navigableMap.values().removeIf(value -> value.equals(zero));

        return new NavigableVector<S>(navigableMap, zero);
    }
}
