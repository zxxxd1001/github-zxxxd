package my.jpa.readyml;

/**
 * Created by zhangxuedong on 2017/4/1.
 */
public class JpaConfiguration extends Configuration{
    private DatabaseConfiguration database;

    public DatabaseConfiguration getDatabase() {
        return database;
    }

    public void setDatabase(DatabaseConfiguration database) {
        this.database = database;
    }
}
