package mode.factory.easy;

public class TestColorFactory {
    public static void main(String[] args) {
        AbstractColorFactory cf=new ColorFactory();
        Color c=cf.createColor();
    }
}
abstract class AbstractColorFactory {
    abstract Color createColor();
}
class ColorFactory extends AbstractColorFactory{
    Color createColor() {
        return new Color();
    }
}
class Color{

}
