import bible.Bible;
import bible.Book;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

/**
 * Created by marcel on 12.02.2015.
 */
public class Main {

    public static void main(String[] args) {
        try {

            Bible bible = (Bible) XMLHandler.handleXML(new File("src/main/resources/bibel_ger_neue.xml"));
            System.out.println("bible.getBiblename() = " + bible.getBiblename());
            bible.getBooks()
                    .stream()
                    .forEach(book ->
                        {
                            System.out.println("book.getBnumber() = " + book.getBnumber());
                            book.getChapters()
                                    .stream()
                                    .forEach(chapter -> {
                                        System.out.println("chapter.getCnumber() = " + chapter.getCnumber());
                                        chapter.getVerses()
                                                .stream()
                                                .filter(vers -> vers.getVnumber() % 2 == 0)
                                                .forEach(vers -> System.out.println("vers.getVnumber() = " + vers.getVnumber()));
                                    });
                        });
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
