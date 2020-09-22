package mode.facade;

public class PointsPaymentService {
    public boolean pay(Gift gift){
        //扣减积分
        System.out.println("支付"+gift.getName()+" 积分成功");
        return true;
    }

}
