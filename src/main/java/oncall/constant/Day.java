package oncall.constant;

public enum Day {
    MONDAY("월", Type.WEEKDAY),
    TUESDAY("화", Type.WEEKDAY),
    WEDNESDAY("수",Type.WEEKDAY),
    THURSDAY("목", Type.WEEKDAY),
    FRIDAY("금", Type.WEEKDAY),
    SATURDAY("토", Type.WEEKEND),
    SUNDAY("일",Type.WEEKEND);

    private final String day;
    private final Type type;

    Day(String day, Type type) {
        this.day = day;
        this.type = type;
    }
}
