package enumeration.moreUsefullEnum.enumWithValues;

/**
 * Instead of being defined as constant types, Java enum can be more useful with value members
 * as if they would work like objects in JavaScript.
 *
 * https://dzone.com/articles/java-enums-how-to-make-much-more-useful
 *
 * @author Ruifeng Ma
 * @Since 2019-Mar-16
 */

public enum Weekday {
    SUNDAY("Sunday Funday", true),
    MONDAY("Marketing Monday"),
    TUESDAY("Trendy Tuesday"),
    WEDNESDAY("Wellness Wednesday"),
    THURSDAY("Thankful Thursday"),
    FRIDAY("Foodie Friday"),
    SATURDAY("Social Saturday", true);

    private String daysGreeting;
    private boolean isWeekend;

    Weekday(final String greeting) {
        this.daysGreeting = greeting;
    }

    Weekday(final String greeting, final boolean isWeekend) {
        this(greeting);
        this.isWeekend = isWeekend;
    }

    public String getDaysGreeting() {
        return this.daysGreeting;
    }

    public boolean isWeekend() {
        return this.isWeekend;
    }
}
