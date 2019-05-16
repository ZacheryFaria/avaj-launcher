package zfaria.avajlauncher.weather;

import zfaria.avajlauncher.Logger;
import zfaria.avajlauncher.aircraft.Flyable;

import java.util.ArrayList;
import java.util.List;

public class Tower {

    protected List<Flyable> observers;

    public Tower() {
        observers = new ArrayList<Flyable>();
    }

    public void register(Flyable f) {
        observers.add(f);
        Logger.getInstance().out.println(f + " registered to tower.");
    }

    public void unregister(Flyable f) {
        observers.remove(f);
        Logger.getInstance().out.println(f + " unregistered from tower.");
    }

    protected void conditionsChanged() {
        for (int i = 0; i < observers.size(); i++) {
            Flyable f = observers.get(i);
            f.updateConditions();
        }
    }

}
