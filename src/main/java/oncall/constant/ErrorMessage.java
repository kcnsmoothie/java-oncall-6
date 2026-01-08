package oncall.constant;

public enum ErrorMessage {
    DEFAULT_ERROR("유효하지 않은 입력 값입니다. 다시 입력해 주세요."),
    NUMBER_FORMAT_ERROR("입력값은 숫자만 입력 가능합니다."),
    NULL_OR_EMPTY_ERROR("입력값은 비워둘 수 없습니다."),
    NUMBER_RANGE_ERROR("당첨 번호는 1~45 사이의 숫자만 입력할 수 있습니다."),
    NUMBER_DUPLICATE_ERROR("중복된 값을 입력할 수 없습니다.");

    private final static String ANNOTATE_ERROR = "[ERROR] ";
    private final String errorMessage;

    ErrorMessage(String inputMessage) {
        this.errorMessage = inputMessage;
    }

    public String getErrorMessage() {
        return ANNOTATE_ERROR + errorMessage;
    }
}
