package enumeration.moreUsefullEnum.enumWithMethods;

/**
 * See how Java enum with defined methods works
 *
 * @author Ruifeng Ma
 * @since 2019-Mar-23
 */


public class EnumWithMethods {
    public static void main(String[] args) {
        int a = 1, b = 0;
        try {
            for (Operator operator : Operator.values()) {
                System.out.println("Current operator: " + operator.name());
                System.out.println("Result " + operator.execute(a, b));
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
