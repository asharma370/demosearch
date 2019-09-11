package com.anuj.demosearch.business.utils;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import androidx.annotation.NonNull;

/**
 * Utility class for application. Contains handy utils.
 */
public class AppUtils {

    private AppUtils() {
        //Required to be private.
    }

    /**
     * Check internet connectivity
     *
     * @param connectivityManager Connectivity manager.
     * @return Boolean is connected.
     */
    public static boolean isConnectedToInternet(@NonNull final ConnectivityManager
                                                        connectivityManager) {
        final NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return connectivityManager.getActiveNetworkInfo() != null
                && (activeNetworkInfo.isConnected() || activeNetworkInfo.isConnectedOrConnecting());
    }
}
