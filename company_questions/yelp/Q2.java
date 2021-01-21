package company_questions.yelp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q2 {
    public static void main(String[] args) {
        List<Message> list = new ArrayList<>();
        list.add(new Message(1,42));
        list.add(new Message(2,42));
        list.add(new Message(42,1));
//        System.out.println("final answer");
        System.out.println(countResponseRate(42,list));
    }

    public static int countResponseRate(int targetId, List<Message> allMessages){
        int count1 = 0;
        int count2 = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<allMessages.size();i++){

            if(allMessages.get(i).getRecipient()==targetId){
                count2++;
                if(!map.containsKey(allMessages.get(i).getSender())){
                    map.put(allMessages.get(i).getSender(),1);
                } else {
                    map.put(allMessages.get(i).getSender(),map.get(allMessages.get(i).getSender())+1);
                }
            }
//            System.out.println(map);

            if(map.containsKey(allMessages.get(i).getRecipient()) && allMessages.get(i).getSender()==targetId) {
                if(map.get(allMessages.get(i).getRecipient())>=1) {
                    count1++;
                    map.put(allMessages.get(i).getRecipient(), map.get(allMessages.get(i).getRecipient()) - 1);
                }
            }
        }
//        System.out.println(count1);
//        System.out.println(count2);
        return count1*100/count2;
    }
}


class Message{
    private int sender;
    private int recipient;

    public Message() {
    }

    public Message(int sender, int recipient) {
        this.sender = sender;
        this.recipient = recipient;
    }

    public int getSender() {
        return sender;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }

    public int getRecipient() {
        return recipient;
    }

    public void setRecipient(int recipient) {
        this.recipient = recipient;
    }
}
