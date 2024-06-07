package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.supportsInputMethods;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AuthorizationScreen {

    public ViewInteraction loginField;
    public ViewInteraction passwordField;
    public ViewInteraction loginButton;
    public ViewInteraction logOutButton;


    public  AuthorizationScreen(){
    loginField = onView(allOf(supportsInputMethods(), isDescendantOfA(withId(R.id.login_text_input_layout))));
    passwordField = onView(allOf(supportsInputMethods(), isDescendantOfA(withId(R.id.password_text_input_layout))));
    loginButton = onView(allOf(withId(R.id.enter_button)));
    logOutButton = onView(allOf(withId(R.id.authorization_image_button)));


    }
}