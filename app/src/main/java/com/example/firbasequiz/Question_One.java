package com.example.firbasequiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
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

    Button opt1;
    Button opt2, next, opt3;
    TextView number, ques,total;
    DatabaseReference databaseReference;
    int num = 0;
    String val = "";
    response res = new response("",0);
    @Override
    protected void onStart() {
        super.onStart();
        updateQuestion();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question__one);
        opt1 = findViewById(R.id.btnopt1);
        opt2 = findViewById(R.id.btnopt2);
        opt3 = findViewById(R.id.btnopt3);
//        next = findViewById(R.id.buttonnext);
        number = findViewById(R.id.questionnum);
        ques = findViewById(R.id.question);
        total = findViewById(R.id.total);

        number.setText(num + "/10");


//        next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                num++;
//
//                number.setText(num + "/10");
//
//                updateQuestion();
//            }
//            });

    }



    public void btnclick(View view) {


        Button b = (Button) view;
        String buttonText = b.getText().toString();
        if(updateQuestion().getCorrectanswer().equalsIgnoreCase(buttonText))
        {
            num++;

            number.setText(num + "/10");

            updateQuestion();


            res.CalculateScore(res.getPoints());
            total.setText("Coins:" + String.valueOf(res.getTotal()));

        }
        else
        {
            Toast.makeText(this, "Wrong Answer", Toast.LENGTH_SHORT).show();
        }

    }

    public response updateQuestion()
    {
            databaseReference = FirebaseDatabase.getInstance().getReference().child("questions").child(String.valueOf(num)).child("answers");

            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                    Books books = dataSnapshot.getValue(Books.class);
//                      Log.d("data" , String.copyValueOf(books.getOpt0()));


                    ques.setText(books.getQuestion());
                    opt1.setText(books.getOpt1());
                    opt2.setText(books.getOpt2());
                    opt3.setText(books.getOpt3());

                    val = books.getcorrectindex();
                    res.setCorrectanswer(val);

                    res.setPoints(books.getPoints());

                }


                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }

            });
        return  res;
    }

}
