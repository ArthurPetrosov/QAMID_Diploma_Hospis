package ru.iteco.fmhandroid.ui.tests;

import static ru.iteco.fmhandroid.ui.data.DataHelper.generateScreenshotName;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.rules.ScreenshotRule;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AboutSteps;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.QuotesSteps;

@RunWith(AllureAndroidJUnit4.class)
public class MainTest {

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule = new ActivityScenarioRule<>(AppActivity.class);
    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule(ScreenshotRule.Mode.FAILURE, generateScreenshotName("Failed"));
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    MainSteps mainSteps = new MainSteps();

    @Before
    public void setUp() {
        authorizationSteps.checkLogInAndLogInIfNot();
    }

    @Test
    @DisplayName("Переход в раздел Новости с помощью кнопки в меню навигации приложения")
    public void isItPossibleToGoToNewsSectionWithNavigationMenuButton() {
        mainSteps.goToNewsPageWithPressNavigationMenuButton();
        mainSteps.checkNewsPage();
    }

    @Test
    @DisplayName("Переход в раздел Новости с помощью кнопки на главной странице")
    public void isItPossibleToGoToNewsSectionWithMainPageButton() {
        mainSteps.goToNewsPageWithPressButtonOnMainPage();
        mainSteps.checkNewsPage();
    }

    @Test
    @DisplayName("Переход в раздел О приложении с помощью кнопки в меню навигации приложения")
    public void isItPossibleToGoToAboutSectionWithNavigationMenuButton() {
        mainSteps.goToAboutPage();
        mainSteps.isDeveloperTextViewDisplayed();
    }

    @Test
    @DisplayName("Переход в раздел Цитаты с помощью кнопки на главной странице")
    public void isItPossibleToGoToQuotesSectionWithMainPageButton() {
        mainSteps.goToQuotesPage();
        mainSteps.isHeaderQuotesPageDisplayed();
    }

}
