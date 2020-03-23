import org.assertj.core.api.AbstractAssert;

public class FriendShipsAssertJMatcher extends AbstractAssert<FriendShipsAssertJMatcher, Friendships> {

    public FriendShipsAssertJMatcher(Friendships actual) {
        super(actual, FriendShipsAssertJMatcher.class);
    }

    public static FriendShipsAssertJMatcher assertThat(Friendships actual) {
        return new FriendShipsAssertJMatcher(actual);
    }

    public FriendShipsAssertJMatcher isHeHaveFriends(String name) {
        isNotNull();
        if (actual.getFriendsList(name) != null) {
            failWithMessage("Expected to have <%s> friend list", name);
        }
        return this;
    }

    public FriendShipsAssertJMatcher areTheyFriends(String person1, String person2) {
        isNotNull();
        if(!actual.friendships.get(person1).contains(person2) && actual.friendships.get(person2).contains(person1))
            failWithMessage("They are not Friends");
        return this;
    }
}
