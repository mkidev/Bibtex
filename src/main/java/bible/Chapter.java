package bible;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by marcel on 12.02.2015.
 */
public class Chapter {
    private Integer cnumber;
    private SortedSet<Vers> verses;

    public Chapter() {
        verses = new TreeSet<>(Comparator.comparingInt(Vers::getVnumber));
    }
    public boolean addVers(Vers vers) { return verses.add(vers); }
    public Integer getCnumber() {
        return cnumber;
    }

    public void setCnumber(Integer cnumber) {
        this.cnumber = cnumber;
    }

    public SortedSet<Vers> getVerses() {
        return verses;
    }
}
