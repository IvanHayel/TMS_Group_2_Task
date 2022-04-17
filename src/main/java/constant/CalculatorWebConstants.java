package constant;

public class CalculatorWebConstants {
    public static final String PATH_HOME = "/home";
    public static final String PATH_AUTHORIZATION = "/authorization";
    public static final String PATH_REGISTRATION = "/registration";
    public static final String PATH_CALCULATION = "/calculation";
    public static final String PATH_CALCULATION_HISTORY = "/calculation/history";
    public static final String PATH_LOGOUT = "/logout";

    public static final String PAGE_PATH_HOME = "/pages/home.jsp";
    public static final String PAGE_PATH_AUTHORIZATION = "/pages/authorization.jsp";
    public static final String PAGE_PATH_REGISTRATION = "/pages/registration.jsp";
    public static final String PAGE_PATH_CALCULATION = "/pages/calculation.jsp";
    public static final String PAGE_PATH_CALCULATION_HISTORY = "/pages/calculation-history.jsp";
    public static final String PAGE_PATH_ERROR_400 = "/pages/error/400.jsp";
    public static final String PAGE_PATH_ERROR_401 = "/pages/error/401.jsp";
    public static final String PAGE_PATH_ERROR_403 = "/pages/error/403.jsp";
    public static final String PAGE_PATH_ERROR_404 = "/pages/error/404.jsp";

    public static final String SESSION_ATTRIBUTE_USER = "user";

    public static final String REQUEST_ATTRIBUTE_OPERATION = "operation";
    public static final String REQUEST_ATTRIBUTE_OPERATION_HISTORY = "operationHistory";
    public static final String REQUEST_PARAMETER_LOGIN = "login";
    public static final String REQUEST_PARAMETER_PASSWORD = "password";
    public static final String REQUEST_PARAMETER_NAME = "name";
    public static final String REQUEST_PARAMETER_SURNAME = "surname";
    public static final String REQUEST_PARAMETER_OPERAND = "operand";
    public static final String REQUEST_PARAMETER_FIRST_VALUE = "firstValue";
    public static final String REQUEST_PARAMETER_SECOND_VALUE = "secondValue";

    private CalculatorWebConstants() {
    }
}