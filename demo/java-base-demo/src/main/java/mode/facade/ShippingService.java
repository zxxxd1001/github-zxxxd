package mode.facade;

public class ShippingService {
    public String shipGift(Gift gift){
        //物流系统的对接逻辑
        System.out.println(gift.getName()+"进入物流系统");
        String shippingOrderNo = "666";
        return shippingOrderNo;
    }
}
