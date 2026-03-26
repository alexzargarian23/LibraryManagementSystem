import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLHandler {

    public static void marshal(List<Book> books, String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(BookListWrapper.class);
            Marshaller mar = context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            BookListWrapper wrapper = new BookListWrapper();
            wrapper.setBooks(books);

            mar.marshal(wrapper, new File(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Book> unmarshal(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) return new ArrayList<>();

            JAXBContext context = JAXBContext.newInstance(BookListWrapper.class);
            Unmarshaller unmar = context.createUnmarshaller();

            BookListWrapper wrapper = (BookListWrapper) unmar.unmarshal(file);
            return wrapper.getBooks();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}