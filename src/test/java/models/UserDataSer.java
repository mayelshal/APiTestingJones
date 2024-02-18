package models;

public class UserDataSer {
    private String name;
    private String job;
    private int id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
    private String support;




    //(String)"{"data":{"id":2,"email":"janet.weaver@reqres.in","first_name":"Janet","last_name":"Weaver","avatar":"https://reqres.in/img/faces/2-image.jpg"},"support":{"url":"https://reqres.in/#support-heading","text":"To keep ReqRes free, contributions towards server costs are appreciated!"}}"; line: 1, column: 2]

    public UserDataSer(String name, String job ) {
       setName(name);
       setJob(job);

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }


}
