import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Twitter {

    private static int timeStamp = 0;
    private Map<Integer, List<Tweet>> tweets;
    private Map<Integer, Set<Integer>> followers;
    
    private static class Tweet {
        int tweetID;
        int time;

        public Tweet(int tweetID, int time) {
            this.time = time;
            this.tweetID = tweetID;
        }
    }

    public Twitter() {
        tweets = new HashMap<>();
        followers = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId, timeStamp++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> news = new ArrayList<>();
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time);
        Set<Integer>  users = followers.getOrDefault(userId, new HashSet<>());
        users.add(userId);

        for (int user : users) {
            List<Tweet> userTweets = tweets.getOrDefault(user, new ArrayList<>());
            maxHeap.addAll(userTweets);
        }
        
        int count = 0;
        while (!maxHeap.isEmpty() & count < 10) {
            news.add(maxHeap.poll().tweetID);
            count++;
        }

        return news;
    }
    
    public void follow(int followerId, int followeeId) {
        followers.putIfAbsent(followerId, new HashSet<>());
        followers.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followers.containsKey(followerId)) {
            followers.get(followerId).remove(followeeId);
        }
    }

}

public class DesignTwitter {
    
}
