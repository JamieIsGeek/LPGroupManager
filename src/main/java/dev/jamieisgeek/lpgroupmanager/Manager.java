package dev.jamieisgeek.lpgroupmanager;

public class Manager {

    public static Manager manager;

    public void setManager() {
        manager = this;
    }
    public static Manager getManager() {
        return manager;
    }
}
