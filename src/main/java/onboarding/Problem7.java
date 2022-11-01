package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> friendPoints = getFriendshipPoints(user, friends, visitors);
        List<Map.Entry<String, Integer>> sortedFriendPoints = sortRecommendedList(friendPoints);
        return getRecommendedList(sortedFriendPoints);
    }
    private static List<String> getRecommendedList(HashMap<String, Integer> usersPoint) {
        List<String> rec = new ArrayList<>();
        List<Map.Entry<String, Integer>> entry = sortRecommendedList(usersPoint);

        for(Map.Entry<String, Integer> entryElement: entry) {
            rec.add(entryElement.getKey());
            if (rec.size() == 5) {
                break;
            }
        }
        return rec;
    }

    private static List<Map.Entry<String, Integer>> sortRecommendedList(Map<String, Integer> friendPoints) {
        List<Map.Entry<String, Integer>> sortList = new ArrayList<>(friendPoints.entrySet());

        sortList.sort((o1, o2) -> {
            if (!o1.getValue().equals(o2.getValue())) {
                return o2.getValue() - o1.getValue();
            } else {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        return sortList;
    }


    private static Set<String> getFriends(String user, List<List<String>> friends) {
        Set<String> userFriends = new HashSet<>();
        for (List<String> friendship : friends) {
            if (friendship.contains(user)) {
                if (friendship.get(0) == user) {
                    userFriends.add(friendship.get(1));
                } else userFriends.add(friendship.get(0));
            }
        }
        return userFriends;
    }
    private static Set<String> getAllUsers(List<List<String>> friends, List<String> visitors) {
        Set<String> allUsers = new HashSet<>();
        for (List<String> users : friends){
            allUsers.add(users.get(0));
            allUsers.add(users.get(1));
        }
        for (String users : visitors){
            allUsers.add(users);
        }
        return allUsers;
    }
    private static Map<String, Integer> makeFriendshipList(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> friendshipList = new HashMap<>();
        Set<String> allUsers = getAllUsers(friends, visitors);

        for (String users : allUsers) {
            if (users == user) {
                continue;
            } else friendshipList.put(users, 0);
        }
        return friendshipList;
    }
    private static Map<String, Integer> getFriendshipPoints(String user, List<List<String>> friends, List<String> visitors) {
        Set<String> friendList = getFriends(user, friends);
        Map<String, Integer> friendshipPoints = makeFriendshipList(user, friends, visitors);
        
        for (String friend : friendList) {
            friendshipPoints.put(friend, friendshipPoints.get(friend) + 10);
        }
        for (String visitor : visitors) {
            friendshipPoints.put(visitor, friendshipPoints.get(visitor) + 1);
        }
        return friendshipPoints;
    }

}
