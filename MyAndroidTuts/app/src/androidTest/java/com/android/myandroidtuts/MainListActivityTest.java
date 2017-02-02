package com.android.myandroidtuts;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainListActivityTest {

    @Rule
    public ActivityTestRule<MainListActivity> mActivityTestRule = new ActivityTestRule<>(MainListActivity.class);

    @Test
    public void mainListActivityTest() {
        ViewInteraction appCompatCheckBox = onView(
                allOf(withId(R.id.fav_button), isDisplayed()));
        appCompatCheckBox.perform(click());

        ViewInteraction appCompatCheckBox2 = onView(
                allOf(withId(R.id.fav_button), isDisplayed()));
        appCompatCheckBox2.perform(click());

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.recycler_view),
                        withParent(allOf(withId(android.R.id.content),
                                withParent(withId(R.id.decor_content_parent)))),
                        isDisplayed()));
        recyclerView.perform(actionOnItemAtPosition(0, click()));

        pressBack();

        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.recycler_view),
                        withParent(allOf(withId(android.R.id.content),
                                withParent(withId(R.id.decor_content_parent)))),
                        isDisplayed()));
        recyclerView2.perform(actionOnItemAtPosition(46, click()));

        pressBack();

        ViewInteraction recyclerView3 = onView(
                allOf(withId(R.id.recycler_view),
                        withParent(allOf(withId(android.R.id.content),
                                withParent(withId(R.id.decor_content_parent)))),
                        isDisplayed()));
        recyclerView3.perform(actionOnItemAtPosition(54, click()));

        ViewInteraction textView = onView(
                allOf(withId(R.id.item_name), withText("MVC VS MVP Eventbus"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                        0),
                                0),
                        isDisplayed()));
        textView.check(matches(withText("MVC VS MVP Eventbus")));

        pressBack();

        ViewInteraction recyclerView4 = onView(
                allOf(withId(R.id.recycler_view),
                        withParent(allOf(withId(android.R.id.content),
                                withParent(withId(R.id.decor_content_parent)))),
                        isDisplayed()));
        recyclerView4.perform(actionOnItemAtPosition(1, click()));

        ViewInteraction recyclerView5 = onView(
                allOf(withId(R.id.recycler_view),
                        withParent(allOf(withId(android.R.id.content),
                                withParent(withId(R.id.decor_content_parent)))),
                        isDisplayed()));
        recyclerView5.perform(actionOnItemAtPosition(1, click()));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.item_name), withText("Application Native and thord party android apps 2. Application Framework Activity Manager, Window Manager, Notification Manager, View System, XMPP Service, Location Manager, Package Manager, Resource Manager, Content Providers 3. Libraries SQLITE, WebKit, Open GL ES, Free Type, Surface Manager, Media framework, SSL, SGL, libc 3. Android Runtime Core Libraries, DVM 4. Linux Kernel Display Driver, Wifi Driver, Audio Drivers, Binder(IPC) Drivers, Bluetooth Driver, Camera Driver, Power Management, Process Management, Memory Management, Flash Memory Driver http://www.techotopia.com/index.php/An_Overview_of_the_Android_Architecture"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                        0),
                                0),
                        isDisplayed()));
        textView2.check(matches(withText("")));

        pressBack();

        pressBack();

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.item_name), withText("1. Architecture"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        0),
                                0),
                        isDisplayed()));
        textView3.check(matches(withText("1. Architecture")));

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.item_name), withText("1. Architecture"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        0),
                                0),
                        isDisplayed()));
        textView4.check(matches(withText("1. Architecture")));

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
