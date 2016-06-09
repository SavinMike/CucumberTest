package com.arello_mobile.test;
import android.app.Activity;
import android.content.Context;
import android.test.ActivityInstrumentationTestCase2;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class MainActivitySteps extends ActivityInstrumentationTestCase2<LoginActivity>
{
	private Activity mActivity;
	private Context mInstrumentationContext;
	private Context mAppContext;

	public MainActivitySteps()
	{
		super(LoginActivity.class);
	}

	@Before
	public void testSetUp() throws Exception
	{
		super.setUp();
		mInstrumentationContext = getInstrumentation().getContext();
		mAppContext = getInstrumentation().getTargetContext();
		mActivity = getActivity(); // Start Activity before each test scenario
		assertNotNull(mActivity);
	}

	@After
	public void testTearDown() throws Exception
	{
		ActivityFinisher.finishOpenActivities();
		getActivity().finish();
		super.tearDown(); // This step scrubs everything in this class so always call it last
	}

	@Given("^my app is launched$")
	public void testMyAppIsLaunched() throws Throwable
	{
		assertNotNull(getActivity());
	}


	@Then("^Success$")
	public void testSuccess() throws Throwable
	{
		onView(withId(R.id.email_sign_in_button)).perform(click());
		Thread.sleep(1000);
	}
}