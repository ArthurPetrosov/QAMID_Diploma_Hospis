package ru.iteco.fmhandroid.ui.screens;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static org.hamcrest.CoreMatchers.allOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.contrib.RecyclerViewActions;

import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.R;

public class NewsScreen {
    public static int errorAddingMessageId;
    public ViewInteraction sortingNewsButton;
    public ViewInteraction editNewsButton;
    public ViewInteraction filterNewsButton;
    public ViewInteraction tittleText;
    public ViewInteraction descriptionText;
    public ViewInteraction filterNewsTittle;
    public ViewInteraction categoryNewsButton;
    public ViewInteraction categoryNewsField;
    public ViewInteraction dateStartPublish;
    public ViewInteraction dateEndPublish;
    public ViewInteraction filterButton;
    public ViewInteraction cancelButton;
    public ViewInteraction checkboxActive;
    public ViewInteraction checkboxNotActive;

    public NewsScreen(){
        errorAddingMessageId = R.string.empty_fields;
        sortingNewsButton = onView(withId(R.id.sort_news_material_button));
        editNewsButton = onView(withId(R.id.edit_news_material_button));
        filterNewsButton = onView(withId(R.id.filter_news_material_button));
        tittleText = onView(withId(R.id.news_item_title_text_view));
        descriptionText = onView(withId(R.id.news_item_description_text_view));
        filterNewsTittle = onView(withId(R.id.filter_news_title_text_view));
        categoryNewsButton = onView(allOf(withId(R.id.text_input_end_icon),
                withContentDescription("Show dropdown menu")));
        categoryNewsField = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
        dateStartPublish = onView(withId(R.id.news_item_publish_date_start_text_input_edit_text));
        dateEndPublish = onView(withId(R.id.news_item_publish_date_end_text_input_edit_text));
        filterButton = onView(withId(R.id.filter_button));
        cancelButton = onView(withId(R.id.cancel_button));
        checkboxActive = onView(withId(R.id.filter_news_active_material_check_box));
        checkboxNotActive = onView(withId(R.id.filter_news_inactive_material_check_box));
    }

    public void sortingNews() {
        DataHelper.waitElement(R.id.news_list_recycler_view);
        sortingNewsButton.perform(click());
    }

    public void filterNewsByStatus(boolean active, boolean notActive) {
        filterNewsButton.perform(click());
        if (!active) {
            checkboxActive.perform(click());
        }
        if (!notActive) {
            checkboxNotActive.perform(click());
        }
        filterButton.perform(click());
        DataHelper.waitElement(R.id.news_list_recycler_view);
    }

    public void filterNewsByStatusAndDate(boolean active, boolean notActive, String startDate, String endDate) {
        filterNewsButton.perform(click());
        if (!active) {
            checkboxActive.perform(click());
        }
        if (!notActive) {
            checkboxNotActive.perform(click());
        }
        dateStartPublish.perform(replaceText(startDate));
        dateEndPublish.perform(replaceText(endDate));
        filterButton.perform(click());
    }

    public void scrollNewsToPosition(int position) {
        DataHelper.waitElement(R.id.news_list_recycler_view);
        onView(withId(R.id.news_list_recycler_view)).perform(RecyclerViewActions.scrollToPosition(position));
    }


}