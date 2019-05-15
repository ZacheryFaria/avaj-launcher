package zfaria.avajlauncher.weather;

import sun.rmi.runtime.Log;
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
        List<Flyable> toRemove = new ArrayList<Flyable>();
        for (int i = observers.size() - 1; i > 0; i--) {
            Flyable f = observers.get(i);
            f.updateConditions();
            if (!f.isActive()) {
                unregister(f);
                f.land();
            }
        }
    }

}
