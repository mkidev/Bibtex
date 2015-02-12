package bible;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by marcel on 12.02.2015.
 */
public class Book {
    private Integer bnumber;
    private SortedSet<Chapter> chapters;
    public Book() {
        chapters = new TreeSet<Chapter>(Comparator.comparingInt(Chapter::getCnumber));
    }
    public boolean addChapter(Chapter chapter) {
        return chapters.add(chapter);
    }

    public Integer getBnumber() {
        return bnumber;
    }

    public void setBnumber(Integer bnumber) {
        this.bnumber = bnumber;
    }

    public SortedSet<Chapter> getChapters() {
        return chapters;
    }
}
