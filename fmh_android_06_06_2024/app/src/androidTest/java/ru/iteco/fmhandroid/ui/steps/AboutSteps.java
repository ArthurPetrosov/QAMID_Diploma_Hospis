package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.screens.AboutScreen;

public class AboutSteps {
AboutScreen aboutScreen = new AboutScreen();

    @Step("Проверка видимость страницы About")
    public void isAppVersionDisplayed() {
        Allure.step("Проверка наличия сведений о версии приложения");
        aboutScreen.versionText.check(matches(isDisplayed()));
        aboutScreen.versionInfo.check(matches(isDisplayed()));
    }

    @Step("Проверка наличия сведений о Privacy Policy")
    public void isAppPrivacyPolicyDisplayed() {
        Allure.step("Проверка наличия сведений о Privacy Policy");
        aboutScreen.aboutPrivacy.check(matches(isDisplayed()));
    }

}