package com.demo.simplexml.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class Contact {

   @Element
   private Name name;

   @Element
   private Phone phone;

   public String getName() {
      return name.first;
   }

   public String getSurname() {
      return name.surname;
   }

   public String getMobilePhone() {
      return phone.mobile;
   }

   public String getHomePhone() {
      return phone.home;
   }

   @Root
   private static class Name {
    
      @Element
      private String first;

      @Element
      private String surname;
   }

   @Root
   private static class Phone {

      @Element(required=false)
      private String mobile;

      @Element
      private String home;
   }
}