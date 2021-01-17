package leetcode_medium;

import java.util.*;

public class leetcode_355 {
    public static void main(String[] args) {

    }
}

class Twitter {

    private int time =0;
    private int recentMax = 10;
    private Map<Integer,Integer> tweetTime = new HashMap<>();
    private Map<Integer,User> userMap = new HashMap<>();

    /** Initialize your data structure here. */
    public Twitter() {}

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)){
            userMap.put(userId,new User());
        }
        userMap.get(userId).getTweetsId().add(tweetId);
        time += 1;
        tweetTime.put(tweetId,time);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        if(!userMap.containsKey(userId)) return new ArrayList<>();
        // System.out.println(userId);
        List<Integer> followee = userMap.get(userId).getFollowee();
        List<Integer> res = new ArrayList<>(userMap.get(userId).getTweetsId());
        for (int followId: followee){
            // System.out.println(userId+"followed"+followId);
            if(userMap.containsKey(followId)&&followId!=userId){
                Set<Integer> tweetsIds = userMap.get(followId).getTweetsId();
                res.addAll(tweetsIds);
            }
        }
        res.sort((o1, o2) -> (tweetTime.get(o2) - tweetTime.get(o1)));
        if(res.size()<=recentMax) return res;
        return res.subList(0,recentMax);
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User());
        }
        if(userMap.get(followerId).getFollowee().contains(followeeId)) return;
        userMap.get(followerId).getFollowee().add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User());
        }
        if(!userMap.get(followerId).getFollowee().contains(followeeId)) return;
        Integer target = followeeId;
        userMap.get(followerId).getFollowee().remove(target);
    }

    class User{
        private Set<Integer> tweetsId = new HashSet<>();
        private List<Integer> followee = new ArrayList<>();

        public Set<Integer> getTweetsId() {
            return tweetsId;
        }

        public void setTweetsId(Set<Integer> tweetsId) {
            this.tweetsId = tweetsId;
        }

        public List<Integer> getFollowee() {
            return followee;
        }

        public void setFollowee(List<Integer> followee) {
            this.followee = followee;
        }
    }
}
