package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Record {
    @JsonProperty("id")
    private String id;
    @JsonProperty("location")
    private String location;
    @JsonProperty("account_id")
    private String accountId;
    @JsonProperty("password")
    private String password;
    public Record() {
    }
    public Record(String location, String accountId, String password) {
        this.location = location;
        this.accountId = accountId;
        this.password = password;
    }

    public Record(String id, String location, String accountId, String password) {
        this.id = id;
        this.location = location;
        this.accountId = accountId;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    @Override
    public String toString() {
        return "Record{" +
                "id:'" + id + '\'' +
                ", location:'" + location + '\'' +
                ", accountId:'" + accountId + '\'' +
                ", password:'" + password + '\'' +
                '}';
    }
}
