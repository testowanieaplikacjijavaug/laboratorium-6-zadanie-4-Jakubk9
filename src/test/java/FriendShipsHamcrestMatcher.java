import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class FriendShipsHamcrestMatcher {
    public static Matcher<Friendships> isHeHaveFriends(final String person) {
        return new TypeSafeMatcher<Friendships>() {
            @Override
            protected boolean matchesSafely(Friendships friendships) {
                if (friendships.getFriendsList(person) == null){
                    return true;
                }
                return false;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("Expected to have friend list").appendValue(person);
            }
        };
    }

    public static Matcher<Friendships> areTheyFriends(final String person1, final String person2) {
        return new TypeSafeMatcher<Friendships>() {
            @Override
            protected boolean matchesSafely(Friendships friendships) {
                if(!friendships.friendships.get(person1).contains(person2))
                    return false;
                return true;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("They are not friends");
            }
        };


    }
}
