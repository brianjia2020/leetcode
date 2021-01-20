package company_questions.yelp;

import java.util.*;

public class Q1_positiveReview {
    public static void main(String[] args) {
        List<PositiveReview> positiveReviews = new ArrayList<>();
        positiveReviews.add(new PositiveReview(1,10));
        positiveReviews.add(new PositiveReview(2,10));
        positiveReviews.add(new PositiveReview(1,11));
        positiveReviews.add(new PositiveReview(2,11));
        positiveReviews.add(new PositiveReview(1,12));
        positiveReviews.add(new PositiveReview(2,12));
        positiveReviews.add(new PositiveReview(3,12));

        Integer mostSimilarBusiness = findMostSimilarBusiness(10, positiveReviews);
        System.out.println(mostSimilarBusiness);

    }

    public static Integer findMostSimilarBusiness(
            Integer businessOfInterestId,
            List<PositiveReview> positiveReviews
    ){
        Map<Integer,List<Integer>> map = new HashMap<>();

        for(PositiveReview positiveReview: positiveReviews){
            if(!map.containsKey(positiveReview.getBusinessId())){
                List<Integer> nums = new ArrayList<>();
                nums.add(positiveReview.getUserId());
                map.put(positiveReview.getBusinessId(),nums);
            } else {
                map.get(positiveReview.getBusinessId()).add(positiveReview.getUserId());
            }
        }
        System.out.println(map);

        int similarMaxId = -1;
        double similarities = Integer.MIN_VALUE;
        for(Map.Entry<Integer,List<Integer>> entry: map.entrySet()){
            if(!entry.getKey().equals(businessOfInterestId)){
                Double similarity = findSimilarity(entry.getKey(), businessOfInterestId, map);
                System.out.println(similarity);
                if(similarity>similarities){
                    similarMaxId = entry.getKey();
                    similarities = similarity;
                }
            }
        }
        return similarMaxId;
    }

    public static Double findSimilarity(Integer b1, Integer b2, Map<Integer,List<Integer>> map){
        List<Integer> b1_id = map.get(b1);
        List<Integer> b2_id = map.get(b2);
        double common = 0;
        for(Integer id: b1_id){
            if(b2_id.contains(id)){
                common++;
            }
        }
        return ((common)/(b1_id.size()+b2_id.size()-common));
    }
}

class PositiveReview {
    Integer userId;
    Integer businessId;

    public PositiveReview(Integer userId, Integer businessId) {
        this.userId = userId;
        this.businessId = businessId;
    }

    public Integer getUserId() {
        return this.userId;
    }
    public Integer getBusinessId() {
        return this.businessId;
    }
}