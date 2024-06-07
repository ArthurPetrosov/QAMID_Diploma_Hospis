package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.R;

public class EditNews {

    public ViewInteraction categoryField;
    public ViewInteraction tittleField;
    public ViewInteraction dateField;
    public ViewInteraction timeField;
    public ViewInteraction descriptionField;
    public ViewInteraction statusSwitcher;
    public ViewInteraction saveButton;
    public ViewInteraction cancelButton;

    public EditNews(){
        categoryField = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
        tittleField = onView(withId(R.id.news_item_title_text_input_edit_text));
        dateField = onView(withId(R.id.news_item_publish_date_text_input_edit_text));
        timeField = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
        descriptionField = onView(withId(R.id.news_item_description_text_input_edit_text));
        statusSwitcher = onView(withId(R.id.switcher));
        saveButton = onView(withId(R.id.save_button));
        cancelButton = onView(withId(R.id.cancel_button));

    }

    public void changeNewsAttribute(String newTittle, String newDate,
                                    String newTime, String newDescription) {
        tittleField.perform(replaceText(newTittle));
        dateField.perform(replaceText(newDate));
        timeField.perform(replaceText(newTime));
        descriptionField.perform(replaceText(newDescription));
        saveButton.perform(click());
        DataHelper.waitElement(R.id.news_list_recycler_view);
    }

}