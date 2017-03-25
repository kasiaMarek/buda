public class Shapes {
    private double a, b;
    private Unary whatUnary;
    private Binary whatBinary;


    public Shapes(Unary whatUnary, double a) {
        this.whatUnary = whatUnary;
        this.whatBinary = null;
        this.a = a;
        this.b = 0;
    }

    public Shapes(Binary whatBinary, double a, double b) {
        this.whatUnary = null;
        this.whatBinary = whatBinary;
        this.a = a;
        this.b = b;
    }

    public double area() {
        if (whatBinary == null)
            return Unary.area(whatUnary, a);
        else
            return Binary.area(whatBinary, a, b);
    }

    public double perimeter() {
        if (whatBinary == null)
            return Unary.perimeter(whatUnary, a);
        else
            return Binary.perimeter(whatBinary, a, b);
    }

    public enum Unary {
        CIRCLE, PENTAGON, HEXAGON, SQUARE;

        public static double area(Unary shape, double a) {
            switch (shape) {
                case CIRCLE:
                    return Math.PI * a * a;
                case PENTAGON:
                    return a * a * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) / 4;
                case HEXAGON:
                    return 3 * a * a * Math.sqrt(3) / 2;
                case SQUARE:
                    return a * a;
                default:
                    return -1;
            }
        }

        public static double perimeter(Unary shape, double a) {
            switch (shape) {
                case CIRCLE:
                    return 2 * Math.PI * a;
                case PENTAGON:
                    return 5 * a;
                case HEXAGON:
                    return 6 * a;
                case SQUARE:
                    return 4 * a;
                default:
                    return -1;
            }
        }
    }

    public enum Binary {
        RECTANGLE, RHOMBUS;

        public static double area(Binary shape, double a, double b) {
            switch (shape) {
                case RECTANGLE:
                    return a * b;
                case RHOMBUS:
                    return a * a * Math.sin(b);
                default:
                    return -1;
            }
        }

        public static double perimeter(Binary shape, double a, double b) {
            switch (shape) {
                case RECTANGLE:
                    return 2 * (a + b);
                case RHOMBUS:
                    return 4 * a;
                default:
                    return -1;
            }
        }
    }
}