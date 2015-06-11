package com.lefukj.health.dao;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper{

	private static int version=1;
	
	public DBhelper(Context context) {
		super(context, "lefukj.db", null, version);
		// TODO Auto-generated constructor stub
	}
	public DBhelper(Context context,int version){
		super(context, "lefukj.db", null, version);
		DBhelper.version=version;
	}
	

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

}
