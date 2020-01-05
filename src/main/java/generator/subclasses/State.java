package generator.subclasses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class State {
    private String name;
    public List<Rule> rules = new ArrayList<>();
    private Set<String> first = new HashSet<>();
    private Set<String> follow = new HashSet<>();
    private boolean hasEpsilon = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addRule(Rule r) {
        rules.add(r);
        if (r.items.size() == 1 && r.items.get(0).equals("EPS")) {
            hasEpsilon = true;
        }
    }

    public Set<String> getFirst() {
        return first;
    }

    public boolean addToFirst(String item) {
        if (item.equals("EPS")) {
            hasEpsilon = true;
        }
        if (first.contains(item)) {
            return false;
        }
        return first.add(item);
    }

    public boolean hasEpsilon() {
        return hasEpsilon;
    }

    public boolean addToFollow(String item) {
        if (follow.contains(item)) {
            return false;
        }
        return follow.add(item);
    }

    public Set<String> getFollow() {
        return follow;
    }
}