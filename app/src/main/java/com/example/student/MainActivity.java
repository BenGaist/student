package com.example.student;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    EditText getName;
    EditText getGrade;
    EditText getStudent;
    Button saveBtn;
    Button showBtn;
    Button logBtn;
    TextView studentTxt;
    ArrayList<Student> studentLst = new ArrayList<Student>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        getName = findViewById(R.id.etStudentName);
        getGrade = findViewById(R.id.etGrade);
        getStudent = findViewById(R.id.etStudentQuery);
        saveBtn = findViewById(R.id.addStudentBtn);
        showBtn = findViewById(R.id.checkStudentBtn);
        logBtn = findViewById(R.id.logSortedGradesBtn);
        studentTxt = findViewById(R.id.tvStudentGrade);


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveStudent();
            }
        });


        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for(int i = 0;i<studentLst.size();i++)
                {
                    String a = getStudent.getText().toString();
                    String b = studentLst.get(i).name;
                    if(a.equals(b))
                    {
                        Toast.makeText(MainActivity.this, "put",
                                Toast.LENGTH_LONG).show();
                      studentTxt.setText(studentLst.get(i).name+" : "+studentLst.get(i).grade);
                    }

                    else if(i == studentLst.size()-1)
                    {
                        Toast.makeText(MainActivity.this, "did not find",
                                Toast.LENGTH_LONG).show();
                    }



                }

            }
        });

        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

    }

    public void saveStudent()
    {
        Student s = new Student(getName.getText().toString(),Integer.parseInt(getGrade.getText().toString()));
        studentLst.add(s);
        Toast.makeText(MainActivity.this, "saved",
                Toast.LENGTH_LONG).show();
    }


}