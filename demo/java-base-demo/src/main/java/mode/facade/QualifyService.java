package mode.facade;

public class QualifyService {
    public boolean isAvailable(Gift gift){
        System.out.println("校验"+gift.getName()+" 积分资格通过,库存通过");
        return true;
    }
}
