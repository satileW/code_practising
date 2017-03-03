import java.util.*;

/**
 * Created by user on 3/2/17.
 */
public class CatchInsider {
    public static void main(String[] args) {
        String feed= "0|20\n0|Kristi|SELL|3000\n0|Will|BUY|5000\n0|Tom|BUY|50000\n0|Shilpa|BUY|1500\n1|Tom|BUY|1500000\n3|25\n5|Shilpa|SELL|1500\n8|Tristi|SELL|600000\n8|Shilpa|SELL|1151500\n10|15\n11|5\n14|Will|BUY|100000\n15|Will|BUY|100000\n16|Will|BUY|100000\n17|25";
        String[] feeds = feed.split("\\n");
        List<FlagTrade> result = findFraudolentTraders(feeds);
        List<String> ans = new ArrayList<>();
        for(FlagTrade trade:result){
            System.out.println(trade.day+" "+trade.name);
            ans.add(new String(trade.day+"|"+trade.name));
        }
    }

    static class FlagTrade{
        int day;
        String name;
        public FlagTrade(int day, String name){
            this.day = day;
            this.name = name;
        }
        public static Comparator<FlagTrade> compare(){
            Comparator comp = new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    FlagTrade f1 = (FlagTrade)o1;
                    FlagTrade f2 = (FlagTrade)o2;
                    if(f1.day>f2.day){
                        return 1;
                    }else if(f1.day < f2.day){
                        return -1;
                    }else{
                        return f1.name.compareTo(f2.name);
                    }
                }
            };
            return comp;
        }

        @Override
        public boolean equals(Object obj) {
            FlagTrade compareObj = (FlagTrade) obj;
            return compareObj.day==this.day&&compareObj.name==this.name;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode()+ this.day*37;
        }
    }
    static class TradeRecord{
        public String trader;
        public boolean isBuy;
        public int tradePrice;
        public int amount;
        public TradeRecord(String name, boolean buyOrNot, int price, int amount){
            this.trader = name;
            this.isBuy = buyOrNot;
            this.tradePrice = price;
            this.amount = amount;
        }
    }
    static List<FlagTrade> findFraudolentTraders(String[] feeds){
        List<FlagTrade> ans ;
        HashMap<Integer, List<TradeRecord>> historyrecord = new HashMap<>();//day, and trades happens in this day
        HashSet<FlagTrade> flagTrades = new HashSet<>();//use set to record the trade is a insider's trade
        int current_price = 0;
        for(String str: feeds){
            String[] vals = str.split("\\|");
            int day = Integer.parseInt(vals[0]);
            if(vals.length==2){
                 current_price = Integer.parseInt(vals[1]);
                for( int i = day-3; i < day; i++){
                    if(historyrecord.containsKey((i))){
                        for(TradeRecord record: historyrecord.get(i)){
                            FlagTrade flag = new FlagTrade(i, record.trader);
                            if(flagTrades.contains(flag)){
                                continue;
                            }
                            boolean isInsider;
                            if( record.isBuy ){
                                isInsider = (current_price - record.tradePrice) * record.amount >= 5000000;
                            }else{
                                isInsider = (record.tradePrice - current_price) * record.amount >= 5000000;
                            }
                            if(isInsider){
                                flagTrades.add(flag);
                            }
                        }
                    }
                }
            }else{
                TradeRecord record = new TradeRecord(vals[1], vals[2].equals("BUY"),current_price, Integer.parseInt(vals[3]));
                if(!historyrecord.containsKey(day)){
                    historyrecord.put(day, new ArrayList<>());
                }
                historyrecord.get(day).add(record);
            }
        }
        ans = new ArrayList<>(flagTrades);
        ans.sort(FlagTrade.compare());//compare and sort them
        return ans;
    }
}
