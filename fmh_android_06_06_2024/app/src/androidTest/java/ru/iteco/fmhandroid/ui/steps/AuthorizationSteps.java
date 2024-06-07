package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.iteco.fmhandroid.ui.data.Data.correctLogin;
import static ru.iteco.fmhandroid.ui.data.Data.correctPassword;
import static ru.iteco.fmhandroid.ui.data.DataHelper.checkToast;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitElement;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitUntilVisible;

import androidx.test.espresso.NoMatchingViewException;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.screens.AuthorizationScreen;

public class AuthorizationSteps {
    public int enterButtonId = R.id.enter_button;
    public int LoginOutId = R.id.authorization_image_button;
    public int title = android.R.id.title;

    AuthorizationScreen authorizationScreen = new AuthorizationScreen();

    @Step("Авторизация валидными данными")
    public void login(String login, String password) {
        Allure.step("Авторизация валидными данными");
        waitElement(enterButtonId);
        authorizationScreen.loginField.perform(replaceText(login));
        authorizationScreen.passwordField.perform(replaceText(password));
        authorizationScreen.loginButton.check(matches(isDisplayed())).perform(click());
    }
    @Step("Выход из аккаунта")
    public void logout() {
        Allure.step("Выход из аккаунта");
        onView(withId(LoginOutId)).perform(click());
        onView(withId(title)).check(matches(isDisplayed()));
        onView(withId(title)).perform(click());
    }

    public void checkLogInAndLogInIfNot() {
        if (logIn()) {
            login(correctLogin, correctPassword);
        }
    }

    @Step("Проверка видимости кнопки выхода из аккаунта.")
    public void logOutIsVisible() {
        authorizationScreen.logOutButton.check(matches(isDisplayed()));
    }

    @Step("Выход из аккаунта")
    public void checkLogOutAndLogOutIfNot() {
        if (logOut()) {
            logout();
        }
    }

    @Step("Проверяем сообщение о недопустимости незаполненных логина или пароля")
    public void emptyLoginAndPassword() {
        Allure.step("Проверка всплывающего сообщения при пустом логине и пароле");
        waitUntilVisible(checkToast(R.string.empty_login_or_password, true));
    }

    @Step("Проверяем сообщение о неверном логине или пароле")
    public void loginOrPasswordIsWrong() {
        Allure.step("Проверка всплывающего сообщения при невалидном логине и пароле");
        waitUntilVisible(checkToast(R.string.error, true));
    }

    public boolean logIn() {
        boolean check = false;
        try {
            waitElement(enterButtonId);
            authorizationScreen.loginField.check(matches(isDisplayed()));
            check = true;
            return check;
        } catch (NoMatchingViewException e) {
            check = false;
            return check;
        } finally {
            return check;
        }
    }

    public boolean logOut() {
        boolean check = false;
        try {
            waitElement(LoginOutId);
            logOutIsVisible();
            check = true;
            return check;
        } catch (NoMatchingViewException e) {
            check = false;
            return check;
        } finally {
            return check;
        }
    }

}