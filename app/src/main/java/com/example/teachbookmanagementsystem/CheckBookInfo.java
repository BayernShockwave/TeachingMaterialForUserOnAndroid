package com.example.teachbookmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class CheckBookInfo extends AppCompatActivity {

    public RadioGroup radioGroup1;
    public RadioGroup radioGroup2;
    public RadioGroup radioGroup3;
    public RadioGroup radioGroup4;
    public RadioGroup radioGroup5;
    public RadioGroup radioGroup6;
    public RadioButton radioButton1_1;
    public RadioButton radioButton1_2;
    public RadioButton radioButton1_3;
    public RadioButton radioButton2_1;
    public RadioButton radioButton2_2;
    public RadioButton radioButton2_3;
    public RadioButton radioButton2_4;
    public RadioButton radioButton3_1;
    public RadioButton radioButton3_2;
    public RadioButton radioButton3_3;
    public RadioButton radioButton3_4;
    public RadioButton radioButton4_1;
    public RadioButton radioButton4_2;
    public RadioButton radioButton4_3;
    public RadioButton radioButton4_4;
    public RadioButton radioButton4_5;
    public RadioButton radioButton4_6;
    public RadioButton radioButton5_1;
    public RadioButton radioButton5_2;
    public RadioButton radioButton5_3;
    public RadioButton radioButton5_4;
    public RadioButton radioButton5_5;
    public RadioButton radioButton6_1;
    public RadioButton radioButton6_2;
    public RadioButton radioButton6_3;
    public Button okButton;
    public Button cleanButton;
    public String discipline;
    public String grade;
    public String type;
    public String area;
    public String count;
    public String publish;
    private final int SUBACTIVITY1 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_book_info);
        radioGroup1 = (RadioGroup)findViewById(R.id.rg1);
        radioGroup2 = (RadioGroup)findViewById(R.id.rg2);
        radioGroup3 = (RadioGroup)findViewById(R.id.rg3);
        radioGroup4 = (RadioGroup)findViewById(R.id.rg4);
        radioGroup5 = (RadioGroup)findViewById(R.id.rg5);
        radioGroup6 = (RadioGroup)findViewById(R.id.rg6);
        radioButton1_1 = (RadioButton)findViewById(R.id.cs);
        radioButton1_2 = (RadioButton)findViewById(R.id.machine);
        radioButton1_3 = (RadioButton)findViewById(R.id.english);
        radioButton2_1 = (RadioButton)findViewById(R.id.g1);
        radioButton2_2 = (RadioButton)findViewById(R.id.g2);
        radioButton2_3 = (RadioButton)findViewById(R.id.g3);
        radioButton2_4 = (RadioButton)findViewById(R.id.g4);
        radioButton3_1 = (RadioButton)findViewById(R.id.basebook);
        radioButton3_2 = (RadioButton)findViewById(R.id.officebook);
        radioButton3_3 = (RadioButton)findViewById(R.id.referencebook);
        radioButton3_4 = (RadioButton)findViewById(R.id.outclassbook);
        radioButton4_1 = (RadioButton)findViewById(R.id.area1);
        radioButton4_2 = (RadioButton)findViewById(R.id.area2);
        radioButton4_3 = (RadioButton)findViewById(R.id.area3);
        radioButton4_4 = (RadioButton)findViewById(R.id.area4);
        radioButton4_5 = (RadioButton)findViewById(R.id.area5);
        radioButton4_6 = (RadioButton)findViewById(R.id.area6);
        radioButton5_1 = (RadioButton)findViewById(R.id.stock1);
        radioButton5_2 = (RadioButton)findViewById(R.id.stock2);
        radioButton5_3 = (RadioButton)findViewById(R.id.stock3);
        radioButton5_4 = (RadioButton)findViewById(R.id.stock4);
        radioButton5_5 = (RadioButton)findViewById(R.id.stock5);
        radioButton6_1 = (RadioButton)findViewById(R.id.publish1);
        radioButton6_2 = (RadioButton)findViewById(R.id.publish2);
        radioButton6_3 = (RadioButton)findViewById(R.id.publish3);
        okButton = (Button)findViewById(R.id.okcheck);
        cleanButton = (Button)findViewById(R.id.cleancheck);
        okButton.setOnClickListener(okButtonListener);
        cleanButton.setOnClickListener(cleanButtonListener);
        radioGroup1.setOnCheckedChangeListener(onCheckedChangeListener1);
        radioGroup2.setOnCheckedChangeListener(onCheckedChangeListener2);
        radioGroup3.setOnCheckedChangeListener(onCheckedChangeListener3);
        radioGroup4.setOnCheckedChangeListener(onCheckedChangeListener4);
        radioGroup5.setOnCheckedChangeListener(onCheckedChangeListener5);
        radioGroup6.setOnCheckedChangeListener(onCheckedChangeListener6);
    }

    Button.OnClickListener okButtonListener = new Button.OnClickListener() {
        @Override
        public void onClick(View view) {
            //System.out.println(discipline);
            //System.out.println(grade);
            //System.out.println(type);
            //System.out.println(area);
            //System.out.println(count);
            //System.out.println(publish);
            Intent intent = new Intent(CheckBookInfo.this,BookInfo.class);
            Bundle bundle = new Bundle();
            bundle.putString("discipline",discipline);
            bundle.putString("grade",grade);
            bundle.putString("type",type);
            bundle.putString("area",area);
            bundle.putString("count",count);
            bundle.putString("publish",publish);
            intent.putExtras(bundle);
            startActivityForResult(intent,SUBACTIVITY1);
        }
    };

    Button.OnClickListener cleanButtonListener = new Button.OnClickListener() {
        @Override
        public void onClick(View view) {
            radioGroup1.clearCheck();
            radioGroup2.clearCheck();
            radioGroup3.clearCheck();
            radioGroup4.clearCheck();
            radioGroup5.clearCheck();
            radioGroup6.clearCheck();
        }
    };

    RadioGroup.OnCheckedChangeListener onCheckedChangeListener1 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId == radioButton1_1.getId()) {
                discipline = radioButton1_1.getText().toString();
            }
            else if (checkedId == radioButton1_2.getId()) {
                discipline = radioButton1_2.getText().toString();
            }
            else if (checkedId == radioButton1_3.getId()) {
                discipline = radioButton1_3.getText().toString();
            }
        }
    };

    RadioGroup.OnCheckedChangeListener onCheckedChangeListener2 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId == radioButton2_1.getId()) {
                grade = radioButton2_1.getText().toString();
            }
            else if (checkedId == radioButton2_2.getId()) {
                grade = radioButton2_2.getText().toString();
            }
            else if (checkedId == radioButton2_3.getId()) {
                grade = radioButton2_3.getText().toString();
            }
            else if (checkedId == radioButton2_4.getId()) {
                grade = radioButton2_4.getText().toString();
            }
        }
    };

    RadioGroup.OnCheckedChangeListener onCheckedChangeListener3 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId == radioButton3_1.getId()) {
                type = radioButton3_1.getText().toString();
            }
            else if (checkedId == radioButton3_2.getId()) {
                type = radioButton3_2.getText().toString();
            }
            else if (checkedId == radioButton3_3.getId()) {
                type = radioButton3_3.getText().toString();
            }
            else if (checkedId == radioButton3_4.getId()) {
                type = radioButton3_4.getText().toString();
            }
        }
    };

    RadioGroup.OnCheckedChangeListener onCheckedChangeListener4 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId == radioButton4_1.getId()) {
                area = radioButton4_1.getText().toString();
            }
            else if (checkedId == radioButton4_2.getId()) {
                area = radioButton4_2.getText().toString();
            }
            else if (checkedId == radioButton4_3.getId()) {
                area = radioButton4_3.getText().toString();
            }
            else if (checkedId == radioButton4_4.getId()) {
                area = radioButton4_4.getText().toString();
            }
            else if (checkedId == radioButton4_5.getId()) {
                area = radioButton4_5.getText().toString();
            }
            else if (checkedId == radioButton4_6.getId()) {
                area = radioButton4_6.getText().toString();
            }
        }
    };

    RadioGroup.OnCheckedChangeListener onCheckedChangeListener5 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId == radioButton5_1.getId()) {
                count = radioButton5_1.getText().toString();
            }
            else if (checkedId == radioButton5_2.getId()) {
                count = radioButton5_2.getText().toString();
            }
            else if (checkedId == radioButton5_3.getId()) {
                count = radioButton5_3.getText().toString();
            }
            else if (checkedId == radioButton5_4.getId()) {
                count = radioButton5_4.getText().toString();
            }
            else if (checkedId == radioButton5_5.getId()) {
                count = radioButton5_5.getText().toString();
            }
        }
    };

    RadioGroup.OnCheckedChangeListener onCheckedChangeListener6 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId == radioButton6_1.getId()) {
                publish = radioButton6_1.getText().toString();
            }
            else if (checkedId == radioButton6_2.getId()) {
                publish = radioButton6_2.getText().toString();
            }
            else if (checkedId == radioButton6_3.getId()) {
                publish = radioButton6_3.getText().toString();
            }
        }
    };
}
