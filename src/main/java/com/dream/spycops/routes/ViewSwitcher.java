package com.dream.spycops.routes;

import com.dream.spycops.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ViewSwitcher {

    // for caching
    private static Map<View, Parent> cache = new HashMap<>();

    private static Scene scene;

    public static void setScene(Scene scene) {
        ViewSwitcher.scene = scene;
    }

    public static void switcherTo(View view) {
        try {
            Parent root;

            if (cache.containsKey(view)) {
                root = cache.get(view);
            } else {
                root =
                        FXMLLoader.load(App.class.getResource(view.getFileName()));
                // adding to cache
                if (view.getIsCacheable())
                    cache.put(view, root);
            }

            scene.setRoot(root);    // setting the route for the scene.
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
