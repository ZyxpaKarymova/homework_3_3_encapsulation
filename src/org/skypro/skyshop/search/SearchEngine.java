package org.skypro.skyshop.search;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SearchEngine {
    private final Set<Searchable> searchables;
    private final Comparator<Searchable> searchableComparator;

    public SearchEngine() {
        this.searchables = new HashSet<>();
        this.searchableComparator = (s1, s2) -> {
            int lengthCompare = Integer.compare(s2.getName().length(), s1.getName().length());
            return lengthCompare != 0 ? lengthCompare : s1.getName().compareTo(s2.getName());
        };
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public Set<Searchable> search(String query) {
        Set<Searchable> results = new TreeSet<>(searchableComparator);
        for (Searchable searchable : searchables) {
            if (searchable.getSearchTerm().contains(query)) {
                results.add(searchable);
            }
        }
        return results;
    }
}