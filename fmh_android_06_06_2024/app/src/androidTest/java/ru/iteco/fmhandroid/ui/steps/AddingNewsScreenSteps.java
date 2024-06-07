package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;

import ru.iteco.fmhandroid.ui.screens.AddingNewsScreen;
import ru.iteco.fmhandroid.ui.screens.NewsEditScreen;

public class AddingNewsScreenSteps {

    AddingNewsScreen addingNewsScreen =new AddingNewsScreen();
    NewsEditScreen newsEditScreen = new NewsEditScreen();


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
        addingNewsScreen.categoryField.perform(replaceText(category));
    }

    public void fillInNewsTitleField(String text) {
        addingNewsScreen.tittleField.perform(replaceText(text));
    }

    public void fillInPublicDateField(String text) {
        addingNewsScreen.dateField.perform(replaceText(text));
    }

    public void fillInTimeField(String text) {
        addingNewsScreen.timeField.perform(replaceText(text));
    }

    public void fillInNewsDescriptionField(String text) {
        addingNewsScreen.descriptionField.perform(replaceText(text));
    }
    public void clickSaveButton() {
        addingNewsScreen.saveButton.perform(click());
    }

    public void clickCancelButton() {
        addingNewsScreen.cancelButton.perform(click());
    }

    public void clickOKButton() {
        addingNewsScreen.cancelMessage.perform(click());
    }


}
