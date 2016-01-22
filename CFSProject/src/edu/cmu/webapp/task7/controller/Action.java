package edu.cmu.webapp.task7.controller;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public abstract class Action {
    public abstract String getName();

    public abstract String perform(HttpServletRequest request);

    private static Map<String, Action> hash = new HashMap<String, Action>();

    public static void add(Action action) {
        synchronized (hash) {
            hash.put(action.getName(), action);
        }
    }

    public static String perform(String name, HttpServletRequest request) {
        Action action;
        synchronized (hash) {
            action = hash.get(name);
        }

        if (action == null) {
            return null;
        }
        return action.perform(request);
    }
}
