package com.example.logonrm.calculator.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.logonrm.calculator.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PesosFragment extends Fragment {

    EditText etPeso1;
    EditText etPeso2;
    Spinner spPesosDe;
    Spinner spPesosPara;
    boolean converteu = false;

    Double peso;

    public PesosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_peso, container, false);

        etPeso1 = (EditText) view.findViewById(R.id.etPeso1);
        etPeso2 = (EditText) view.findViewById(R.id.etPeso2);
        spPesosDe = (Spinner) view.findViewById(R.id.spPesoDe);
        spPesosPara = (Spinner) view.findViewById(R.id.spPesoPara);

        etPeso1.setText("0.0");
        etPeso2.setText("0.0");

        etPeso1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (converteu) {
                    converteu = false;
                } else {
                    converteu = true;
                    converter1();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        etPeso2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (converteu) {
                    converteu = false;
                } else {
                    converteu = true;
                    converter2();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        spPesosDe.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (converteu) {
                    converteu = false;
                } else {
                    converteu = true;
                    converter2();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spPesosPara.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (converteu) {
                    converteu = false;
                } else {
                    converteu = true;
                    converter1();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return view;
    }

    private void converter1() {

        if (!etPeso1.getText().toString().isEmpty()) {
            peso = Double.parseDouble(etPeso1.getText().toString());

            Double quilo = 0.0;

            if (spPesosDe.getSelectedItem().toString().equals("Tonelada")) {
                quilo = peso * 1000;
            } else if (spPesosDe.getSelectedItem().toString().equals("Quilograma")) {
                quilo = peso * 1;
            } else if (spPesosDe.getSelectedItem().toString().equals("Grama")) {
                quilo = peso * 0.001;
            } else if (spPesosDe.getSelectedItem().toString().equals("Stone")) {
                quilo = peso * 6.35029;
            } else if (spPesosDe.getSelectedItem().toString().equals("Libra")) {
                quilo = peso * 0.453592142840941;
            } else if (spPesosDe.getSelectedItem().toString().equals("Onça")) {
                quilo = peso * 0.0283495;
            }

            Double resul = 0.0;

            if (spPesosPara.getSelectedItem().toString().equals("Tonelada")) {
                resul = quilo * 0.001;
            } else if (spPesosPara.getSelectedItem().toString().equals("Quilograma")) {
                resul = quilo * 1;
            } else if (spPesosPara.getSelectedItem().toString().equals("Grama")) {
                resul = quilo * 1000;
            } else if (spPesosPara.getSelectedItem().toString().equals("Stone")) {
                resul = quilo * 0.157473;
            } else if (spPesosPara.getSelectedItem().toString().equals("Libra")) {
                resul = quilo * 2.20462;
            } else if (spPesosPara.getSelectedItem().toString().equals("Onça")) {
                resul = quilo * 35.274;
            }

            etPeso2.setText(resul.toString());

        } else{
            converteu = false;
        }


    }

    private void converter2() {

        if (!etPeso2.getText().toString().isEmpty()) {
            peso = Double.parseDouble(etPeso2.getText().toString());

            Double quilo = 0.0;

            if (spPesosPara.getSelectedItem().toString().equals("Tonelada")) {
                quilo = peso * 1000;
            } else if (spPesosPara.getSelectedItem().toString().equals("Quilograma")) {
                quilo = peso * 1;
            } else if (spPesosPara.getSelectedItem().toString().equals("Grama")) {
                quilo = peso * 0.001;
            } else if (spPesosPara.getSelectedItem().toString().equals("Stone")) {
                quilo = peso * 6.35029;
            } else if (spPesosPara.getSelectedItem().toString().equals("Libra")) {
                quilo = peso * 0.453592142840941;
            } else if (spPesosPara.getSelectedItem().toString().equals("Onça")) {
                quilo = peso * 0.0283495;
            }

            Double resul = 0.0;

            if (spPesosDe.getSelectedItem().toString().equals("Tonelada")) {
                resul = quilo * 0.001;
            } else if (spPesosDe.getSelectedItem().toString().equals("Quilograma")) {
                resul = quilo * 1;
            } else if (spPesosDe.getSelectedItem().toString().equals("Grama")) {
                resul = quilo * 1000;
            } else if (spPesosDe.getSelectedItem().toString().equals("Stone")) {
                resul = quilo * 0.157473;
            } else if (spPesosDe.getSelectedItem().toString().equals("Libra")) {
                resul = quilo * 2.20462;
            } else if (spPesosDe.getSelectedItem().toString().equals("Onça")) {
                resul = quilo * 35.274;
            }

            etPeso1.setText(resul.toString());

        } else{

            converteu = false;

        }
    }


}
