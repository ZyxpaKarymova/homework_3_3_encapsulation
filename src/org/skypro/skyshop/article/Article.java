package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

public class Article implements Searchable {
    private final String title;
    private final String text;

    public Article(String title, String text) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Название статьи не может быть пустым или состоять только из пробелов.");
        }
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("Текст статьи не может быть пустым или состоять только из пробелов.");
        }
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return getTitle() + " (" + getContentType() + ")";
    }

    @Override
    public String getSearchTerm() {
        return getTitle() + " " + getText();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return getTitle();
    }
}
