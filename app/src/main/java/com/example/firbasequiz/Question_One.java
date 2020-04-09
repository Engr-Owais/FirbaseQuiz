package com.example.firbasequiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Database;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Question_One extends AppCompatActivity {
    private static final String FIRE_LOG = "Fire_Log";
    private TextView textview;
    private Button opt1,opt2,opt3;
    private List<Question_One> questionsList;
    private FirebaseAuth mAuth;
    private FirebaseFirestore Firestore;
    private FirebaseDatabase fb = FirebaseDatabase.getInstance();
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private DatabaseReference Database = fb.getReference();
    private DataSnapshot snapshot;
    private DatabaseReference firstdatabase;
    private DocumentReference noteRef = db.document("Game/QUestion 1");
    public String a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question__one);


        opt1 = findViewById(R.id.button);
        opt2 = findViewById(R.id.button2);
        opt3 = findViewById(R.id.button3);
        mAuth = FirebaseAuth.getInstance();
        Firestore = FirebaseFirestore.getInstance();
        textview = findViewById(R.id.textview2);

Database=FirebaseDatabase.getInstance().getReference().child("questions").child("0").child("answers").child("0");

        Database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) { textview.setText(dataSnapshot.getValue(String.class));

                Log.e("hellow",textview.toString());


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });






    }




}
