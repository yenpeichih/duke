package Model_Class;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Parsing {

    public SimpleDateFormat dateFormat;
    public String splittingDeadline;
    public Ui ui;

    public Parsing(SimpleDateFormat dateFormat, String splittingDeadline) {
        this.dateFormat = dateFormat;
        this.splittingDeadline = splittingDeadline;
    }

}
