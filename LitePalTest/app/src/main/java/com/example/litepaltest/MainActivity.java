package com.example.litepaltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.crud.LitePalSupport;
import org.litepal.tablemanager.Connector;

import java.sql.Connection;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button createDatabase = (Button) findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connector.getDatabase();
            }
        });

        Button  addDatabase = (Button) findViewById(R.id.add_data);
        addDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setAuthor("Dan Brown");
                book.setName("The Da Vinci Code");
                book.setPages(454);
                book.setPrice(16.96);
                book.setPress("unknown");
                book.save();
            }
        });

        Button  updateDatabase = (Button) findViewById(R.id.update_data);
        addDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                Book book = new Book();
                book.setAuthor("Dan Brown");
                book.setName("The Lost Symbol");
                book.setPages(504);
                book.setPrice(19.99);
                book.setPress("unknown");
                book.save();
                book.setPrice(10.88);
                book.save();
                */
                Book book = new Book();
                book.setPrice(88.88);
                book.setPress("HKR");
                book.updateAll("name = ? and author = ?", "The Da Vinci Code", "Dan Brown");
            }
        });

        //TODO: error [why]
        Button delateDatabase = (Button) findViewById(R.id.remove_data);
        delateDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //LitePalSupport.deleteAll()
                //LitePal.deleteAll(Book.class, "price < ?", "15");
            }
        });

        //TODO: error [why]
        Button queryDatabase = (Button) findViewById(R.id.query_data);
        queryDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                List<Book> books = LitePal.findAll(Book.class);
                for (Book book: books) {
                    Log.d("MainActivity", "book name is " + book.getName());
                    Log.d("MainActivity", "book author is " + book.getAuthor());
                    Log.d("MainActivity", "book price is " + book.getPrice());
                    Log.d("MainActivity", "book page is " + book.getPages());
                    Log.d("MainActivity", "book press is " + book.getPress());
                }
                */
            }
        });
    }
};
