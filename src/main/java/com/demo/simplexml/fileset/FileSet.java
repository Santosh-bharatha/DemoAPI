package com.demo.simplexml.fileset;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.core.Commit;

@Root
public class FileSet {

   @ElementList(entry="include", inline=true)
   private List<Match> include;

   @ElementList(entry="exclude", inline=true)
   private List<Match> exclude;

   @Attribute
   private File path;

   private List<File> files;

   public FileSet() {
      this.files = new ArrayList<File>();
   }

   @Commit
   public void commit() {
      scan(path);
   }

   private void scan(File path) { 
      File[] list = path.listFiles();
      for(File file : list) {
         if(file.isDirectory()) {
            scan(path);
         } else {            
            if(matches(file)) {
               files.add(file);
            }
         }
      }
   }

   private boolean matches(File file) {
      for(Match match : exclude) {
         if(match.matches(file)) {
            return false;
         }
      }
      for(Match match : include) {
         if(match.matches(file)) {
            return true;
         }
      }
      return false;
   }

   public List<File> getFiles() {
      return files;
   }

   @Root
   private static class Match {

      @Attribute            
      private String pattern;            

      public boolean matches(File file) {
         String path = file.getPath();

         if(!file.isFile()) {
            return false;
         }
         return path.matches(pattern);         
      }         
   }
}