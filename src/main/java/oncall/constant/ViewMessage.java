package oncall.constant;

public enum ViewMessage {
    DEFAULT_WORK_TABLE("%d월 %d일 %s %s");

    private final String viewMessage;

    ViewMessage(String inputMessage) {
        this.viewMessage = inputMessage;
    }

    public String getViewMessage() {
        return viewMessage;
    }

    public String getViewMessage(int int1, int int2, String str1, String str2) {
        return String.format(viewMessage, int1, int2, str1, str2);
    }
}
