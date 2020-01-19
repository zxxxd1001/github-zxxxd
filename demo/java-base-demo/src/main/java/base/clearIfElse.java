package base;

import java.util.*;
import java.util.stream.Collectors;

public class clearIfElse {
    public static void main(String[] args) {
        clearIfElse c=new clearIfElse();
        c.today();
        System.out.println(c.p(1000,"白金会员"));

        System.out.println(c.getResult(1000,"黄金会员"));
    }
    //        -------------------- 理想中的 if-else  --------------------
    public void today() {
        if (isWeekend()) {
            System.out.println("玩游戏");
        } else {
            System.out.println("上班!");
        }
    }

    public boolean isWeekend() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            return true;
        } else {
            return false;
        }
    }

//        -------------------- 现实中的 if-else  --------------------

    public double p(Integer money,String type) {
        double result=money;
        if (money >= 1000) {
            if (UserTypeEnum.SILVER_VIP.getValue().equals(type)) {
                System.out.println("白银会员 优惠50元");
                result = money - 50;
            } else if (UserTypeEnum.GOLD_VIP.getValue().equals(type)) {
                System.out.println("黄金会员 8折");
                result = money * 0.8;
            } else if (UserTypeEnum.PLATINUM_VIP.getValue().equals(type)) {
                System.out.println("白金会员 优惠50元，再打7折");
                result = (money - 50) * 0.7;
            } else {
                System.out.println("普通会员 不打折");
                result = money;
            }
        }
        return result;
//省略 n 个 if-else ......
    }

    public double getResult(Integer money, String type) {

        if (money < 1000) {
            return money;
        }

        Strategy strategy = StrategyFactory.getInstance().get(type);

        if (strategy == null){
            throw new IllegalArgumentException("please input right type");
        }

        return strategy.compute(money);
    }
}
enum UserTypeEnum{
    SILVER_VIP("白银会员"),
    GOLD_VIP("黄金会员"),
    PLATINUM_VIP("白金会员");
    private String value;

    UserTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static UserTypeEnum fromValue(String value) throws Exception {
        for (UserTypeEnum rcptType : UserTypeEnum.values()) {
            if (rcptType.getValue().equals(value)) {
                return rcptType;
            }
        }
        throw new Exception();
    }
}
interface Strategy {

    // 计费方法
    double compute(long money);
    String getType();
}

// 普通会员策略
class OrdinaryStrategy implements Strategy {

    @Override
    public double compute(long money) {
        System.out.println("普通会员 不打折");
        return money;
    }

    @Override
    public String getType() {
        return "";
    }
}

// 白银会员策略
class SilverStrategy implements Strategy {

    @Override
    public double compute(long money) {

        System.out.println("白银会员 优惠50元");
        return money - 50;
    }

    @Override
    public String getType() {
        return UserTypeEnum.SILVER_VIP.getValue();
    }
}

// 黄金会员策略
class GoldStrategy implements Strategy{

    @Override
    public double compute(long money) {
        System.out.println("黄金会员 8折");
        return money * 0.8;
    }

    @Override
    public String getType() {
        return UserTypeEnum.GOLD_VIP.getValue();
    }
}

// 白金会员策略
class PlatinumStrategy implements Strategy {
    @Override
    public double compute(long money) {
        System.out.println("白金会员 优惠50元，再打7折");
        return (money - 50) * 0.7;
    }

    @Override
    public String getType() {
        return UserTypeEnum.PLATINUM_VIP.getValue();
    }
}
class StrategyFactory {

    private Map<String, Strategy> map;

    StrategyFactory() {

        List<Strategy> strategies = new ArrayList<>();

        strategies.add(new OrdinaryStrategy());
        strategies.add(new SilverStrategy());
        strategies.add(new GoldStrategy());
        strategies.add(new PlatinumStrategy());

        // 看这里 看这里 看这里！
        map = strategies.stream().collect(Collectors.toMap(Strategy::getType, strategy -> strategy));
        // 等同上面
//        map = new HashMap<>();
//        for (Strategy strategy : strategies) {
//            map.put(strategy.getType(), strategy);
//        }
    }

    public static class Holder {
        public static StrategyFactory instance = new StrategyFactory();
    }

    public static StrategyFactory getInstance() {
        return Holder.instance;
    }

    public Strategy get(String type) {
        return map.get(type);
    }
}