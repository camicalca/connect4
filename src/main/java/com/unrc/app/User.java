package com.unrc.app;

import org.javalite.activejdbc.Model;

public class User extends Model {
   static {
    validatePresenceOf("first_name");
  }
   public Integer id;
   public String email;
   public String last_name;
   public String first_name;

    public Integer getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
   

}
