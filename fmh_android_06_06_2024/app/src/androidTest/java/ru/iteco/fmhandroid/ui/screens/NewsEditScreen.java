package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItem;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.RecyclerViewActions;

import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.R;

public class NewsEditScreen {

    public ViewInteraction addNewsButton;
    public ViewInteraction categoryIconImage;
    public ViewInteraction tittleNewsEditing;
    public ViewInteraction datePublishNews;
    public ViewInteraction dateCreateNews;
    public ViewInteraction authorNews;
    public ViewInteraction statusNews;
    public ViewInteraction deleteNewsButton;
    public ViewInteraction editNewsButton;
    public ViewInteraction expandNewsButton;
    public ViewInteraction descriptionNews;
    public ViewInteraction refreshZone;
    public ViewInteraction statusSwitcher;
    public ViewInteraction saveButton;
    public ViewInteraction confirmDeleteNewsButton;
    public ViewInteraction addingNewsButton;

    public NewsEditScreen(){
        addNewsButton = onView(withId(R.id.add_news_image_view));
        addingNewsButton = onView(withId(R.id.edit_news_material_button));
        categoryIconImage = onView(withId(R.id.category_icon_image_view));
        tittleNewsEditing = onView(withId(R.id.news_item_title_text_view));
        datePublishNews = onView(withId(R.id.news_item_publication_date_text_view));
        dateCreateNews = onView(withId(R.id.news_item_create_date_text_view));
        authorNews = onView(withId(R.id.news_item_author_name_text_view));
        statusNews = onView(withId(R.id.news_item_published_text_view));
        deleteNewsButton = onView(withId(R.id.delete_news_item_image_view));
        editNewsButton = onView(withId(R.id.edit_news_item_image_view));
        expandNewsButton = onView(withId(R.id.view_news_item_image_view));
        descriptionNews = onView(withId(R.id.news_item_description_text_view));
        refreshZone = onView(withId(R.id.news_control_panel_swipe_to_refresh));
        statusSwitcher = onView(withId(R.id.switcher));
        saveButton = onView(withId(R.id.save_button));
        confirmDeleteNewsButton = onView(allOf(withId(android.R.id.button1)));

    }

    public static void scrollNews(int i) {
        onView(withId(R.id.news_list_recycler_view))
                .perform(scrollToPosition(i))
                .perform(actionOnItemAtPosition(i, scrollTo()))
                .check(matches(isDisplayed()));
    }


    public void scrollAndClickToNewsWithTittle(String tittle) {
        DataHelper.waitElement(R.id.news_list_recycler_view);
        onView(withId(R.id.news_list_recycler_view))
                .check(matches(isDisplayed()))
                .perform(RecyclerViewActions.scrollTo(hasDescendant(allOf(withText(tittle)))));
        onView(withId(R.id.news_list_recycler_view))
                .check(matches(isDisplayed()))
                .perform(actionOnItem(hasDescendant(withText(tittle)), click()));
    }

    public void editNews(String tittle) {
        scrollAndClickToNewsWithTittle(tittle);
        onView(allOf(withId(R.id.news_item_material_card_view), hasDescendant(withText(tittle))))
                .perform(DataHelper.clickChildViewWithId(R.id.edit_news_item_image_view));
    }
    public void confirmDelete() {
        DataHelper.waitElement(android.R.id.button1);
        confirmDeleteNewsButton.perform(click());
    }

    public void changeNewsStatus(String tittle) {
        scrollAndClickToNewsWithTittle(tittle);
        editNews(tittle);
        statusSwitcher.perform(click());
        saveButton.perform(click());
    }

    public void deleteNews(String tittle) {
        scrollAndClickToNewsWithTittle(tittle);
        onView(allOf(withId(R.id.news_item_material_card_view), hasDescendant(withText(tittle))))
                .perform(DataHelper.clickChildViewWithId(R.id.delete_news_item_image_view));
        confirmDelete();
    }

    public void refreshListOfNews() {
        refreshZone.perform(ViewActions.swipeDown());
        DataHelper.waitElement(R.id.news_list_recycler_view);
    }

}