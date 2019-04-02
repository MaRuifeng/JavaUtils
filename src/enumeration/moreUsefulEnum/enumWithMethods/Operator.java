package enumeration.moreUsefulEnum.enumWithMethods;

/**
 * Enum with defined methods
 *
 * https://dzone.com/articles/java-enums-how-to-make-much-more-useful
 *
 * @author Ruifeng Ma
 * @Since 2019-Mar-23
 */

public enum Operator {
    ADD {
        @Override int execute(final int a, final int b) {
            return Math.addExact(a, b);
        }
    },
    SUBTRACT {
        @Override int execute(final int a, final int b) {
            return Math.subtractExact(a, b);
        }
    },
    MULTIPLY {
        @Override int execute(final int a, final int b) {
            return Math.multiplyExact(a, b);
        }
    },
    DVIDE {
        @Override int execute(final int a, final int b) throws Exception {
            if (b != 0) {
            return Math.floorDiv(a, b);
            } else throw new Exception("No division by zero!");
        }
    };

    abstract int execute(int a, int b) throws  Exception;
}

