package com.example.logonrm.calculator.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.logonrm.calculator.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MedidasFragment extends Fragment {

    EditText etMedida1;
    EditText etMedida2;
    Spinner spMedidasDe;
    Spinner spMedidasPara;

    public MedidasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_medidas, container, false);

        etMedida1 = (EditText) view.findViewById(R.id.etMedidas1);
        etMedida2 = (EditText) view.findViewById(R.id.etMedidas2);
        spMedidasDe = (Spinner) view.findViewById(R.id.spMedidasDe);
        spMedidasPara = (Spinner) view.findViewById(R.id.spMedidasPara);

        etMedida1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                converter1();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        etMedida2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                converter2();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return view;
    }

    private void converter1() {

        Double metro = 0.0;

        if(spMedidasDe.getSelectedItem().toString().equals("Quilômetro")){
            metro = Double.parseDouble(etMedida1.getText().toString()) * 1000;
        }else if(spMedidasDe.getSelectedItem().toString().equals("Metro")){
            metro = Double.parseDouble(etMedida1.getText().toString()) * 1;
        }else if(spMedidasDe.getSelectedItem().toString().equals("Centímetro")){
            metro = Double.parseDouble(etMedida1.getText().toString()) * 0.01;
        }else if(spMedidasDe.getSelectedItem().toString().equals("Milímetro")){
            metro = Double.parseDouble(etMedida1.getText().toString()) * 0.001;
        }else if(spMedidasDe.getSelectedItem().toString().equals("Micrômetro")){
            metro = Double.parseDouble(etMedida1.getText().toString()) * 1000;
        }else if(spMedidasDe.getSelectedItem().toString().equals("Nanômetro")){
            metro = Double.parseDouble(etMedida1.getText().toString()) * 1000;
        }else if(spMedidasDe.getSelectedItem().toString().equals("Milha")){
            metro = Double.parseDouble(etMedida1.getText().toString()) * 1000;
        }else if(spMedidasDe.getSelectedItem().toString().equals("Jarda")){
            metro = Double.parseDouble(etMedida1.getText().toString()) * 1000;
        }else if(spMedidasDe.getSelectedItem().toString().equals("Pé")){
            metro = Double.parseDouble(etMedida1.getText().toString()) * 1000;
        }else if(spMedidasDe.getSelectedItem().toString().equals("Polegada")){
            metro = Double.parseDouble(etMedida1.getText().toString()) * 1000;
        }else if(spMedidasDe.getSelectedItem().toString().equals("Milha Náutica")){
            metro = Double.parseDouble(etMedida1.getText().toString()) * 1000;
        }

        Double resul = 0.0;

        if(spMedidasPara.getSelectedItem().toString().equals("Quilômetro")){
            resul = metro * 0.001;
        }else if(spMedidasPara.getSelectedItem().toString().equals("Metro")){
            resul = metro * 1;
        }else if(spMedidasPara.getSelectedItem().toString().equals("Centímetro")){
            resul = metro * 100;
        }else if(spMedidasPara.getSelectedItem().toString().equals("Milímetro")){
            resul = metro * 1000;
        }else if(spMedidasPara.getSelectedItem().toString().equals("Micrômetro")){
            resul = metro * 1000;
        }else if(spMedidasPara.getSelectedItem().toString().equals("Nanômetro")){
            resul = metro * 1000;
        }else if(spMedidasPara.getSelectedItem().toString().equals("Milha")){
            resul = metro * 1000;
        }else if(spMedidasPara.getSelectedItem().toString().equals("Jarda")){
            resul = metro * 1000;
        }else if(spMedidasPara.getSelectedItem().toString().equals("Pé")){
            resul = metro * 1000;
        }else if(spMedidasPara.getSelectedItem().toString().equals("Polegada")){
            resul = metro * 1000;
        }else if(spMedidasPara.getSelectedItem().toString().equals("Milha Náutica")){
            resul = metro * 1000;
        }

        etMedida2.setText(resul.toString());











    }

    private void converter2() {

    }

}
