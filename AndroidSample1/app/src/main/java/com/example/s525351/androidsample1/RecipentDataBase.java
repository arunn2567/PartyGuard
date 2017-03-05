package com.example.s525351.androidsample1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.w3c.dom.Text;

public class RecipentDataBase {
	
	 private static final String RP_DATABASE="Recipent_DB";
	    private static final int RP_DB_VERSION=4;
	    
	    private static final String RP_DB_VENDOR_TABLE="vendor_table";
	    
	    private static final String RP_DB_VENDOR_NAME="vendor_name";
	    private static final String RP_DB_VENDOR_NUMBER="vendor_num";
	    
	    private static final String RP_DB_VENDOR_TABLE_CREATE= "CREATE TABLE " + RP_DB_VENDOR_TABLE + " ( "
			+ RP_DB_VENDOR_NAME + " TEXT NOT NULL " + ")";
	    
	    private SQLiteDatabase db;
	    private RpDBhelper helper;
	    public RecipentDataBase(Context context)
	    {
	        helper=new RpDBhelper(context);
	        // TODO Auto-generated constructor stub
	    }
	    
	    class RpDBhelper extends SQLiteOpenHelper
	    {

	        public RpDBhelper(Context context)
	        {
	            super(context, RP_DATABASE, null, RP_DB_VERSION);
	            // TODO Auto-generated constructor stub
	        }

	        @Override
	        public void onCreate(SQLiteDatabase db)
	        {
	            // TODO Auto-generated method stub
	            db.execSQL(RP_DB_VENDOR_TABLE_CREATE);
	           
	        }

	        @Override
	        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	        {
	            // TODO Auto-generated method stub
	            
	        }
	        
	    }
	    public  RecipentDataBase open() throws SQLException
	    {
	        db=helper.getWritableDatabase();
	        return this;
	    }
	
	    public void close()
	    {
	        helper.close();
	    }
	    public long insertVendorDetails(String vendor_namee)
	    {
			db=helper.getWritableDatabase();
	        ContentValues cv=new ContentValues();
	        cv.put( RP_DB_VENDOR_NAME, vendor_namee);
			return db.insert(RP_DB_VENDOR_TABLE, null,cv);
	    }
	   
	    public Cursor getVendorDetails()
	    {
//	        return db.query(RP_DB_VENDOR_TABLE,
//					 new String[] { RP_DB_VENDOR_NAME } ,
//	                null, null, null, null, null);
			String selectQuery = "SELECT * FROM " + RP_DB_VENDOR_TABLE;
			return db.rawQuery(selectQuery,null);
	    }
	    
	    public Cursor getVendorRefId(String vendor_name)
	    {
	        
	    	String queryforRefId="select vendor_ref_id from vendor_table where vendor_name='"+vendor_name+"'";
	        return db.rawQuery(queryforRefId, null);
	    	
	    }
	    
	    public boolean deleteVendorDetails(String _id)	 
	       {
	    	   return db.delete(RP_DB_VENDOR_TABLE, RP_DB_VENDOR_NUMBER + "=" + _id, null) > 0;
	    	   
	       }
	    
}
