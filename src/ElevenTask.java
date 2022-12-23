import java.util.*;
import java.util.stream.*;

public class ElevenTask {
    public String listToStringNames(List array) {
        if (isListEmpty(array)) throw new NoSuchElementException("Empty list");

        return IntStream
                .range(0, array.size())
                .filter(i -> i % 2 != 0)
                .mapToObj(i -> i + ". " + array.get(i))
                .collect(Collectors.joining(","));
    }

    public List toUpperNames(List<String> array) {
        if (isListEmpty(array)) throw new NoSuchElementException("Empty list");

        return array
                .stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

    }

    private boolean isListEmpty(List array) {
        return array.isEmpty();
    }

    public String fromListToOneString(String[] array) {
        if (array.length == 0) throw new NoSuchElementException("Empty list");
        return  Stream
                .of(array)
                .flatMap(line -> Stream.of(line.split(", ")))
                .sorted()
                .collect(Collectors.joining(", "));
    }

    private Stream<Long> randomStream(long a, int c, long m, long seed, int end) {
        return Stream
                .iterate(seed, x -> (a * x + c) % m)
                .limit(end);
    }

    public void loopStream(long a, int c, long m, long seed, int end) {
        randomStream(a, c, m, seed,end)
                .forEach(System.out::println);
    }
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){
        List<T> result = new ArrayList<>();
        Iterator<T> a = first.iterator();
        Iterator<T> b = second.iterator();

        while (a.hasNext() && b.hasNext()) {
            result.add(a.next());
            result.add(b.next());
        }
        Collections.shuffle(result);
        return result.stream();
    }

}
