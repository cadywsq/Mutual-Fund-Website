package edu.cmu.webapp.task7.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public abstract class Action {
    // The name of a action - match the returned request in the hash map
    public abstract String getName();

    // Returns the jsp to render the output
    public abstract String perform(HttpServletRequest request);

    // Map string and action Class methods to manage dispatching to Actions
    private static Map<String, Action> hash = new HashMap<String,Action>();

    public static void add(Action a) {
    	synchronized (hash) {
    		if (hash.get(a.getName()) != null) {
    			throw new AssertionError("Two actions with the same name (" + a.getName() + "): " + a.getClass().getName() + " and " + hash.get(a.getName()).getClass().getName());
    		}
    		
    		hash.put(a.getName(),a);
    	}
    }

    public static String perform(String name,HttpServletRequest request) {
        Action a;
        synchronized (hash) {
        	a = hash.get(name);
        }
        
        if (a == null) return null;
        return a.perform(request);
    }
}
