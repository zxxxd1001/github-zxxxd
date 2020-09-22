package mode.decorator;

public abstract class AbstractDecorator extends AbstractBattercake {
    private AbstractBattercake aBattercake;

    public AbstractDecorator(AbstractBattercake aBattercake) {
        this.aBattercake = aBattercake;
    }

    protected abstract void doSomething();

    @Override
    protected String getDesc() {
        return this.aBattercake.getDesc();
    }

    @Override
    protected int cost() {
        return this.aBattercake.cost();
    }
}
