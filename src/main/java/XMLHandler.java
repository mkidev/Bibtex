import bible.Bible;
import bible.Book;
import bible.Chapter;
import bible.Vers;
import org.apache.commons.digester3.Digester;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

/**
 * Created by marcel on 12.02.2015.
 */
public class XMLHandler {

    public static Object handleXML(File file) throws IOException, SAXException {
        Digester digester = new Digester();
        digester.setValidating(false);
        digester.addObjectCreate("XMLBIBLE", Bible.class);
        digester.addSetProperties("XMLBIBLE");
        digester.addObjectCreate("XMLBIBLE/BIBLEBOOK", Book.class);
        digester.addSetProperties("XMLBIBLE/BIBLEBOOK");
        digester.addObjectCreate("XMLBIBLE/BIBLEBOOK/CHAPTER", Chapter.class);
        digester.addSetProperties("XMLBIBLE/BIBLEBOOK/CHAPTER");
        digester.addObjectCreate("XMLBIBLE/BIBLEBOOK/CHAPTER/VERS", Vers.class);
        digester.addSetProperties("XMLBIBLE/BIBLEBOOK/CHAPTER/VERS");
        digester.addSetNext("XMLBIBLE/BIBLEBOOK/CHAPTER/VERS", "addVers", "bible.Vers");
        digester.addSetNext("XMLBIBLE/BIBLEBOOK/CHAPTER", "addChapter", "bible.Chapter");
        digester.addSetNext("XMLBIBLE/BIBLEBOOK", "addBook", "bible.Book");
        return digester.parse(file);
    }
}
