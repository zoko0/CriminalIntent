package bartek.criminalintent.database;

/**
 * Created by ciulkba4 on 29.10.2018.
 */

public class CrimeDbShema {
    public static final class CrimeTable {
        public static final String NAME = "crimes";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String DATE = "date";
            public static final String SOLVED = "solved";
        }
    }

}
