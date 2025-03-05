package com.dream.spycops.routes;

public enum View {
    MAIN("main.fxml", true),
    LOGIN("login.fxml", true),
    REGISTER("register.fxml", true),
    HOME("hello-view.fxml", false);

    private final String fileName;
    private final boolean isCacheable;

    View(String fileName, boolean isCacheable) {
        this.fileName = fileName;
        this.isCacheable = isCacheable;
    }

    public String getFileName() {
        return fileName;
    }

    public boolean getIsCacheable() {
        return isCacheable;
    }
}
