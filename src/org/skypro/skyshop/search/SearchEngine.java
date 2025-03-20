package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new ArrayList<>();
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public List<Searchable> search(String query) {
        List<Searchable> results = new ArrayList<>();
        for (Searchable searchable : searchables) {
            if (searchable.getSearchTerm().contains(query)) {
                results.add(searchable);
            }
        }
        return results;
    }
}
