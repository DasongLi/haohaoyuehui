package com.example.pro.test1;

/**
 * Created by pro on 2017/5/14.
 */

public class SearchControl {
    private Place[] places;
    private String searchtext;
    public void setPlaces(Place[] p) {
        places = p;
    }
    public SearchControl(Place[] p) {
        places = new Place[p.length];
        for (int i=0;i<p.length;i++) {
            places[i] = p[i];
        }

    }
    public void setSearchtext(String s) {
        searchtext = s;
    }
    public Place[] Search() {
        int len = searchtext.length();
        int l=0;
        Place[] place_list = new Place[60];
        for (int i=0;i<places.length;i++) {
            for (int j=0;j<places[i].name.length()+1-len;j++) {
                if (searchtext.equals(places[i].name.substring(j,j+len) )) {
                    place_list[l++] = places[i];
                    break;
                }
            }
        }
        Place[] places1 = new Place[l];
        for (int i=0;i<l;i++) {
            places1[i] = place_list[i];
        }
        return places1;
    }
}
