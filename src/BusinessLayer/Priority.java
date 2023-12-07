package BusinessLayer;

public enum Priority {
    INVALUABLE(3),
    HIGHLY_SIGNIFICANT(2),
    NOTEWORTHY(1);

    private final int value;

    Priority(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
