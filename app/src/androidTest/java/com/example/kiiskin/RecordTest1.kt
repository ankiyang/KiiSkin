package com.example.kiiskin


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.rule.GrantPermissionRule
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@LargeTest
@RunWith(JUnit4::class)
class RecordTest1 {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Rule
    @JvmField
    var mGrantPermissionRule =
        GrantPermissionRule.grant(
            "android.permission.CAMERA",
            "android.permission.READ_EXTERNAL_STORAGE"
        )

    @Test
    fun recordTest1() {
        val appCompatButton = onView(
            allOf(
                withId(R.id.MainRegButton), withText("registration"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.home_11),
                        7
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatButton.perform(click())

        val appCompatEditText = onView(
            allOf(
                withId(R.id.email),
                childAtPosition(
                    allOf(
                        withId(R.id.main_registration),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            1
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatEditText.perform(click())

        val appCompatEditText2 = onView(
            allOf(
                withId(R.id.email),
                childAtPosition(
                    allOf(
                        withId(R.id.main_registration),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            1
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatEditText2.perform(click())

        val appCompatEditText3 = onView(
            allOf(
                withId(R.id.email),
                childAtPosition(
                    allOf(
                        withId(R.id.main_registration),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            1
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatEditText3.perform(click())

        val appCompatEditText4 = onView(
            allOf(
                withId(R.id.email),
                childAtPosition(
                    allOf(
                        withId(R.id.main_registration),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            1
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatEditText4.perform(click())

        val appCompatEditText5 = onView(
            allOf(
                withId(R.id.email),
                childAtPosition(
                    allOf(
                        withId(R.id.main_registration),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            1
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatEditText5.perform(click())

        val appCompatEditText6 = onView(
            allOf(
                withId(R.id.email),
                childAtPosition(
                    allOf(
                        withId(R.id.main_registration),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            1
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatEditText6.perform(click())

        val appCompatEditText7 = onView(
            allOf(
                withId(R.id.email),
                childAtPosition(
                    allOf(
                        withId(R.id.main_registration),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            1
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatEditText7.perform(click())

        val appCompatEditText8 = onView(
            allOf(
                withId(R.id.email),
                childAtPosition(
                    allOf(
                        withId(R.id.main_registration),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            1
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatEditText8.perform(click())

        val appCompatEditText9 = onView(
            allOf(
                withId(R.id.email),
                childAtPosition(
                    allOf(
                        withId(R.id.main_registration),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            1
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatEditText9.perform(click())

        val appCompatEditText10 = onView(
            allOf(
                withId(R.id.email),
                childAtPosition(
                    allOf(
                        withId(R.id.main_registration),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            1
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatEditText10.perform(replaceText("a@gmail.com"), closeSoftKeyboard())

        pressBack()

        val appCompatEditText11 = onView(
            allOf(
                withId(R.id.username),
                childAtPosition(
                    allOf(
                        withId(R.id.main_registration),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            1
                        )
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        appCompatEditText11.perform(replaceText("aa"), closeSoftKeyboard())

        pressBack()

        val appCompatEditText12 = onView(
            allOf(
                withId(R.id.password),
                childAtPosition(
                    allOf(
                        withId(R.id.main_registration),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            1
                        )
                    ),
                    4
                ),
                isDisplayed()
            )
        )
        appCompatEditText12.perform(replaceText("aaa"), closeSoftKeyboard())

        pressBack()

        val appCompatButton2 = onView(
            allOf(
                withId(R.id.AccountSave), withText("save"),
                childAtPosition(
                    allOf(
                        withId(R.id.main_registration),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            1
                        )
                    ),
                    5
                ),
                isDisplayed()
            )
        )
        appCompatButton2.perform(click())

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(700)

        val appCompatButton3 = onView(
            allOf(
                withId(R.id.StartSkip), withText("Start Journey"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatButton3.perform(click())

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(700)

        val appCompatButton4 = onView(
            allOf(
                withId(R.id.btn_capture), withText("Camera"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.LinearLayout")),
                        1
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatButton4.perform(click())

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(700)

        val tabView = onView(
            allOf(
                withContentDescription("PhotoResult "),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tab_layout),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        tabView.perform(click())

        val tabView2 = onView(
            allOf(
                withContentDescription("PhotoResult "),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tab_layout),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        tabView2.perform(click())

        val tabView3 = onView(
            allOf(
                withContentDescription("Support"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tab_layout),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        tabView3.perform(click())

        val tabView4 = onView(
            allOf(
                withContentDescription("UserProfiles"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tab_layout),
                        0
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        tabView4.perform(click())
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
