package mode.factory.easy;

public abstract class AbstractColorFactory {
    abstract Color createColor();

    public static void main(String[] args) {
        ColorFactory cf=new ColorFactory();
        Color c=cf.createColor();
    }
}
class ColorFactory extends AbstractColorFactory{
    Color createColor() {
        return new Color();
    }
}
class Color{

}
