package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AboutScreen {

    public ViewInteraction versionText;
    public ViewInteraction versionInfo;
    public ViewInteraction aboutPrivacy;
    public ViewInteraction backButton;
    public ViewInteraction aboutInfo;


    public AboutScreen() {
        versionText = onView(allOf(withId(R.id.about_version_title_text_view)));
        versionInfo = onView(allOf(withId(R.id.about_company_info_label_text_view)));
        aboutPrivacy = onView(allOf(withId(R.id.about_privacy_policy_label_text_view)));
        backButton = onView(allOf(withId(R.id.about_back_image_button)));
        aboutInfo = onView(allOf(withId(R.id.about_company_info_label_text_view)));

    }
}