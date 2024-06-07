package ru.iteco.fmhandroid.ui.screens;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AddingNewsScreen {

    NewsEditScreen newsEditScreen = new NewsEditScreen();


    public ViewInteraction categoryField;
    public ViewInteraction tittleField;
    public ViewInteraction dateField;
    public ViewInteraction timeField;
    public ViewInteraction descriptionField;
    public ViewInteraction statusSwitcher;
    public ViewInteraction saveButton;
    public ViewInteraction cancelButton;
    public ViewInteraction confirmCancelAddingNewsButton;
    public ViewInteraction cancelMessage;

    public AddingNewsScreen() {

        categoryField = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
        tittleField = onView(withId(R.id.news_item_title_text_input_edit_text));
        dateField = onView(withId(R.id.news_item_publish_date_text_input_edit_text));
        timeField = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
        descriptionField = onView(withId(R.id.news_item_description_text_input_edit_text));
        statusSwitcher = onView(withId(R.id.switcher));
        saveButton = onView(withId(R.id.save_button));
        cancelButton = onView(withId(R.id.cancel_button));
        cancelMessage = onView(withText(R.string.cancellation));
    }
    public void addNews(String category, String tittle, String date, String time, String description) {
        fillingNewsFields(category, tittle, date, time, description);
        clickSaveButton();
    }

    public void fillingNewsFields(String category, String tittle, String date, String time, String description) {
        newsEditScreen.addNewsButton.perform(click());
        fillInNewsCategoryField(category);
        fillInNewsTitleField(tittle);
        fillInPublicDateField(date);
        fillInTimeField(time);
        fillInNewsDescriptionField(description);
    }

    public void fillInNewsCategoryField(String category) {
        categoryField.perform(replaceText(category));
    }

    public void fillInNewsTitleField(String text) {
        tittleField.perform(replaceText(text));
    }

    public void fillInPublicDateField(String text) {
        dateField.perform(replaceText(text));
    }

    public void fillInTimeField(String text) {
        timeField.perform(replaceText(text));
    }

    public void fillInNewsDescriptionField(String text) {
        descriptionField.perform(replaceText(text));
    }
    public void clickSaveButton() {
        saveButton.perform(click());
    }

    public void clickCancelButton() {
        cancelButton.perform(click());
    }

    public void clickOKButton() {
        cancelMessage.perform(click());
    }


}
