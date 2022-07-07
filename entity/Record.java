package entity;

public class Record {
    private Integer id;
    private String location;
    private String accountId;
    private String password;

    public Record() {
    }

    public Record(String location, String accountId, String password) {
        this.location = location;
        this.accountId = accountId;
        this.password = password;
    }

    public Record(Integer id, String location, String accountId, String password) {
        this.id = id;
        this.location = location;
        this.accountId = accountId;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
