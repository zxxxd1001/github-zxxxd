package mode.facade;

/**
 * 外观模式
 */
public class Facade {

    private QualifyService qualifyService = new QualifyService();
    private PointsPaymentService pointsPaymentService = new PointsPaymentService();
    private ShippingService shippingService = new ShippingService();

    public void giftExchange(Gift gift){
        if(qualifyService.isAvailable(gift)){
            //资格校验通过
            if(pointsPaymentService.pay(gift)){
                //如果支付积分成功
                String shippingOrderNo = shippingService.shipGift(gift);
                System.out.println("物流系统下单成功,订单号是:"+shippingOrderNo);
            }
        }
    }
    public static void main(String[] args) {
        Facade facade=new Facade();
        facade.giftExchange(new Gift("T恤"));
    }
}
