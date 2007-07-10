package ru.org.linux.site;

import java.io.*;
import java.util.Collections;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

import ru.org.linux.site.cli.mkdefprofile;
import ru.org.linux.util.ProfileHashtable;

public class Profile {
//  private final static Map defaultProfile = Collections.unmodifiableMap(mkdefprofile.getDefaultProfile());

  private final ProfileHashtable profileHashtable;
  private final String profileName;

  private final boolean isdefault;

  public Profile(InputStream df, String profileName) throws IOException, ClassNotFoundException {
    ObjectInputStream dof = null;
    try {
      dof = new ObjectInputStream(df);
      Map userProfile = (Map) dof.readObject();
      dof.close();
      df.close();

      this.profileName = profileName;

      userProfile.put("ProfileName", profileName);
      
      profileHashtable = new ProfileHashtable(getDefaults(), userProfile);

      isdefault = false;
    } finally {
      if (dof!=null) {
        dof.close();
      }
    }
  }

  public Profile(String profile) {
    profileHashtable = new ProfileHashtable(getDefaults(), new Hashtable());
    profileName = profile;

    isdefault = profile==null;
  }

  public String getName() {
    return profileName;
  }

  public boolean isDefault() {
    return isdefault;
  }

  public ProfileHashtable getHashtable() {
    return profileHashtable;
  }

  public static Map getDefaults() {
    return Collections.unmodifiableMap(mkdefprofile.getDefaultProfile());
  }

  public void write(OutputStream df) throws IOException {
    profileHashtable.setObject("system.timestamp", new Long(new Date().getTime()));
    profileHashtable.removeObject("Storage");

    ObjectOutputStream dof = null;
    try {
      dof = new ObjectOutputStream(df);
      dof.writeObject(profileHashtable.getSettings());
      dof.close();
    } finally {
      if (dof!=null) {
        dof.close();
      }
    }
  }
}
