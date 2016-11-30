package com.vunke.sharehome.greendao.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import com.vunke.sharehome.greendao.dao.bean.Contact;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "CONTACT".
*/
public class ContactDao extends AbstractDao<Contact, Long> {

    public static final String TABLENAME = "CONTACT";

    /**
     * Properties of entity Contact.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property UserId = new Property(0, Long.class, "userId", true, "USER_ID");
        public final static Property Face = new Property(1, String.class, "face", false, "FACE");
        public final static Property CompanyPhone = new Property(2, String.class, "companyPhone", false, "COMPANY_PHONE");
        public final static Property UserName = new Property(3, String.class, "userName", false, "USER_NAME");
        public final static Property Email = new Property(4, String.class, "email", false, "EMAIL");
        public final static Property GroupId = new Property(5, String.class, "groupId", false, "GROUP_ID");
        public final static Property FirstName = new Property(6, String.class, "firstName", false, "FIRST_NAME");
        public final static Property LastName = new Property(7, String.class, "lastName", false, "LAST_NAME");
        public final static Property IsRcs = new Property(8, Boolean.class, "isRcs", false, "IS_RCS");
        public final static Property HomePhone = new Property(9, String.class, "homePhone", false, "HOME_PHONE");
        public final static Property ContactName = new Property(10, String.class, "contactName", false, "CONTACT_NAME");
    };


    public ContactDao(DaoConfig config) {
        super(config);
    }
    
    public ContactDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CONTACT\" (" + //
                "\"USER_ID\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: userId
                "\"FACE\" TEXT," + // 1: face
                "\"COMPANY_PHONE\" TEXT," + // 2: companyPhone
                "\"USER_NAME\" TEXT," + // 3: userName
                "\"EMAIL\" TEXT," + // 4: email
                "\"GROUP_ID\" TEXT," + // 5: groupId
                "\"FIRST_NAME\" TEXT," + // 6: firstName
                "\"LAST_NAME\" TEXT," + // 7: lastName
                "\"IS_RCS\" INTEGER," + // 8: isRcs
                "\"HOME_PHONE\" TEXT," + // 9: homePhone
                "\"CONTACT_NAME\" TEXT);"); // 10: contactName
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CONTACT\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Contact entity) {
        stmt.clearBindings();
 
        Long userId = entity.getUserId();
        if (userId != null) {
            stmt.bindLong(1, userId);
        }
 
        String face = entity.getFace();
        if (face != null) {
            stmt.bindString(2, face);
        }
 
        String companyPhone = entity.getCompanyPhone();
        if (companyPhone != null) {
            stmt.bindString(3, companyPhone);
        }
 
        String userName = entity.getUserName();
        if (userName != null) {
            stmt.bindString(4, userName);
        }
 
        String email = entity.getEmail();
        if (email != null) {
            stmt.bindString(5, email);
        }
 
        String groupId = entity.getGroupId();
        if (groupId != null) {
            stmt.bindString(6, groupId);
        }
 
        String firstName = entity.getFirstName();
        if (firstName != null) {
            stmt.bindString(7, firstName);
        }
 
        String lastName = entity.getLastName();
        if (lastName != null) {
            stmt.bindString(8, lastName);
        }
 
        Boolean isRcs = entity.getIsRcs();
        if (isRcs != null) {
            stmt.bindLong(9, isRcs ? 1L: 0L);
        }
 
        String homePhone = entity.getHomePhone();
        if (homePhone != null) {
            stmt.bindString(10, homePhone);
        }
 
        String contactName = entity.getContactName();
        if (contactName != null) {
            stmt.bindString(11, contactName);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Contact readEntity(Cursor cursor, int offset) {
        Contact entity = new Contact( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // userId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // face
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // companyPhone
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // userName
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // email
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // groupId
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // firstName
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // lastName
            cursor.isNull(offset + 8) ? null : cursor.getShort(offset + 8) != 0, // isRcs
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // homePhone
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10) // contactName
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Contact entity, int offset) {
        entity.setUserId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setFace(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setCompanyPhone(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setUserName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setEmail(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setGroupId(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setFirstName(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setLastName(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setIsRcs(cursor.isNull(offset + 8) ? null : cursor.getShort(offset + 8) != 0);
        entity.setHomePhone(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setContactName(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Contact entity, long rowId) {
        entity.setUserId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Contact entity) {
        if(entity != null) {
            return entity.getUserId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
