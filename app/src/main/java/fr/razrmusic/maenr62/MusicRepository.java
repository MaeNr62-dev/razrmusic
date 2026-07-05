package fr.razrmusic.maenr62;

import java.util.ArrayList;
import java.util.List;

public class MusicRepository {

    public static List<String> getFavorites() {
        List<String> list = new ArrayList<>();
        list.add("Favori 1");
        list.add("Favori 2");
        return list;
    }
}
