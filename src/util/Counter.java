package util;


public class Counter implements AutoCloseable {
    private int count = 0;
    private boolean closed = false;
    private boolean usedInTryWithResources = false;

    public void markUsedInTry() {
        usedInTryWithResources = true;
    }

    public void add() {
        if (closed) {
            throw new IllegalStateException("Ресурс уже закрыт.");
        }
        count++;
        System.out.println("Счётчик: " + count);
    }

    public int getCount() {
        return count;
    }

    @Override
    public void close() {
        closed = true;
        if (!usedInTryWithResources) {
            throw new IllegalStateException("Counter должен использоваться внутри try-with-resources!");
        }
        System.out.println("Счётчик закрыт.");
    }
}
