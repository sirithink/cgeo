package cgeo.geocaching.apps.cache.navi;

import cgeo.geocaching.Geocache;
import cgeo.geocaching.R;
import cgeo.geocaching.Waypoint;
import cgeo.geocaching.activity.ActivityMixin;
import cgeo.geocaching.apps.AbstractApp;
import cgeo.geocaching.geopoint.Geopoint;

import android.app.Activity;

/**
 * navigation app for simple point navigation (no differentiation between cache/waypoint/point)
 */
abstract class AbstractPointNavigationApp extends AbstractApp implements CacheNavigationApp, WaypointNavigationApp, GeopointNavigationApp {

    protected AbstractPointNavigationApp(final String name, final int id, final String intent) {
        super(name, id, intent);
    }

    protected AbstractPointNavigationApp(final String name, final int id, final String intent, final String packageName) {
        super(name, id, intent, packageName);
    }

    @Override
    public void navigate(Activity activity, Geocache cache) {
        navigateWithNullCheck(activity, cache.getCoords());
    }

    private void navigateWithNullCheck(Activity activity, final Geopoint coords) {
        if (coords != null) {
            navigate(activity, coords);
        } else {
            ActivityMixin.showToast(activity, activity.getResources().getString(R.string.err_nav_no_coordinates));
        }
    }

    @Override
    public void navigate(Activity activity, Waypoint waypoint) {
        navigateWithNullCheck(activity, waypoint.getCoords());
    }

    @Override
    public boolean isEnabled(Geocache cache) {
        return cache.getCoords() != null;
    }

    @Override
    public boolean isEnabled(Waypoint waypoint) {
        return waypoint.getCoords() != null;
    }
}
