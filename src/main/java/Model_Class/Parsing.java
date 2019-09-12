package Model_Class;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class takes in a string for the date and time and parses it into a standard format.
 */
public class Parsing {

    public SimpleDateFormat dateFormat;
    public String splittingDeadline;

    /**
     * The constructor for this class.
     *
     * @param dateFormat The format to apply to the date and time.
     * @param splittingDeadline The string of date and time to convert into the standard format.
     */
    public Parsing(SimpleDateFormat dateFormat, String splittingDeadline) {
        this.dateFormat = dateFormat;
        this.splittingDeadline = splittingDeadline;
    }

    /**
     * The method to format the date and time.
     *
     * @return The formatted date and time as a string or an error message if the input does not follow a
     * standard pattern.
     */
    public String parseDate() {
        try {
            Date date = dateFormat.parse(splittingDeadline);
            String dateString = date.toString();
            return dateString;
        } catch (ParseException p) {
            return "Sorry, please enter the date in the format 'yyyy-MM-dd HHmm', thank you.";
        }
    }
}
