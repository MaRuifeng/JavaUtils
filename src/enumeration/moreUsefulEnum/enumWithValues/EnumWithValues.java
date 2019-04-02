package enumeration.moreUsefulEnum.enumWithValues;

/**
 * See how Java enum with values works
 *
 * @author Ruifeng Ma
 * @since 2019-Mar-16
 */

public class EnumWithValues {

    public static void main(String[] args) {
        for (Weekday day: Weekday.values()) {
            System.out.println(day.getDaysGreeting());
            if (day.isWeekend()) {
                System.out.println("Oh! Happy " + day.name() + "!");
            } else {
                System.out.println("Snap! It's still " + day.name() + "...");
            }
            System.out.println();
        }
        System.out.println("All rabbits gone!");
    }
}
