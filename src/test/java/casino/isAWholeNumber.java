package casino;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class isAWholeNumber extends TypeSafeMatcher<Integer> {
    @Override
    protected boolean matchesSafely(Integer item) {
        if(item>=0)
            return true;
        return false;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Not a whole number");
    }
    public static Matcher<Integer> IsAWholeNumber(){
        return new isAWholeNumber();
    }
}
