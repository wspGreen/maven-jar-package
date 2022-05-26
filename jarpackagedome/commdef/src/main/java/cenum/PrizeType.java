package cenum;

public enum PrizeType {
    None(0), // 0-
    Gold(1), // 1-金币
    Crystal(2), // 2-水晶
    Exp(3), // 3-队伍经验
    VipExp(4), // 4-VIP经验
    Item(5), // 5-道具
    RoomCard(6), // 6-房卡
    FastCard(7), // 7-闪电卷
    // myland
    Physical(8), // 8-体力值
    ;
    private int value;
    private PrizeType(int value) {this.value = value;}
    public int value() {return value;}
    public static PrizeType valueOf(int value) {

        for (PrizeType flow : PrizeType.values()) {
            if (flow.value == value) {
                return flow;
            }
        }
        return PrizeType.None;
    }
}