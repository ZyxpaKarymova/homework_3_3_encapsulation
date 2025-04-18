package org.skypro.skyshop.search;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> searchables;
    private final Comparator<Searchable> searchableComparator;

    public SearchEngine() {
        this.searchables = new HashSet<>();
        this.searchableComparator = Comparator
                .comparingInt((Searchable s) -> s.getName().length()).reversed()
                .thenComparing(Searchable::getName);
    }
    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public Set<Searchable> search(String query) {
        String lowerQuery = query.toLowerCase();
        return searchables.stream()
                .filter(s -> s.getSearchTerm().toLowerCase().contains(lowerQuery))
                .collect(Collectors.toCollection(() -> new TreeSet<>(searchableComparator)));
    }
}