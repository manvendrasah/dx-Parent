package com.xseed.dx.parent.utils;


import com.xseed.dx.parent.CountryModel;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Manvendra Sah on 03/05/17.
 */

public class CountryUtils {

    private CountryUtils() {

    }

    private static TreeMap<Integer, CountryModel> countryCodesMap;

    static {
        countryCodesMap = new TreeMap<Integer, CountryModel>();
        countryCodesMap.put(0, new CountryModel("India", "+91")); // for India
        countryCodesMap.put(1, new CountryModel("Philipines", "+63")); // for Phillipines
    }

    public static ArrayList<CountryModel> getCountryModelList() {
        ArrayList<CountryModel> list = new ArrayList<CountryModel>();
        for (Map.Entry<Integer, CountryModel> entry : countryCodesMap.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }

    public static CountryModel getCountryModel(int spinnerSelection) {
        if (countryCodesMap.containsKey(spinnerSelection))
            return countryCodesMap.get(spinnerSelection);
        else
            return null;
    }

    public static Integer getSelection(String countryCode) {
        int i = 0;
        for (Map.Entry<Integer, CountryModel> entry : countryCodesMap.entrySet()) {
            CountryModel model = (CountryModel) entry.getValue();
            if (model.code.equals(countryCode))
                return i;
            i++;
        }
        return 0;
    }
}
